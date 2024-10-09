package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.util.List;
import dao.ProductoDao;
import model.Producto;

public class ListView extends JPanel {

    private JTable table;

    public ListView() {
    	initialize();
    }
    
    public void initialize() {
    	setLayout(null);

        JLabel titlePanel = new JLabel("Lista de Productos");
        titlePanel.setHorizontalAlignment(SwingConstants.CENTER);
        titlePanel.setFont(new Font("Tahoma", Font.BOLD, 15));
        titlePanel.setBounds(10, 11, 234, 14);
        add(titlePanel);

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 36, 570, 200);
        add(scrollPane);

        listProducts();
    }

    public void listProducts() {
            ProductoDao productoDao = new ProductoDao();
            List<Producto> productos = productoDao.readAll();
            String[] columnas = {"id", "nombre", "descripción", "precio", "cantidad"};
	        DefaultTableModel modelo = new DefaultTableModel(columnas, 0); 

	        for (Producto producto : productos) {
	            Object[] columna = {producto.getId(),producto.getNombre(),producto.getDescripcion(),
	            		producto.getPrecio(),producto.getCantidad()};
	            modelo.addRow(columna);
	        }
	        table.setModel(modelo);
    }
}
