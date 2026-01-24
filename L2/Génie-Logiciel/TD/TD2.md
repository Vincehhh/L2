# TD2 – Modélisation UML (part 1)

## Application de covoiturage

### La démarche est la même pour chacune des parties. On chercher à recenser les cas 
### d’utilisation, et à les décrire (acteurs, uses cases, scénarios). Puis, pour chaque scénario, on 
### va réaliser un diagramme de séquences système. Il sera ensuite raffiné, (analyse puis 
### conception 3-tier). 
### On s’intéressera en priorité aux points 1 et 4, en considérant que le paiement est un service 
### externalisé (proposé par une banque par exemple).

---

### 1. Inscription et gestion du profil


Description : 

Nom du Cas : S'inscrire

Acteur Principal : Passager

Objectif : 
- Créer un compte utilisateur sécurisé avec ses préférences.

Pré-conditions :
- L'application est lancée.
- L'utilisateur n'est pas encore connecté/inscrit.

Scénario:

- Le Passager demande la création d'un compte.

- Le Système affiche le formulaire d'inscription demandant :
  - Les informations de base : Nom, Email, Numéro de téléphone.
  - Les préférences de trajet : Musique, Discussions, Bagages, Animaux .

- Le Passager saisit l'ensemble des informations et valide.

- Le Système vérifie la validité des formats (email valide, tel valide).
  
- Le Système lance la procédure de vérification d'identité (envoi d'un code par SMS/Email).

- Le Système demande la saisie du code de vérification.

 - Le Passager reçoit le code et le saisit dans l'application.
 
 - Le Système valide l'identité.Le Système crée le compte, enregistre les préférences et connecte l'utilisateur.
 
 - Scénarios d'Exception :
    - A l'étape 4 : Si l'email ou le téléphone existe déjà $\to$ Le Système affiche une erreur "Compte déjà existant".
    - A l'étape 8 : Si le code saisi est incorrect $\to$ Le Système affiche une erreur et propose de renvoyer le code.
    
  - Post-conditions :
     - Le profil Passager est créé en base de données avec ses préférences.
     - Le Passager est authentifié et redirigé vers l'accueil.

### Recensement cas d'utilisation et description



### Diagramme de séquence 

<img width="977" height="461" alt="image" src="https://github.com/user-attachments/assets/673c9419-5e77-41be-98f5-b22d8ae3b2fb" />


### Version raffiné : 

<img width="1415" height="907" alt="image" src="https://github.com/user-attachments/assets/44a169d8-019d-474a-8c1c-809159fbed13" />

