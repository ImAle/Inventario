package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import dao.ProductoDao;
import model.Producto;

public class UpdateView extends JPanel {
	private JTextField updateName;
	private JTextField updateDescription;
	private JTextField updatePrice;
	private JTextField updateAmount;
	private JTextField updateId;
	private String imagenPath;
	private JLabel imagenLabel;

	public UpdateView() {
		initialize();
	}
	
	public void initialize() {
		setLayout(null);
		setPreferredSize(new Dimension(500, 301));

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
		productName.setBounds(10, 67, 112, 14);
		add(productName);

		updateName = new JTextField();
		updateName.setColumns(10);
		updateName.setBounds(132, 64, 112, 20);
		add(updateName);

		JLabel description = new JLabel("Descripción:");
		description.setHorizontalAlignment(SwingConstants.RIGHT);
		description.setBounds(10, 95, 112, 14);
		add(description);

		updateDescription = new JTextField();
		updateDescription.setColumns(10);
		updateDescription.setBounds(132, 92, 112, 20);
		add(updateDescription);

		JLabel price = new JLabel("Precio:");
		price.setHorizontalAlignment(SwingConstants.RIGHT);
		price.setBounds(254, 67, 60, 14);
		add(price);

		updatePrice = new JTextField();
		updatePrice.setColumns(10);
		updatePrice.setBounds(324, 64, 112, 20);
		add(updatePrice);

		JLabel amount = new JLabel("Cantidad:");
		amount.setHorizontalAlignment(SwingConstants.RIGHT);
		amount.setBounds(254, 95, 60, 14);
		add(amount);

		updateAmount = new JTextField();
		updateAmount.setColumns(10);
		updateAmount.setBounds(324, 92, 112, 20);
		add(updateAmount);

		imagenLabel = new JLabel();
		imagenLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		imagenLabel.setBounds(132, 145, 112, 92);
		add(imagenLabel);

		JButton searchButton = new JButton("Buscar por ID");
		searchButton.setBackground(new Color(120, 141, 241));
		searchButton.setBounds(294, 35, 142, 23);
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});
		add(searchButton);
		
		JButton seleccionarImagenButton = new JButton("Seleccionar Imagen");
        seleccionarImagenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccionarImagen();
            }
        });
        seleccionarImagenButton.setBounds(284, 145, 150, 30);
        add(seleccionarImagenButton);


		JButton updateButton = new JButton("Actualizar producto");
		updateButton.setBackground(new Color(255, 255, 255));
		updateButton.setBounds(285, 200, 150, 30);
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		add(updateButton);
	}
	
	public void search() {
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

	            // Convertir ruta relativa a ruta absoluta y verificar si existe
	            String projectDir = System.getProperty("user.dir");
	            File imagenFile = new File(projectDir, "src/main/java" + producto.getImagenURI());
	            if (imagenFile.exists()) {
	                ImageIcon imageIcon = new ImageIcon(new ImageIcon(imagenFile.getAbsolutePath()).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
	                imagenLabel.setIcon(imageIcon);
	            } else {
	                imagenLabel.setIcon(null);
	                JOptionPane.showMessageDialog(null, "Imagen no encontrada", "Advertencia", JOptionPane.WARNING_MESSAGE);
	            }
	        } else {
	            JOptionPane.showMessageDialog(null, "Producto no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    } catch (NumberFormatException ex) {
	        JOptionPane.showMessageDialog(null, "ID inválido", "Error", JOptionPane.ERROR_MESSAGE);
	    } catch (Exception ex) {
	        JOptionPane.showMessageDialog(null, "Error al buscar el producto", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}
	
	public void update() {
		String idText = updateId.getText();
	    String nombre = updateName.getText();
	    String descripcion = updateDescription.getText();
	    double precio = Double.parseDouble(updatePrice.getText());
	    int cantidad = Integer.parseInt(updateAmount.getText());

	    if (idText.isEmpty() || nombre.isEmpty() || descripcion.isEmpty() || updatePrice.getText().isEmpty() || updateAmount.getText().isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
	    } else {
	        ProductoDao productoDao = new ProductoDao();
	        int id = Integer.parseInt(idText);

	        // Obtener la imagen original de la base de datos si no se selecciona una nueva
	        String imagenBbdd = productoDao.readById(id).getImagenURI();
	        String imagenFinal = (imagenPath != null && !imagenPath.isEmpty()) ? "/resources/" + new File(imagenPath).getName() : imagenBbdd;

	        // Crear producto actualizado con la imagen final
	        Producto producto = new Producto(id, nombre, descripcion, precio, cantidad, imagenFinal);
	        
	        if (productoDao.update(producto)) {
	            JOptionPane.showMessageDialog(null, "Producto actualizado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
	            limpiarCampos();
	        } else {
	            JOptionPane.showMessageDialog(null, "Error al actualizar el producto", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	}
	
	private void seleccionarImagen() {
		JFileChooser fileChooser = new JFileChooser();
	    int numero = fileChooser.showOpenDialog(this);
	    if (numero == JFileChooser.APPROVE_OPTION) {
	        File file = fileChooser.getSelectedFile();

	        // Obtener la ruta de la carpeta "resources" directamente
	        String projectDir = System.getProperty("user.dir");
	        File resourcesDir = new File(projectDir, "src/main/java/resources");

	        // Copiar la imagen seleccionada a la carpeta "resources"
	        File destino = new File(resourcesDir, file.getName());
	        try {
	            Files.copy(file.toPath(), destino.toPath(), StandardCopyOption.REPLACE_EXISTING);
	            imagenPath = destino.getAbsolutePath(); // Ruta donde se ha copiado la imagen

	            // Mostrar la imagen seleccionada
	            ImageIcon imageIcon = new ImageIcon(new ImageIcon(imagenPath).getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
	            imagenLabel.setIcon(imageIcon);
	        } catch (IOException e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(this, "Error al obtener la imagen", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	}
	
	private void limpiarCampos() {
	    updateId.setText("");
	    updateName.setText("");
	    updateDescription.setText("");
	    updatePrice.setText("");
	    updateAmount.setText("");
	    imagenLabel.setIcon(null);  // Limpiamos la imagen mostrada
	    imagenPath = null;  // Reiniciamos el path de la imagen
	}
}
