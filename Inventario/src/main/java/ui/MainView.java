package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Rol;

public class MainView extends JFrame {
    private Rol rol;
    private JLayeredPane layeredPane;

    public MainView(Rol rol) {
        this.rol = rol;
        initialize();
    }

    private void initialize() {
        setTitle("Gestión de productos");
        setBounds(100, 100, 753, 438);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(120, 141, 241));
        panel.setBounds(10, 11, 110, 377);
        getContentPane().add(panel);
        panel.setLayout(null);

        layeredPane = new JLayeredPane();
        layeredPane.setBounds(130, 11, 597, 248);
        getContentPane().add(layeredPane);
        layeredPane.setLayout(new CardLayout(0, 0));

        JButton createButton = new JButton("Crear");
        createButton.setBackground(new Color(255, 255, 255));
        createButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchPanel(new CreateView());
            }
        });
        createButton.setBounds(10, 33, 89, 23);
        panel.add(createButton);

        JButton updateButton = new JButton("Actualizar");
        updateButton.setBackground(new Color(255, 255, 255));
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchPanel(new UpdateView());
            }
        });
        updateButton.setBounds(10, 67, 89, 23);
        panel.add(updateButton);

        JButton deleteButton = new JButton("Eliminar");
        deleteButton.setBackground(new Color(255, 255, 255));
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchPanel(new DeleteView());
            }
        });
        deleteButton.setBounds(10, 101, 89, 23);
        panel.add(deleteButton);

        JButton listButton = new JButton("Listar");
        listButton.setBackground(new Color(255, 255, 255));
        listButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		switchPanel(new ListView());
        	}
        });
        listButton.setBounds(10, 135, 89, 23);
        panel.add(listButton);

        JButton searchButton = new JButton("Buscar");
        searchButton.setBackground(new Color(255, 255, 255));
        searchButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		switchPanel(new SearchView());
        	}
        });
        searchButton.setBounds(10, 169, 89, 23);
        panel.add(searchButton);
        
        JButton exitButton = new JButton("Salir");
        exitButton.setBackground(new Color(255, 255, 255));
        exitButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        	}
        });
        exitButton.setBounds(10, 237, 89, 23);
        panel.add(exitButton);
        
        JButton btnNewButton = new JButton("Imagenes");
        btnNewButton.setBackground(new Color(255, 255, 255));
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		switchPanel(new ImageView());
        	}
        });
        btnNewButton.setBounds(10, 203, 89, 23);
        panel.add(btnNewButton);

        switchPanel(new ListView());

        if(this.rol == Rol.valueOf("USUARIO")) {
        	createButton.setVisible(false);
        	updateButton.setVisible(false);
        	deleteButton.setVisible(false);
        }
    }

    private void switchPanel(JPanel panel) {
    	layeredPane.removeAll();
    	layeredPane.add(panel);
    	layeredPane.repaint();
    	layeredPane.revalidate();
    }
}
