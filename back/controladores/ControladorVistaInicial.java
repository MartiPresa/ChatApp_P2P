package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import UI.IVistaChat;
import UI.IVistaInicial;
import UI.IVistaModoEscucha;
import UI.VistaChat;
import UI.VistaModoEscucha;
import back.Conexion;

public class ControladorVistaInicial implements ActionListener {

	private IVistaInicial vistaInicial = null;
	private Conexion conexion = null;

	public ControladorVistaInicial(IVistaInicial vista) {
		this.vistaInicial = vista;
		this.vistaInicial.addActionListener(this);
		this.conexion = new Conexion();
	}

	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();

		if (comando.equalsIgnoreCase("CONECTAR")) {
			boolean condition = !this.vistaInicial.getPuerto().equals("puerto")
					&& this.vistaInicial.getIP().equals("localhost");

			try {

				if (condition == false)
					JOptionPane.showMessageDialog(null, "El puerto o el IP son invalidos");
				else {
					System.out.println("Conexion exitosa\n");
					IVistaChat vistaChat = new VistaChat();
					conexion.setVista(vistaChat);
					this.conexion.conectar(this.vistaInicial.getIP(), Integer.parseInt(this.vistaInicial.getPuerto()));
					this.vistaInicial.mostrarVentana(false);
					vistaChat.getCont().setConexion(conexion);
					vistaChat.mostrarVentana(true);
					conexion.recibirMensajes(); // crea un thread para poder recibir mensajes por el socket
				}

			} catch (NumberFormatException e1) {
				System.out.println("e1");
			} catch (UnknownHostException e1) {

			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		} else if (comando.equalsIgnoreCase("MODOESCUCHA")) {
			IVistaModoEscucha vistaEscucha = new VistaModoEscucha();
			this.vistaInicial.mostrarVentana(false);
			vistaEscucha.mostrarVentana(true);
			vistaEscucha.setConexion(this.conexion);

		}

	}

}
