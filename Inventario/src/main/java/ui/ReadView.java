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

public class ReadView {

	private JFrame frmGestinDeProductos;
	private JTable table;
	UsuarioDao user = new UsuarioDao();
	private Rol rol;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReadView window = new ReadView();
					window.frmGestinDeProductos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the application.
	 */
	public ReadView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestinDeProductos = new JFrame();
		frmGestinDeProductos.setTitle("Gestión de productos");
		frmGestinDeProductos.setBounds(100, 100, 753, 438);
		frmGestinDeProductos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestinDeProductos.getContentPane().setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(10, 11, 110, 377);
		frmGestinDeProductos.getContentPane().add(panel);
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
		frmGestinDeProductos.getContentPane().add(table);
		
		JLabel lblNewLabel = new JLabel("Tabla donde se muestran los datos");
		lblNewLabel.setBounds(130, 184, 172, 14);
		frmGestinDeProductos.getContentPane().add(lblNewLabel);
		
		if(!user.equals(Rol.ADMINISTRADOR) ) {
			createButton.setVisible(false);
            updateButton.setVisible(false);
		}
		
	}
}
