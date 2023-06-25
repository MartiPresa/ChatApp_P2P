package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import UI.IVistaChat;
import UI.IVistaInicial;
import UI.VistaInicial;
import back.Conexion;

public class ControladorVistaChat implements ActionListener {

	private IVistaChat vistaChat = null;
    private Conexion conexion= null;
    
    public ControladorVistaChat(IVistaChat vista) {
        this.vistaChat = vista;
        this.vistaChat.addActionListener(this);
       
    } 

	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
        if (comando.equalsIgnoreCase("ABANDONAR")) {
        	
        	this.conexion.getMessageManager().enviaMensaje("El otro usuario se desconecto.\n");
        	this.conexion.getConectionHandler().terminarRecibirMensajes();
        	this.vistaChat.mostrarVentana(false);
        	IVistaInicial vistaInicial = new VistaInicial();
        	vistaInicial.mostrarVentana(true);
        }
        else {
        	if (comando.equalsIgnoreCase("ENVIAR")) {
        		this.conexion.getMessageManager().enviaMensaje(this.vistaChat.getTxtIngreseTextoAqui().getText());
        		this.vistaChat.getTextArea().setText(this.vistaChat.getTextArea().getText()+"\n\t\t\t" + this.vistaChat.getTxtIngreseTextoAqui().getText()+"\n");
        		this.vistaChat.getTxtIngreseTextoAqui().setText("");
        	}
        }

	}

	public Conexion getConexion() {
		return conexion;
	}

	public void setConexion(Conexion conexion) {
		this.conexion = conexion;
	}
	
}
