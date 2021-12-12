/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import env3d.Env;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author zodji
 */
public abstract class Jeu  {

    Env env;
    private Room room;
    private Profil profil;
    private Tux tux;
    //soit le mot tiré du dico soit on le definie de maniere 
    //aleatoire comme dans la partie 7.30

    private Dico dico;

    ArrayList<Letter> lettres;

    public ArrayList<Letter> getLettres() {
        return lettres;
    }
    
    public Env getEnv(){
    return env;}

    //private Partie partie;
    public Jeu() throws SAXException, IOException, ParserConfigurationException {

        // Crée un nouvel environnement
        env = new Env();

        // Instancie une Room
        room = new Room();

        // Règle la camera
        env.setCameraXYZ(50, 60, 175);
        env.setCameraPitch(-20);

        // Désactive les contrôles par défaut
        env.setDefaultControl(false);

        //profil = new Profil();
        profil = new Profil();

        lettres = new ArrayList<>();

       

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
        tux = new Tux(env, room);
        env.addObject(tux);

        /* 
        _______________________________________________________________________________________________________
                recupration des lettre d'un mot et ajout
                a l'environnement de manniere aleatoire
        _______________________________________________________________________________________________________
        
         */
        dico = new Dico("src/xml/dico.xml");
         
        dico.lireDictionnaireDom("src/xml","dico.xml");
        
        //le niveau sera changé quand on va gerer les partie ou l'utilisateur doit designer des niveau lui meme
        String mot = dico.getMotDepuisListeNiveau(1);
        
       
        char[] c = mot.toCharArray();

        for (char e : c) {

            Letter l = new Letter(e, positonLettreSelonX(), positionLettresSelonY());
            lettres.add(l);

        }

        /*for(Letter e:lettres){
            env.addObject(e);
        }  c'est pareil*/
        lettres.forEach(e -> {
            env.addObject(e);
        });

        /*
        _______________________________________________________________________________________________________
        _______________________________________________________________________________________________________
         */
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
    //distance d'un point a à un point b avec les coordonnés polaire
    protected double distance (Letter letter){
        
    return  Math.sqrt((tux.getX() - letter.getX()) *(tux.getX() - letter.getX()) +
            (tux.getY() - letter.getY()) * (tux.getY() - letter.getY())+ 
            (tux.getZ() - letter.getZ()) * (tux.getZ() - letter.getZ()))-4;
    }
   
    
     protected boolean collision(Letter letter) {
        return (distance(letter) <1 );
    }

    protected abstract void démarrePartie(Partie partie);

    protected abstract void appliqueRegles(Partie partie);

    protected abstract void terminePartie(Partie partie);
    
    

    private double positonLettreSelonX() {
        
        
        double x = 0.0;
        x = Math.random() * ((room.getWidth() - 2) - 1);
        return x;
    }

    private double positionLettresSelonY() {
        double y = 0.0;

        y = Math.random() * ((room.getDepth() - 2) - 1);

        return y;
    }

}
