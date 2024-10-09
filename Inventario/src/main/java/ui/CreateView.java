package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import dao.ProductoDao;
import model.Producto;

public class CreateView extends JPanel {
	private JTextField nameText;
	private JTextField descriptionText;
	private JTextField priceText;
	private JTextField amountText;
	private String imagenPath;
	private JLabel imagenLabel;

	public CreateView() {
		initialize();
	}
	
	public void initialize() {
		setLayout(null);

		JLabel titlePanel = new JLabel("Creación de Productos");
		titlePanel.setHorizontalAlignment(SwingConstants.CENTER);
		titlePanel.setFont(new Font("Tahoma", Font.BOLD, 15));
		titlePanel.setBounds(10, 11, 234, 14);
		add(titlePanel);

		JLabel productName = new JLabel("Nombre de producto:");
		productName.setHorizontalAlignment(SwingConstants.RIGHT);
		productName.setBounds(10, 44, 112, 14);
		add(productName);

		nameText = new JTextField();
		nameText.setColumns(10);
		nameText.setBounds(132, 41, 112, 20);
		add(nameText);

		JLabel description = new JLabel("Descripción:");
		description.setHorizontalAlignment(SwingConstants.RIGHT);
		description.setBounds(10, 75, 112, 14);
		add(description);

		descriptionText = new JTextField();
		descriptionText.setColumns(10);
		descriptionText.setBounds(132, 72, 112, 20);
		add(descriptionText);

		JLabel price = new JLabel("Precio:");
		price.setHorizontalAlignment(SwingConstants.RIGHT);
		price.setBounds(254, 44, 60, 14);
		add(price);

		priceText = new JTextField();
		priceText.setColumns(10);
		priceText.setBounds(324, 41, 112, 20);
		add(priceText);

		JLabel amountProduct = new JLabel("Cantidad:");
		amountProduct.setHorizontalAlignment(SwingConstants.RIGHT);
		amountProduct.setBounds(254, 75, 60, 14);
		add(amountProduct);

		amountText = new JTextField();
		amountText.setColumns(10);
		amountText.setBounds(324, 72, 112, 20);
		add(amountText);
		
		
        JButton seleccionarImagenButton = new JButton("Seleccionar Imagen");
        seleccionarImagenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccionarImagen();
            }
        });
        seleccionarImagenButton.setBounds(284, 145, 150, 30);
        add(seleccionarImagenButton);

		imagenLabel = new JLabel("");
		imagenLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		imagenLabel.setBounds(83, 102, 168, 149);
		add(imagenLabel);

		JButton createButton = new JButton("Crear producto");
		createButton.setBackground(new Color(255, 255, 255));
		createButton.setBounds(284, 204, 152, 30);
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createProduct();
			}
		});
		add(createButton);
	}
	
	public void createProduct() {
		String nombre = nameText.getText();
		String descripcion = descriptionText.getText();
		double precio = Double.parseDouble(priceText.getText());
		int cantidad = Integer.parseInt(amountText.getText());

		if(nombre.isEmpty() || descripcion.isEmpty() || priceText.getText().isEmpty() || amountText.getText().isEmpty() || imagenPath.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			ProductoDao productoDao = new ProductoDao();
			Producto producto = new Producto(nombre, descripcion, precio, cantidad, imagenPath);
			if (productoDao.create(producto)) {
				JOptionPane.showMessageDialog(null, "Producto creado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
				limpiarCampos();
			}
			else
				JOptionPane.showMessageDialog(null, "Error al crear el producto", "Error", JOptionPane.ERROR_MESSAGE);

		}
	}
	
	private void seleccionarImagen() {
        JFileChooser fileChooser = new JFileChooser();
        int numero = fileChooser.showOpenDialog(this);
        if (numero == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            imagenPath = file.getAbsolutePath();
            ImageIcon imageIcon = new ImageIcon(new ImageIcon(imagenPath).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
            imagenLabel.setIcon(imageIcon); // Mostrar la imagen seleccionada
        }
    }

	private void limpiarCampos() {
	    nameText.setText("");
	    descriptionText.setText("");
	    priceText.setText("");
	    amountText.setText("");
	    imagenLabel.setIcon(null);  // Limpiamos la imagen mostrada
	    imagenPath = null;  // Reiniciamos el path de la imagen
	}
}
