package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import UI.IVistaInicial;
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
            System.out.println("Enre");
            try {
				conexion.conectar(this.vistaInicial.getIP(), Integer.parseInt(this.vistaInicial.getPuerto()));
			} catch (NumberFormatException e1) {
		 		
			} catch (UnknownHostException e1) {
				JOptionPane.showMessageDialog(null, "Lo siento. El receptor no se encuentra en modo escucha.");
			} catch (IOException e1) {
				
			}
            //vistaInicial.getContentPane().setVisible(true);
            //cl.show(contentPane, ventana.getVistaModificaMozoAdmin());
        }
        else if (comando.equalsIgnoreCase("MODOESCUCHA")) {
            //cl.show(contentPane, ventana.getVistaAltaMozo());
        }
        
		
	}
    
}
