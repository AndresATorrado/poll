/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redsocial.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import redsocial.modelo.Etiqueta;
import redsocial.vista.NuevaFoto;

/**
 *
 * @author Jean
 */
public class ControladorNuevaFoto implements ActionListener{
    private NuevaFoto nuevaFoto;
    private ArrayList<Etiqueta> etiquetas;
    private Controlador padre;

    public ControladorNuevaFoto(NuevaFoto nuevaFoto) {
        this.nuevaFoto = nuevaFoto;
        this.etiquetas = new ArrayList<>();
    }
    
    public void iniciar() {
        this.nuevaFoto.btnAgregarEtiquetado.addActionListener(this);
        this.nuevaFoto.btnSubir.addActionListener(this);
        this.etiquetas.clear();
        this.nuevaFoto.txtDescripcion.setText("");
        this.nuevaFoto.txtEtiquetados.setText("");
        this.nuevaFoto.txtInvitado.setText("");
        this.nuevaFoto.txtX.setText("");
        this.nuevaFoto.txtY.setText("");
        this.nuevaFoto.txtNick.setText("");
        this.nuevaFoto.txtNombre.setText("");
        this.nuevaFoto.setVisible(true);
    }
    
    public void añadirFoto(String nombre, String descripcion) {
        this.padre.añadirFoto(nombre, descripcion, this.etiquetas);
    }
    
    public void listarEtiquetas() {
        String sEtiqueta = "";
        for (Etiqueta etiqueta : etiquetas) {
            sEtiqueta += etiqueta.getNombreUsuario()+"\n";
        }
        this.nuevaFoto.txtEtiquetados.setText(sEtiqueta);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.nuevaFoto.btnAgregarEtiquetado) {
            if (!"".equals(this.nuevaFoto.txtX.getText()) && !"".equals(this.nuevaFoto.txtY.getText())){
                if (!"".equals(this.nuevaFoto.txtInvitado.getText())) {
                    Etiqueta invitado = new Etiqueta(Integer.parseInt(this.nuevaFoto.txtX.getText()), 
                            Integer.parseInt(this.nuevaFoto.txtY.getText()), this.nuevaFoto.txtInvitado.getText());
                    etiquetas.add(invitado);
                } else if (!"".equals(this.nuevaFoto.txtNick.getText())) {
                    Etiqueta usuario = new Etiqueta(Integer.parseInt(this.nuevaFoto.txtX.getText()), 
                            Integer.parseInt(this.nuevaFoto.txtY.getText()), this.nuevaFoto.txtInvitado.getText());
                    etiquetas.add(usuario);
                } else {
                    JOptionPane.showMessageDialog(null, "Debe llenar uno de los campos, Invitado o Usuario");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe llenar los campos obligatorios");
            }
            listarEtiquetas();
        } else if(e.getSource()== this.nuevaFoto.btnSubir) {
            if (!"".equals(this.nuevaFoto.txtNombre.getText()) && !"".equals(this.nuevaFoto.txtDescripcion.getText())) {
                if (this.etiquetas.size() >= 2 && this.etiquetas.size() <= 5) {
                    añadirFoto(this.nuevaFoto.txtNombre.getText(), this.nuevaFoto.txtDescripcion.getText());
                } else {
                    JOptionPane.showMessageDialog(null, "Debe etiquetar entre 2 a 5 usuarios en la foto");
                }
            } 
        }
    }

    public void setPadre(Controlador padre) {
        this.padre = padre;
    }
   
}
