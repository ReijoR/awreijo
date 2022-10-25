/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.reijo.miniprojekti;

/**
 *
 * @author Reijo
 */
public class ColumnDef {
    private String ColumnTitle;
    private int width;
    

    public ColumnDef(String Columntitle, int width) {
        this.ColumnTitle= Columntitle;
        this.width=width;
        
    }
    public int getWidth(){
        return width;
    }
    /**
     * @return the ColumnTitle
     */
    public String getColumnTitle() {
        return ColumnTitle;
    }

}
