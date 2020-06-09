/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redsocial.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import redsocial.modelo.Comentario;
import redsocial.modelo.Etiqueta;
import redsocial.modelo.Fotografia;
import redsocial.modelo.Grupo;
import redsocial.modelo.Usuario;
import redsocial.vista.Index;

/**
 *
 * @author Jean
 */
public class Controlador implements ActionListener {

    private Index index;
    private ControladorLogin login;
    private ControladorNuevaFoto nuevaFoto;
    private Usuario usuarioActual;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Grupo> grupos;

    public Controlador(Index index, ControladorLogin login, ControladorNuevaFoto nuevaFoto) {
        this.index = index;
        this.login = login;
        this.nuevaFoto = nuevaFoto;
        this.login.setPadre(this);
        this.nuevaFoto.setPadre(this);
        this.grupos = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.login.inicia();
    }

    public void inciciar(Usuario usuarioActual) {
        this.index.btnBorrar.addActionListener(this);
        this.index.btnComentario.addActionListener(this);
        this.index.btnMisFotosComen.addActionListener(this);
        this.index.btnNuevaFoto.addActionListener(this);
        this.index.btnSalir.addActionListener(this);
        this.usuarioActual = usuarioActual;
        index.lblNombre.setText(this.usuarioActual.getNick());
        index.setVisible(true);
        String sUsuarios = "";
        for (Usuario usuario : usuarios) {
            sUsuarios += usuario.getNick() + "\n";
        }
        this.index.txtUsuarios.setText(sUsuarios);
        listarComentarios();
    }

    public void registrarUsuario(String apellido, String clave, String correo, int edad, String nombre, String nick) {
        boolean repetido = false;
        for (Usuario usuario : usuarios) {
            if (correo.equals(usuario.getCorreo()) || nick.equals(usuario.getNick())) {
                repetido = true;
                break;
            }
        }
        if (!repetido) {
            Usuario nuevoUsuario = new Usuario(apellido, clave, correo, edad, nombre, nick);
            usuarios.add(nuevoUsuario);
            JOptionPane.showMessageDialog(null, "Usuario registrado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "El correo o nick del usuario ya está en uso");
        }
    }

    public void añadirFoto(String nombre, String descripcion, ArrayList<Etiqueta> etiquetas) {
        Fotografia nuevaFoto = new Fotografia(nombre, descripcion);
        nuevaFoto.setEtiquetados(etiquetas);
        usuarioActual.getFotografias().add(nuevaFoto);
        JOptionPane.showMessageDialog(null, "Fotografía añadida correctamente");
    }
    
    public void listarComentarios() {
        String sComentario = "";
        for (Usuario usuario : usuarios) {
            for (Comentario comentario : usuario.getComentarios()) {
                sComentario += comentario.getFecha()+"\n-"+usuario.getNick()+" "+comentario.getComentario()+"\n";
            }
            sComentario += "\n";
        }
        this.index.txtAreaFotosComen.setText(sComentario);
    }
    
    public void listarFotos() {
        String sFotos = "";
        for (Fotografia fotografia : usuarioActual.getFotografias()) {
            sFotos += fotografia.getNombre()+"\n-desc: "+fotografia.getDescripcion()+"\n";
        }
        this.index.txtAreaFotosComen.setText(sFotos);
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public ArrayList<Grupo> getGrupos() {
        return grupos;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.index.btnNuevaFoto) {
            nuevaFoto.iniciar();
        } else if (e.getSource() == this.index.btnComentario) {
            if (!"".equals(this.index.txtComentario.getText())) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                String sdfString = sdf.format(new Date());
                Comentario nuevoComentario = new Comentario(this.index.txtComentario.getText(), sdfString);
                JOptionPane.showMessageDialog(null, nuevoComentario.getComentario());
                usuarioActual.getComentarios().add(nuevoComentario);
            }
            listarComentarios();
        } else if (e.getSource() == this.index.btnBorrar) {
            this.index.txtComentario.setText("");
        } else if(e.getSource() == this.index.btnMisFotosComen) {
            if ("Comentarios".equalsIgnoreCase(this.index.btnMisFotosComen.getText())) {
                listarComentarios();
                this.index.btnMisFotosComen.setText("Mis Fotografías");
            } else if ("Mis Fotografías".equalsIgnoreCase(this.index.btnMisFotosComen.getText())) {
                listarFotos();
                this.index.btnMisFotosComen.setText("Comentarios");
            }
        } else if(e.getSource() == this.index.btnSalir) {
            this.index.dispose();
            this.login.inicia();
            this.usuarioActual = null;
        }
    }

}
