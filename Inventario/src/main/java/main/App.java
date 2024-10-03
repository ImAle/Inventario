package main;

import java.util.List;

import dao.ProductoDao;
import model.Producto;

public class App 
{
    public static void main( String[] args )
    {  
       ProductoDao pdao = new ProductoDao();
       
       pdao.readAll().forEach(System.out::println);
       System.out.println();
       System.out.println(pdao.readById(1));
       System.out.println();
       Producto producto = new Producto("Producto 99", "Descripción del Producto 99", 25.50, 100, "imagen99.jpg");
       pdao.create(producto);
       List<Producto> productosFiltro = pdao.search("99");
       
       productosFiltro.forEach(System.out::println);
       System.out.println();
       
       for(Producto product : pdao.search("")) {
    	   pdao.deleteById(product.getId());
       }
       
       productosFiltro = pdao.search("99");
       if(!productosFiltro.isEmpty())
    	   productosFiltro.forEach(System.out::println);
       else
    	   System.out.println("No hay productos con ese filtro");
    }
}
