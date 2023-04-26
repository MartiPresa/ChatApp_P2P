package UI;

import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public interface IVistaChat 
{
	void EnviarMensaje(String Mensaje);
	void RecibirMensaje();
	void AbandonarChat();
	void addActionListener(ActionListener actionListener);
	void mostrarVentana(boolean cond);

	public Socket getS() ;

	public  DataInputStream getDin() ;

	public  DataOutputStream getDon() ;
	public JTextArea getTextArea() ;

	public JScrollPane getjScrollPane1() ;

	public JTextField getTxtIngreseTextoAqui() ;
}
