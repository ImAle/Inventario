package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class register {

	private JFrame frmRegistroDeUsuarios;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					register window = new register();
					window.frmRegistroDeUsuarios.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistroDeUsuarios = new JFrame();
		frmRegistroDeUsuarios.setTitle("Registro de usuarios");
		frmRegistroDeUsuarios.setBounds(100, 100, 326, 300);
		frmRegistroDeUsuarios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistroDeUsuarios.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registro de usuarios");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 11, 151, 14);
		frmRegistroDeUsuarios.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(10, 55, 46, 14);
		frmRegistroDeUsuarios.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(124, 52, 140, 20);
		frmRegistroDeUsuarios.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setBounds(10, 80, 46, 14);
		frmRegistroDeUsuarios.getContentPane().add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(124, 77, 140, 20);
		frmRegistroDeUsuarios.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Contraseña");
		lblNewLabel_3.setBounds(10, 118, 68, 14);
		frmRegistroDeUsuarios.getContentPane().add(lblNewLabel_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(124, 115, 140, 20);
		frmRegistroDeUsuarios.getContentPane().add(passwordField);
		
		JLabel lblNewLabel_4 = new JLabel("Confirmar contraseña");
		lblNewLabel_4.setBounds(10, 143, 126, 20);
		frmRegistroDeUsuarios.getContentPane().add(lblNewLabel_4);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(124, 143, 140, 20);
		frmRegistroDeUsuarios.getContentPane().add(passwordField_1);
		
		JButton btnNewButton = new JButton("Registrarse");
		btnNewButton.setBounds(211, 227, 89, 23);
		frmRegistroDeUsuarios.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Iniciar sesión");
		btnNewButton_1.setBounds(10, 227, 111, 23);
		frmRegistroDeUsuarios.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_5 = new JLabel("¿Ya tienes cuenta?");
		lblNewLabel_5.setBounds(10, 208, 164, 14);
		frmRegistroDeUsuarios.getContentPane().add(lblNewLabel_5);
	}
}
