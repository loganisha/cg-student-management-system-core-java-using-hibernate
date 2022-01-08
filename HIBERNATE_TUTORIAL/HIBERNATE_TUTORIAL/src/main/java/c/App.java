package c;

import javax.swing.JOptionPane;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		String x = JOptionPane.showInputDialog("enter choice", "type here");
		switch (x) {
		case "CREATE":
			CreateStudent.main(args);

			break;
		case "READ":
			String h = JOptionPane.showInputDialog("enter id", "type here");
			String ss[] = { h };
			ReadStudent.main(ss);

			break;

		case "UPDATE":
			String h2 = JOptionPane.showInputDialog("enter id to update ", "type here");
			String ss2[] = { h2 };
			UpdateStudent.main(ss2);

			break;

		case "DELETE":
			String h22 = JOptionPane.showInputDialog("enter id to delete ", "type here");
			String ss22[] = { h22 };
			DeleteStudent.main(ss22);

			break;

		default:
			System.out.println("bye");

		}

	}
}
