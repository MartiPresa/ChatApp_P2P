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
	private MessageManager messageManager;
	
	public Conexion() {}
	 
	public Conexion(IVistaChat vistaChat) {
		super();
		this.vistaChat = vistaChat;
	}

//	public void conectacion(String IP, int puerto) throws UnknownHostException, IOException {
//		this.socket = new Socket(IP,puerto);
//		this.serverSocket = new ServerSocket(puerto);
//	}
	
//	public void enviaMensaje() {}
	
//	public void conectar(String IP, int puerto) throws UnknownHostException, IOException {
//		System.out.println("1\n");
//		 //Socket socket = new Socket(IP,puerto);
//		this.socket = new Socket(IP,puerto);
//			
//		 System.out.println("1\n");
//         this.out = new PrintWriter(socket.getOutputStream(), true);
//         System.out.println("2\n");
//         this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//         System.out.println("3\n");
//        
//   //      out.println(jTextArea1.getText()); //el método println(...) escribe el MENSAJE por el canal out enviándolo al proceso Servidor.
//         out.close(); //creo que nosotros no deberiamos cerrar el canal ya que permitirai nuevas conexiones en este lapso
//         System.out.println("5\n");
//         socket.close(); //o es este?
//    //     jTextArea1.setText("");
//		
//	}

	
	
	
//	//RECEPTOR
//	public void Conectar(final int puerto) {
//		
//		System.out.println("Antes del run\n");
//		
//		new Thread() {
//			
//			
//
//			public void run() {
//				System.out.println("despues del run\n");
//                try {
//                	ServerSocket serverSocket = new ServerSocket(puerto);
// //                   jTextArea1.append("Esperando conexiones en puerto " + direccionIP.getText() + "\n");
//
//                    while (true) { //como siempre esta atento a escuchar peticiones del cliente
//                    	System.out.println("conexion\n");
//                    	Socket socket = serverSocket.accept(); //accept() se queda a la espera, no continua el codigo. socket es el socket del cliente.
//                    	System.out.println("socketserver\n");
//                    	PrintWriter out = new PrintWriter(socket.getOutputStream(), true); //puede ser new DataOutputStream(soc.getOutputStream())
//                    	BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); //puede ser new DataInputStream(soc.getInputStream())
//
//                        String msg = in.readLine(); 
//     //                   jTextArea1.append(msg + "\n"); //es como el system out
//                    }
//
//                } catch (Exception e) {
//                    e.printStackTrace();
// //                   jTextArea1.append(e.getMessage() + "\n");
//                }
//  //              jTextArea1.append("fin");
//
//            }
//        }.start();
//		
//	}
	
	//RECEPTOR
		public void Conectar(final int puerto) throws IOException {
			
			 ServerSocket ss = new ServerSocket(puerto);

//		        while (true) 
//		        {
		            Socket s = null;
		              
		            try 
		            {
		                s = ss.accept();
		                
		                System.out.println(s.isConnected());
		                System.out.println("A new client is connected : " + s);
		                  
		                // obtaining input and out streams
		                DataInputStream dis = new DataInputStream(s.getInputStream());
		                DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		                  
		                //System.out.println("Assigning new thread for this client");
		  
		                // create a new thread object
		                //System.out.println("Vista"+this.vistaChat);
		                this.messageManager = new MessageManager(s, dis, dos,this.vistaChat);
		                Thread t = new ConectionHandler(s, dis, dos,this.vistaChat);
		                // Invoking the start() method
		                t.start();
		                  
		            }
		            catch (Exception e){
		                s.close();
		                e.printStackTrace();
		            }
		        //}
		    }
		
//			System.out.println("Antes del run\n");
//			
//			//new Thread() {
//				
//		
//				//public void run() {
//
//	                try {
//	                	ServerSocket serverSocket = new ServerSocket(puerto);
//	 //                   jTextArea1.append("Esperando conexiones en puerto " + direccionIP.getText() + "\n");
//
//	                    while (true) { //como siempre esta atento a escuchar peticiones del cliente
//	                    	System.out.println("conexion\n");
//	                    	Socket socket = serverSocket.accept(); //accept() se queda a la espera, no continua el codigo. socket es el socket del cliente.
//	                    	System.out.println("socketserver\n");
//	                    	PrintWriter out = new PrintWriter(socket.getOutputStream(), true); //puede ser new DataOutputStream(soc.getOutputStream())
//	                    	BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); //puede ser new DataInputStream(soc.getInputStream())
//
//	                        String msg = in.readLine(); 
//	     //                   jTextArea1.append(msg + "\n"); //es como el system out
//	                    }
//
//	                } catch (Exception e) {
//	                    e.printStackTrace();
//	 //                   jTextArea1.append(e.getMessage() + "\n");
//	                }
//	  //              jTextArea1.append("fin");
//
//	           // }
//	     //   }.start();
//			
//		}
	
		public void recibirMensajes() {
			Socket s = this.messageManager.getSocket();
			DataInputStream dis = null;
			DataOutputStream dos = null;
			try {
				dis = new DataInputStream(s.getInputStream());
				dos = new DataOutputStream(s.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            Thread t = new ConectionHandler(s, dis, dos,this.vistaChat);
            // Invoking the start() method
            t.start();
		}
		public void conectar(String IP, int puerto) throws UnknownHostException, IOException {
			
			Socket s = new Socket(IP,puerto);
			DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			
			this.messageManager = new MessageManager(s,dis,dos,this.vistaChat);
			
			//this.socket = new Socket(IP,puerto);
//	         this.out = new PrintWriter(socket.getOutputStream(), true);      
//	         this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	      
	        
	   //      out.println(jTextArea1.getText()); //el método println(...) escribe el MENSAJE por el canal out enviándolo al proceso Servidor.
	       //  out.close(); //creo que nosotros no deberiamos cerrar el canal ya que permitirai nuevas conexiones en este lapso
	         
	         //s.close(); //o es este?
	    //     jTextArea1.setText("");
			
		}
		
		
		public MessageManager getMessageManager() {
			return this.messageManager;
		}

//		public void setMm(MessageManager mm) {
//			this.messageManager = mm;
//		}

		public void setVista(IVistaChat v) {
			this.vistaChat = v;
		}
		 
		public Socket getsocket() {
			return this.socket;
		}
}
