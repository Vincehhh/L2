# Dépendances Fonctionnelles (DF), Axiomes d'Armstrong, DF élémentaire (DFE), Fermétude Transitive de DFE, Couverture Minimale de DFE, Graphe de DFE, Clés de relation

## Exercice 1.
### L'axiome de pseudo-transitivité nous dit que si X −→ Y et YW −→ Z, alors XW −→ Z. Démontrer cet axiome à l'aide des autres axiomes d'Armstrong

- X->Y alors XW->YW (accroissement)
- XW->YW et YW->Z alors XW->Z (transitivité)

## Exercice 2.
### En utilisant les axiomes d'Armstrong, démontrer que si X −→ Y Z et Z −→ CW alors X −→ YZC.

- Z->CW alors Z->CWZ (accroissement)
- Z->CWZ alors YZ->CWZY (accroissement)
- X->YZ et YZ->CWZY donc X->CWZY(transitivité)
- X->CWZY donc X->CZY (projectivité)

## Exercice 3.
### Soit R(A,B,C,D,E,G,H) F = {AB −→ C,B −→ D,CD −→ E,CE −→ GH,G −→ A}. En utilisant les axiomes d'Armstrong, montrer que l'on peut déduire de cet ensemble :

### 1. AB −→E;

- B-> D donc AB -> D par augmentation
- AB -> C et AB -> D donc AB -> CD par union
- AB -> CD et CD -> E donc AB -> E par transitivité.

### 2. BG−→C;

- G -> A donc BG -> A par augmentation
- BG -> BG donc BG -> B par projection,
- BG -> A et BG -> B donc BG -> AB par union,
- BG -> AB et AB -> C donc BG -> C par transitivité.

### 3.AB −→G.

- AB -> C et AB-> E donc AB -> CE par union,
- CE -> GH donc AB -> GH par transitivité
- AB -> GH donc AB -> G par projection

  
## Exercice 4.

### Soit la relation R(A,B,E,G,H,I,J) avec les Dfs F = {AB −→ E,AG −→ J,BE −→ I,E −→ G,GI −→ H}. En utilisant les axiomes d'Armstrong, montrer que l'on peut déduire de cet ensemble :

### 1. ABG -> EGJ

- AB - > E donc ABG -> EG par augmentation ,
- AG - > J donc ABG -> GJ par additivité,
- ABG -> EGJ par union

### 2. AB -> GH

- AB -> E et E -> G, par transitivité AB -> G
- AB -> E, par augmentation AB -> BE
- AB -> BE et BE -> I, par transitivité AB -> I
- AB -> G et AB -> I, par union AB -> GI
- AB -> GI et GI -> H, par transitivité AB -> H
- AB *> G et AB *> H, par union AB ->GH

### BE −→H 

- E -> G donc BE -> G par augmentation 
- BE -> G et BE -> I donc BE -> GI par union 
- BE -> GI et GI -> H donc BE -> H par transitivité


## Exercice 5.

### 1. ABC −→E

- AB -> C donc ABC -> CC par augmentation et donc ABC -> C
- B -> D donc AB -> AD par augmentation et AB -> D par décomposition
- AB -> D et ABC -> C donc ABC -> CD par union
- ABC -> CD et CD -> E donc ABC -> E par transitivité

### 2. BG -> C

- G -> A donc BG -> AB par augmentation
- BG -> AB et AB -> C donc BG -> C par transitivité

### 3. BG−→GH

- B -> D donc BG -> D
- BG -> C et BG -> D donc BG -> CD
- CD -> E donc CD -> CE
- BG -> CD et CD -> CE donc BG -> CE

### 4. GBCE −→GH;

- G -> A donc GB ->AB
- GB -> AB et AB -> C donc GB -> C
- GB -> C et CD ->E donc GBC -> E
- GBC -> E donc GBCE -> CE
- GBCE -> CE et CE -> GH donc GBCE -> GH

### 5. AB −→GH.

- B -> D donc AB -> D
- AB -> D et AB -> C donc AB -> CD
- CD -> E donc CD -> CE
- AB -> CD et CD -> CE donc AB -> CE
- AB -> CE et CE -> GH donc AB -> GH

# 2 Propriétés des Dépendances Fonctionnelles

## Exercice 6 

### Soit la relation R(A,B,C,D,E,F) avec les Dfs F = {A −→ BC,E −→ CF,B −→ E,CD −→ EF}. Calculer la fermeture {A,B}+ de l'ensemble des attributs {A,B} pour cet ensemble de Df F.

- Etape 0 : {A, B}

-   Etape 1 :
      -  A - > BC donc { A, B, C}
      - E -> CF donc { A, B, C }
      -  B -> E donc { A, B, C , E}
      -  CD -> EF donc { A, B, C , E}
 
- Etape 2 :
   - E -> CF donc { A, B, C , E, F}
   - CD -> EF donc { A, B, C , E, F}
 
$$\{A, B}^+ = \{A, B, C, E, F\}$$


## Exercice 7 

### Soit la relation R(A,B,C,D,E,F,G) avec les Dfs F = {AC −→ B,BC −→ DE,AEF −→ G} Calculer la fermeture {A,C}+ de l'ensemble des attributs {A,C} pour cet ensemble de Df F.

- Etape 0 : {A, C}
  
- Etape 1 :
    - AC -> B donc { A,B,C}
    - BC -> DE donc { A, B, C , D , E }
    - AEF -> G donc { A, B, C , D , E }
 
  $$\{A, C\}^+ = \{A, B, C, D, E\}$$

  ## Exercice 8

  ### Soit la relation R(A,B,C,D,E) avec les Dfs F = {A −→ CD,C −→ BDE,D −→ CE} 1. Donner deux couvertures minimales de F

 - Etape 1 : Decomposition de F
    - A -> C
    - A -> D
    - C -> B
    - C -> D
    - C -> E
    - D -> C
    - D -> E

- Etape 2 : Rechercher redondance
    - On a A -> C et C -> D donc A -> D inutile
    - On a A -> D et D -> C donc A -> C inutile
    - On a C -> et D -> E donc C -> E inutile
    - On a D -> C et -> C-> E donc D -> E inutile

- Solution 1 : Chemin par C 
    - On garde A-> C et on supprime A-> D , retrouvable via A-> C -> D
    - On garde C -> E et on supprime D -> E ,retrouvable via D-> C -> E
    -  Couverture minimale 1 : { A -> C , C-> B , C -> D , C -> E, D -> C}

- Solution 2 : Chemin par D
  - On garde A -> D et on supprime A -> C , retrouvable via A -> D -> C
  - On garde D -> E et on supprime C -> E , retrouvable via C-> D -> E
  -  Couverture minimale 2 : { A -> D, C -> B, C -> C -> D , D-> C, D -> E}

## Exercice 9.

### Soit la relation R(A,B,C,D) avec les Dfs F = {A −→ B,AB −→ CD} 1. Produisez une couverture minimale pour F ;

- Etape 1 : atomisation :
  - A -> B
  - AB -> CD devient deux règles : AB -> C et AB -> D 
 
- Etape  2 : Supresssion attributs étranger
  - AB -> C et A -> B donc A -> C (car A détermine B)
  - AB -> D et A -> B donc A -> D
  - Couvertur minimale { A -> B , A-> C , A -> D }
 
### 2. Quelles sont les clés candidates de la relation R?.

L'attribut A n'apparait jamais à droite donc c'est forcément lui qui détermine tout : 

$A^+ = \{A, B, C, D\}$

## Exercice 10 
### Soit la relation R(A,B,C,D) avec les Dfs F = {A −→ B,B −→ C,C −→ B,A −→ C} 1. Produisez une couverture minimale pour F ;

- Etape 1 : Décomposition de F :
  - A -> B
  - B -> C
  - C -> B
  - A -> C
 
- Etape 2 : Chercher redondance :
  - A -> B et C -> B donc A -> C inutile
  - A -> C et C -> B donc A -> B inutile 
  - Couverture minimale 1 : { B -> C , C -> B , A -> C }
  - Couverture minimale 2 : { A -> B , B -> C , C -> B }
 

  


  
 
  
 
      
        

  

  
    





    

  




  

  
