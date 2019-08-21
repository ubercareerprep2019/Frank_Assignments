package part_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Evaluations {

	// public static void main(String[] args) throws FileNotFoundException {
	// Create a list and a bst phonebook
	PhoneBook list = new ListPhoneBook();
	PhoneBook bst = new BstPhoneBook();
	String dataPath = System.getProperty("user.dir") + "/src/homework2/Trees/Assets/data.csv";
	String searchPath = System.getProperty("user.dir") + "/src/homework2/Trees/Assets/search.txt";
	Scanner scan = null;

	void CSV(String dataPath, PhoneBook Dir) {
		try {
			scan = new Scanner(new File(dataPath));
			long startTime = System.currentTimeMillis();

			while (scan.hasNextLine()) {
				String[] line = scan.nextLine().split(",");
				String name = line[0];
				long number = Long.parseLong(line[1]);
				Dir.insert(name, number);

			}
			long endTime = System.currentTimeMillis();
			System.out.println("Insert took " + (endTime - startTime) + " ms.");
			System.out.println("Check for size of both books equal the constant size(1000000) - "
					+ (list.size() == 1000000 && bst.size() == 1000000));

		} catch (FileNotFoundException e) {
			long abortTime = System.currentTimeMillis();
			System.out.println("fnf exception caught.");
			e.printStackTrace();
		} finally {
			if (scan != null) {
				try {
					scan.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	void TXT(String searchPath, PhoneBook Dir) {
		int count = 0;

		try {
			long startTime = System.currentTimeMillis();
			scan = new Scanner(new File(searchPath));

			List<String> searchQueries = new ArrayList<>();

			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				Dir.find(line);
				count++;
			}
			long endTime = System.currentTimeMillis();
			scan.close();
			System.out.println("find() was called " + count + " times.");
			System.out.println("Search took " + (endTime - startTime) + " ms.");
		} catch (FileNotFoundException e) {
			long abortTime = System.currentTimeMillis();
			System.out.println("fnf exception caught.");
			e.printStackTrace();
		} finally {
			if (scan != null) {
				try {
					scan.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String args[]) {
		Evaluations eval = new Evaluations();
		String data = "src/input/" + args[0];
		String search = "src/input/" + args[1];

		// ListPhoneBook tests
		eval.CSV(data, eval.list);
		int listSize = eval.list.size();
		System.out.println("The size of the PhoneBook is " + eval.list.size());
		eval.TXT(search, eval.list);
		System.out.println();

		// BstPhoneBook tests
		eval.CSV(data, eval.bst);
		int BSTSize = eval.bst.size();
		System.out.println("The size of the PhoneBook is " + eval.bst.size());
		eval.TXT(search, eval.bst);
		System.out.println();
	}

}
