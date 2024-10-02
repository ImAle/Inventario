package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Rol;
import model.Usuario;
import servicies.ConnectionManager;

public class UsuarioDao {

	    public void create(Usuario usuario) throws ClassNotFoundException {
	        String sql = "INSERT INTO Usuario (nombre, correo_electronico, password, rol) VALUES (?, ?, ?, ?)";
	        
	        try (Connection conn = ConnectionManager.conectar();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {
	            
	            stmt.setString(1, usuario.getNombre());
	            stmt.setString(2, usuario.getCorreoElectronico());
	            stmt.setString(3, usuario.getPassword());
	            stmt.setString(4, usuario.getRol().name());
	            
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	        public Usuario readById(int id) throws ClassNotFoundException {
	            String sql = "SELECT * FROM Usuarios WHERE id = ?";
	            Usuario usuario = null;
	            
	            try (Connection conn = ConnectionManager.conectar();
	                 PreparedStatement stmt = conn.prepareStatement(sql)) {
	                
	                stmt.setInt(1, id);
	                
	                ResultSet rs = stmt.executeQuery();
	                
	                if (rs.next()) {
	                    usuario = new Usuario(
	                        rs.getInt("id"),
	                        rs.getString("nombre"),
	                        rs.getString("correo_electronico"),
	                        rs.getString("password"),
	                        Rol.valueOf(rs.getString("rol"))
	                    );
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	            return usuario;
	        }

	        
	        public List<Usuario> readAll() throws ClassNotFoundException {
	            String sql = "SELECT * FROM Usuarios";
	            List<Usuario> usuarios = new ArrayList<>();
	            
	            try (Connection conn = ConnectionManager.conectar();
	                 PreparedStatement stmt = conn.prepareStatement(sql);
	                 ResultSet rs = stmt.executeQuery()) {
	                
	                while (rs.next()) {
	                    Usuario usuario = new Usuario(
	                        rs.getInt("id"),
	                        rs.getString("nombre"),
	                        rs.getString("correo_electronico"),
	                        rs.getString("contraseña"),
	                        Rol.valueOf(rs.getString("rol"))
	                    );
	                    usuarios.add(usuario);
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	            return usuarios;
	        }

	            public void update(Usuario usuario) throws ClassNotFoundException {
	                String sql = "UPDATE Usuarios SET nombre = ?, correo_electronico = ?, password = ?, rol = ? WHERE id = ?";
	                
	                try (Connection conn = ConnectionManager.conectar();
	                     PreparedStatement stmt = conn.prepareStatement(sql)) {
	                    
	                    stmt.setString(1, usuario.getNombre());
	                    stmt.setString(2, usuario.getCorreoElectronico());
	                    stmt.setString(3, usuario.getPassword());
	                    stmt.setString(4, usuario.getRol().name());
	                    stmt.setInt(5, usuario.getId());
	                    
	                    stmt.executeUpdate();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	        
	            public void deleteById(int id) throws ClassNotFoundException {
	                String sql = "DELETE FROM Usuarios WHERE id = ?";
	                
	                try (Connection conn = ConnectionManager.conectar();
	                     PreparedStatement stmt = conn.prepareStatement(sql)) {
	                	
	                    stmt.setInt(1, id);
	                    stmt.executeUpdate();
	                    
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	            
	            public void deleteAll(int id) throws ClassNotFoundException {
	                String sql = "DELETE FROM Usuarios WHERE id";
	                
	                try (Connection conn = ConnectionManager.conectar();
	                     PreparedStatement stmt = conn.prepareStatement(sql)) {
	                	
	                    stmt.executeUpdate();
	                    
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }

}
