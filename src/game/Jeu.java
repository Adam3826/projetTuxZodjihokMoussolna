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
    //ArrayList<Letter> lettres;
    Letter lettre;
   

    public Jeu() {
        
          // Crée un nouvel environnement
        env = new Env();

        // Instancie une Room
        room = new Room() ;

        // Règle la camera
        env.setCameraXYZ(50, 60, 175);
        env.setCameraPitch(-20);

        // Désactive les contrôles par défaut
        env.setDefaultControl(false);

        // Instancie un profil par défaut
        profil = new Profil();
        //instanciatioon des lettres
        //lettres = new ArrayList<>();
        
        


    }
     
    public Env getEnv() {
        return env;
    }

    public void setEnv(Env env) {
        this.env = env;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Profil getProfile() {
        return profil;
    }

    public void setProfile(Profil profile) {
        this.profil= profile;
    }
    
    
    public void joue(Partie partie){
        
        // TEMPORAIRE : on règle la room de l'environnement. Ceci sera à enlever lorsque vous ajouterez les menus.
        env.setRoom(room);
        
        //declaration et initialisation de lettre
        
 
        // Instancie un Tux
        Tux tux = new Tux(env ,room );
        env.addObject(tux); //?!!?;);
        lettre=new Letter('c',10,20);
        env.addObject(lettre);
         
        // Ici, on peut initialiser des valeurs pour une nouvelle partie
        démarrePartie(partie);
         
        // Boucle de jeu
        Boolean finished;
        finished = false;
        while (!finished) {
 
            // Contrôles globaux du jeu (sortie, ...)
            //1 is for escape key
            if (env.getKey() == 1) {
                finished = true;//?!!?;
            }
 
            // Contrôles des déplacements de Tux (gauche, droite, ...)
            // ... (sera complété plus tard) ...
            tux.déplace();
 
            // Ici, on applique les regles
            appliqueRegles(partie);
 
            // Fait avancer le moteur de jeu (mise à jour de l'affichage, de l'écoute des événements clavier...)
            env.advanceOneFrame();
            
        }
 
        // Ici on peut calculer des valeurs lorsque la partie est terminée
        terminePartie(partie);
    }
    
    public void execute(){
        
        // pour l'instant, nous nous contentons d'appeler la méthode joue comme cela
        // et nous créons une partie vide, juste pour que cela fonctionne
        joue(new Partie());
         
        // Détruit l'environnement et provoque la sortie du programme 
        env.exit();
    
        
    }
 
    
    protected void démarrePartie(Partie partie){};
    protected void terminePartie(Partie partie){};
    protected void appliqueRegles(Partie partie){};
    
}
