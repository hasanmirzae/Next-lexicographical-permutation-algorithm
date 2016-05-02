import java.util.Arrays;

/**
 * Next lexicographical permutation algorithm
 *Source: https://www.nayuki.io/page/next-lexicographical-permutation-algorithm
 */
public class Main {

	public static void main(String[] args) {
		int[] array = {0, 1, 1, 1, 4};
		int count = 1;
		do {  // Must start at lowest permutation
		    System.out.println(Arrays.toString(array));
		    count++;
		} while (nextPermutation(array));
		System.out.println("Count: "+count);
	}

	private static boolean nextPermutation(int[] arr){
		// Find longest non-increasing suffix
		int i = arr.length-1;
		while (i>0 && arr[i-1] >= arr[i])
			i--;
		// Now i is the head index of the suffix
		
		// Are we at the last permutation already?
		if (i<=0)
			return false;
		int j = arr.length-1;
		
		// Let array[i - 1] be the pivot
	    // Find rightmost element that exceeds the pivot
		while (arr[j]<=arr[i-1])
			j--;
		// Now the value array[j] will become the new pivot
		assert j>=i;
		
		// swap the pivot with j
		int tmp = arr[i-1];
		arr[i-1] = arr[j];
		arr[j] = tmp;
		
		//reverse the suffix
		j = arr.length-1;
		while (i<j){
			tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
			i++;
			j--;
		}
		return true;
	}
	

}
