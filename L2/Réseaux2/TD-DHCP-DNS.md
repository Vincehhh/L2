# TD DHCP/DNS 2021-2022

## Exercice 1

### Question 1 . Répondre par vrai ou faux aux assertions suivantes en justifiant votre réponse.

a) En appliquant le masque par défaut, l’adresse 193.95.66.0 peut être attribuée à une machine.

Réponse : FAUX.

Justification : L'adresse 193.x.x.x appartient à la classe C. Le masque par défaut est donc 255.255.255.0 (/24). Dans ce cas, le dernier octet .0 désigne l'adresse du réseau lui-même, et non une machine hôte. Elle n'est pas attribuable.


b) Un serveur DHCP est capable d’allouer une adresse IP à un client en fonction de son adresse MAC. 

Réponse : VRAI.

Justification : C'est le principe de la réservation d'adresse (ou bail statique). L'administrateur configure le serveur pour qu'une adresse MAC spécifique reçoive toujours la même adresse IP définie.


c) Un client DHCP obtient systématiquement la même adresse IP chaque fois qu’il effectue la demande. 

Réponse : FAUX.

Justification : Par défaut, l'allocation est dynamique. Si le bail expire et que le client se déconnecte, l'adresse IP peut être réattribuée à quelqu'un d'autre. À sa prochaine connexion, le client recevra une adresse disponible différente (sauf s'il y a une réservation comme au point b).


d) Il est possible d’avoir plusieurs serveurs DHCP sur un même réseau. 

Réponse : VRAI.

Justification : C'est possible (souvent pour la redondance), mais à condition impérative que leurs plages d'adresses (pools) ne se chevauchent pas, sinon il y aura des conflits d'IP.


e) Un serveur DHCP peut proposer aux clients l’adresse du routeur par défaut. 

Réponse : VRAI.

Justification : Le protocole DHCP fournit l'IP, le masque, mais aussi des options comme la passerelle par défaut (option routers) et les serveurs DNS.


### Question 2. Soit un réseau IP géré par un serveur DHCP utilisant l’intervalle d’adresses de 192.168.1.1 à 192.168.1.100. 
### Quels problèmes peuvent surgir si un client configure manuellement sa machine en utilisant l’adresse IP 192.168.1.2 ?
### Étudier le cas où l’adresse est déjà allouée par le serveur DHCP et le cas contraire.

Si l'adresse est déjà allouée par le serveur DHCP : Si le serveur a déjà donné la .2 à un "Client A" et qu'on force la .2 
sur notre "Client B", les deux machines vont entrer en conflit. Cela entraîne généralement des messages d'erreur sur les 
OS et une perte de connectivité réseau pour les deux machines (instabilité du trafic.

Si l'adresse n'est pas encore allouée : Le serveur DHCP considère que la .2 est libre. Lorsqu'un futur "Client C" arrivera, le serveur lui proposera la .2.
Au moment où le Client C tentera d'utiliser cette IP, il détectera qu'elle est déjà prise par notre machine manuelle. Le Client C refusera 
l'adresse et devra redemander une autre offre au serveur, ce qui ralentit le processus ou provoque une erreur.


### Q3. Afin d’améliorer la tolérance aux pannes, l’administrateur d’un réseau décide de mettre en place deux serveurs DHCP sur deux machines
### différentes en utilisant exactement la même étendue d’adresses IP. 
### Quelles sont les conséquences de cette stratégie ? Avez-vous une meilleure proposition et en quoi elle consiste ?

Le Serveur A peut donner l'IP 192.168.1.50 à l'ordinateur X.
Le Serveur B peut donner la même IP 192.168.1.50 à l'ordinateur Y.
Résultat : Conflits d'adresses IP généralisés sur tout le réseau.

Meilleure proposition : Il faut utiliser des plages d'adresses disjointes.
Exemple : Serveur A distribue de 192.168.1.1 à 192.168.1.50.
Serveur B distribue de 192.168.1.51 à 192.168.1.100. Ainsi, si un serveur tombe en panne, 
l'autre peut toujours servir des adresses, et il n'y a aucun risque qu'ils donnent la même IP à deux personnes différentes.
