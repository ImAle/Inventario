package ui;

import model.Producto;
import model.Rol;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import dao.ProductoDao;
import dao.UsuarioDao;
import model.Rol;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JTextField;
import java.awt.Font;

public class ReadView extends JFrame{

	private JFrame frmGestinDeProductos;
	private JTable table;
	UsuarioDao user = new UsuarioDao();
	private Rol rol;
	private JTextField nameText;
	private JTextField descriptionText;
	private JTextField priceText;
	private JTextField amountText;
	private JTextField imageText;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	
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
				//createProduct create = new createProduct();
				//create.setVisible(true);
				//showPanel();
				
			}
		});
		createButton.setBounds(10, 33, 89, 23);
		panel.add(createButton);
		
		JButton updateButton = new JButton("Actualizar");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		updateButton.setBackground(new Color(255, 255, 255));
		updateButton.setBounds(10, 67, 89, 23);
		panel.add(updateButton);
		
		JButton deleteButton = new JButton("Eliminar");
		deleteButton.setBackground(new Color(255, 255, 255));
		deleteButton.setBounds(10, 101, 89, 23);
		panel.add(deleteButton);
		
		JButton readButton = new JButton("Listar");
		readButton.setBackground(new Color(255, 255, 255));
		readButton.setBounds(10, 135, 89, 23);
		panel.add(readButton);
		
		JButton searchButton = new JButton("Buscar");
		searchButton.setBackground(new Color(255, 255, 255));
		searchButton.setBounds(10, 169, 89, 23);
		panel.add(searchButton);
		
		JButton exitButton = new JButton("Salir");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		exitButton.setBackground(new Color(255, 255, 255));
		exitButton.setBounds(10, 203, 89, 23);
		panel.add(exitButton);
		
		table = new JTable();
		table.setBounds(130, 209, 400, 179);
		getContentPane().add(table);
		
		JLabel lblNewLabel = new JLabel("Tabla donde se muestran los datos");
		lblNewLabel.setBounds(130, 184, 312, 14);
		getContentPane().add(lblNewLabel);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(130, 11, 450, 168);
		getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel createPanel = new JPanel();
		layeredPane.add(createPanel, "name_172681291164900");
		createPanel.setLayout(null);
		
		JLabel productName = new JLabel("Nombre de producto:");
		productName.setHorizontalAlignment(SwingConstants.RIGHT);
		productName.setBounds(10, 44, 112, 14);
		createPanel.add(productName);
		
		nameText = new JTextField();
		nameText.setColumns(10);
		nameText.setBounds(132, 41, 112, 20);
		createPanel.add(nameText);
		
		descriptionText = new JTextField();
		descriptionText.setColumns(10);
		descriptionText.setBounds(132, 72, 112, 20);
		createPanel.add(descriptionText);
		
		JLabel description = new JLabel("Descripción:");
		description.setHorizontalAlignment(SwingConstants.RIGHT);
		description.setBounds(10, 75, 112, 14);
		createPanel.add(description);
		
		priceText = new JTextField();
		priceText.setColumns(10);
		priceText.setBounds(324, 41, 112, 20);
		createPanel.add(priceText);
		
		JLabel price = new JLabel("Precio:");
		price.setHorizontalAlignment(SwingConstants.RIGHT);
		price.setBounds(254, 44, 60, 14);
		createPanel.add(price);
		
		amountText = new JTextField();
		amountText.setColumns(10);
		amountText.setBounds(324, 72, 112, 20);
		createPanel.add(amountText);
		
		JLabel amountProduct = new JLabel("Cantidad:");
		amountProduct.setHorizontalAlignment(SwingConstants.RIGHT);
		amountProduct.setBounds(254, 75, 60, 14);
		createPanel.add(amountProduct);
		
		JLabel image = new JLabel("Imagen del producto:");
		image.setHorizontalAlignment(SwingConstants.RIGHT);
		image.setBounds(10, 106, 112, 14);
		createPanel.add(image);
		
		imageText = new JTextField();
		imageText.setColumns(10);
		imageText.setBounds(132, 103, 112, 20);
		createPanel.add(imageText);
		
		JButton createButton_1 = new JButton("Crear producto");
		createButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = nameText.getText();
				String descripcion = descriptionText.getText();
				double precio = Double.parseDouble(priceText.getText());
	            int cantidad = Integer.parseInt(amountText.getText()); 
                String imagen = imageText.getText();
                
                if(nombre.isEmpty() || descripcion.isEmpty() || priceText.getText().isEmpty() || amountText.getText().isEmpty() || imagen.isEmpty()) {
                	 JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
                }
                
                try {
                	ProductoDao producto = new ProductoDao();
                	Producto prod = new Producto(nombre, descripcion, precio, cantidad, imagen);
                	producto.create(prod);
                	
                }catch (Exception ex) {
					// TODO: handle exception
				}
			}
		});
		createButton_1.setBounds(294, 134, 142, 23);
		createPanel.add(createButton_1);
		
		JLabel titlePanel = new JLabel("Creación de Productos");
		titlePanel.setHorizontalAlignment(SwingConstants.CENTER);
		titlePanel.setFont(new Font("Tahoma", Font.BOLD, 15));
		titlePanel.setBounds(10, 11, 234, 14);
		createPanel.add(titlePanel);
		
		JPanel updatePanel = new JPanel();
		layeredPane.add(updatePanel, "name_172768850591800");
		updatePanel.setLayout(null);
		
		JLabel productName_1 = new JLabel("Nombre de producto:");
		productName_1.setHorizontalAlignment(SwingConstants.RIGHT);
		productName_1.setBounds(10, 70, 112, 14);
		updatePanel.add(productName_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(132, 67, 112, 20);
		updatePanel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(132, 98, 112, 20);
		updatePanel.add(textField_6);
		
		JLabel description_1 = new JLabel("Descripción:");
		description_1.setHorizontalAlignment(SwingConstants.RIGHT);
		description_1.setBounds(10, 101, 112, 14);
		updatePanel.add(description_1);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(330, 67, 112, 20);
		updatePanel.add(textField_7);
		
		JLabel price_1 = new JLabel("Precio:");
		price_1.setHorizontalAlignment(SwingConstants.RIGHT);
		price_1.setBounds(254, 70, 66, 14);
		updatePanel.add(price_1);
		
		JLabel amountProduct_1 = new JLabel("Cantidad:");
		amountProduct_1.setHorizontalAlignment(SwingConstants.RIGHT);
		amountProduct_1.setBounds(254, 101, 66, 14);
		updatePanel.add(amountProduct_1);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(330, 98, 112, 20);
		updatePanel.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(132, 129, 112, 20);
		updatePanel.add(textField_9);
		
		JLabel image_1 = new JLabel("Imagen del producto:");
		image_1.setHorizontalAlignment(SwingConstants.RIGHT);
		image_1.setBounds(10, 132, 112, 14);
		updatePanel.add(image_1);
		
		JLabel id = new JLabel("Id del producto:");
		id.setHorizontalAlignment(SwingConstants.RIGHT);
		id.setBounds(38, 39, 84, 14);
		updatePanel.add(id);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(132, 36, 112, 20);
		updatePanel.add(textField_10);
		
		JButton createButton_2 = new JButton("Actualizar producto");
		createButton_2.setBounds(300, 134, 142, 23);
		updatePanel.add(createButton_2);
		
		JLabel lblActualizacinDeProductos = new JLabel("Actualización de Productos");
		lblActualizacinDeProductos.setHorizontalAlignment(SwingConstants.CENTER);
		lblActualizacinDeProductos.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblActualizacinDeProductos.setBounds(10, 11, 234, 14);
		updatePanel.add(lblActualizacinDeProductos);
		
		JPanel deletePanel = new JPanel();
		layeredPane.add(deletePanel, "name_172788986186200");
		
		JPanel listarPanel = new JPanel();
		layeredPane.add(listarPanel, "name_172813861614200");
		
		JPanel searchPanel = new JPanel();
		layeredPane.add(searchPanel, "name_172839804379000");
		
		if(rol != Rol.ADMINISTRADOR) {
			System.out.println(rol);
			//createButton.setVisible(false);
            //updateButton.setVisible(false);
            //deleteButton.setVisible(false);
		}
		
	}
}
