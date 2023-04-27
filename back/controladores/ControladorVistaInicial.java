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
import back.Emisor;
import back.Receptor;

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
            		
            		this.vistaInicial.mostrarVentana(false);
            		
            		vistaChat.setConexion(conexion);
            		vistaChat.mostrarVentana(true);
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
        			//System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\ \n");
					//this.conexionReceptor.Conectar(Integer.parseInt(this.vistaInicial.getPuertoEscucha()));
					this.conexion.Conectar(Integer.parseInt(this.vistaInicial.getPuertoEscucha()));
					//System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\ \n");
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		
        		vistaEscucha.mostrarVentana(false);
        		IVistaChat vistaChat = new vistaChat();
        		vistaChat.mostrarVentana(true);
        	}
        	else
        		JOptionPane.showMessageDialog(null, "El puerto es invalido");
        }
        
		
	}
    
}
