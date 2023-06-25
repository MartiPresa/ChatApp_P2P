package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import UI.IVistaChat;
import UI.IVistaInicial;
import UI.IVistaModoEscucha;
import UI.vistaChat;
import UI.vistaEspera;
import back.Conexion;


public class ControladorVistaInicial implements ActionListener{
	
	private IVistaInicial vistaInicial = null;
    private Conexion conexion= null;
    
    public ControladorVistaInicial(IVistaInicial vista) {
        this.vistaInicial = vista;
        this.vistaInicial.addActionListener(this);
        this.conexion = new Conexion();
    } 

	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
        if (comando.equalsIgnoreCase("CONECTAR")) {
        	boolean condition = !this.vistaInicial.getPuerto().equals("puerto")&& this.vistaInicial.getIP().length()>5;
   
        	
            try {
            	
            	if (condition == false)
            		JOptionPane.showMessageDialog(null, "El puerto o el IP son invalidos");
            	else {
            		System.out.println("Conexion exitosa\n");
            		
            		IVistaChat vistaChat = new vistaChat();
            		conexion.setVista(vistaChat);
            		
            		this.conexion.conectar(this.vistaInicial.getIP(), Integer.parseInt(this.vistaInicial.getPuerto()));
            		
//            		IVistaChat vistaChat = new vistaChat();
//            		conexion.setVista(vistaChat);
            		this.vistaInicial.mostrarVentana(false);  
            		
            		//vistaChat.setConexion(conexion);
            		vistaChat.getCont().setConexion(conexion);
            		vistaChat.mostrarVentana(true);
            		conexion.recibirMensajes();	       // crea un thread para poder recibir mensajes por el socket     	
            	}
            		
			} catch (NumberFormatException e1) {
				System.out.println("e1");
			} catch (UnknownHostException e1) {
				
			} catch (IOException e1) {
				//JOptionPane.showMessageDialog(null, "Lo siento. El receptor no se encuentra en modo escucha.");
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
        }
        else if (comando.equalsIgnoreCase("MODOESCUCHA")) {
        		IVistaModoEscucha vistaEscucha = new vistaEspera();
        		this.vistaInicial.mostrarVentana(false);
        		vistaEscucha.mostrarVentana(true);  
        		vistaEscucha.setConexion(this.conexion);
        		
        }
        
		
	}
    
}
