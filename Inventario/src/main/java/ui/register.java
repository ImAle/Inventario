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
import servicies.authentication;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class register extends JFrame{

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
		
		JLabel titleRegister = new JLabel("Registro de usuarios");
		titleRegister.setFont(new Font("Tahoma", Font.PLAIN, 14));
		titleRegister.setBounds(10, 11, 151, 20);
		frmRegistroDeUsuarios.getContentPane().add(titleRegister);
		
		JLabel userName = new JLabel("Nombre");
		userName.setBounds(104, 55, 46, 14);
		frmRegistroDeUsuarios.getContentPane().add(userName);
		
		textField = new JTextField();
		textField.setBounds(160, 52, 140, 20);
		frmRegistroDeUsuarios.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel userMail = new JLabel("Email");
		userMail.setBounds(104, 80, 46, 14);
		frmRegistroDeUsuarios.getContentPane().add(userMail);
		
		textField_1 = new JTextField();
		textField_1.setBounds(160, 77, 140, 20);
		frmRegistroDeUsuarios.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel userPassword = new JLabel("Contraseña");
		userPassword.setBounds(82, 118, 68, 14);
		frmRegistroDeUsuarios.getContentPane().add(userPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(160, 115, 140, 20);
		frmRegistroDeUsuarios.getContentPane().add(passwordField);
		
		JLabel userPasswordConfirm = new JLabel("Confirmar contraseña");
		userPasswordConfirm.setBounds(24, 143, 126, 14);
		frmRegistroDeUsuarios.getContentPane().add(userPasswordConfirm);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(160, 140, 140, 20);
		frmRegistroDeUsuarios.getContentPane().add(passwordField_1);
		
		JCheckBox userRol = new JCheckBox("Rol administrador");
		userRol.setBounds(160, 167, 126, 23);
		frmRegistroDeUsuarios.getContentPane().add(userRol);
		
		JButton registerButton = new JButton("Registrarse");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = textField.getText();
				String correoElectronico = textField_1.getText();
				String password = new String(passwordField.getPassword());
				password = new String(passwordField_1.getPassword());
				boolean rolSelect = userRol.isSelected();
				
				if (nombre.isEmpty() || correoElectronico.isEmpty() || password.isEmpty() || password.isEmpty()) {
					JOptionPane.showMessageDialog(frmRegistroDeUsuarios, "Los campos son obligatorios",
							"Error", JOptionPane.ERROR_MESSAGE);
				}else if (!passwordField.equals(passwordField_1)) {
					 JOptionPane.showMessageDialog(frmRegistroDeUsuarios, "Las contraseñas no coinciden",
							 "Error", JOptionPane.ERROR_MESSAGE);
				}else {
					try {
						UsuarioDao user = new UsuarioDao();
						String rol = rolSelect ? "Administrador" : "Usuario";
			            Usuario usu = new Usuario(nombre, correoElectronico, password, Rol.valueOf(rol));
			            user.create(usu);
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
				
			}
		});
		registerButton.setBounds(211, 227, 89, 23);
		frmRegistroDeUsuarios.getContentPane().add(registerButton);
		
		JButton loginButton = new JButton("Iniciar sesión");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new authentication();
	
			}
		});
		loginButton.setBounds(10, 227, 111, 23);
		frmRegistroDeUsuarios.getContentPane().add(loginButton);
		
		JLabel infoLogin = new JLabel("¿Ya tienes cuenta?");
		infoLogin.setBounds(10, 208, 164, 14);
		frmRegistroDeUsuarios.getContentPane().add(infoLogin);
		
		
	}
}
