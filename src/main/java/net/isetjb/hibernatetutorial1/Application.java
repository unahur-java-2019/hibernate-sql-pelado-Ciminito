package net.isetjb.hibernatetutorial1;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Application class.
 *
 * @author Nafaa Friaa (nafaa.friaa@isetjb.rnu.tn)
 */
public class Application
{
    /**
     * Attribute declaration for factory to share between methods.
     */
    public static void main(String[] args)
    {
        Session session = HibernateUtil.getSession();

        borrarProductos(session);
        insertarProductos(session);
        listarProductos(session);

        session.close();
        HibernateUtil.closeSessionFactory();
    }

    private static void borrarProductos(Session session) {
        Transaction transaction = session.beginTransaction();
        session.createNativeQuery("DELETE FROM Product").executeUpdate();
        transaction.commit();
    }

    private static void listarProductos(Session session) {
        List<Object[]> listaProductos = session.createNativeQuery("SELECT * FROM Product").getResultList();
        System.out.println("PRODUCTOS");
        for (Object[] Producto : listaProductos) {
            System.out.println("id: " + Producto[0] + ", name: " + Producto[1] + ", price: " + Producto[2]);
        }
    }

    private static void insertarProductos(Session session) {
        Transaction transaction = session.beginTransaction();
        List<String> sqlQueries = Arrays.asList(
                "INSERT INTO Product VALUES(null, 'Yerba La Cumbrecita 500g', 35)",
                "INSERT INTO Product VALUES(null, 'Almidón de Mandioca Arapeguá 1kg', 80)",
                "INSERT INTO Product VALUES(null, 'Uvas rosadas 2kg', 110)");

        for (String query : sqlQueries) {
            session.createNativeQuery(query).executeUpdate();
        }
        transaction.commit();
    }

}
