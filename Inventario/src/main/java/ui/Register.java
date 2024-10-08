package ui;

import java.awt.Checkbox;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import dao.UsuarioDao;
import model.Rol;
import model.Usuario;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Register extends JFrame{

	private JFrame frmRegistroDeUsuarios;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Create the application.
	 */
	public Register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setTitle("Registro de usuarios");
		this.setBounds(100, 100, 326, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JLabel titleRegister = new JLabel("Registro de usuarios");
		titleRegister.setHorizontalAlignment(SwingConstants.CENTER);
		titleRegister.setFont(new Font("Tahoma", Font.BOLD, 14));
		titleRegister.setBounds(10, 11, 290, 20);
		this.getContentPane().add(titleRegister);
		
		JLabel userName = new JLabel("Nombre");
		userName.setBounds(104, 55, 46, 14);
		this.getContentPane().add(userName);
		
		textField = new JTextField();
		textField.setBounds(160, 52, 140, 20);
		this.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel userMail = new JLabel("Email");
		userMail.setBounds(104, 80, 46, 14);
		this.getContentPane().add(userMail);
		
		textField_1 = new JTextField();
		textField_1.setBounds(160, 77, 140, 20);
		this.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel userPassword = new JLabel("Contraseña");
		userPassword.setBounds(82, 118, 68, 14);
		this.getContentPane().add(userPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(160, 115, 140, 20);
		this.getContentPane().add(passwordField);
		
		JLabel userPasswordConfirm = new JLabel("Confirmar contraseña");
		userPasswordConfirm.setBounds(24, 143, 126, 14);
		this.getContentPane().add(userPasswordConfirm);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(160, 140, 140, 20);
		this.getContentPane().add(passwordField_1);
		
		JCheckBox userRol = new JCheckBox("Rol administrador");
		userRol.setBounds(160, 167, 126, 23);
		this.getContentPane().add(userRol);
		
		JButton registerButton = new JButton("Registrarse");
		registerButton.setBackground(new Color(255, 255, 255));
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = textField.getText();
				String correoElectronico = textField_1.getText();
				String password = new String(passwordField.getPassword());
				String confirmPassword = new String(passwordField_1.getPassword());
				boolean rolSelect = userRol.isSelected();
				
				if (nombre.isEmpty() || correoElectronico.isEmpty() || password.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
					JOptionPane.showMessageDialog(frmRegistroDeUsuarios, "Los campos son obligatorios",
							"Error", JOptionPane.ERROR_MESSAGE);
				}else if (!password.equals(confirmPassword)) {
					 JOptionPane.showMessageDialog(frmRegistroDeUsuarios, "La contraseñas no coinciden",
							 "Error", JOptionPane.ERROR_MESSAGE);
				}else {
					try {
						UsuarioDao user = new UsuarioDao();
						String rol = rolSelect ? "ADMINISTRADOR" : "USUARIO";
			            Usuario usu = new Usuario(nombre, correoElectronico, password, Rol.valueOf(rol));
			            user.create(usu);
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
				
			}
		});
		registerButton.setBounds(195, 227, 105, 23);
		this.getContentPane().add(registerButton);
		
		JButton loginButton = new JButton("Iniciar sesión");
		loginButton.setBackground(new Color(255, 255, 255));
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Authentication auth = new Authentication();
				auth.setVisible(true);
				dispose();
	
			}
		});
		loginButton.setBounds(10, 227, 111, 23);
		this.getContentPane().add(loginButton);
		
		JLabel infoLogin = new JLabel("¿Ya tienes cuenta?");
		infoLogin.setBounds(10, 208, 164, 14);
		this.getContentPane().add(infoLogin);
		
		this.setVisible(true);
		
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Register registerWindow = new Register();
				registerWindow.setVisible(true);
			}
		});
	}
	
	
}
