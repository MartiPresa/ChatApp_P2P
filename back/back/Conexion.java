package back;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import UI.IVistaChat;

public class Conexion
{
	
	private IVistaChat vistaChat = null;
	private Socket socket;
	private ServerSocket serverSocket;
	private PrintWriter out;
	private BufferedReader in;
	static ServerSocket ss;
    static Socket s;
    static DataInputStream din;
    static DataOutputStream don;
	
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
			
		 Socket socket = new Socket(IP,puerto);
//		 
//		 
//         this.out = new PrintWriter(socket.getOutputStream(), true);
//        
//         this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//        
//        
//   //      out.println(jTextArea1.getText()); //el método println(...) escribe el MENSAJE por el canal out enviándolo al proceso Servidor.
//         out.close(); //creo que nosotros no deberiamos cerrar el canal ya que permitirai nuevas conexiones en este lapso
//         System.out.println("5\n");
//         socket.close(); //o es este?
//    //     jTextArea1.setText("");
		  
	}
//	
//	
//	
//	public void Conectar( int puerto, Socket socket) {
//		String msgin = "";
//		try {
//			
//			ss = new ServerSocket (1234); 
//			//System.out.println("Holax1");
//			s = ss.accept(); //server will accept the connections
//			socket = s;
//			//System.out.println("Holax2");
////			din= new DataInputStream(s.getInputStream());
////			don = new DataOutputStream(s.getOutputStream());
////			
////			while (!msgin.equals("exit")) {
////				msgin = din.readUTF();
////				textArea.setText(textArea.getText().trim()+msgin+"\n");
////			}
//			
//		}catch(Exception e) {}
//	}
//		
//
////	//RECEPTOR
////	public void Conectar(final int puerto, int bandera) {
////		
////		System.out.println("Antes del run\n");  
////		new Thread() {
////			
////			public void run() {
////				System.out.println("despues del run\n");
////                try {
////                	ServerSocket serverSocket = new ServerSocket(puerto);
//// //                   jTextArea1.append("Esperando conexiones en puerto " + direccionIP.getText() + "\n");
////
////                    while (true) { //como siempre esta atento a escuchar peticiones del cliente
////                    	System.out.println("conexion\n");
////                    	Socket socket = serverSocket.accept(); //accept() se queda a la espera, no continua el codigo. socket es el socket del cliente.
////                    	System.out.println("socketserver\n");
////                    	PrintWriter out = new PrintWriter(socket.getOutputStream(), true); //puede ser new DataOutputStream(soc.getOutputStream())
////                    	BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); //puede ser new DataInputStream(soc.getInputStream())
////
////                        String msg = in.readLine(); 
////     //                   jTextArea1.append(msg + "\n"); //es como el system out
////                    }
////
////                } catch (Exception e) {
////                    e.printStackTrace();
//// //                   jTextArea1.append(e.getMessage() + "\n");
////                }  
////                bandera=1;
////  //              jTextArea1.append("fin");
////
////            }
////        }.start();
////		
////	}
//
//	public void Conectar(int puerto) {
//		// TODO Auto-generated method stub
//		
//	}
	public void establecerConxion () {
		
		Thread hilo = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					conectar(ip, puerto);
					abrirFlujos();
					recibirDatos();
				} finally {
					cerrarConexion();
				}
			}
		});
		hilo.start();
	}
	
}
