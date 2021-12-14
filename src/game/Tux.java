/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import env3d.Env;
import env3d.advanced.EnvNode;
import org.lwjgl.input.Keyboard;

/**
 *
 * @author zodji
 */

public class Tux extends EnvNode {
    
    
    
    
     Env env;
     Room room=new Room();
   
    public Tux(Env env, Room room) {
        this.env = env;
       
        setScale(4.0);
        setX(room.getWidth() / 2);// positionnement au milieu de la largeur de la room
        setY(getScale() * 1.1); // positionnement en hauteur basé sur la taille de Tux

        setZ(room.getDepth() / 2); // positionnement au milieu de la profondeur de la room
        setTexture("models/tux/tux.png");
        setModel("models/tux/tux.obj");

    }
    
    
    
    public void déplace() {
        
        
        
         if (env.getKeyDown(Keyboard.KEY_Z) || env.getKeyDown(Keyboard.KEY_UP)) { // Fleche 'haut' ou Z
            // Haut
            this.setRotateY(180);
            if (this.getZ() >= 0) {
                this.setZ(this.getZ() - 1.0);
            }
        }
        
        if (env.getKeyDown(Keyboard.KEY_Q) || env.getKeyDown(Keyboard.KEY_LEFT)) { // Fleche 'gauche' ou Q
            // Gauche
            this.setRotateY(270);
            if (this.getX() >= 0) {
                this.setX(this.getX() -1.0);
            }

        }
        
        if (env.getKeyDown(Keyboard.KEY_D) || env.getKeyDown(Keyboard.KEY_RIGHT)) { // Fleche 'droite' ou S
            // Droite
            this.setRotateY(90);
            if (this.getX() <= room.getWidth()){
                this.setX(this.getX() +1.0);
            }

        }
        
    
        if (env.getKeyDown(Keyboard.KEY_W)|| env.getKeyDown(Keyboard.KEY_DOWN)) { // Fleche 'bas' ou S
            // Bas
            this.setRotateY(0);
            if(this.getZ() <= room.getDepth()){
                this.setZ(this.getZ() + 1.0);
            }

        } 
    }  
    

    
    
    
    
    
} 
           
