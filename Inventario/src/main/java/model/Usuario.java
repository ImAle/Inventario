package model;

import java.util.Objects;

public class Usuario {
	
	private int id;
	private String nombre;
	private String correoElectronico;
	private String password;
	private Rol rol;
	
	public Usuario(int id, String nombre, String correoElectronico, String password, Rol rol) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.correoElectronico = correoElectronico;
		this.password = password;
		this.rol = rol;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", correoElectronico=" + correoElectronico + ", password="
				+ password + ", rol=" + rol + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
