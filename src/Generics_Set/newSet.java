package Generics_Set;

import java.util.ArrayList;

public class newSet<T extends Identifiable> {
	private ArrayList<T> list;

	public newSet() {
		this.list = new ArrayList<>();
	}

	public boolean add(T element) {
		boolean flag = true;
		for (T t : list) {
			if (t.getId().equals(element.getId())) {
				flag = false;
				break;
			}
		}

		if (flag) {
			list.add(element);
			System.out.println("\nElement Successfully Inserted!!");
		}else {
			System.out.println("\nCan't Insert Duplicate Element.\nPlease Enter Unique Element.");
		}

		return flag;
	}

	public T delete(String id) {
		for (T t : list) {
			if (t.getId().equals(id)) {
				list.remove(t);
				System.out.println("\nElement Successfully Removed!!");
				return t;
			}
		}
		System.out.println("\nRemoval Unsuccessful!!");
		return null;
	}

	
	public boolean peek(String id) {
		for (T t : list) {
			//System.out.println(t.getId() + " : "+id);
			if (t.getId().equals(id))
				return true;
		}
		return false;
	}

	public int size() {
		return list.size();
	}

	public boolean equals(newSet<T> set) {
		if (set == null)
			return false;
		if (size() != set.size())
			return false;
		for (T t : list)
			if (!set.peek(t.getId()))
				return false;
		return true;
	}

	@Override
	public String toString() {
		return list.toString();
	}

	public void displayElements() {
		if (list.size() == 0)
			System.out.println("List Is Empty!!!");
		else
			System.out.println("Following Are The Set Elements : \n\n" + list);
	}
}
