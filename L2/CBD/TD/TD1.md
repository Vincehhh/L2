
# TD 1 Redondance, Anomalies de mise à jour, Dépendances Fonctionnelles

## Exercice 1 :

### Cette relation contient-elle des redondances? Si oui lesquelles? Justi ez votre réponse.

On observe que dans le tableau, dès que A vaut 0 , D vaut 10. 
On observe aussi que dès que A vaut 1, D vaut 20.
Cela indique donc une dépendance fonctionelle probable entre A et D : A -> D
Donc oui il y a une redondance.  En cas de modification (ex: A=0 implique désormais D=15),
il faudrait modifier 5 lignes, ce qui crée un risque d'incohérence (anomalie de modification).

## Exercice 2 :

### Contient-elle des redondances? Si oui, donnez quelques exemples de problèmes de contrôle de cohérence de l'information pouvant être générés à cause de la présence de la redondance.

Cette table contient des redondances car les informations de la personne , son nom et son prénom,  sont dupliquées pour chaque véhicule acheté.
De plus , les caractéristiques techniques du véhicule telle que la marque, type, Puissance sont dupliquées à chaque fois que ce véhicule spécifique (Immat) est référencé (achat par une autre personne ou revente).

Exemple problème de cohérence : 

Si la puissance de la "Peugeot 504" est erronée et doit être corrigée, il faut le faire sur 3 lignes. L'oubli d'une ligne rend la base incohérente.
Si M. Durand vend tous ses véhicules et qu'on supprime les lignes d'achat, on perd définitivement le fait que M. Durand existe

## Exercice 3 

### Parmi les dépendances fonctionnelles suivantes, lesquelles s'appliquent à R?

E -> D : VRAI (e5 donne toujours d1).

D -> E : FAUX car d1 donne e4 (ligne 2) et e5 (ligne 3).

C -> A : FAUX car c2 donne a1 (ligne 1) et a2 (ligne 3).

E -> B : FAUX car e5 donne b3 (ligne 3) et b4 (ligne 4).

E -> A : VRAI (e2->a1, e4->a1, e5->a2).

B -> C : VRAI (b2 donne toujours c2).

B -> D : FAUX car b2 donne d3 (ligne 1) et d1 (ligne 2).

B -> A : VRAI (b2->a1, b3->a2, b4->a2).

## Exercice 4 

On a les données suivantes sur des élèves avec les DFs 
Eleve(Matricule, Nom, Age, Club, Salle)
Matricule-> Nom, Age
Matricule-> Club
Club-> Salle

### Que signifie chaque DF?

Matricule -> Nom, Age Un numéro de matricule identifie de manière unique un élève. Autrement dit, pour un matricule donné, il n'y a qu'un seul nom et un seul âge correspondants.

Matricule -> Club Un élève (identifié par son matricule) ne peut être inscrit qu'à un seul club.

Club -> Salle. Un club se réunit toujours dans une salle unique et déterminée (la salle dépend du club).


## Exercice 5 

On a les données suivantes sur des élèves avec les DFs :
Eleve(Matricule, Nom, Age, Club, Salle)
Matricule-> Nom, Age
Matricule-> Club
Club-> Salle

### Que signifie chaque DF ?

Mle-Etud -> Nom-Etud, Classe. Un étudiant (identifié par son matricule) possède un nom unique et est inscrit dans une seule classe.

No-Ens -> Nom-Ens . Un numéro d'enseignant désigne une seule personne (un nom unique).

Cours -> Module. Un cours appartient à un seul et unique module.

Cours, Module -> Nb-h. Le volume horaire est déterminé par le cours (au sein de son module).

Classe, Cours, Module -> No-Ens, Nom-Ens. Pour une classe donnée suivant un cours spécifique, il y a un enseignant affecté unique.

Mle-Etud, Cours, Module -> Note . Un étudiant obtient une note unique pour un cours spécifique.

## Exercice 6 

Soit la relation suivante (auto-explicative) qui concerne les employés d'une société implantée sur plusieurs bâti
ments?
EMPLOYES (NumE, Nom, Salaire, Département, Bâtiment)

### Déterminer les dépendances fonctionnelles

NumE -> Nom, Salaire, Département Un employé est identifié par son numéro ; il a un seul nom, un seul salaire et travaille dans un seul département.

Département -> Bâtiment Un département est localisé dans un seul bâtiment spécifique.

## Exercice 7 

La relation suivante décrit des commandes faites par des clients, avec les produits et quantités commandées par
client.
Commandes (NumCom, DateCom, NumCli, AdrCli, NumProd, Prix, Qte)

### Déterminer les dépendances fonctionnelles

NumCom -> DateCom, NumCli Une commande possède une date unique et est passée par un seul client.

NumCli -> AdrCli Un client est associé à une adresse unique.

NumProd -> Prix Un produit possède un prix unitaire fixe (indépendant de la commande).

NumCom, NumProd -> Qte La quantité commandée dépend à la fois du numéro de commande et du produit concerné (c'est la ligne de commande).

## Exercice 8 

La relation :
Projection (NoFilm, TitreFilm, DuréeFilm, NoSalle, CapacitéSalle,
TypePlace, PrixPlace, DateProjection, HeureDeb)
exprime que le lm NoFilm intitulé TitreFilm dure dureeFilm heures et est projeté dans la salle NoSalle ayant
une capacité CapacitéSalle places.
Le lm est projeté à la date DateProjection à HeureDeb heures.
Deux lms peuvent avoir le même titre.
Le prix de la place est fonction de son type.

### Déterminer les dépendances fonctionnelles.

NoFilm -> TitreFilm, DuréeFilm  Un numéro de film identifie son titre et sa durée.

NoSalle -> CapacitéSalle  Un numéro de salle détermine sa capacité.

TypePlace -> PrixPlace  Le tarif est fixé par le type de place.

NoSalle, DateProjection, HeureDeb -> NoFilm  Pour une salle donnée, à une date et une heure précises, il n'y a qu'un seul film projeté.


## Exercice 9 

L'Entreprise Vendetout voudrait créer une base de données relationnelle pour automatiser la gestion de ses ventes
et de ses approvisionnements. Elle gère d'une part des informations sur les commandes des clients, et d'autre
part les produits en stock avec leurs fournisseurs.
Les informations à garder sont :
Pour un client, un numéro unique, un nom ou raison sociale, le solde client et les adresses possibles
de livraison. Pour chaque commande de client, un numéro unique, la date de commande, l'adresse de
livraison et les produits commandés avec la quantité éventuelle.
Pour un produit, on a un numéro unique, un nom, la quantité actuelle en stock, le seuil minimum, la liste
des fournisseurs avec le prix correspondant.
Les fournisseurs sont décrits quant à eux, par un numéro unique, un nom et une adresse.

### Donner la liste des attributs nécessaires et dire quelles sont les dépendances fonctionnelles qui les lient.

NumCli -> Nom, Solde  Un client a un nom et un solde uniques.

NumCom -> DateCom, AdrLiv, NumCli  Une commande a une date unique, une adresse de livraison et appartient à un seul client.

NumCom, NumProd -> Qte  La quantité commandée dépend de la commande et du produit spécifique dans cette commande.

NumProd -> Nom, QteStock, SeuilMin  Un produit a des caractéristiques uniques de stock et de nom.

NumFourn -> Nom, Adresse  Un fournisseur est identifié par son numéro.

NumProd, NumFourn -> Prix  Le prix d'achat dépend du produit et du fournisseur qui le vend.

## Exercice 10 

On voudrait créer une base de données pour la gestion du personnel d'une compagnie organisée comme suit :
La compagnie est constituée d'un ensemble de départements.
Un département est constitué d'un ensemble d'employés, mène un ensemble de projets et possède un
ensemble de bureaux.
Pour chaque employé, on a l'historique des emplois qu'il a occupé, et pour chacun de ces emplois, on a
l'historique des salaires perçus dans le cadre de cet emploi.
Chaque bureau possède un ensemble de postes téléphoniques.
La BD doit contenir les informations :
Pour chaque département : un numéro de département unique, le budget, l'étage où il est situé et le
numéro d'employé du chef de département.
Pour chaque employé : un numéro d'employé unique, un nom et prénom, le numéro du projet sur lequel
il travaille actuellement, le numéro de bureau ainsi que le n◦ téléphone. On a aussi, le titre de chaque
emploi que l'employé a tenu, avec la date et le salaire pour chaque salaire di érent perçu pour cet emploi.
Pour chaque projet : un numéro de projet unique et le budget alloué au projet.
Pour chaque bureau : un numéro de bureau unique, une super cie en mètre2 et les numéros des postes
téléphoniques dans ce bureau.

### Quelle est la liste des données élémentaires et quelles sont les dépendances fonctionnelles qui les lient

NumDept -> Budget, Etage, Chef_NumEmp  Un département a un budget, un étage et un chef uniques.

NumProjet -> BudgetProjet  Un projet a un budget défini.

NumBureau -> Superficie  Un bureau a une superficie fixe.

NumTel -> NumBureau  Un poste téléphonique est rattaché à un bureau spécifique.

NumEmp -> Nom, Prénom, NumProjet, NumBureau, NumTel  Un employé travaille sur un projet actuel, occupe un bureau et possède un numéro de téléphone direct.

NumEmp, Date -> TitreEmploi, Salaire  L'historique est déterminé par l'employé et la date : à un moment donné, un employé a un titre et un salaire précis.



## Exercice 11 

Pour chaque relation ci-dessous :
Pièce : description des pièces employées dans un atelier de montage.
Pièce (N◦pièce, prix-unit, TVA, libellé, catégorie)
avec les dépendances fonctionnelles suivantes:
N◦pièce-> prix-unit, TVA, libellé, catégorie
catégorie-> TVA
Prime : liste des primes attribuées au personnel technique en fonction des machines sur lesquelles il
travaille
Prime (N◦machine, atelier, N◦techn, montant-prime, nom-techn)
avec les dépendances fonctionnelles suivantes:
N◦machine-> atelier
N◦techn-> nom-techn
(N◦machine, N◦techn)-> montant-prime
Employé1 : description d'un employé travaillant sur un projet d'un laboratoire.
Employé ( N◦Emp, N◦Lab, N◦Proj, NomEmp, NomProj, adresse)
avec les dépendances fonctionnelles suivantes:
(N◦Emp, N◦Lab)-> N◦Proj, NomProj, NomEmp
N◦Emp-> NomEmp
N◦Emp-> adresse
N◦Proj-> NomProj
Adresse
Adresse (rue, ville, NPA)
avec les dépendances fonctionnelles suivantes:
NPA-> ville
(rue, ville)-> NPA

### identifier les redondances éventuelles dans sa population

*Pièce* Redondance sur la TVA. Comme Catégorie -> TVA, on répète inutilement le taux de TVA pour chaque 
pièce appartenant à la même catégorie.

*Prime* Redondance sur l'atelier et le nom du technicien.

N°machine -> atelier : on répète l'atelier pour chaque technicien sur une machine. Notechn -> nom-techn : on répète le nom du technicien pour chaque machine sur laquelle il travaille.

*Employé* Redondance sur le Nom, l'Adresse et le Nom du Projet. Un employé travaillant dans plusieurs labos verra ses infos (Nom, Adresse) dupliquées. Le nom du projet est répété pour chaque employé y participant.

*Adresse* Redondance sur la Ville.

NPA -> Ville : on répète le nom de la ville pour chaque rue ayant le même code postal (NPA).

## Exercice 12 

### Identify possible redundancies and anomalies;

Tutor -> Department 

Head OfDept -> Faculty.

(Department, Faculty) -> Head OfDept

### Identify the functional dependencies of the relation.

L'association entre le Chef de département et sa Faculté est répétée. Si Jackson change de faculté, il faut mettre à jour toutes les lignes où il apparaît (Math et Physics), sinon il y a incohérence

## Exercice 13 

### 1. Identify the functional dependencies of the relation

Product -> PriceOfP (Le prix total est unique par produit).

(Product, Component) -> Quantity (La quantité dépend de la recette du produit).

(Product, Component) -> PriceOfC (Le prix du composant varie selon le produit : Wood vaut 10.00 pour Bookcase mais 8.00 pour Desk).

(Product, Component) -> Supplier (Le fournisseur dépend du choix fait pour ce produit : Wood vient de Smith pour Bookcase, mais de Quasimodo pour Desk).

### 2. Consider the following update operations :
### Insertion of a new product
### Deletion of a product
### Addition of a component in a product
### Modi cation of the price of a product.
### Discuss the types of anomaly that can be caused by these operation 

Insertion : Impossible de créer un nouveau produit avec son prix global (PriceOfP) si on ne lui associe pas encore de composant (car la clé primaire inclut Component).

Suppression : Si on supprime le produit "Desk", on perd l'information que le fournisseur "Quasimodo" existe.

Modification : Si le prix du produit "Bookcase" change, il faut mettre à jour 3 lignes. Risque d'erreur si une ligne est oubliée.

