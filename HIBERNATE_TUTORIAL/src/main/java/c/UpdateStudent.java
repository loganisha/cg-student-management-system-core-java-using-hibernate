package c;

import javax.swing.JOptionPane;
//import javax.transaction.Transaction;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateStudent {
	public static void main(String[] args) {
		String x = args[0];
		int id = Integer.parseInt(x);
		System.out.println(id);
		// create a Session Factory

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();

		// create a Session
		Session session = sessionFactory.openSession();

		try {

			Student st = (Student) session.load(Student.class, id);
			System.out.println("before update" + st);
			st.setEmail(JOptionPane.showInputDialog("enter new mail id", "type here"));
			Transaction tr = session.beginTransaction();
			session.saveOrUpdate(st);
			tr.commit();
			System.out.println("after update with new mail ID" + st);
			session.close();

		} catch (HibernateException h) {
			System.out.println("the hibernate error is " + h);
		} catch (Exception h) {
			System.out.println("the hibernate error is " + h);
		}
	}

}
