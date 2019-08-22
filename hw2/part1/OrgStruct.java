package part_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class OrgStruct {
	public Employee ceo;
	Queue<Employee> queue = new LinkedList<>();

	public static class Employee {
		public String name;
		public String title;
		public List<Employee> sub; // surbodinates
		public int level = 1;

		public Employee(String name, String title, List<Employee> sub) {
			this.name = name;
			this.title = title;
			this.sub = sub;
		}

		public String getName() {
			return name;
		}

		public String getTitle() {
			return title;
		}

		public List<Employee> getSubs() {
			return sub;
		}

		public void print() {
			System.out.println("Name: " + name + ", Title: " + title);
		}

	}

	public void printLevelByLevel() {
		Employee temp = ceo;
		queue.add(temp);
		while (queue.size() > 0) {
			System.out.println("Queue's head: " + queue.peek());
			Employee sup = queue.poll(); // supervisor
			if (sup.sub != null) {
				queue.add((Employee) sup.sub);
			}
		}

	}

//	public void printLevelByLevel() {
//		Employee curr = ceo;
//		Queue<Employee> queue = new LinkedList<>();
//		queue.add(curr);
//		while (!queue.isEmpty()) {
//			Queue<Employee> temp = new LinkedList<>();
//			// Print out all employees on the current level and add all the employees
//			// directly under them to a temporary queue
//			for (Employee e : queue) {
//				temp.addAll(e.getSubs());
//				e.print();
//			}
//			System.out.println("");
//			queue = temp;
//		}
//		return;
//	}

	public void printNumLevels() {
		if (ceo == null) {
			return;
		}

		queue.add(ceo);
		int tier = ceo.level;
		while (!queue.isEmpty()) {
			Employee staff = queue.poll();
			int tierLevel = staff.level;
			List<Employee> subordinates = staff.getSubs();

			if (subordinates != null) {
				for (Employee e : subordinates) {
					e.level = tierLevel + 1;
					queue.add(e);

				}
			}
			if (tier < tierLevel) {
				tier = tierLevel;
			}

		}
		System.out.println(tier);

	}

	public void orgChart() {
		Employee K = new Employee("K", "Sales Intern", null);

		List<Employee> Jstaff = new ArrayList<>(Arrays.asList(K));
		Employee J = new Employee("J", "Sales Representative", Jstaff);

		List<Employee> Istaff = new ArrayList<>(Arrays.asList(J));
		Employee I = new Employee("I", "Director", Istaff);

		Employee H = new Employee("H", "Engineer", null);
		Employee G = new Employee("G", "Engineer", null);
		Employee F = new Employee("F", "Engineer", null);

		Employee E = new Employee("E", "Manager", null);
		// List<Employee> Dstaff = List.of(H, G, F);
		List<Employee> Dstaff = new ArrayList<>(Arrays.asList(H, G, F));
		Employee D = new Employee("D", "Manager", Dstaff);

		List<Employee> Cstaff = new ArrayList<>(Arrays.asList(E, D));
		Employee C = new Employee("C", "CTO", Cstaff);

		List<Employee> Bstaff = new ArrayList<>(Arrays.asList(I));
		Employee B = new Employee("B", "CFO", Bstaff);

		List<Employee> staff = new ArrayList<>(Arrays.asList(B, C));
		ceo = new Employee("A", "CEO", staff);

	}

}
