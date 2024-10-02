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

	public void create(Usuario usuario) {
		String sql = "INSERT INTO Usuario (nombre, correo_electronico, password, rol) VALUES (?, ?, ?, ?)";

		try (Connection conn = ConnectionManager.conectar();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			
			String password = HashUtil.hashPassword(usuario.getPassword());
			
			stmt.setString(1, usuario.getNombre());
			stmt.setString(2, usuario.getCorreoElectronico());
			stmt.setString(3, password);
			stmt.setString(4, usuario.getRol().name());

			stmt.executeUpdate();
		}catch(ClassNotFoundException cnfex) {
			cnfex.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
						Rol.valueOf(rs.getString("rol"))
						);
			}
		}catch(ClassNotFoundException cnfex) {
			cnfex.printStackTrace();
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
						rs.getString("contraseña"),
						Rol.valueOf(rs.getString("rol"))
						);
				usuarios.add(usuario);
			}
		}catch(ClassNotFoundException cnfex) {
			cnfex.printStackTrace();
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
		}catch(ClassNotFoundException cnfex) {
			cnfex.printStackTrace();
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

		}catch(ClassNotFoundException cnfex) {
			cnfex.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteAll(int id) {
		String sql = "DELETE FROM Usuarios WHERE id";

		try (Connection conn = ConnectionManager.conectar();
				PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.executeUpdate();

		}catch(ClassNotFoundException cnfex) {
			cnfex.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean login(String nombreUsuario, String password) {
		boolean exito = false;
		
		String sql = "SELECT password FROM Usuarios WHERE nombre = ?";
		try (Connection conn = ConnectionManager.conectar();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, nombreUsuario);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				String passwordBd = rs.getString("password");
				if(passwordBd.equals(password))
					exito = true;
			}else {
				System.out.println("No existe usuario co tal nombre");			}
				
		}catch(ClassNotFoundException cnfex) {
			cnfex.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return exito;
	}

}
