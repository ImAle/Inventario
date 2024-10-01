package model;

public enum Rol {
	ADMINISTRADOR("Administrador"), USUARIO("Usuario");
	
	private final String nombre;
	
	Rol(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
	
}
