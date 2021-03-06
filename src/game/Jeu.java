/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import env3d.Env;
import java.util.ArrayList;

/**
 *
 * @author zodji
 */
public class Jeu {

    private Env env;
    private Room room;
    private Profil profil;
    private Tux tux;
    //private Partie partie;

    public Jeu() {

        // Crée un nouvel environnement
        env = new Env();

        // Instancie une Room
        room = new Room();
        

        // Règle la camera
        env.setCameraXYZ(50, 60, 175);
        env.setCameraPitch(-20);

        // Désactive les contrôles par défaut
        env.setDefaultControl(false);

        profil = new Profil();

    }

    public void execute() {

        // pour l'instant, nous nous contentons d'appeler la méthode joue comme cela
        // et nous créons une partie vide, juste pour que cela fonctionne
        joue(new Partie());
        // Détruit l'environnement et provoque la sortie du programme 
        env.exit();
    }

    public void joue(Partie partie) {

        // TEMPORAIRE : on règle la room de l'environnement. Ceci sera à enlever lorsque vous ajouterez les menus.
        env.setRoom(room);

        // Instancie un Tux
        tux = new Tux(env ,room);
        env.addObject(tux);
        

        // Ici, on peut initialiser des valeurs pour une nouvelle partie
        démarrePartie(partie);

        // Boucle de jeu
        Boolean finished;
        finished = false;
        while (!finished) {

            // Contrôles globaux du jeu (sortie, ...)
            //1 is for escape key
            if (env.getKey() == 1) {
                finished = true;
            }

            // Contrôles des déplacements de Tux (gauche, droite, ...)
            tux.déplace();
            // ... (sera complété plus tard) ...
            // Ici, on applique les regles
            appliqueRegles(partie);

            // Fait avancer le moteur de jeu (mise à jour de l'affichage, de l'écoute des événements clavier...)
            env.advanceOneFrame();
        }

        // Ici on peut calculer des valeurs lorsque la partie est terminée
        terminePartie(partie);

    }

    protected void démarrePartie(Partie partie){}

    protected  void appliqueRegles(Partie partie){}

    protected  void terminePartie(Partie partie){}

}
