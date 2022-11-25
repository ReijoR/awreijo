/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.reijo.techniques.advanced;

/**
 *
 * @author Reijo
 */
class Point{
    private int x,y;
    
    static void justWait(int ms){
        try{
            Thread.sleep(ms);
        }
        catch(Exception ex){}
    }
    
    public synchronized void set(int val){
        x=val;
        justWait(100);
        y=val;
    }
    
    public synchronized String toString(){
        return "("+x+","+y+")";
    }
}

    

