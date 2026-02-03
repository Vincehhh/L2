# TP 1 – SQL

## Travail à faire : 
### 1. Evaluer les requêtes en SQL de difficulté (a), (b) et (c)  

### 1. (a)  
Quelles équipes ont obtenu la première place de leurs groupes en 2010 ?   

```sql
SELECT firstPlace 
FROM A_GROUPS 
WHERE cup = 2010
```

### 2. (b) Quelles équipes se sont classifiées pour la deuxième phase en 2010 ? (i.e. ceux qui ont obtenu la première et la deuxième place de leurs groupes) 

```sql
SELECT firstPlace AS equipe FROM A_GROUPS WHERE cup = 2010
UNION
SELECT secondPlace AS equipe FROM A_GROUPS WHERE cup = 2010;
```

### 3. (b) Quelles sont les équipes du groupe H en 2010 ?

```sql
SELECT firstPlace, secondPlace, thirdPlace, fourthPlace
FROM A_GROUPS
WHERE cup = 2010 AND groupId = 'H';
```

### 4. (b) Dans quel groupe joue la France en 2010 ?

```sql
SELECT groupId 
FROM A_GROUPS 
WHERE cup = 2010
AND (firstPlace = 'France' OR secondPlace = 'France' 
OR thirdPlace = 'France' OR fourthPlace = 'France')
```

### 5. (b) Dans quel groupe joue l’organisateur (host) de la coupe 2010 ? 

```sql
SELECT G.groupId
FROM A_GROUPS G, A_TOP T
WHERE G.cup = 2010 AND T.cup = 2010
  AND (G.firstPlace = T.host OR G.secondPlace = T.host 
       OR G.thirdPlace = T.host OR G.fourthPlace = T.host);
```

### 6. (b) Quelles équipes ont joué le 22/6/2010 ?

```sql
SELECT team1 FROM A_MATCHES WHERE cup = 2010 AND matchDate = '22/6'
UNION
SELECT team2 FROM A_MATCHES WHERE cup = 2010 AND matchDate = '22/6';
```

### 7. (c) Quelles équipes ont marqué des buts le 22/6/2010 ?

```sql
SELECT team1 
FROM A_MATCHES 
WHERE cup = 2010 AND matchDate = '22/6' 
  AND CAST(SUBSTRING_INDEX(goals, ':', 1) AS UNSIGNED) > 0
UNION
SELECT team2 
FROM A_MATCHES 
WHERE cup = 2010 AND matchDate = '22/6' 
  AND CAST(SUBSTRING_INDEX(goals, ':', -1) AS UNSIGNED) > 0;
```

### 8. (c) Quelles équipes ont gagné les matches du 22/6/2010 ?

```sql
SELECT team1 as team FROM a_matches WHERE LEFT(goals, 1) > RIGHT (goals, 1)
UNION SELECT team2 as team FROM a_matches WHERE LEFT (goals, 1) < RIGHT (goals,1)
```

### 9. (c) Quelles équipes ont marqué plus de 3 buts dans un match ?

```sql
SELECT team1 
FROM A_MATCHES 
WHERE CAST(SUBSTRING_INDEX(goals, ':', 1) AS UNSIGNED) > 3
UNION
SELECT team2 
FROM A_MATCHES 
WHERE CAST(SUBSTRING_INDEX(goals, ':', -1) AS UNSIGNED) > 3;
```

### 10. (c) Dans quelles villes a joué la France en 2010 ?

```sql
SELECT DISTINCT SUBSTRING_INDEX(stadium, ',', -1) as Ville
FROM A_MATCHES
WHERE cup = 2010 AND (team1 = 'France' OR team2 = 'France');
```
### 11. (a) Quelles équipes ont gagné au moins une fois une coupe ?

```sql
SELECT DISTINCT winner FROM A_TOP;
```

### 12. (a) Quelles équipes ont gagné au moins une fois une coupe et ont organisé au moins une coupe (pas forcement la même) ?

```sql
SELECT DISTINCT winner
FROM A_TOP
WHERE host LIKE CONCAT('%', winner, '%');
```

### 13. (b) Quelles équipes ont gagné plusieurs coupes ?

```sql
SELECT winner
FROM A_TOP
GROUP BY winner
HAVING COUNT(*) > 1;
```

### 14. (b) Quelle équipe a gagné la première coupe ?

```sql
SELECT winner
FROM A_TOP 
WHERE cup = (SELECT MIN(cup) FROM A_TOP);
```

### 15.(c) Quelles équipes européennes ont gagné au moins une fois une coupe ?

```sql
SELECT DISTINCT T.winner
FROM A_TOP T, A_TEAMS TM
WHERE TM.continent = 'Europe' 
  AND TM.teams LIKE CONCAT('%', T.winner, '%');
```
### 16.(d) Quelles équipes apparaissent plusieurs fois dans le palmarès ?

```sql
SELECT team, COUNT(*) as nb_fois
FROM (
    SELECT winner as team FROM A_TOP
    UNION ALL
    SELECT runnerUp FROM A_TOP
    UNION ALL
    SELECT thirdPlace FROM A_TOP
    UNION ALL
    SELECT fourthPlace FROM A_TOP
) as Palmares
GROUP BY team
HAVING COUNT(*) > 1;
```


### 17. (d) De quels groupes sont les équipes qui ont joué le 22/6/2010 ?

```sql
SELECT g.groupId
FROM A_MATCHES M JOIN A_GROUPS G ON M.cup = G.cup
AND (
  M.team1 IN (G.firstPlace, G.secondPlace, G.thirdPlace, G.fourthPlace)
  OR M.team2 IN (G.firstPlace,  G.secondPlace, G.thirdPlace, G.fourthPlace )
)
WHERE M.cup = 2010 AND M.matchDate = '22/6'
```

### 18.(d) Quels joueurs ont été élus meilleurs buteurs ?

```sql
SELECT 
SUBSTRING(goalScore, LOCATE('-', goalScore) + 2) as Joueur
FROM A_TOP
WHERE goalScore IS NOT NULL 
  AND goalScore LIKE '%-%';
```

### 19. (d) Quels joueurs ont été élus meilleurs buteurs dans plusieurs coupes du monde ?

```sql
SELECT 
    SUBSTRING(goalScore, LOCATE('-', goalScore) + 2) AS Joueur,
    COUNT(*) AS Nb_Trophees
FROM A_TOP
WHERE goalScore LIKE '%-%' 
GROUP BY Joueur
HAVING COUNT(*) > 1;

```

### 20. (d) Quels sont les équipes ayant gagné une coupe du monde et dont un des joueurs a été meilleur buteur ?



## Partie III – Modifications de schéma et migration de données


### 1. Créer une table A-CUPS qui stockera, pour chaque coupe, les pays organisateurs. Nommer les attributs cup (number/4/not null) et hosts(varchar2/25/not null). La clé primaire est cup. Inclure la contrainte cup => 1930

```sql
CREATE TABLE A_CUPS (
    cup     INT NOT NULL,         
    hosts   VARCHAR(25) NOT NULL,  
    CONSTRAINT pk_A_Cups PRIMARY KEY (cup),
    CONSTRAINT ch_cup_date CHECK (cup >= 1930)
);
```

### 2. Insérer des données des coupes et leurs organisateurs dans A_CUPS à partir de données stockées dans A-TOP. Attention : n’insérez pas les tuples un à un, chargez-les de la table A-TOP.

```sql
INSERT INTO A_CUPS (cup, hosts)
SELECT DISTINCT cup, host 
FROM A_TOP;
```

### 3. Supprimer les tuples correspondant aux coupes à venir de la table A-TOP

```sql
DELETE FROM A_TOP 
WHERE winner IS NULL;
```

### 4. Modifier la table A_TOP afin de supprimer l’attribut host (l’information se retrouve maintenant dans la table A_CUPS).

```sql
ALTER TABLE A_TOP 
DROP COLUMN host;
```



### 5. La table A_CUPS liste désormais toutes les coupes passées et à venir. Définir des clés étrangères dans toutes les autres tables, pour référer à l’attribut cup de la table A_CUPS.

```sql
ALTER TABLE A_TEAMS
ADD CONSTRAINT fk_A_Teams_cup FOREIGN KEY (cup) REFERENCES A_CUPS(cup);

ALTER TABLE A_GROUPS
ADD CONSTRAINT fk_A_Groups_cup FOREIGN KEY (cup) REFERENCES A_CUPS(cup);

ALTER TABLE A_MATCHES
ADD CONSTRAINT fk_A_Matches_cup FOREIGN KEY (cup) REFERENCES A_CUPS(cup);

ALTER TABLE A_TOP
ADD CONSTRAINT fk_A_Top_cup FOREIGN KEY (cup) REFERENCES A_CUPS(cup);
```
