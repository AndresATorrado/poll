/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redsocial.modelo;

/**
 *
 * @author Jean
 */
public class Etiqueta {
    private int x;
    private int y;
    private Usuario usuario;
    private String nombreUsuario;

    public Etiqueta(int x, int y, Usuario usuario) {
        this.x = x;
        this.y = y;
        this.usuario = usuario;
        this.nombreUsuario = this.usuario.getNick();
    }

    public Etiqueta(int x, int y, String nombreUsuario) {
        this.x = x;
        this.y = y;
        this.nombreUsuario = nombreUsuario;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
  
}
