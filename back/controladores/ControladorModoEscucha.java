package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import UI.IVistaChat;
import UI.IVistaInicial;
import UI.IVistaModoEscucha;
import UI.VistaChat;
import UI.VistaInicial;
import back.Conexion;

public class ControladorModoEscucha implements ActionListener {

	private IVistaModoEscucha vistaModoEscucha = null;
	private Conexion conexion;
	// private Conexion conexion= new Conexion();

	public ControladorModoEscucha(IVistaModoEscucha vista) {
		this.vistaModoEscucha = vista;
		this.vistaModoEscucha.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();

		if (comando.equalsIgnoreCase("VOLVER")) {
			this.vistaModoEscucha.mostrarVentana(false);
			IVistaInicial vistaInicial = new VistaInicial();
			vistaInicial.mostrarVentana(true);
		} else if (comando.equalsIgnoreCase("ACTIVAR")) {
			if (!this.vistaModoEscucha.getPuerto().equals("puerto")) {

				try {
					this.conexion = this.vistaModoEscucha.getConexion();
					IVistaChat vistaChat = new VistaChat();
					conexion.setVista(vistaChat);
					vistaChat.getCont().setConexion(conexion);
					JOptionPane.showMessageDialog(null,
							"Se encuentra en modo escucha. Espere a que alguien lo contacte.");
					this.conexion.Conectar(Integer.parseInt(this.vistaModoEscucha.getPuerto()));

					this.vistaModoEscucha.mostrarVentana(false);
					vistaChat.setText("Puerto: "+this.conexion.getsocket().getLocalPort());
					vistaChat.mostrarVentana(true);

				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} else
				JOptionPane.showMessageDialog(null, "El puerto es inválido");
		}

	}

}
