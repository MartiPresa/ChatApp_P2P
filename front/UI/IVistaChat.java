package UI;

import java.awt.event.ActionListener;

public interface IVistaChat 
{
	void EnviarMensaje(String Mensaje);
	void RecibirMensaje(String Mensaje);
	void AbandonarChat();
	void addActionListener(ActionListener actionListener);
	void mostrarVentana(boolean cond);
}
