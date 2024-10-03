package ui;

import javax.swing.*;

import dao.UsuarioDao;
import servicies.ConnectionManager;
import util.HashUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;

public class Authentication extends JFrame {

    private JTextField textFieldUser;
    private JPasswordField passwordField;

    public Authentication() {
        initialize();
    }

    private void initialize() {
        this.getContentPane().setBackground(new Color(255, 255, 255));
        this.setTitle("Inicio de sesión");
        this.setBounds(100, 100, 331, 485);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);
        
        JLabel userLabel = new JLabel("Usuario: ");
        userLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        userLabel.setBounds(31, 114, 52, 37);
        this.getContentPane().add(userLabel);
        
        textFieldUser = new JTextField();
        textFieldUser.setBounds(93, 123, 150, 20);
        this.getContentPane().add(textFieldUser);
        textFieldUser.setColumns(10);
        
        JLabel passwordLabel = new JLabel("Contraseña: ");
        passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        passwordLabel.setBounds(10, 187, 90, 14);
        this.getContentPane().add(passwordLabel);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(93, 185, 150, 20);
        this.getContentPane().add(passwordField);
        
        JButton loginButton = new JButton("Iniciar sesión");
        loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario = textFieldUser.getSelectedText();
				String password = HashUtil.hashPassword(passwordField.getSelectedText());
				UsuarioDao.login(usuario, password);
				
				if (usuario.isEmpty() || password.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Los campos son obligatorios",
							"Error", JOptionPane.ERROR_MESSAGE);
				}
				new ReadView();
			}});
        loginButton.setBounds(105, 242, 120, 23);
		this.getContentPane().add(loginButton);
        
        JButton registerButton = new JButton("Registrarse");
        registerButton.setBounds(190, 412, 115, 23);
        this.getContentPane().add(registerButton);
        
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Register registerWindow = new Register();
                registerWindow.setVisible(true);
                dispose();
            }
        });
    }
    
    private static void correctPassword() {
    	
    	//Conexion con la base de datos
    	ConnectionManager conect = new ConnectionManager();
    	try {
			// Conectamos y comprobamos mediante una sentencia sql el usuario y contraseña,
    		// de esta manera comprobamos si estan bien para posteriormente incluirlo en la
    		// validacion del login.
    		
    		// 
		} catch (Exception e) {
			// TODO: handle exception
		}
    }

    public static void main(String[] args) {
        Authentication loginWindow = new Authentication();
        loginWindow.setVisible(true);
    }
}
