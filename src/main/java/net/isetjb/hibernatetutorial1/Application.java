package net.isetjb.hibernatetutorial1;

import java.util.List;
import java.util.Random;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
    private static SessionFactory factory;

    public static void main(String[] args)
    {
        // Open connection  pool
        factory = HibernateUtil.getSessionFactory();

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        ///// SQL queries
        // Single result :
        String sql1 = "SELECT VERSION()";
        String result1 = (String) session.createNativeQuery(sql1).getSingleResult();
        System.out.println("Result1 ==> " + result1);

        // List result :
        String sql2 = "SHOW TABLES";
        List result2 = session.createNativeQuery(sql2).getResultList();
        System.out.println("Result2 ==> ");
        for (Object temp : result2)
        {
            System.out.println(temp);
        }

        // Insert record :
        int randomNumber = new Random().nextInt(100);
        String sql3 = "INSERT INTO product VALUES(null, 'Qwerty_" + randomNumber + "' , " + randomNumber + ")";
        int result3 = (int) session.createNativeQuery(sql3).executeUpdate();
        System.out.println("Result3 ==> " + result3);

        // List array result :
        String sql4 = "SELECT * FROM product";
        List<Object[]> result4 = session.createNativeQuery(sql4).getResultList();
        System.out.println("Result4 ==> ");
        for (Object[] temp : result4)
        {
            System.out.println("id:" + temp[0] + " ===> name:" + temp[1] + " ===> price:" + temp[2]);
        }

        transaction.commit();
        session.close();

        // Cleaning up connection pool
        factory.close();
    }

}
