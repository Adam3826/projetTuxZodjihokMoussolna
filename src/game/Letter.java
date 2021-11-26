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

    
    
    Letter(char l, double x ,double y){
        
        this.letter=l;
        //this.setScale(4.0);
        this.setY(4.0);
        this.setX(x);
        this.setZ(y);
       

     
                
    }
    
 
    
     public void setLetter(char letter) {
         //si nottre lettre est une chaine vide on affaiche un cube sans la lettre 
         //si non on affiche la cube avec la lettre passé passer en paramettre 
         //ces lettre et cubes sont disponible dans le dossier de l'archive telecharger 
         //d'ou il faut mettre lechemin vers  et l'objet cube et les lettres
        if (letter == ' ') {
            this.setTexture("textures/letter/cube.png");
        } else {
            this.setTexture("textures/letter/" + letter + ".png");
        }
        
        //ici c'est le model objete de la lettre 
        this.setModel("textures/letter/cube.obj");
        this.letter = letter;
    }
    
    public char getLetter() {
        return this.letter;
    }
    
    
}
