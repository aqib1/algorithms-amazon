import java.util.Arrays;

public class KLargestAndSmallestNumber {

	public static void main(String[] args) {
		int kLargest = 2;
		Integer arr[] = new Integer[] {2,1,32,31,2,34,5,1,2,0,-1};
		Arrays.sort(arr, (x,y) -> y.compareTo(x));
		System.out.println(Arrays.toString(arr));
		System.out.println(arr[kLargest-1]);
		System.out.println(arr[arr.length - kLargest]);
		
	}
}
