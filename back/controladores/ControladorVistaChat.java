package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import UI.IVistaChat;
import UI.IVistaInicial;
import UI.vistaInicial;
import back.Conexion;
import back.Emisor;

public class ControladorVistaChat implements ActionListener {

	private IVistaChat vistaChat = null;
    private Emisor conexion= null;

    public ControladorVistaChat(IVistaChat vista) {
        this.vistaChat = vista;
        this.vistaChat.addActionListener(this);
        this.conexion = new Conexion (vista);
        
    } 

	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
        if (comando.equalsIgnoreCase("ABANDONAR")) {
        	this.vistaChat.mostrarVentana(false);
        	IVistaInicial vistaInicial = new vistaInicial();
        	vistaInicial.mostrarVentana(true);
        	//Socket closeeeee
        }
        else {
        	if (comando.equalsIgnoreCase("ENVIAR")) {
        		
        	}
        }

	}

}
