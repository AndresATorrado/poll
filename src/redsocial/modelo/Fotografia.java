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
public class Fotografia {
    private String nombre;
    private String descripcion;
    private ArrayList<Etiqueta> etiquetados;

    public Fotografia(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.etiquetados = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<Etiqueta> getEtiquetados() {
        return etiquetados;
    }

    public void setEtiquetados(ArrayList<Etiqueta> etiquetados) {
        this.etiquetados = etiquetados;
    }
    
}
