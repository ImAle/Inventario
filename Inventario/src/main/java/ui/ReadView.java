package ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.SwingConstants;

import dao.ProductoDao;
import dao.UsuarioDao;
import model.Producto;
import model.Usuario;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.Color;

public class ReadView extends JPanel {
	private JTextField idText;
	private JTextField nameField;
	private JTextField descripcionField;
	private JTextField cantidadField;
	private JTextField precioField;
	private JLabel imagenLabel;


	public ReadView() {
		initialize();
	}
	
	public void initialize() {
		setLayout(null);
		
		imagenLabel = new JLabel();
		imagenLabel.setHorizontalAlignment(SwingConstants.CENTER);
		imagenLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		imagenLabel.setBounds(112, 137, 144, 83);
		add(imagenLabel);
		
		idText = new JTextField();
		idText.setBounds(132, 36, 112, 20);
		add(idText);
		idText.setColumns(10);
		
		JLabel idLabel = new JLabel("Id del producto:");
		idLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		idLabel.setBounds(45, 39, 77, 14);
		add(idLabel);
		
		JLabel productName = new JLabel("Nombre de producto:");
		productName.setHorizontalAlignment(SwingConstants.RIGHT);
		productName.setBounds(10, 70, 112, 14);
		add(productName);
		
		nameField = new JTextField();
		nameField.setEditable(false);
		nameField.setColumns(10);
		nameField.setBounds(132, 67, 112, 20);
		add(nameField);
		
		descripcionField = new JTextField();
		descripcionField.setEditable(false);
		descripcionField.setColumns(10);
		descripcionField.setBounds(132, 95, 112, 20);
		add(descripcionField);
		
		JLabel description = new JLabel("Descripción:");
		description.setHorizontalAlignment(SwingConstants.RIGHT);
		description.setBounds(10, 98, 112, 14);
		add(description);
		
		JLabel amount = new JLabel("Cantidad:");
		amount.setHorizontalAlignment(SwingConstants.RIGHT);
		amount.setBounds(254, 67, 60, 14);
		add(amount);
		
		cantidadField = new JTextField();
		cantidadField.setEditable(false);
		cantidadField.setColumns(10);
		cantidadField.setBounds(324, 67, 112, 20);
		add(cantidadField);
		
		precioField = new JTextField();
		precioField.setEditable(false);
		precioField.setColumns(10);
		precioField.setBounds(324, 36, 112, 20);
		add(precioField);

		JLabel price = new JLabel("Precio:");
		price.setHorizontalAlignment(SwingConstants.RIGHT);
		price.setBounds(254, 39, 60, 14);
		add(price);

		JButton searchButton = new JButton("Leer");
		searchButton.setBackground(new Color(255, 255, 255));
		searchButton.setBounds(326, 128, 89, 23);
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarProducto();
			}
		});
		add(searchButton);

	}

	public void buscarProducto() {
		ProductoDao dao = new ProductoDao();
		int id = Integer.parseInt(idText.getText());
		Producto producto = dao.readById(id);

		nameField.setText(producto.getNombre());
		descripcionField.setText(producto.getDescripcion());
		cantidadField.setText(String.valueOf(producto.getCantidad()));
		precioField.setText(String.valueOf(producto.getPrecio()));

		// Convertir la ruta relativa a una ruta absoluta
		String projectDir = System.getProperty("user.dir");
		File imagenFile = new File(projectDir, "main/java" + producto.getImagenURI());

		// Verificar si la imagen existe antes de intentar cargarla
		if (imagenFile.exists()) {
			ImageIcon imageIcon = new ImageIcon(new ImageIcon(imagenFile.getAbsolutePath()).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
			imagenLabel.setIcon(imageIcon);

		}

	}
}
