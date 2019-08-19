package part_2;

import java.util.ArrayList;

public class ListPhoneBook implements PhoneBook {

	/**
	 * Phone directory data is stored in arrays, holding names and phone numbers a
	 * third variable count keeps track of the entries in the directory
	 **/
	private String name;
	private long number;
	private ArrayList<ListPhoneBook> Dir;
	private int size;

	public ListPhoneBook(String name, long number) {
		this.name = name;
		this.number = number;

	}

	ListPhoneBook() {
		Dir = new ArrayList<>();
		size = 0;

	}

	public String getName() {
		return name;
	}

	public long getNumber() {
		return number;
	}

	/**
	 * @return The number of entries in this phone book.
	 */

	@Override
	public int size() {
		return size;
	}

	/**
	 * Inserts an entry in this phone book.
	 *
	 * @param name        The name for the entry.
	 * @param phoneNumber The phone number for the entry.
	 */

	@Override
	public void insert(String name, long phoneNumber) {
		ListPhoneBook contact = new ListPhoneBook(name, number);
		Dir.add(contact);
		size++;

	}

	/**
	 * Returns the phone number associated with a name in the phone book.
	 *
	 * @param name The name to search for.
	 * @return The phone number for the entry, or -1 if the name is not present in
	 *         the phone book. Assumption that there are no duplicate names in the
	 *         directory
	 */

	@Override
	public long find(String name) {
		for (ListPhoneBook num : Dir) {
			if (num.getName().equals(name)) {
				return num.getNumber();
			}
		}
		return -1;
	}

}