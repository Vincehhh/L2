# TP SSH 2025


## **Donner la commande à utiliser pour l’installation et la sortie de terminal.**

```bash
sudo apt-get install ssh
```


## Sur quelle(s) IP écoute par défaut le serveur SSH ? Donner une sortie de terminal qui valide votre réponse.

Par défaut, SSH écoute sur **toutes** les interfaces réseaux disponibles de la machine.

```
sudo netstat -tulpn | grep ssh
```
