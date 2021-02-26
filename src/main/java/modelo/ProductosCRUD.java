package modelo;

//com.mycompany_ProductosCRUDUpdate_war_1.0-SNAPSHOTPU
import java.util.List;
import javax.persistence.*;

public class ProductosCRUD {

    public static List<Productos> getProductos() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_ProductosCRUDUpdate_war_1.0-SNAPSHOTPU");
        EntityManager manager = factory.createEntityManager();
        String sql = "SELECT * FROM productos";
        Query q = manager.createNativeQuery(sql, Productos.class);
        List<Productos> productosBD = q.getResultList();

        return productosBD;
    }

    public static int actualizaProducto() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_ProductosCRUDUpdate_war_1.0-SNAPSHOTPU");
        EntityManager manager = factory.createEntityManager();
        String sql = "UPDATE Productos p SET p.categoria = 'zumos' WHERE p.id = 8";
        Query q = manager.createQuery(sql, Productos.class);
        manager.getTransaction().begin();
        int filasAfectadas = q.executeUpdate();
        manager.getTransaction().commit();
        //manager.close();

        return filasAfectadas;
    }

    public static int actualizaProducto2() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_ProductosCRUDUpdate_war_1.0-SNAPSHOTPU");
        EntityManager manager = factory.createEntityManager();
        String sql = "UPDATE Productos p SET p.nombre = :nombre, p.imagen = :imagen, p.categoria = :categoria, p.precio = :precio WHERE p.id = 10";
        Query q = manager.createQuery(sql, Productos.class);
        q.setParameter("categoria", "Digestivos");
        q.setParameter("nombre", "Pacharán");
        q.setParameter("imagen", "pacharan.jpg");
        q.setParameter("precio", 4.0);
        manager.getTransaction().begin();
        int filasAfectadas = q.executeUpdate();
        manager.getTransaction().commit();
        //manager.close();
        return filasAfectadas;
    }

    public static int actualizaProducto(Productos miProducto) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_ProductosCRUDUpdate_war_1.0-SNAPSHOTPU");
        EntityManager manager = factory.createEntityManager();
        String sql = "UPDATE Productos p SET p.nombre = :nombre, p.imagen = :imagen, p.categoria = :categoria, p.precio = :precio WHERE p.id = :id";
        Query q = manager.createQuery(sql, Productos.class);
        q.setParameter("id", miProducto.getId());
        q.setParameter("categoria", miProducto.getCategoria());
        q.setParameter("nombre", miProducto.getNombre());
        q.setParameter("imagen", miProducto.getImagen());
        q.setParameter("precio", miProducto.getPrecio());
        manager.getTransaction().begin();
        int filasAfectadas = q.executeUpdate();
        manager.getTransaction().commit();
        //manager.close();
        return filasAfectadas;
    }

    public static void insertaProducto() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_ProductosCRUDUpdate_war_1.0-SNAPSHOTPU");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        Productos producto = new Productos();
        producto.setNombre("Espinacas");
        producto.setPrecio(13);
        producto.setImagen("espinacas.jpg");
        producto.setCategoria("complementos");
        manager.merge(producto);
        manager.getTransaction().commit();
    }
    
    public static void insertaProducto(Productos producto) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_ProductosCRUDUpdate_war_1.0-SNAPSHOTPU");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.merge(producto);
        manager.getTransaction().commit();
    }

}
