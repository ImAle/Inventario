package ui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dao.ProductoDao;
import model.Producto;

public class updateProduct extends JFrame {

	private JFrame frame;
	private JTextField nameText;
	private JTextField descriptionText;
	private JTextField priceText;
	private JTextField amountText;
	private JTextField imageText;
	private JTextField idText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateProduct window = new updateProduct();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public updateProduct() {
		getContentPane().setLayout(null);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		setTitle("Actualizar productos");
		setBounds(100, 100, 277, 331);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		nameText = new JTextField();
		nameText.setBounds(132, 70, 112, 20);
		getContentPane().add(nameText);
		nameText.setColumns(10);
		
		JLabel productName = new JLabel("Nombre de producto:");
		productName.setHorizontalAlignment(SwingConstants.RIGHT);
		productName.setBounds(10, 73, 112, 14);
		getContentPane().add(productName);
		
		JLabel description = new JLabel("Descripción:");
		description.setHorizontalAlignment(SwingConstants.RIGHT);
		description.setBounds(10, 104, 112, 14);
		getContentPane().add(description);
		
		descriptionText = new JTextField();
		descriptionText.setBounds(132, 101, 112, 20);
		getContentPane().add(descriptionText);
		descriptionText.setColumns(10);
		
		priceText = new JTextField();
		priceText.setBounds(132, 132, 112, 20);
		getContentPane().add(priceText);
		priceText.setColumns(10);
		
		JLabel price = new JLabel("Precio:");
		price.setHorizontalAlignment(SwingConstants.RIGHT);
		price.setBounds(20, 135, 102, 14);
		getContentPane().add(price);
		
		JLabel amountProduct = new JLabel("Cantidad:");
		amountProduct.setHorizontalAlignment(SwingConstants.RIGHT);
		amountProduct.setBounds(10, 166, 112, 14);
		getContentPane().add(amountProduct);
		
		amountText = new JTextField();
		amountText.setBounds(132, 163, 112, 20);
		getContentPane().add(amountText);
		amountText.setColumns(10);
		
		JLabel image = new JLabel("Imagen del producto:");
		image.setHorizontalAlignment(SwingConstants.RIGHT);
		image.setBounds(10, 195, 112, 14);
		getContentPane().add(image);
		
		imageText = new JTextField();
		imageText.setBounds(132, 192, 112, 20);
		getContentPane().add(imageText);
		imageText.setColumns(10);
		
		JButton createButton = new JButton("Actualizar producto");
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = nameText.getText();
				String descripcion = descriptionText.getText();
				double precio = Double.parseDouble(priceText.getText());
				int cantidad = Integer.parseInt(amountText.getText()); 
				String imagen = imageText.getText();
				int id = Integer.parseInt(idText.getText());
                
				if(nombre.isEmpty() || descripcion.isEmpty() || priceText.getText().isEmpty() 
						|| amountText.getText().isEmpty() || imagen.isEmpty() || idText.getText().isEmpty()) {
               	 JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
				}
				try {
					ProductoDao producto = new ProductoDao();
	            	Producto prod = new Producto(nombre, descripcion, precio, cantidad, imagen);
	            	producto.update(prod);
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				
			}
		});
		createButton.setBounds(102, 265, 142, 23);
		getContentPane().add(createButton);
		
		JLabel titlePanel = new JLabel("Actualización de Productos");
		titlePanel.setHorizontalAlignment(SwingConstants.CENTER);
		titlePanel.setFont(new Font("Tahoma", Font.BOLD, 15));
		titlePanel.setBounds(10, 23, 234, 14);
		getContentPane().add(titlePanel);
		
		JLabel id = new JLabel("Id:");
		id.setHorizontalAlignment(SwingConstants.RIGHT);
		id.setBounds(10, 226, 112, 14);
		getContentPane().add(id);
		
		idText = new JTextField();
		idText.setBounds(132, 223, 112, 20);
		getContentPane().add(idText);
		idText.setColumns(10);
	}

}
