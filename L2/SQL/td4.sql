--ex1

--1
CREATE TABLE CATEGORIE (
    NumCategorie INT AUTO_INCREMENT,
    Libelle VARCHAR(50),
    CONSTRAINT pk_categorie PRIMARY KEY (NumCategorie)
);

--2
CREATE TABLE LIGNE_CAHIER (
    NumCahier INT,
    NumLigneCahier INT,
    DescriptionLigneCahier VARCHAR(500),
    CONSTRAINT pk_lignecahier PRIMARY KEY (NumCahier, NumLigneCahier),
    CONSTRAINT fk_lignecahier_cahier FOREIGN KEY (NumCahier) REFERENCES CAHIER(NumCahier)
);

--3
CREATE TABLE CLIENT (
    NumClient INT AUTO_INCREMENT,
    NomClient VARCHAR(80) NOT NULL,
    AdresseClient VARCHAR(500),
    EmailClient VARCHAR(100) UNIQUE,
    ContactClient VARCHAR(100),
    CategorieClient INT, 
    CONSTRAINT pk_client PRIMARY KEY (NumClient),
    CONSTRAINT fk_client_categorie FOREIGN KEY (CategorieClient) REFERENCES CATEGORIE(NumCategorie)
);


--4
ALTER TABLE CAHIER
ADD CONSTRAINT ck_montant_positif CHECK (MontantCahier > 0);


--5
ALTER TABLE APPEL
ALTER COLUMN DateAppel SET DEFAULT (CURDATE());

--6
ALTER TABLE CAHIER
DROP CHECK ck_montant_positif;

--7
CREATE INDEX idx_date_cahier ON CAHIER(DateCahier);

--8
DROP INDEX idx_date_cahier ON CAHIER;

--9
DROP TABLE CLIENT;

--10
ALTER TABLE EMPLOYE

DROP COLUMN AdresseEmploye;



Exercice 2

--1
    
CREATE TABLE PATIENT (
    noPatient INT PRIMARY KEY,
    nom VARCHAR(80),
    prenom VARCHAR(80),
    sexe CHAR(1) CHECK (sexe IN ('M', 'F')),
    dateNaiss DATE NOT NULL,
    noSecu VARCHAR(20) UNIQUE,
    noMedecin INT,
    FOREIGN KEY (noMedecin) REFERENCES MEDECIN(noMedecin)
);

--2
CREATE TABLE CONSULTE (
    noMedecin INT,
    noPatient INT,
    dateConsultation DATE NOT NULL,
    diagnostic VARCHAR(500),
    PRIMARY KEY (noMedecin, noPatient, dateConsultation),
    FOREIGN KEY (noMedecin) REFERENCES MEDECIN(noMedecin),
    FOREIGN KEY (noPatient) REFERENCES PATIENT(noPatient)
);


--3
ALTER TABLE MEDECIN
ADD PRIMARY KEY (noMedecin);


--4
ALTER TABLE MEDECIN
ADD CONSTRAINT unique_doctor_surname_name UNIQUE (nom, prenom);


--5
ALTER TABLE PATIENT
MODIFY COLUMN noSecu VARCHAR(20) NOT NULL;


--6
CREATE INDEX idx_patient_surname_name ON PATIENT (nom, prenom);


--7
DROP INDEX idx_patient_surname_name ON PATIENT;

--9
DROP TABLE CONSULTE;
DROP TABLE PATIENT;
DROP TABLE MEDECIN;

Exercice 3

--1
SELECT
    C.NomClient,
    COUNT(A.NumAppel)
FROM CLIENT C
JOIN APPEL A ON C.NumClient = A.NumClient
GROUP BY C.NomClient;
```

--2
SELECT AVG(C.MontantCahier)
FROM CAHIER C
JOIN APPEL A ON C.NumAppel = A.NumAppel
WHERE A.DateAppel BETWEEN '2025-01-01' AND '2025-12-31';
```

--3
SELECT
    C.NomClient,
    SUM(CH.MontantCahier)
FROM CLIENT C
JOIN CAHIER CH ON C.NumClient = CH.NumClient
WHERE CH.DateCahier > '2020-01-01'
GROUP BY C.NomClient;


--4
SELECT DISTINCT
    C.NomClient,
    E1.NomEmploye,
    E1.PrenomEmploye,
    E2.NomEmploye,
    E2.PrenomEmploye
FROM APPEL A1
JOIN APPEL A2 ON A1.NumClient = A2.NumClient AND A1.NumResponsable < A2.NumResponsable
JOIN CLIENT C ON A1.NumClient = C.NumClient
JOIN EMPLOYE E1 ON A1.NumResponsable = E1.NumEmploye
JOIN EMPLOYE E2 ON A2.NumResponsable = E2.NumEmploye;


--5
SELECT E.NomEmploye, E.PrenomEmploye
FROM EMPLOYE E
LEFT JOIN APPEL A ON E.NumEmploye = A.NumResponsable
WHERE A.NumAppel IS NULL;


SELECT E.NomEmploye, E.PrenomEmploye
FROM EMPLOYE E
WHERE NOT EXISTS (
    SELECT 1
    FROM APPEL A
    WHERE A.NumResponsable = E.NumEmploye
);


--6
SELECT
    C.NomClient,
    COUNT(DISTINCT A.NumAppel),
    SUM(CH.MontantCahier)
FROM CLIENT C
JOIN APPEL A ON C.NumClient = A.NumClient
JOIN CAHIER CH ON A.NumAppel = CH.NumAppel
GROUP BY C.NomClient
HAVING COUNT(DISTINCT A.NumAppel) > 5 AND SUM(CH.MontantCahier) > 100000;

