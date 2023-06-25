package UI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import back.Conexion;
import controladores.ControladorModoEscucha;

public class vistaEspera extends JFrame implements IVistaModoEscucha, ActionListener {

	private JPanel contentPane;
	private ActionListener actionListener =null;
	private JButton btnVolver;
	private JTextField txtPuerto;
	private Conexion conexion;
	private JButton btnNewButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vistaEspera frame = new vistaEspera();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public vistaEspera() {
		setTitle("MODO ESCUCHA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		this.setEnabled(true);
//		this.setVisible(true);
		setContentPane(contentPane);
		
		btnVolver = new JButton("Volver");
		btnVolver.setActionCommand("VOLVER");
		
		txtPuerto = new JTextField();
		txtPuerto.setText("puerto");
		txtPuerto.setColumns(10);
		
		btnNewButton = new JButton("Activar");
		btnNewButton.setActionCommand("ACTIVAR");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnVolver, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(371, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(147)
					.addComponent(txtPuerto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(163, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(164)
					.addComponent(btnNewButton)
					.addContainerGap(188, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(80)
					.addComponent(txtPuerto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
					.addComponent(btnVolver))
		);
		contentPane.setLayout(gl_contentPane);
		//JOptionPane.showConfirmDialog(null, "El tiempo de espera ha finalizado. Desea intentar nuevamente?");
		//JOptionPane.showConfirmDialog(null, "El usuario con puerto 1234 e IP 192.158.1.38 busca comunicarse. Desea conectarse?");
		ControladorModoEscucha cont = new ControladorModoEscucha(this);
		
	}


	public void addActionListener(ActionListener actionListener) {
		this.actionListener = actionListener; 
		this.btnVolver.addActionListener(actionListener);
		this.btnNewButton.addActionListener(actionListener);
		this.txtPuerto.addActionListener(actionListener);
	}

	public void mostrarVentana(boolean cond) {
		this.setEnabled(cond);
		this.setVisible(cond);
		
	}

	public void ConfirmarConexion() {
		// TODO Auto-generated method stub
		
	}

	public void Temporizador() {
		// TODO Auto-generated method stub
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public Conexion getConexion() {
		return conexion;
	}

	public void setConexion(Conexion conexion) {
		this.conexion = conexion;
	}
	public String getPuerto() {
		return this.txtPuerto.getText();
	}
}
