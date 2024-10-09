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
	private JTextField nombreUsuario;
	private JTextField correo;
	private JPasswordField passwordField1;
	private JPasswordField passwordField2;

	public Register() {
		initialize();
	}

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
		
		nombreUsuario = new JTextField();
		nombreUsuario.setBounds(160, 52, 140, 20);
		this.getContentPane().add(nombreUsuario);
		nombreUsuario.setColumns(10);
		
		JLabel userMail = new JLabel("Email");
		userMail.setBounds(104, 80, 46, 14);
		this.getContentPane().add(userMail);
		
		correo = new JTextField();
		correo.setBounds(160, 77, 140, 20);
		this.getContentPane().add(correo);
		correo.setColumns(10);
		
		JLabel userPassword = new JLabel("Contraseña");
		userPassword.setBounds(82, 118, 68, 14);
		this.getContentPane().add(userPassword);
		
		passwordField1 = new JPasswordField();
		passwordField1.setBounds(160, 115, 140, 20);
		this.getContentPane().add(passwordField1);
		
		JLabel userPasswordConfirm = new JLabel("Confirmar contraseña");
		userPasswordConfirm.setBounds(24, 143, 126, 14);
		this.getContentPane().add(userPasswordConfirm);
		
		passwordField2 = new JPasswordField();
		passwordField2.setBounds(160, 140, 140, 20);
		this.getContentPane().add(passwordField2);
		
		JButton registerButton = new JButton("Registrarse");
		registerButton.setBackground(new Color(255, 255, 255));
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register();
			}
		});
		registerButton.setBounds(195, 227, 105, 23);
		this.getContentPane().add(registerButton);
		
		JButton loginButton = new JButton("Iniciar sesión");
		loginButton.setBackground(new Color(255, 255, 255));
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeToLogin();
			}
		});
		loginButton.setBounds(10, 227, 111, 23);
		this.getContentPane().add(loginButton);
		
		JLabel infoLogin = new JLabel("¿Ya tienes cuenta?");
		infoLogin.setBounds(10, 208, 164, 14);
		this.getContentPane().add(infoLogin);
		
		this.setVisible(true);
		
	}
	
	public void register() {
		String nombre = nombreUsuario.getText();
		String correoElectronico = correo.getText();
		String password = new String(passwordField1.getPassword());
		String confirmPassword = new String(passwordField2.getPassword());
		
		if (nombre.isEmpty() || correoElectronico.isEmpty() || password.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
			JOptionPane.showMessageDialog(frmRegistroDeUsuarios, "Los campos son obligatorios",
					"Error", JOptionPane.ERROR_MESSAGE);
		}else if (!password.equals(confirmPassword)) {
			 JOptionPane.showMessageDialog(frmRegistroDeUsuarios, "La contraseñas no coinciden",
					 "Error", JOptionPane.ERROR_MESSAGE);
		}else {
				UsuarioDao user = new UsuarioDao();
				String rol = "USUARIO";
	            Usuario usu = new Usuario(nombre, correoElectronico, password, Rol.valueOf(rol));
	            user.create(usu);
	            JOptionPane.showMessageDialog(frmRegistroDeUsuarios, "Registrado exitosamente",
						 "Error", JOptionPane.INFORMATION_MESSAGE);
	            limpiarCampos();
		}
	}
	
	public void changeToLogin() {
		Authentication auth = new Authentication();
		auth.setVisible(true);
		dispose();
	}
	
	public void limpiarCampos() {
		nombreUsuario.setText("");
		correo.setText("");
		passwordField1.setText("");
		passwordField2.setText("");
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Register registerWindow = new Register();
				registerWindow.setVisible(true);
			}
		});
	}
	
	
}
