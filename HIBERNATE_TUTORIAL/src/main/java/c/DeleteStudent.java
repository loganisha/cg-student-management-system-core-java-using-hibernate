package c;

import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteStudent {
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
			System.out.println("before delete" + st);

			Transaction tr = session.beginTransaction();
			int input = JOptionPane.showConfirmDialog(null, "do want to delete ? ",
					"select what u want to delete or not?", JOptionPane.YES_NO_OPTION);

			if (input == 0) {
				session.delete(st);
				JOptionPane.showMessageDialog(null, "OBJECT IS DELETED!!!!....");
			}

			else
				JOptionPane.showMessageDialog(null, "User want to retain it....");

			// int status=JOptionPane.showConfirmDialog(null, "do you want to delete for
			// sure???");
			// if(status==1)
			// session.delete(st);
			// else

			tr.commit();
			System.out.println("after delete with new mail ID" + st);
			session.close();

		} catch (HibernateException h) {
			System.out.println("the hibernate error is " + h);
		} catch (Exception h) {
			System.out.println("the hibernate error is " + h);
		}
	}
}
