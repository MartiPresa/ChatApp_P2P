package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import UI.IVistaChat;
import UI.IVistaInicial;
import UI.vistaInicial;
import back.Conexion;
import back.Emisor;

public class ControladorVistaChat implements ActionListener {

	private IVistaChat vistaChat = null;
    private Emisor conexion= new Conexion();

    public ControladorVistaChat(IVistaChat vista) {
        this.vistaChat = vista;
        this.vistaChat.addActionListener(this);
        
    } 

	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
        if (comando.equalsIgnoreCase("ABANDONAR")) {
        	this.vistaChat.mostrarVentana(false);
        	IVistaInicial vistaInicial = new vistaInicial();
        	vistaInicial.mostrarVentana(true);
        }
        else {
        //	if (comando.equalsIgnoreCase("ENVIAR")) 
        }

	}

}
