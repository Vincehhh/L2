# TP 2 – Contraintes d’intégrité

## 1. Considérer la table B_GROUPS. Elle contient des informations sur les équipes (team) participants à chaque  coupe du monde (cup), leur groupe de la première phase (groupId), leur résultat de la phase (rank) et leur  continent. Expliquer pourquoi les insertions suivantes devraient être interdites : 

### <2010, ‘A’, 4, ‘France’, ‘Europe’> 

<img width="1501" height="301" alt="image" src="https://github.com/user-attachments/assets/2cb33c54-9670-452e-8096-67594e8007db" />

Ici il y a une erreur car France a déjà été inséré dans la table b_groups. La france étant une clé primaire, elle ne peut pas être dupliqué. En effet, celle ci ne peut pas avoir été 
plusieurs fois dans le top 4 en 2010, cela créerait donc une redondance.


###  <2010, ‘A’, 4, ‘Sweden’, ‘Europe’> 

Ici l'erreur réside dans le fait que le top 4 de 2010 est déjà occupé par la France. Cela ne respecte pas également la contrainte de clé primaire qui doit etre unique. 


### <2010, ‘A’, 5, ‘Colombia’, ‘America’>

L'insertion devrait être interdite car le top est constitué de seulement 4 équipes, en inséré une 5 ème serait illogique.

### <2014, ‘A’, 1, ‘XXX’, ‘Europe’> 

L'insertion devrait être interdite car l'équipe est une clé primaire mais aussi une clé étrangère qui doit cohérente car XXX ne correspond pas à un nom de pays existant, donc si on souhaite par la suite le référencé dans une autre table cela créera une incohérence. 

### <2014, ‘A’, 2, ‘France’, ‘America’> 

Violation d'une contrainte métier car chaque équipe appartient à un seul continent



