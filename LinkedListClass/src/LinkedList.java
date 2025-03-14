import java.util.ArrayList;
import java.util.Collections;

public class LinkedList<T> {
	Node head;

	public void insert(T data) {
		Node node = new Node(data);
		if (head == null) {
			head = node;
			return;
		}
		Node current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = node;
	}

	public void deleteIteratively(T data) {
		if (head == null)
			return;

		if (head.data.equals(data)) {
			head = head.next;
			return;
		}

		Node current = head;
		while (current.next != null && !current.next.data.equals(data)) {
			current = current.next;
		}

		if (current.next != null) {
			current.next = current.next.next;
		}
	}

	public void deleteRecursively(T data) {
		head = deleteRecursivelyHelper(head, data);
	}

	private Node deleteRecursivelyHelper(Node current, T data) {
		if (current == null) {
			return null;
		}

		if (current.data.equals(data)) {
			return current.next;
		}

		current.next = deleteRecursivelyHelper(current.next, data);
		return current;
	}

	public void traverseForward() {
		Node current = head;
		int i = 1;
		while (current != null) {
			System.out.println(i + ". " + current.data);
			current = current.next;
			i++;
		}
	}

	public void traverseBackwards() {
		ArrayList<T> list = new ArrayList<>();
		Node current = head;
		while (current != null) {
			list.add((T) current.data);
			current = current.next;
		}
		Collections.reverse(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println((i + 1) + ". " + list.get(i));
		}
	}

	public void search(T data) {
		if (head == null) {
			return;
		}

		Node current = head;
		while (current != null) {
			if (current.data.equals(data)) {
				System.out.println("Entity Found: " + current.data);
				return;
			}

			current = current.next;
		}
		System.out.println("Entity not found");
	}

	public void deleteAll() {
		Node current = head;
		while (current != null) {
			if (current.next != null)
				current.next = current.next.next;
		}
	}

	public int size() {
		if (head == null || head.next == null)
			return 0;

		int i = 0;
		Node current = head;
		while (current != null) {
			i++;
			current = current.next;
		}

		return i;
	}

}
