
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
