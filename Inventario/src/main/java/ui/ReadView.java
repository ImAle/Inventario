package ui;

import model.Rol;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import dao.UsuarioDao;
import model.Rol;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JLabel;

public class ReadView extends JFrame{

	private JFrame frmGestinDeProductos;
	private JTable table;
	UsuarioDao user = new UsuarioDao();
	private Rol rol;
	
	/**
	 * Create the application.
	 */
	public ReadView(Rol rol) {
		this.rol = rol;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		setTitle("Gestión de productos");
		setBounds(100, 100, 753, 438);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(10, 11, 110, 377);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton createButton = new JButton("Crear");
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		createButton.setBounds(10, 33, 89, 23);
		panel.add(createButton);
		
		JButton updateButton = new JButton("Actualizar");
		updateButton.setBounds(10, 67, 89, 23);
		panel.add(updateButton);
		
		JButton deleteButton = new JButton("Eliminar");
		deleteButton.setBounds(10, 101, 89, 23);
		panel.add(deleteButton);
		
		JButton readButton = new JButton("Leer");
		readButton.setBounds(10, 135, 89, 23);
		panel.add(readButton);
		
		JButton searchButton = new JButton("Buscar");
		searchButton.setBounds(10, 169, 89, 23);
		panel.add(searchButton);
		
		JButton exitButton = new JButton("Salir");
		exitButton.setBounds(10, 203, 89, 23);
		panel.add(exitButton);
		
		table = new JTable();
		table.setBounds(130, 209, 400, 179);
		getContentPane().add(table);
		
		JLabel lblNewLabel = new JLabel("Tabla donde se muestran los datos");
		lblNewLabel.setBounds(130, 184, 312, 14);
		getContentPane().add(lblNewLabel);
		
		if(rol != Rol.ADMINISTRADOR) {
			createButton.setVisible(false);
            updateButton.setVisible(false);
            deleteButton.setVisible(false);
		}
		
	}
}
