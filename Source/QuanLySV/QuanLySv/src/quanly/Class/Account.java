/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanly.Class;

/**
 *
 * @author jacky
 */
public class Account {

    private int id;
    private String username;
    private String password;
    private String loaitk;
    
    public Account(int id,String u, String p, String l){
        this.id = id;
        this.username = u;
        this.password = p;
        this.loaitk = l;
    }
    /**
     * @return the id
     */
    
    public Object get(int x){
        switch (x){
            case 0:
                return this.id;
            case 1:
                return this.username;
            case 2:
                return this.password;
            case 3:
                return this.loaitk;
        }
        return null;
    }
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the loaitk
     */
    public String getLoaitk() {
        return loaitk;
    }

    /**
     * @param loaitk the loaitk to set
     */
    public void setLoaitk(String loaitk) {
        this.loaitk = loaitk;
    }
    
}
