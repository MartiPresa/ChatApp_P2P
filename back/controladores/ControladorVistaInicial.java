package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import UI.IVistaInicial;
import UI.IVistaModoEscucha;
import UI.vistaEspera;
import back.Conexion;
import back.Emisor;

public class ControladorVistaInicial implements ActionListener{
	
	private IVistaInicial vistaInicial = null;
    private Emisor conexion= null;

    public ControladorVistaInicial(IVistaInicial vista) {
        this.vistaInicial = vista;
        this.vistaInicial.addActionListener(this);
        
    } 

	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
        if (comando.equalsIgnoreCase("CONECTAR")) {
        	boolean condition = !this.vistaInicial.getPuerto().equals("puerto")&& this.vistaInicial.getIP().length()>5;
   
        	
//            try {
//            	System.out.println("Enre");
//            	if (condition == false)
//            		JOptionPane.showMessageDialog(null, "El puerto o el IP son invalidos");
//            	else
//            		conexion.conectar(this.vistaInicial.getIP(), Integer.parseInt(this.vistaInicial.getPuerto()));
//			} catch (NumberFormatException e1) {
//				System.out.println("e1");
//			} catch (UnknownHostException e1) {
//				
//			} catch (IOException e1) {
//				JOptionPane.showMessageDialog(null, "Lo siento. El receptor no se encuentra en modo escucha.");
//			}
        }
        else if (comando.equalsIgnoreCase("MODOESCUCHA")) {
        	if (!this.vistaInicial.getPuertoEscucha().equals("puerto")) {
        		IVistaModoEscucha vistaEscucha = new vistaEspera();
        		this.vistaInicial.mostrarVentana(false);
        		vistaEscucha.mostrarVentana(true);        		
        	}
        	else
        		JOptionPane.showMessageDialog(null, "El puerto es invalido");
        }
        
		
	}
    
}
