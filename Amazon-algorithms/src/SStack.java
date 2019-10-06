import java.util.Stack;

public class SStack<T> extends Stack<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9104624162283188893L;

	private Stack<T> minStacker = new Stack<>();

	@Override
	public T push(T item) {
		pushToMinStacker(item);
		return super.push(item);

	}

	@Override
	public synchronized T pop() {
		T mainV = super.pop();
		T minV = minStacker.pop();
		if (mainV instanceof Integer && minV instanceof Integer) {
			if ((Integer) minV != (Integer) mainV) {
				minStacker.push(minV);
			}
		}
		return mainV;
	}

	public T getMin() {
		return minStacker.peek();
	}

	@Override
	public synchronized boolean isEmpty() {
		return super.isEmpty() && minStacker.isEmpty();
	}

	private void pushToMinStacker(T item) {
		if (!minStacker.isEmpty()) {
			T minVal = minStacker.peek();

			if (minVal instanceof Integer && item instanceof Integer) {
				Integer i = (Integer) minVal;
				Integer j = (Integer) item;
				if (j < i)
					minStacker.push(item);
			}
		} else
			minStacker.push(item);

	}

	public static void main(String[] args) {
		SStack<Integer> sStack = new SStack<>();
		
		sStack.push(2);
		sStack.push(112);
		sStack.push(1);
		System.out.println(sStack.getMin());
		System.out.println(sStack.pop());
		System.out.println(sStack.pop());
		System.out.println(sStack.pop());
		System.out.println(sStack.isEmpty());
	}
}
