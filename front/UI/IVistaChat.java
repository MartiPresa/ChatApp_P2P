package UI;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import back.Conexion;
import back.MessageManager;
import controladores.ControladorVistaChat;

public interface IVistaChat 
{
	void EnviarMensaje(String Mensaje);
	void RecibirMensaje(String Mensaje);
	void AbandonarChat();
	void addActionListener(ActionListener actionListener);
	void mostrarVentana(boolean cond);
	JTextArea getTextArea();
	JScrollPane getjScrollPane1();
	JTextField getTxtIngreseTextoAqui();
	void setText(String text);
	void setConexion(Conexion conexion);
	Conexion getConexion();
	ControladorVistaChat getCont();
	JButton getBtnEnviar() ;
}
