/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.model;

/**
 *
 * @author Hazzan
 */
public class userBean {
    private String username = "hazz";
    private String pass = "hazz";
    public boolean isUserValid(String username, String pass){
        if (username.equals(this.username) && pass.equals(this.pass)){
            return true;
        }return false;
            
    }
}
