package back.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import front.UI.IVistaModoEscucha;
import front.UI.IVistaInicial;
import front.UI.vistaInicial;


public class ControladorModoEscucha implements ActionListener {

	private IVistaModoEscucha vistaModoEscucha = null;
    //private Conexion conexion= new Conexion();

    public ControladorModoEscucha(IVistaModoEscucha vista) {
        this.vistaModoEscucha = vista;
        this.vistaModoEscucha.addActionListener(this);
        
    } 

	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
        if (comando.equalsIgnoreCase("VOLVER")) {
        	this.vistaModoEscucha.mostrarVentana(false);
        	IVistaInicial vistaInicial = new vistaInicial();
        	vistaInicial.mostrarVentana(true);
        }
        	
        
		
	}

}
