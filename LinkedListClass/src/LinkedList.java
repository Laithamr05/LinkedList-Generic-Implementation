
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

	public void delete(T data) {
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

	public void display() {
		Node current = head;
		int i = 1;
		while (current != null) {
			System.out.println(i + " " + current.data);
			current = current.next;
			i++;
		}
	}

}
