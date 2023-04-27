package back.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import back.back.Conexion;
import front.UI.IVistaInicial;
import front.UI.IVistaChat;
import front.UI.IVistaModoEscucha;
import front.UI.vistaChat;
import front.UI.vistaEspera;


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
            	System.out.println("Enre");
            	if (condition == false)
            		JOptionPane.showMessageDialog(null, "El puerto o el IP son invalidos");
            	else {
            		System.out.println("Conexion exitosa\n");
            		
            		IVistaChat vistaChat = new vistaChat();
            		conexion.setVista(vistaChat);
            		
            		this.conexion.conectar(this.vistaInicial.getIP(), Integer.parseInt(this.vistaInicial.getPuerto()));
            		
            		System.out.println("Conexion exitosa x2\n"+conexion.getMessageManager());
            		
//            		IVistaChat vistaChat = new vistaChat();
//            		conexion.setVista(vistaChat);
            		this.vistaInicial.mostrarVentana(false);
            		
            		vistaChat.setConexion(conexion);
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
        	if (!this.vistaInicial.getPuertoEscucha().equals("puerto")) {
        		IVistaModoEscucha vistaEscucha = new vistaEspera();
        		this.vistaInicial.mostrarVentana(false);
        		vistaEscucha.mostrarVentana(true);  
        		try {
        			IVistaChat vistaChat = new vistaChat();
            		conexion.setVista(vistaChat);
					this.conexion.Conectar(Integer.parseInt(this.vistaInicial.getPuertoEscucha()));
					vistaChat.setConexion(conexion);
					vistaEscucha.mostrarVentana(false);
					vistaChat.mostrarVentana(true);
					
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		
        		//vistaEscucha.mostrarVentana(false);
        		//IVistaChat vistaChat = new vistaChat();
        		//vistaChat.mostrarVentana(true);
        	}
        	else
        		JOptionPane.showMessageDialog(null, "El puerto es invalido");
        }
        
		
	}
    
}
