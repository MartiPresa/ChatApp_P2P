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
	
	public Conexion() {}
	
	public Conexion(IVistaChat vistaChat) {
		super();
		this.vistaChat = vistaChat;
	}

	public void conectacion(String IP, int puerto) throws UnknownHostException, IOException {
		this.socket = new Socket(IP,puerto);
		this.serverSocket = new ServerSocket(puerto);
	}
	
	public void enviaMensaje() {}
	
	public void conectar(String IP, int puerto) throws UnknownHostException, IOException {
		System.out.println("1\n");
		 Socket socket = new Socket(IP,puerto);
		 
		 System.out.println("1\n");
         this.out = new PrintWriter(socket.getOutputStream(), true);
         System.out.println("2\n");
         this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
         System.out.println("3\n");
        
   //      out.println(jTextArea1.getText()); //el método println(...) escribe el MENSAJE por el canal out enviándolo al proceso Servidor.
         out.close(); //creo que nosotros no deberiamos cerrar el canal ya que permitirai nuevas conexiones en este lapso
         System.out.println("5\n");
         socket.close(); //o es este?
    //     jTextArea1.setText("");
		
	}

	//RECEPTOR
	public void Conectar(final int puerto) {
		
		System.out.println("Antes del run\n");  
		new Thread() {
			
			public void run() {
				System.out.println("despues del run\n");
                try {
                	ServerSocket serverSocket = new ServerSocket(puerto);
 //                   jTextArea1.append("Esperando conexiones en puerto " + direccionIP.getText() + "\n");

                    while (true) { //como siempre esta atento a escuchar peticiones del cliente
                    	System.out.println("conexion\n");
                    	Socket socket = serverSocket.accept(); //accept() se queda a la espera, no continua el codigo. socket es el socket del cliente.
                    	System.out.println("socketserver\n");
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
