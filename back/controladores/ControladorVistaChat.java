package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import UI.IVistaChat;
import UI.IVistaInicial;
import UI.vistaInicial;
import back.Conexion;
import back.Emisor;
import back.Receptor;

public class ControladorVistaChat implements ActionListener {

	private IVistaChat vistaChat = null;
    private Conexion conexion= null;
    //private Conexion conexionReceptor = null;
    
    public ControladorVistaChat(IVistaChat vista) {
        this.vistaChat = vista;
        this.vistaChat.addActionListener(this);
        this.conexion = vista.getConexion();
        //this.conexionReceptor = new Conexion(vista);
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
        		//System.out.println("mensajito manager"+conexion.getMessageManager());
        		this.conexion.getMessageManager().enviaMensaje(this.vistaChat.getTxtIngreseTextoAqui().getText());
//        		try {
//        			Socket socket = this.conexionReceptor.getsocket();
//                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
//                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//                    out.println(this.vistaChat.getTxtIngreseTextoAqui());
//                    out.close();
//                    socket.close();
//                    this.vistaChat.setText("");
//                    
//                } catch (Exception e1) {
//                    e1.printStackTrace();
//                }
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
