/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redsocial;

import redsocial.controlador.Controlador;
import redsocial.controlador.ControladorLogin;
import redsocial.controlador.ControladorNuevaFoto;
import redsocial.vista.Index;
import redsocial.vista.Ingresar;
import redsocial.vista.NuevaFoto;
import redsocial.vista.Registrar;

/**
 *
 * @author Jean
 */
public class RedSocial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Index index = new Index();
        Ingresar ingreso = new Ingresar();
        Registrar registro  = new Registrar();
        NuevaFoto nuevaFoto = new NuevaFoto();
        ControladorNuevaFoto controladorNuevaFoto = new ControladorNuevaFoto(nuevaFoto);
        ControladorLogin login = new ControladorLogin(ingreso, registro);
        Controlador controlador = new Controlador(index, login, controladorNuevaFoto);
    }
    
}
