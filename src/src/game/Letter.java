/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;
import env3d.Env;
import env3d.EnvObject;

/**
 *
 * @author zodji
 */

//letter  herite de l'nevironnement EnvNode exectement comme on l'a fafit avec tux ne pas oublier les 
public class Letter extends EnvObject {
    
    private char letter;

    
    //on declare l'environnelment dans lequel se trouvera les mots
    private Env env;

    
    //constructeurs de la classe letter
    Letter(char l, double x ,double y){
        
        setLetter(l);
        this.setScale(4.0);
        this.setY(4.0);
        this.setX(x);
        this.setZ(y);
       // ajoutLetter("s");
       

     
                
    }
    
    /*private void ajoutLetter(String  letters){
      String mot=letters;
      for (int i =0;i<mot.length();i++){
          letter= mot.charAt(i);
          setLetter(letter);
      }
    }*/
    
 
    
     public void setLetter(char letter) {
         //si nottre lettre est une chaine vide on affaiche un cube sans la lettre 
         //si non on affiche la cube avec la lettre passé passer en paramettre 
         //ces lettre et cubes sont disponible dans le dossier de l'archive telecharger 
         //d'ou il faut mettre lechemin vers  et l'objet cube et les lettres
        if (letter == ' ') {
            this.setTexture("models/cube/cube.png");
        } else {
            this.setTexture("models/letter/" + letter + ".png");
        }
        
        //ici c'est le model objet de la lettre 
        this.setModel("models/cube/cube.obj");
       
    }
    
    public char getLetter() {
        return this.letter;
    }
    
    
}
