package UI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controlador.ControladorVistaInicial;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VistaInicial extends JFrame implements IVistaInicial {

	private JPanel contentPane;
	private JTextField txtPuerto;
	private JTextField txtIp;
	private ActionListener actionListenr;
	private JButton btnModoEscucha;
	public JButton btnConectar;
	private ControladorVistaInicial cont = null;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaInicial frame = new VistaInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VistaInicial() {
		setTitle("BIENVENIDO!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setVisible(true);

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel);

		txtPuerto = new JTextField();
		txtPuerto.setForeground(new Color(120, 120, 120));
		txtPuerto.setText("puerto");
		txtPuerto.setToolTipText("puerto");
		txtPuerto.setBackground(new Color(255, 255, 255));
		txtPuerto.setColumns(10);

		txtIp = new JTextField();
		txtIp.setForeground(new Color(120, 120, 120));
		txtIp.setText("IP");
		txtIp.setColumns(10);

		btnConectar = new JButton("Conectar");

		btnConectar.setActionCommand("CONECTAR");
		btnConectar.setBackground(new Color(245, 255, 246));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup().addGap(57).addComponent(btnConectar))
								.addGroup(gl_panel.createSequentialGroup().addGap(45)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(txtPuerto, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(txtIp, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(45, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addGap(83)
				.addComponent(txtPuerto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE)
				.addGap(18)
				.addComponent(txtIp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(18).addComponent(btnConectar).addGap(62)));
		panel.setLayout(gl_panel);
		btnConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);

		btnModoEscucha = new JButton("Modo escucha");
		btnModoEscucha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModoEscucha.setActionCommand("MODOESCUCHA");
		btnModoEscucha.setForeground(new Color(0, 0, 0));
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_3
				.createSequentialGroup().addGap(34).addComponent(btnModoEscucha).addContainerGap(52, Short.MAX_VALUE)));
		gl_panel_3.setVerticalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_panel_3.createSequentialGroup().addContainerGap(118, Short.MAX_VALUE).addComponent(btnModoEscucha)
						.addGap(115)));
		panel_3.setLayout(gl_panel_3);
		this.cont = new ControladorVistaInicial(this);
	}

	public String getPuerto() {
		return this.txtPuerto.getText();
	}

	public String getIP() {
		return this.txtIp.getText();
	}

	public void addActionListener(ActionListener actionListener) {
		this.btnConectar.addActionListener(actionListener);
		this.btnModoEscucha.addActionListener(actionListener);
		this.actionListenr = actionListener;
	}

	public void setVisibleBtn() {
		this.btnModoEscucha.setVisible(true);

	}

	public void mostrarVentana(boolean cond) {
		this.setVisible(cond);

	}

}
