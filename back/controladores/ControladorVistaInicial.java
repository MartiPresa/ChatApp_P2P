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

public class ControladorVistaInicial implements ActionListener{
	
	private IVistaInicial vistaInicial = null;
    private Conexion conexion= new Conexion();

    public ControladorVistaInicial(IVistaInicial vista) {
        this.vistaInicial = vista;
        this.vistaInicial.addActionListener(this);
        
    } 

	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
        if (comando.equalsIgnoreCase("CONECTAR")) {
        	 
            try {
            	System.out.println("Enre");
				conexion.conectar(this.vistaInicial.getIP(), this.vistaInicial.getPuerto());
			} catch (NumberFormatException e1) {
				System.out.println("e1");
			} catch (UnknownHostException e1) {
				
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, "Lo siento. El receptor no se encuentra en modo escucha.");
			}
            
        }
        else if (comando.equalsIgnoreCase("MODOESCUCHA")) {
            IVistaModoEscucha vistaEscucha = new vistaEspera();
          
            vistaEscucha.mostrarVentana();
        }
        
		
	}
    
}
