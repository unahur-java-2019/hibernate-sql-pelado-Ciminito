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
        Transaction transaction = session.beginTransaction();

        borrarProductos(session);
        insertarProductos(session);
        listarProductos(session);

        transaction.commit();
        session.close();
        HibernateUtil.closeSessionFactory();
    }

    private static void borrarProductos(Session session) {
        session.createNativeQuery("DELETE FROM product").executeUpdate();
    }

    private static void listarProductos(Session session) {
        List<Object[]> listaProductos = session.createNativeQuery("SELECT * FROM product").getResultList();
        System.out.println("PRODUCTOS");
        for (Object[] producto : listaProductos) {
            System.out.println("id: " + producto[0] + ", name: " + producto[1] + ", price: " + producto[2]);
        }
    }

    private static void insertarProductos(Session session) {
        List<String> sqlQueries = Arrays.asList(
                "INSERT INTO product VALUES(null, 'Yerba La Cumbrecita 500g', 35)",
                "INSERT INTO product VALUES(null, 'Almidón de Mandioca Arapeguá 1kg', 80)",
                "INSERT INTO product VALUES(null, 'Uvas rosadas 2kg', 110)");

        for (String query : sqlQueries) {
            session.createNativeQuery(query).executeUpdate();
        }
    }

}
