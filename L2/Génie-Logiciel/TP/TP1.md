## Exercice 1

## 1. UML
<img width="708" height="436" alt="image" src="https://github.com/user-attachments/assets/91e58982-9a9b-4230-b9ec-2b01bc014ba2" />

## 2. Code 

```java
public class Exercice1 {
    private String _statut;
    public Exercice1(String ch) {
        // statut par défaut
        this.setStatutPair();
        // initialisation de la machine
        int state = 1;
        int rang = -1;
        while (state!=3) {
            switch (state) {
                case 1: // etat pair
                    rang++;
                    this.setStatutPair();
                    if (rang >= ch.length()) state=3;
                    else {
                        if (ch.charAt(rang) == '1') state=2;
                        else state=1;
                    }
                    break;
                case 2 : // etat impair
                    rang++;
                    this.setStatutImpair();
                    if (rang >= ch.length()) state=3;
                    else {
                        if (ch.charAt(rang) == '1') state=1;
                        else state=2;
                    }
                    break;
            }
        }
    }
    public String getStatut() {
        return this._statut;
    }
    private void setStatutPair() {
        this._statut = "pair";
    }
    private void setStatutImpair() {
        this._statut = "impair";
    }
    public static void main(String[] args) {
        String demo = "0011010010101";
        Exercice1 objet = new Exercice1(demo);
        System.out.println("La chaine [" + demo + "] contient un 
nombre de 1 " + objet.getStatut());
    }
}
```
