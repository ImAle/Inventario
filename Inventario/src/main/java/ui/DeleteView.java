package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import dao.ProductoDao;

public class DeleteView extends JPanel {
	private JTextField deleteId;

	public DeleteView() {
		initialize();
	}
	
	public void initialize() {
		setLayout(null);

		JLabel titlePanel = new JLabel("Eliminar Producto");
		titlePanel.setHorizontalAlignment(SwingConstants.CENTER);
		titlePanel.setFont(new Font("Tahoma", Font.BOLD, 15));
		titlePanel.setBounds(10, 11, 234, 14);
		add(titlePanel);

		JLabel id = new JLabel("Id del producto:");
		id.setHorizontalAlignment(SwingConstants.RIGHT);
		id.setBounds(38, 44, 84, 14);
		add(id);

		deleteId = new JTextField();
		deleteId.setColumns(10);
		deleteId.setBounds(132, 41, 112, 20);
		add(deleteId);

		JButton deleteButton = new JButton("Eliminar producto");
		deleteButton.setBackground(new Color(255, 255, 255));
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteProduct();
			}
		});
		deleteButton.setBounds(254, 40, 142, 23);
		add(deleteButton);
	}
	
	public void deleteProduct() {
		String id = deleteId.getText();
		if (!id.isEmpty()) {

			ProductoDao producto = new ProductoDao();
			if (producto.deleteById(Integer.parseInt(id))) {
				JOptionPane.showMessageDialog(null, "Producto eliminado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
				deleteId.setText("");
			} else
				JOptionPane.showMessageDialog(null, "Error al eliminar el producto", "Error", JOptionPane.ERROR_MESSAGE);

		}else 
			JOptionPane.showMessageDialog(null, "El campo ID es obligatorio", "Error", JOptionPane.ERROR_MESSAGE);
	}
}
