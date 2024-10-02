package servicies;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JPasswordField;

public class authentication {

	private JFrame frmInicioDeSesin;
	private JTextField textFieldUser;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					authentication window = new authentication();
					window.frmInicioDeSesin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public authentication() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInicioDeSesin = new JFrame();
		frmInicioDeSesin.getContentPane().setBackground(new Color(255, 255, 255));
		frmInicioDeSesin.setTitle("Inicio de sesión");
		frmInicioDeSesin.setBounds(100, 100, 331, 485);
		frmInicioDeSesin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInicioDeSesin.getContentPane().setLayout(null);
		
		JLabel userLabel = new JLabel("Usuario: ");
		userLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		userLabel.setBounds(31, 114, 52, 37);
		frmInicioDeSesin.getContentPane().add(userLabel);
		
		textFieldUser = new JTextField();
		textFieldUser.setBounds(93, 123, 150, 20);
		frmInicioDeSesin.getContentPane().add(textFieldUser);
		textFieldUser.setColumns(10);
		
		JLabel passwordLabel = new JLabel("Contraseña: ");
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		passwordLabel.setBounds(10, 187, 90, 14);
		frmInicioDeSesin.getContentPane().add(passwordLabel);
		
		JButton btnNewButton = new JButton("Iniciar sesión");
		btnNewButton.setBounds(105, 242, 120, 23);
		frmInicioDeSesin.getContentPane().add(btnNewButton);
		
		JLabel loginTitle = new JLabel("Inicie sesión");
		loginTitle.setHorizontalAlignment(SwingConstants.CENTER);
		loginTitle.setFont(new Font("Tahoma", Font.PLAIN, 17));
		loginTitle.setBounds(31, 27, 248, 37);
		frmInicioDeSesin.getContentPane().add(loginTitle);
		
		JButton registerButton = new JButton("Registrarse");
		registerButton.setBounds(190, 412, 115, 23);
		frmInicioDeSesin.getContentPane().add(registerButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(93, 185, 150, 20);
		frmInicioDeSesin.getContentPane().add(passwordField);
		
		JLabel lblNewLabel = new JLabel("¿No tienes cuenta?");
		lblNewLabel.setBounds(190, 387, 115, 14);
		frmInicioDeSesin.getContentPane().add(lblNewLabel);
	}
}
