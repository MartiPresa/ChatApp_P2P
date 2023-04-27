package back;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import UI.IVistaChat;

public class ConectionHandler extends Thread{
	IVistaChat vista;
	final DataInputStream dis;
    final DataOutputStream dos;
    final Socket s;
    
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
	
		//while(true) {
			
			try {
				System.out.println("xd");
				recibido = dis.readUTF();
				System.out.println(recibido);
				this.vista.setText(recibido);
				
				//HAY QUE MATAR ESTE THREAD EN QUE MOMENTO?
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//}
		
//	   this.dis.close();
//	   this.dos.close();
	}
	
	
	
    
}
