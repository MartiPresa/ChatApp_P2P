package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import UI.IVistaChat;
import UI.IVistaInicial;
import UI.IVistaModoEscucha;
import UI.vistaChat;
import UI.vistaInicial;
import back.Conexion;
import back.Receptor;

public class ControladorModoEscucha implements ActionListener {

	private IVistaModoEscucha vistaModoEscucha = null;
	private Conexion conexion;
    //private Conexion conexion= new Conexion();

    public ControladorModoEscucha(IVistaModoEscucha vista) {
        this.vistaModoEscucha = vista;
        this.vistaModoEscucha.addActionListener(this);
    } 

	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
        if (comando.equalsIgnoreCase("VOLVER")) {
        	this.vistaModoEscucha.mostrarVentana(false);
        	IVistaInicial vistaInicial = new vistaInicial();
        	vistaInicial.mostrarVentana(true);
        }
        else  if (comando.equalsIgnoreCase("ACTIVAR")) {
        	try {
        		this.conexion = this.vistaModoEscucha.getConexion();
    			IVistaChat vistaChat = new vistaChat();
        		conexion.setVista(vistaChat);
				vistaChat.getCont().setConexion(conexion);
				JOptionPane.showMessageDialog(null, "Se encuentra en modo escucha. Espere a que alguien lo contacte.");
				this.conexion.Conectar(this.vistaModoEscucha.getPuerto());
//				VENTANA EMERGENTE PARA QUE EL USUARIO CONFIRME SI QUIERE INICIAR UN CHAT
//				if (this.conexion.getsocket().isConnected()) {
//					JOptionPane.showMessageDialog(null, "Un usuario quiere iniciar un chat.\nDesea aceptarlo?");
//				}
					
				//vistaChat.setConexion(conexion);
				//if(this.conexion.getsocket().isConnected() == true) {
				//Thread.sleep(2000);
				this.vistaModoEscucha.mostrarVentana(false);
				vistaChat.mostrarVentana(true);
				//}
				
				
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
        	
        
		
	}

}
