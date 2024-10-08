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
import util.HashUtil;

public class UsuarioDao {

	public boolean create(Usuario usuario) {
		boolean exito = false;
		String sql = "INSERT INTO Usuarios (nombre, correo_electronico, password, rol) VALUES (?, ?, ?, ?)";

		try (Connection conn = ConnectionManager.conectar();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			
			String password = HashUtil.hashPassword(usuario.getPassword());
			
			stmt.setString(1, usuario.getNombre());
			stmt.setString(2, usuario.getCorreoElectronico());
			stmt.setString(3, password);
			stmt.setString(4, usuario.getRol().name());

			if (stmt.executeUpdate() > 0)
				exito = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return exito;
	}

	public Usuario readById(int id) {
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
						Rol.valueOf(rs.getString("rol").toUpperCase())
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}


	public List<Usuario> readAll() {
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
						rs.getString("password"),
						Rol.valueOf(rs.getString("rol").toUpperCase())
						);
				usuarios.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}

	public void update(Usuario usuario) {
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

	public void deleteById(int id) {
		String sql = "DELETE FROM Usuarios WHERE id = ?";

		try (Connection conn = ConnectionManager.conectar();
				PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, id);
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteAll(int id) {
		String sql = "DELETE FROM Usuarios WHERE id";

		try (Connection conn = ConnectionManager.conectar();
				PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static int login(String nombreUsuario, String password) {
		int id = -1;
		
		String sql = "SELECT id, password FROM Usuarios WHERE nombre = ?";
		try (Connection conn = ConnectionManager.conectar();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, nombreUsuario);
			ResultSet rs = stmt.executeQuery(); 
			password = HashUtil.hashPassword(password);
			System.out.println(password);
			if (rs.next()) {
				String passwordBd = rs.getString("password");
				System.out.println();
				
				if(passwordBd.equals(password))
					id = rs.getInt("id");
				else
					System.out.println("Contraseña incorrecta");
			} else
				System.out.println("No existe usuario con tal nombre");	
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return id;
	}

}
