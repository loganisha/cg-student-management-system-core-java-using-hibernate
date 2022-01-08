package c;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CreateStudent {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = sessionFactory.openSession();

		try {

			System.out.println("Creating a new Student object...");
			Student student = new Student("loga", "nisha", "loga.nisha@gmail.com");

			Transaction tr = session.beginTransaction();

			session.save(student);

			System.out.println("Java object saved to the database");
			tr.commit();
			session.close();
		} catch (HibernateException h) {
			System.out.println("the hibernate error is " + h);
		} catch (Exception h) {
			System.out.println("the hibernate error is " + h);
		}
	}
}
