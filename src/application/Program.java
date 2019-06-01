package application;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		double s, tx;
		boolean e = false;
		String name;
		int id, n, ident, t = 0;
		ArrayList<Funcionario> list = new ArrayList();

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.printf("Employer #%d:\n", i + 1);
			System.out.println("Id: ");
			id = sc.nextInt();
			for(Funcionario f : list) {
				while(id == f.getId()) {
					System.out.println("Digite um novo ID");
					id = sc.nextInt();
				}
			}
			System.out.println("Name: ");
			sc.nextLine();
			name = sc.nextLine();
			System.out.println("Salary: ");
			s = sc.nextDouble();

			Funcionario f = new Funcionario(id, name, s);

			list.add(f);
		}
		System.out.println("Enter the employee id that will have salary increase:");
		ident = sc.nextInt();

		for (Funcionario f : list) {
			int ind = list.indexOf(f);

			if (f.getId() == ident) {
				System.out.println("Enter the percentage:");
				tx = sc.nextDouble();
				f.aumentaSalario(tx);

			}
			if (f.getId() != ident) {
				t++;
				if (t == list.size()) {
					System.out.println("This employee does not exist.");
					e = true;
				}
			}
		}
		System.out.println("List of employee");
		for (Funcionario f : list) {
			System.out.println(f.getId() + ", " + f.getNome() + ", " + f.getSalario());
		}
		if (e == true)
			System.exit(0);
	}
}
