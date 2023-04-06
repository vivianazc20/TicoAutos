/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class Usuario {
    private int id;
    private String user;
    private String password;
    private String perfil;

    public Usuario() {
    }

    public Usuario(String user, String password, String perfil) {
        this.user = user;
        this.password = password;
        this.perfil = perfil;
    }

    public Usuario(String user, String perfil) {
        this.user = user;
        this.perfil = perfil;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
    
    
}
