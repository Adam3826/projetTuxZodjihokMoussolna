/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author zodji
 */
public class Chronometre {
   


  private long begin;
    private long end;
    private long current;
    private int limite;

    public Chronometre(int limite) {
        //intialisation
        this.limite=limite;
        start();
        stop();
    }
    
    public void start(){
        begin = System.currentTimeMillis();
    }
  //quand on stop le chrono  c'est comme si on recuprere la valeur courante du chronometre
    public void stop(){
        end = System.currentTimeMillis();
    }
 
    public long getTime() {
        return end-begin;
    }
 
    public long getMilliseconds() {
        return end-begin;
    }
    //cating en int
    public int getSeconds() {
        return (int) ((end - begin) / 1000.0);
    }
 
    public double getMinutes() {
        return (end - begin) / 60000.0;
    }
 
    public double getHours() {
        return (end - begin) / 3600000.0;
    }
    
    /**
    * Method to know if it remains time.
    */
    
    //temps ecouler est egale au temps du deut moins le temps de fin(temps courant)
    // a verifier plutot current moins fin ???
    //si le temps ecouler est inferierieur  au temps limite alors on renvoie un tru(il a gagner)
    public boolean remainsTime() {
        current = System.currentTimeMillis();
        int timeSpent;
        timeSpent = (int) ((current-begin)/1000.0);
        return (timeSpent<this.limite);
    }
     
}

    

