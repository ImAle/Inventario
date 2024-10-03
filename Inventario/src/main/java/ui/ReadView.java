package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ReadView {

	private JFrame frmGestinDeProductos;

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
		
		JMenu menuProductos = new JMenu("Menu");
		menuProductos.setBounds(10, 11, 115, 26);
		frmGestinDeProductos.getContentPane().add(menuProductos);
		
		JMenuItem createProducto = new JMenuItem("Crear");
		menuProductos.add(createProducto);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Consultar");
		menuProductos.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Actualizar");
		menuProductos.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Eliminar");
		menuProductos.add(mntmNewMenuItem_2);
	}
}
