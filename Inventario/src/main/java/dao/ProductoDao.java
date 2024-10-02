package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Producto;
import servicies.ConnectionManager;

public class ProductoDao {
	
	public void create(Producto producto) throws ClassNotFoundException {
        String sql = "INSERT INTO Productos (nombre, descripcion, precio, cantidad, imagen) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = ConnectionManager.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, producto.getNombre());
            stmt.setString(2, producto.getDescripcion());
            stmt.setDouble(3, producto.getPrecio());
            stmt.setInt(4, producto.getCantidad());
            stmt.setString(5, producto.getImagenURI());
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public Producto readById(int id) throws ClassNotFoundException {
        String sql = "SELECT * FROM Productos WHERE id = ?";
        Producto producto = null;
        
        try (Connection conn = ConnectionManager.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                producto = new Producto(
                    rs.getInt("id_producto"),
                    rs.getString("nombre_producto"),
                    rs.getString("descripcion"),
                    rs.getDouble("precio"),
                    rs.getInt("cantidad"),
                    rs.getString("imagen")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return producto;
    }
	
	public List<Producto> readAll() throws ClassNotFoundException {
        String sql = "SELECT * FROM Productos";
        List<Producto> productos = new ArrayList<>();
        
        try (Connection conn = ConnectionManager.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Producto producto = new Producto(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("descripcion"),
                    rs.getDouble("precio"),
                    rs.getInt("cantidad"),
                    rs.getString("imagen")
                );
                productos.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }
	
	public void update(Producto producto) throws ClassNotFoundException {
        String sql = "UPDATE Productos SET nombre = ?, descripcion = ?, precio = ?, cantidad = ?, imagen = ? WHERE id = ?";
        
        try (Connection conn = ConnectionManager.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, producto.getNombre());
            stmt.setString(2, producto.getDescripcion());
            stmt.setDouble(3, producto.getPrecio());
            stmt.setInt(4, producto.getCantidad());
            stmt.setString(5, producto.getImagenURI());
            stmt.setInt(6, producto.getId());
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public void deleteById(int id) throws ClassNotFoundException {
        String sql = "DELETE FROM Productos WHERE id_producto = ?";
        
        try (Connection conn = ConnectionManager.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public void deleteAll() throws ClassNotFoundException {
        String sql = "DELETE FROM Productos";
        
        try (Connection conn = ConnectionManager.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
