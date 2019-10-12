import java.util.Objects;

class LinkedList<T> {

	private Node<T> end;
	private Node<T> start;

	public void push(T t) {
		if (Objects.isNull(start)) {
			addFirst(t);
		} else {
			doubleLinkedNode(t);

		}
	}

	private void doubleLinkedNode(T t) {
		end.next = new Node<>(t);
		end.next.previous = end;
		end = end.next;
	}

	private void addStart(T t) {
		start.previous = new Node<>(t);
		start.previous.next = start;
		start = start.previous;
	}

	public LinkedList<T> reverseKNumber(int k) {
		LinkedList<T> reverseList = new LinkedList<>();
		Node<T> temp = this.end;
		while (!Objects.isNull(temp)) {
			if (k != 0) {
				reverseList.push(temp.value);
				--k;
			} else {
				reverseList.addStart(temp.value);
			}
			temp = temp.previous;
		}
		return reverseList;
	}

	private void addFirst(T t) {
		start = new Node<>(t);
		end = start;
	}

	public T pop() {
		Node<T> popNode = end;
		end = end.previous;
		end.next = null;
		return popNode.value;
	}

	public T poll() {
		Node<T> pollNode = start;
		start = start.next;
		start.previous = null;
		return pollNode.value;
	}

	@Override
	public String toString() {
		Node<T> temp = end;
		String data = "";
		if (!Objects.isNull(temp))
			data = "[";
		while (!Objects.isNull(temp)) {
			data += temp.value + ", ";
			temp = temp.previous;
		}
		if (!data.isEmpty())
			data = data.substring(0, data.length() - 2) + "]";
		return data;
	}

	public String fifoString() {
		Node<T> temp = start;
		String data = "";
		if (!Objects.isNull(temp))
			data = "[";
		while (!Objects.isNull(temp)) {
			data += temp.value + ", ";
			temp = temp.next;
		}
		if (!data.isEmpty())
			data = data.substring(0, data.length() - 2) + "]";
		return data;
	}

	@SuppressWarnings("hiding")
	class Node<T> {
		private Node<T> next;
		private Node<T> previous;
		private Integer index;
		private T value;

		public Node() {

		}

		public Node(T value) {
			this.value = value;
		}

		public Node<T> getNext() {
			return next;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}

		public Node<T> getPrevious() {
			return previous;
		}

		public void setPrevious(Node<T> previous) {
			this.previous = previous;
		}

		public T getValue() {
			return value;
		}

		public void setValue(T value) {
			this.value = value;
		}

		public Integer getIndex() {
			return index;
		}

		public void setIndex(Integer index) {
			this.index = index;
		}
	}
}

public class ReverseLinkedListInGroupOfKNumber {
	public static void main(String[] args) {
		LinkedList<Integer> li = new LinkedList<>();
		li.push(1);
		li.push(2);
		li.push(3);
		li.push(4);
		li.push(5);
		System.out.println(li.reverseKNumber(3));
	}
}
