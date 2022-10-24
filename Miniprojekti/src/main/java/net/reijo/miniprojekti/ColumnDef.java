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
    

    ColumnDef(String Columntitle, int width) {
        this.ColumnTitle= ColumnTitle;
        this.width=width;
        
    }

    /**
     * @return the ColumnTitle
     */
    public String getColumnTitle() {
        return ColumnTitle;
    }

    /**
     * @param ColumnTitle the ColumnTitle to set
     */
    public void setColumnTitle(String ColumnTitle) {
        this.ColumnTitle = ColumnTitle;
    }

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }
    
    
}
