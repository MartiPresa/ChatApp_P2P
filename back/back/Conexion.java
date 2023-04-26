package back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import UI.IVistaChat;

public class Conexion implements Receptor, Emisor
{
	
	private IVistaChat vistaChat = null;
	private Socket socket;
	private ServerSocket serverSocket;
	private PrintWriter out;
	private BufferedReader in;
	
	public Conexion(IVistaChat vistaChat) {
		super();
		this.vistaChat = vistaChat;
	}

	public void conectacion(String IP, int puerto) throws UnknownHostException, IOException {
		this.socket = new Socket(IP,puerto);
		this.serverSocket = new ServerSocket(puerto);
	}
	
	public void enviaMensaje() {
		
	}
	
	public void conectar(String IP, int puerto) throws UnknownHostException, IOException {
		 Socket socket = new Socket(IP,puerto);
		
         this.out = new PrintWriter(socket.getOutputStream(), true);
         this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        
   //      out.println(jTextArea1.getText()); //el método println(...) escribe el MENSAJE por el canal out enviándolo al proceso Servidor.
         out.close(); //creo que nosotros no deberiamos cerrar el canal ya que permitirai nuevas conexiones en este lapso
         socket.close(); //o es este?
    //     jTextArea1.setText("");
		
	}

	//RECEPTOR
	public void Conectar(final int puerto) {
		new Thread() {
            
			public void run() {
                try {
                	ServerSocket serverSocket = new ServerSocket(puerto);
 //                   jTextArea1.append("Esperando conexiones en puerto " + direccionIP.getText() + "\n");

                    while (true) { //como siempre esta atento a escuchar peticiones del cliente

                    	Socket socket = serverSocket.accept(); //accept() se queda a la espera, no continua el codigo. socket es el socket del cliente.
                    	PrintWriter out = new PrintWriter(socket.getOutputStream(), true); //puede ser new DataOutputStream(soc.getOutputStream())
                    	BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); //puede ser new DataInputStream(soc.getInputStream())

                        String msg = in.readLine(); 
     //                   jTextArea1.append(msg + "\n"); //es como el system out
                    }

                } catch (Exception e) {
                    e.printStackTrace();
 //                   jTextArea1.append(e.getMessage() + "\n");
                }
  //              jTextArea1.append("fin");

            }
        }.start();
		
	}
	
}
