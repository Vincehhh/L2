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
SELECT groupId
