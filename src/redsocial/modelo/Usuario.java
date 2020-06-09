/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redsocial.modelo;

import java.util.ArrayList;

/**
 *
 * @author Jean
 */
public class Usuario {
    private String nombre;
    private String apellido;
    private String nick;
    private int edad;
    private String clave;
    private String correo;
    private ArrayList<Comentario> comentarios;
    private ArrayList<Fotografia> fotografias;

    public Usuario(String apellido, String clave, String correo, int edad, String nombre, String nick) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nick = nick;
        this.edad = edad;
        this.clave = clave;
        this.correo = correo;
        this.comentarios = new ArrayList<>();
        this.fotografias = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public ArrayList<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(ArrayList<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public ArrayList<Fotografia> getFotografias() {
        return fotografias;
    }

    public void setFotografias(ArrayList<Fotografia> fotografias) {
        this.fotografias = fotografias;
    }
    
}
