package ui;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
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
        initialize();
    }
    
    public void initialize() {
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
        
        searchName.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                buscar();
            }

            public void removeUpdate(DocumentEvent e) {
                buscar();
            }

            public void changedUpdate(DocumentEvent e) {
                buscar();
            }

            private void buscar() {
                searchByName();
            }
        });
        
        // Crear la tabla para mostrar los resultados
        searchResultTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(searchResultTable);
        scrollPane.setBounds(10, 76, 486, 138);
        add(scrollPane);
    }

    public void searchProduct(String nombre) {
        try {
            ProductoDao productoDao = new ProductoDao();
            List<Producto> productos = productoDao.search(nombre);

            if (!productos.isEmpty()) {
                String[] columnas = {"id", "nombre", "descripción", "precio", "cantidad"};
                DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

                for (Producto producto : productos) {
                    Object[] fila = {
                        producto.getId(),
                        producto.getNombre(),
                        producto.getDescripcion(),
                        producto.getPrecio(),
                        producto.getCantidad()
                    };
                    modelo.addRow(fila);
                }

                
                searchResultTable.setModel(modelo);
                
            } else {
                DefaultTableModel modelo = new DefaultTableModel();
                searchResultTable.setModel(modelo);
                JOptionPane.showMessageDialog(null, "Producto no encontrado", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar el producto", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void searchByName() {
    	String nombre = searchName.getText();
        if (nombre.isEmpty()) {
            // Limpiar la tabla si no hay texto en el campo de búsqueda
            DefaultTableModel tableModel = new DefaultTableModel();
            searchResultTable.setModel(tableModel);
        } else {
            searchProduct(nombre);
        }
    }
}
