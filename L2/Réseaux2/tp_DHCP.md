# Mise en place d’un serveur DHCP

## Montrer les interfaces actives sur votre machine.

Commande à utiliser : `ifconfig` ou `ip addr show`


## Donner la commande et commenter votre réponse. 

```bash
sudo dhclient -r enp0s8   # (Release : libère l'IP)
sudo dhclient -v enp0s8   # (Verbose : redemande une IP en mode bavard)
```

## Fournir une extraction des logs du serveur pour montrer quel(s) message(s) protocolaire(s) ont transité après cette commande

Commande pour obtenir une extraction des logs des messages protocolaires : 

```bash
sudo journalctl -u isc-dhcp-server -f
```


# DNS : whois

Commande à effectuer : `whois univ-tours.fr`

## À qui appartient ce nom de domaine ?

Propriétaire : UNIVERSITE DE TOURS FRANCOIS RABELAIS

## Quelle est sa date de création ?

Date de création : 19 décembre 1995

## Quel est son bureau d’enregistrement ?

Bureau d'enregistrement : GIP RENATER

## Quels sont les serveurs DNS en charge de ce nom de domaine ?

Serveur DNS : admin.cnrs-orleans.fr, ronsard.univ-tours.fr.

# Utilisation de la résolution de noms

## Déterminez l'adresse de www.inria.fr. (indiquer la commande et la réponse)

Commande : `dig www.inria.fr`

Reponse : `128.93.162.84`

## Quels sont les serveurs de noms interrogés ?

Commande : `dig +trace www.univ-tours.fr`

nom serveurs : `univ-tours.fr`

## www.yahoo.fr est-il le nom canonique ou un alias ? Donner la commande et la réponse.

Commande : `dig yahoo.fr`

c'est un alias. 




