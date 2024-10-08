package ui;

import model.Rol;
import model.Usuario;

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
    private UsuarioDao dao;

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
        userLabel.setBounds(71, 152, 52, 14);
        this.getContentPane().add(userLabel);
        
        textFieldUser = new JTextField();
        textFieldUser.setBounds(71, 177, 150, 20);
        this.getContentPane().add(textFieldUser);
        textFieldUser.setColumns(10);
        
        JLabel passwordLabel = new JLabel("Contraseña: ");
        passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        passwordLabel.setBounds(71, 208, 90, 14);
        this.getContentPane().add(passwordLabel);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(71, 233, 150, 20);
        this.getContentPane().add(passwordField);
        
        JButton loginButton = new JButton("Iniciar sesión");
        loginButton.setBackground(new Color(255, 255, 255));
        loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String usuario = textFieldUser.getText();
				String password = new String(passwordField.getPassword());
				dao = new UsuarioDao();			
				int id;
				
				if (usuario.isEmpty() || password.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Los campos son obligatorios",
							"Error", JOptionPane.ERROR_MESSAGE);
				}
				
				if ((id = UsuarioDao.login(usuario, password)) > -1) {
					JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso", "Bienvenido", JOptionPane.INFORMATION_MESSAGE);
					MainView mainView = new MainView(dao.readById(id).getRol());
					mainView.setVisible(true); 
					dispose();
				}
				
			}});
        loginButton.setBounds(81, 279, 120, 23);
		this.getContentPane().add(loginButton);
        
        JButton registerButton = new JButton("Registrarse");
        registerButton.setBackground(new Color(255, 255, 255));
        registerButton.setBounds(190, 412, 115, 23);
        this.getContentPane().add(registerButton);
        
        JLabel lblNewLabel = new JLabel("¿No tienes cuenta?");
        lblNewLabel.setBounds(190, 387, 115, 14);
        getContentPane().add(lblNewLabel);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(128, 0, 255));
        panel.setBounds(10, 11, 295, 95);
        getContentPane().add(panel);
        panel.setLayout(null);
        
        JLabel lblInicioDeSesin = new JLabel("Inicio de sesión");
        lblInicioDeSesin.setBounds(10, 39, 275, 19);
        panel.add(lblInicioDeSesin);
        lblInicioDeSesin.setHorizontalAlignment(SwingConstants.CENTER);
        lblInicioDeSesin.setFont(new Font("Tahoma", Font.BOLD, 15));
        
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Register registerWindow = new Register();
                registerWindow.setVisible(true);
                dispose();
            }
        });
    }
    

    public static void main(String[] args) {
        Authentication loginWindow = new Authentication();
        loginWindow.setVisible(true);
    }
}
