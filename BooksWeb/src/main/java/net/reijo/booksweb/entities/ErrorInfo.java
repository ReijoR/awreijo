/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.reijo.booksweb.entities;

/**
 *
 * @author Reijo
 */
public class ErrorInfo {
    private int code=123;
    private String message="VIRHE";
    
    public ErrorInfo(){
    
    }
    
    public ErrorInfo(int code, String message){
        this.code=code;
        this.message = message;
    }
    /**
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
    
}
