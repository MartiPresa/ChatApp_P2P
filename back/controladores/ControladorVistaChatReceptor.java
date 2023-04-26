package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import UI.IVistaChat;
import UI.IVistaChatReceptor;
import UI.IVistaInicial;
import UI.vistaInicial;
import back.Conexion;
import back.Emisor;

public class ControladorVistaChatReceptor implements ActionListener {

	private IVistaChatReceptor vistaChat = null;
    private Emisor conexion= null;
    

    public ControladorVistaChatReceptor(IVistaChatReceptor vista) {
        this.vistaChat = vista;
        this.vistaChat.addActionListener(this);
        
    } 

	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
        if (comando.equalsIgnoreCase("ABANDONAR")) {
        	this.vistaChat.mostrarVentana(false);
        	IVistaInicial vistaInicial = new vistaInicial();
        	vistaInicial.mostrarVentana(true);
        	//Socket closeeeee
        }
        else {
        	if (comando.equalsIgnoreCase("ENVIAR")) {
        		try {
        			String msgout = "";
        			msgout = this.vistaChat.getTxtIngreseTextoAqui().getText().trim();
        			this.vistaChat.getDon().writeUTF(msgout);
        			
        		}catch(Exception e1) {}
        	}
        }

	}

}
