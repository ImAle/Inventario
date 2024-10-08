package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import dao.ProductoDao;
import model.Producto;

public class SearchView extends JPanel {
    private JTextField searchName;
    private JTable searchResultTable;

    public SearchView() {
        setLayout(null);

        JLabel titlePanel = new JLabel("Buscar Producto");
        titlePanel.setHorizontalAlignment(SwingConstants.CENTER);
        titlePanel.setFont(new Font("Tahoma", Font.BOLD, 15));
        titlePanel.setBounds(10, 11, 234, 14);
        add(titlePanel);

        JLabel nameLabel = new JLabel("Nombre de producto:");
        nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        nameLabel.setBounds(10, 44, 112, 14);
        add(nameLabel);

        searchName = new JTextField();
        searchName.setColumns(10);
        searchName.setBounds(132, 41, 112, 20);
        add(searchName);

        // Crear la tabla para mostrar los resultados
        searchResultTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(searchResultTable);
        scrollPane.setBounds(10, 76, 486, 138);
        add(scrollPane);

        JButton searchButton = new JButton("Buscar producto");
        searchButton.setBackground(new Color(255, 255, 255));
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = searchName.getText();
                if (nombre.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "El campo nombre es obligatorio", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    searchProduct(nombre);
                }
            }
        });
        searchButton.setBounds(254, 40, 142, 23);
        add(searchButton);
    }

    private void searchProduct(String nombre) {
        try {
            ProductoDao productoDao = new ProductoDao();
            List<Producto> productos = productoDao.search(nombre);

            if (!productos.isEmpty()) {
                // Definir las columnas del modelo de la tabla
                String[] columnas = {"id", "nombre", "descripción", "precio", "cantidad", "imagen"};

                // Crear el modelo de la tabla con las columnas
                DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

                // Recorrer la lista de productos y agregar cada uno al modelo de la tabla
                for (Producto producto : productos) {
                    Object[] fila = {
                        producto.getId(),
                        producto.getNombre(),
                        producto.getDescripcion(),
                        producto.getPrecio(),
                        producto.getCantidad(),
                        producto.getImagenURI()
                    };
                    modelo.addRow(fila);
                }

                // Asignar el modelo a la tabla
                searchResultTable.setModel(modelo);
            } else {
                // Limpiar la tabla y mostrar un mensaje de que no se encontraron resultados
                DefaultTableModel modelo = new DefaultTableModel();
                searchResultTable.setModel(modelo);
                JOptionPane.showMessageDialog(null, "Producto no encontrado", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar el producto", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
