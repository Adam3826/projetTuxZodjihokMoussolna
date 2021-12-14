/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import env3d.Env;
import java.util.ArrayList;
import env3d.advanced.EnvNode;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * /**
 *
 * @author zodji
 */
public class JeuDevineLeMotOrdre extends Jeu {

    private int nbLettresRestantes;
    private Chronometre chrono;
    private final int tempsDeJeu = 80;

    private int getNbLettresRestantes() {
        return nbLettresRestantes;
    }

    public void setNbLettresRestantes(int nbLettresRestantes) {
        this.nbLettresRestantes = nbLettresRestantes;
    }

    public Chronometre getChrono() {
        return chrono;
    }

    public void setChrono(Chronometre chrono) {
        this.chrono = chrono;
    }

    @Override
    public ArrayList<Letter> getLettres() {
        return lettres;
    }

    public void setLettres(ArrayList<Letter> lettres) {
        this.lettres = lettres;
    }

    public JeuDevineLeMotOrdre() throws SAXException, IOException, ParserConfigurationException {
        //appelle au constructeur de la classe jeu qui initialise 
        //l'environnement ainsi que le mot et tux
        super();

        this.nbLettresRestantes = nbLettresRestantes;
        //this.chrono = new Chronometre(30);//temps limite 30 seconde

    }

    //lorsqu'on demarre une partie  on initialise le chrono à sa valeur max(ici 30 s) puis on demarre le chrono le 
    //nbre de mot lettre restant est initialiser aà la taille du mot
    @Override
    protected void démarrePartie(Partie partie) {
        chrono = new Chronometre(tempsDeJeu);
        chrono.start();  //la methode start est dans la classe Chrono
        //lorsqu'on demarre une partie  le nombre de lettre restantes est egale au nombre de lettre du mot
        nbLettresRestantes = getLettres().size();

    }

    @Override
    protected void appliqueRegles(Partie partie) {
        if (chrono.remainsTime() ) {

            if (nbLettresRestantes > 0) {
                if(tuxTrouveLettre()){
                //on remet ajour la partie avec le nombre restant de letttre
                //partie.setTrouve(nbLettresRestantes);
                env.removeObject(getLettres().get(getLettres().size()-nbLettresRestantes));
                lettres.remove(getLettres().size() -nbLettresRestantes);
                nbLettresRestantes--;
                //puis on enleve cette lettre de l'environnement
                }
            }else{
               env.exit();
               System.out.print("victoire");
            }
            // si il reste plus de temps on met ajour  la partie et on met fin  a la partie
            /*if (!chrono.remainsTime()) {
                partie.setTrouve(nbLettresRestantes);
                partie.finPartie = true;
            }*/

           /* if (getNbLettresRestantes() == 0) {
                partie.setTrouve(nbLettresRestantes);
                partie.finPartie = true;
            }
            partie.setTemps((int) chrono.getTime());
*/
        }else{
            
            env.exit();
        }
        //si le temps de jeu est fini on termine la partie et on remet ajour le nombre de lettre

        //ici on applique les regle d'une partie qui sont
        //on enleve la lettre de l'evironnement
    }
    

    @Override
    protected void terminePartie(Partie partie) {
       /* //on stop le chrono une fois la partie terminer
        chrono.stop();
        //on recupere dans ce cas la durée emis pour trouver les lettre
        //getTime() est de type long dans la classe chrono donc il faut le caster
        int durée = (int) chrono.getTime();
        //on met ajour le temps
        if (durée < tempsDeJeu) {
            partie.setTemps(durée);
        }
        //et le nombre de lettre restante
        partie.setTrouve(getNbLettresRestantes());*/
    }

    private boolean tuxTrouveLettre() {
        boolean trouve = false;
        ArrayList<Letter> lettres = this.getLettres();
        if (lettres.isEmpty() == false) {
            Letter l = lettres.get(0);
            if (collision(l)) {
                trouve = true;
            }
        }
        return trouve;

    }

    private int getTemps() {
        return (int) chrono.getTime();
    }

}