import java.util.Arrays;
import java.util.Objects;

public class PythagoreanTriplet {

	public static boolean isPythagoreanTriplet(int[] arr) {
		if (Objects.isNull(arr) || arr.length == 0)
			throw new IllegalArgumentException("Null or empty array is not allowed");
		Arrays.sort(arr);
		int left;
		int right;
		int maxValue = arr.length - 1;
		boolean isValid = false;

		outer: for (int x = arr.length - 2; x >= 0; x--) {
			right = x;
			left = 0;
			while (left < right) {
				double sumSquare = Math.pow(arr[left], 2) + Math.pow(arr[right], 2);
				double maxValueSquare = Math.pow(arr[maxValue], 2);

				if (sumSquare == maxValueSquare) {
					isValid = true;
					break outer;
				}

				if (sumSquare > maxValueSquare)
					--right;
				if (sumSquare < maxValueSquare)
					++left;
			}
			--maxValue;
		}
		System.out.println(isValid);

		return isValid;
	}

	// a^2 + b^2 = c^2
	public static final void main(String[] args) {
		int arr[] = { 3, 1, 4, 6, 5 };
		isPythagoreanTriplet(arr);
	}
}
