package back;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

import UI.IVistaChat;

public class ConectionHandler extends Thread{
	
	IVistaChat vista;
	final DataInputStream dis;
    final DataOutputStream dos;
    final Socket s;
    private boolean terminar = false;
    
	public ConectionHandler(Socket s,DataInputStream dis, DataOutputStream dos,IVistaChat vista) {
		super();
		this.vista = vista;
		this.dis = dis;
		this.dos = dos;
		this.s = s;
	}

	public void run() {

		String recibido;
		super.run();
		String mensaje = "Socket closed";
		
		while(this.terminar == false) {
			
			try {
				recibido = dis.readUTF();
				this.vista.getTextArea().setText(this.vista.getTextArea().getText()+"\n"+recibido);
			} 
			catch (EOFException e) {
				this.terminarRecibirMensajes();
			}
			catch (SocketException e1) {
				this.terminarRecibirMensajes();
			}
			catch (IOException e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public void terminarRecibirMensajes() {
		this.terminar = true;
		
		try {
			this.dis.close();
			this.dos.close();
			this.s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
    
}
