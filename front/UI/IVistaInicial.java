package UI;

import java.awt.event.ActionListener;

import javax.swing.JPanel;

public interface IVistaInicial 
{
	//void ActivarModoEscucha();
	//void EstablecerConexion();
	String getPuerto();
	String getIP();
	void addActionListener(ActionListener actionListener);
	void mostrarVentana();
	
}
