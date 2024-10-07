package servicies;

import dao.ProductoDao;
import model.Producto;
import model.Rol;
import model.Usuario;

public class ProductoService {

	private ProductoDao dao = new ProductoDao();

	public void create(Usuario usuario, Producto producto) {

		if(usuario.getRol()==Rol.ADMINISTRADOR)
			dao.create(producto);
		else
			System.out.println("El usuario no tiene privilegios para crear el producto");

	}
	
	public void readById(Producto producto) {
		dao.readById(producto.getId());
	}
	
	public void readAll(Producto producto) {
		dao.readAll();
	}

	public void update(Usuario usuario, Producto producto) {

		if(usuario.getRol()==Rol.ADMINISTRADOR)
			dao.update(producto);
		else
			System.out.println("El usuario no tiene privilegios para actualizar el producto");

	}

	public void delete(Usuario usuario, Producto producto) {

		if(usuario.getRol()==Rol.ADMINISTRADOR)
			dao.deleteById(producto.getId());
		else
			System.out.println("El usuario no tiene privilegios para eliminar el producto");
	}

	public void deleteAll(Usuario usuario) {

		if(usuario.getRol()==Rol.ADMINISTRADOR)
			dao.deleteAll();
		else
			System.out.println("El usuario no tiene privilegios para eliminar los productos");
	}
}
