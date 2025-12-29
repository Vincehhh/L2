## TP Révision commande Linux- Réseau 

### En vous aidant du man et d’internet mettre une adresse ip avec l’une de ces commandes. Réseau (192.168.4.0/24) sur enp0s8 .
### Donner la commande et une preuve de la réussite de votre commande.

Commande : 

```bash
sudo ip addr add 192.168.4.10/24 dev enp0s8
```

Preuve : 

```bash
ip addr show enp0s8
```
---

```bash
The primary network interface
allow-hot plug enp0s8
iface enp0s8 inet static
  address 192.168.1.50
  broadcast 192.168.1.255
  netmask 255.255.255.0

allow-hotplug enp0s3
auto enp0s3
iface enp0s3 inet dhcp
```
### Expliquer ces 2 configurations.
```bash
allow-hotplug enp0s8
iface enp0s8 inet static
  address 192.168.1.50
  broadcast 192.168.1.255
  netmask 255.255.255.0
```

enp0s8 (configuration statique):
allow-hotplug : L'interface est activée dès qu'elle est détectée par le noyau.
inet static : Indique que l'adresse IP est fixée manuellement .
Les lignes suivantes définissent l'IP (address), le masque de sous-réseau (netmask) et l'adresse de diffusion (broadcast) .

```bash
allow-hotplug enp0s3
auto enp0s3
iface enp0s3 inet dhcp
```
enp0s3 :
auto : L'interface est montée automatiquement au démarrage du système.
inet dhcp : L'interface va demander une configuration réseau (IP, passerelle, DNS) à un serveur DHCP sur le réseau.

### Faire une configuration ip fixe sur une interface de votre machine.

```bash
allow-hotplug eth0
iface eth0 inet static
  address 192.168.6.40
  broadcast 192.168.6.255
  netmask 255.255.255.0
```

### Vérifier que votre configuration fonctionne. Donner une preuve.
`ip addr show`

### À quoi sert la commande ping ?
Elle sert à tester l'accessibilité d'une machine à distance via le réseau. Elle utilise le protocole ICMP. Elle permet de vérifier si la connexion fonctionne, le temps de transmission des paquets, et d'observer si des paquets sont perdus. 

### À quoi sert la commande nslookup ? Commenter le résultat.

nslookup est un outil qui permet d'interroger les serveurs DNS pour traduire un nom de domaine en adresse IP et inversement.

### Expliquer la syntaxe de la commande dig précédente ? Que pouvez-vous tirer comme information du résultat de la commande précédente.

`dig` outil permettant d'interroger un serveur DNS.
`@ronsard.univ-tours.fr` On force l'utilisation d'un serveur DNS spécifique au lieu de celui par défaut.
`celene.univ-tours.fr` : Le nom de domaine que l'on souhaite résoudre.

Informations tirées : 
La requete a réussi (status : NOERROR)
Le domaine pointe vers l'ip 193.52.209.77
La requete a pris 49msec.

### `user@client:~$ sudo lsof -i tcp` À quoi sert précisément cette commande ?

`lsof` signifie LiSt Open Files 
`-i` filtre pour afficher les fichiers liés au réseau
`tcp` restreint l'affichage uniquement au protocole TCP

Cette commande liste tous les processus en cours d'exécution qui ont des connexions réseaux TCP ouvertes.

