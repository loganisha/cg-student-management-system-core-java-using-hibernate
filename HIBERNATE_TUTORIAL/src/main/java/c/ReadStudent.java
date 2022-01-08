package c;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;

public class ReadStudent {

	public static void main(String[] args) {
		String x = args[0];
		int id = Integer.parseInt(x);
		System.out.println(id);
		try {

			SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
					.addAnnotatedClass(Student.class).buildSessionFactory();

			Session session = sessionFactory.openSession();
			Student st = (Student) session.load(Student.class, id);
			System.out.println(st);
		} catch (HibernateException h) {
			System.out.println("the hibernate error is " + h);
		} catch (Exception h) {
			System.out.println("the hibernate error is " + h);
		}
	}

}
