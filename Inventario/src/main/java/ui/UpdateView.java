package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dao.ProductoDao;
import model.Producto;

public class UpdateView extends JPanel {
	private JTextField updateName;
	private JTextField updateDescription;
	private JTextField updatePrice;
	private JTextField updateAmount;
	private JTextField updateImage;
	private JTextField updateId;

	public UpdateView() {
		setLayout(null);
		setPreferredSize(new Dimension(500, 300));

		JLabel lblActualizacionDeProductos = new JLabel("Actualización de Productos");
		lblActualizacionDeProductos.setHorizontalAlignment(SwingConstants.CENTER);
		lblActualizacionDeProductos.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblActualizacionDeProductos.setBounds(10, 11, 234, 14);
		add(lblActualizacionDeProductos);

		JLabel id = new JLabel("Id del producto:");
		id.setHorizontalAlignment(SwingConstants.RIGHT);
		id.setBounds(38, 39, 84, 14);
		add(id);

		updateId = new JTextField();
		updateId.setColumns(10);
		updateId.setBounds(132, 36, 112, 20);
		add(updateId);

		JLabel productName = new JLabel("Nombre de producto:");
		productName.setHorizontalAlignment(SwingConstants.RIGHT);
		productName.setBounds(38, 74, 112, 14);
		add(productName);

		updateName = new JTextField();
		updateName.setColumns(10);
		updateName.setBounds(160, 71, 112, 20);
		add(updateName);

		JLabel description = new JLabel("Descripción:");
		description.setHorizontalAlignment(SwingConstants.RIGHT);
		description.setBounds(38, 105, 112, 14);
		add(description);

		updateDescription = new JTextField();
		updateDescription.setColumns(10);
		updateDescription.setBounds(160, 102, 112, 20);
		add(updateDescription);

		JLabel price = new JLabel("Precio:");
		price.setHorizontalAlignment(SwingConstants.RIGHT);
		price.setBounds(282, 74, 60, 14);
		add(price);

		updatePrice = new JTextField();
		updatePrice.setColumns(10);
		updatePrice.setBounds(352, 71, 112, 20);
		add(updatePrice);

		JLabel amount = new JLabel("Cantidad:");
		amount.setHorizontalAlignment(SwingConstants.RIGHT);
		amount.setBounds(282, 105, 60, 14);
		add(amount);

		updateAmount = new JTextField();
		updateAmount.setColumns(10);
		updateAmount.setBounds(352, 102, 112, 20);
		add(updateAmount);

		JLabel image = new JLabel("Imagen del producto:");
		image.setHorizontalAlignment(SwingConstants.RIGHT);
		image.setBounds(38, 136, 112, 14);
		add(image);

		updateImage = new JTextField();
		updateImage.setColumns(10);
		updateImage.setBounds(160, 133, 112, 20);
		add(updateImage);

		JButton searchButton = new JButton("Buscar por ID");
		searchButton.setBounds(282, 36, 142, 23);
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idText = updateId.getText();
				if (idText.isEmpty()) {
					JOptionPane.showMessageDialog(null, "El campo ID es obligatorio", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				try {
					ProductoDao productoDao = new ProductoDao();
					int id = Integer.parseInt(idText);
					Producto producto = productoDao.readById(id);

					if (producto != null) {
						updateName.setText(producto.getNombre());
						updateDescription.setText(producto.getDescripcion());
						updatePrice.setText(String.valueOf(producto.getPrecio()));
						updateAmount.setText(String.valueOf(producto.getCantidad()));
						updateImage.setText(producto.getImagenURI());
					} else {
						JOptionPane.showMessageDialog(null, "Producto no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "ID inválido", "Error", JOptionPane.ERROR_MESSAGE);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error al buscar el producto", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		add(searchButton);

		JButton updateButton = new JButton("Actualizar producto");
		updateButton.setBounds(10, 220, 142, 23);
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idText = updateId.getText();
				String nombre = updateName.getText();
				String descripcion = updateDescription.getText();
				double precio = Double.parseDouble(updatePrice.getText());
				int cantidad = Integer.parseInt(updateAmount.getText());
				String imagen = updateImage.getText();

				if (idText.isEmpty() || nombre.isEmpty() || descripcion.isEmpty() || updatePrice.getText().isEmpty() || updateAmount.getText().isEmpty() || imagen.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					ProductoDao productoDao = new ProductoDao();
					int id = Integer.parseInt(idText);
					Producto producto = new Producto(id, nombre, descripcion, precio, cantidad, imagen);

					if (productoDao.update(producto))
						JOptionPane.showMessageDialog(null, "Producto actualizado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
					else
						JOptionPane.showMessageDialog(null, "Error al actualizar el producto", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		add(updateButton);
	}
}
