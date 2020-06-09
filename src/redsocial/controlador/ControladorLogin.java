/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redsocial.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import redsocial.modelo.Usuario;
import redsocial.vista.Ingresar;
import redsocial.vista.Registrar;

/**
 *
 * @author Jean
 */
public class ControladorLogin implements ActionListener {

    private Ingresar ingreso;
    private Registrar registro;
    private Controlador padre;

    public ControladorLogin(Ingresar ingreso, Registrar registro) {
        this.ingreso = ingreso;
        this.registro = registro;
        this.ingreso.btnIngresar.addActionListener(this);
        this.ingreso.btnRegistrar.addActionListener(this);
        this.registro.btnRegistrar.addActionListener(this);
    }

    public void inicia() {
        this.ingreso.txtContraseña.setText("");
        this.ingreso.txtCorreo.setText("");
        this.ingreso.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.ingreso.btnIngresar) {
            if (!"".equals(this.ingreso.txtCorreo.getText()) && !"".equals(this.ingreso.txtContraseña.getText())) {
                boolean encontrado = false;
                for (Usuario usuario : padre.getUsuarios()) {
                    if (usuario.getCorreo().equals(this.ingreso.txtCorreo.getText())
                            && usuario.getClave().equals(this.ingreso.txtContraseña.getText())) {
                        this.padre.inciciar(usuario);
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado) {
                    JOptionPane.showMessageDialog(null, "El usuario o la contraseña que ingresó no es correcto");
                }
                this.registro.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Llene todos los cambios");
            }
        } else if (e.getSource() == this.ingreso.btnRegistrar) {
            this.registro.setVisible(true);
            this.ingreso.setVisible(false);
        } else if (e.getSource() == this.registro.btnRegistrar) {
            if (!"".equals(this.registro.txtCorreo.getText()) && !"".equals(this.registro.txtContraseña.getText())
                    && !"".equals(this.registro.txtApellido.getText()) && !"".equals(this.registro.txtNick.getText())
                    && !"".equals(this.registro.txtEdad.getText()) && !"".equals(this.registro.txtNombre.getText())) {
                String apellido = this.registro.txtApellido.getText();
                String clave = this.registro.txtContraseña.getText();
                String correo = this.registro.txtCorreo.getText();
                int edad = Integer.parseInt(this.registro.txtEdad.getText());
                String nombre = this.registro.txtNombre.getText();
                String nick = this.registro.txtNick.getText();
                this.padre.registrarUsuario(apellido, clave, correo, edad, nombre, nick);
                this.registro.dispose();
                this.ingreso.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Llene todos los cambios");
            }
        }
    }

    public void setPadre(Controlador padre) {
        this.padre = padre;
    }

}
