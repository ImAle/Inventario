package ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.Color;

public class ImageView extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField idText;
	private JTextField nameText;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Create the panel.
	 */
	public ImageView() {
		setLayout(null);
		
		JLabel lblImagenDelProducto = new JLabel("Imagen del Producto");
		lblImagenDelProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagenDelProducto.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblImagenDelProducto.setBounds(10, 11, 234, 14);
		add(lblImagenDelProducto);
		
		idText = new JTextField();
		idText.setBounds(132, 36, 112, 20);
		add(idText);
		idText.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Id del producto:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(45, 39, 77, 14);
		add(lblNewLabel_1);
		
		JLabel productName = new JLabel("Nombre de producto:");
		productName.setHorizontalAlignment(SwingConstants.RIGHT);
		productName.setBounds(10, 70, 112, 14);
		add(productName);
		
		nameText = new JTextField();
		nameText.setEditable(false);
		nameText.setColumns(10);
		nameText.setBounds(132, 67, 112, 20);
		add(nameText);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(132, 95, 112, 20);
		add(textField_3);
		
		JLabel description = new JLabel("Descripción:");
		description.setHorizontalAlignment(SwingConstants.RIGHT);
		description.setBounds(10, 98, 112, 14);
		add(description);
		
		JLabel lblImagen = new JLabel("Imagen:");
		lblImagen.setHorizontalAlignment(SwingConstants.RIGHT);
		lblImagen.setBounds(454, 39, 50, 14);
		add(lblImagen);
		
		JLabel amount = new JLabel("Cantidad:");
		amount.setHorizontalAlignment(SwingConstants.RIGHT);
		amount.setBounds(254, 67, 60, 14);
		add(amount);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(324, 67, 112, 20);
		add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(324, 36, 112, 20);
		add(textField_6);
		
		JLabel price = new JLabel("Precio:");
		price.setHorizontalAlignment(SwingConstants.RIGHT);
		price.setBounds(254, 39, 60, 14);
		add(price);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setBounds(464, 64, 152, 225);
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Leer");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(210, 126, 89, 23);
		add(btnNewButton);

	}
}
