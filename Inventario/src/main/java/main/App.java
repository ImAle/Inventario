package main;

import java.util.List;

import dao.ProductoDao;
import dao.UsuarioDao;
import model.Producto;
import model.Rol;
import model.Usuario;

public class App 
{
	public static void main( String[] args )
	{  
		// Comprobando que los metodos de productos funciona
		/*
       ProductoDao pdao = new ProductoDao();

       pdao.readAll().forEach(System.out::println);
       System.out.println();
       System.out.println(pdao.readById(67));
       System.out.println();
       Producto producto = new Producto("Producto 99", "Descripción del Producto 99", 25.50, 100, "imagen99.jpg");
       pdao.create(producto);
       List<Producto> productosFiltro = pdao.search("99");

       productosFiltro.forEach(System.out::println);
       System.out.println();


       for(Producto product : pdao.search("99")) {
    	   product.setNombre("Producto infinito");
    	   pdao.update(product);
    	   //pdao.deleteById(product.getId());
       }

       productosFiltro = pdao.search("infinito");
       //productosFiltro = pdao.search("99");
       if(!productosFiltro.isEmpty())
    	   productosFiltro.forEach(System.out::println);
       else
    	   System.out.println("No hay productos con ese filtro");
		 */

		// Comprobando que los métodos de usuarios funciona
		/*
    	UsuarioDao udao = new UsuarioDao();
    	List<Usuario> usuarios = udao.readAll();
    	usuarios.forEach(System.out::println);

    	System.out.println();
    	System.out.println(udao.readById(14));

    	//udao.deleteById(16);

    	//Usuario usuario = new Usuario("Pepe", "pepe@gmail.com", "user", Rol.USUARIO);
    	//udao.create(usuario);

    	usuarios = udao.readAll();
    	usuarios.forEach(System.out::println);

    	if (UsuarioDao.login("Pepe", "user"))
    		System.out.println("Inicio de sesion correcto");
    	else
    		System.out.println("Fallo al iniciar sesión");
		 */
	}

}
