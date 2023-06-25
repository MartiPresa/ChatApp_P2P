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
	void addActionListener(ActionListener actionListener);
	void mostrarVentana(boolean cond);
	JTextArea getTextArea();
	JScrollPane getjScrollPane1();
	JTextField getTxtIngreseTextoAqui();
	void setText(String text);
	ControladorVistaChat getCont();
	JButton getBtnEnviar() ;
}
