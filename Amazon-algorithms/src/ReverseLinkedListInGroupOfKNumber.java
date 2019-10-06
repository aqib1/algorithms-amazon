import java.util.Objects;

class LinkedList<T> {

	private Node<T> currentNode;

	public void push(T t) {
		if (Objects.isNull(currentNode)) {
			currentNode = new Node<>(t);
			currentNode.previous = null;
		} else {
			currentNode.next = new Node<>(t);
			currentNode.next.previous = currentNode;
			currentNode = currentNode.next;
		}
	}

	public T pop(T t) {
		T poppedVal = currentNode.value;
		currentNode = currentNode.previous;
		return poppedVal;
	}

	@Override
	public String toString() {
		return "LinkedList [currentNode=" + currentNode + "]";
	}

	@SuppressWarnings("hiding")
	class Node<T> {
		private Node<T> next;
		private Node<T> previous;
		private T value;

		public Node() {

		}

		public Node(T value) {
			this.value = value;
		}

		public T getValue() {
			return value;
		}

		public void setValue(T value) {
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

		@Override
		public String toString() {
			return "Node [next=" + next + ", previous=" + previous + ", value=" + value + "]";
		}

	}
}

public class ReverseLinkedListInGroupOfKNumber {
	public static void main(String[] args) {
		LinkedList<Integer> li = new LinkedList<>();
			li.push(1);
			li.push(2);
			li.push(3);
			System.out.println(li);
	}
}
