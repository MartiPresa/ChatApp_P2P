package back;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Prueba {

	public static void main(String[] args) {
	Server server = new Server();
		
		
		String IP = "localhost";
		Socket s;
		try {
			s = new Socket(IP,1234);
			
			
			DataInputStream dis = new DataInputStream(s.getInputStream());
	        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
	        dos.writeUTF("tuvieja");
	        server.Conectar();
	        
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
