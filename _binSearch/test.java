class test{
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,7,7,7,9,10};

		//System.out.println(binarySearch(arr, 1));

		System.out.println(bSearch(arr,3));
	}

	public static int bSearch(int[] a, int value){
		return bSearch(a, value, 0, a.length-1);
	}

	public static int bSearch(int[] a, int value, int low, int high){
		if(low>high)
			return -1;

		int mid = (low+high)/2;

		if(a[mid] == value)
			return mid;

		else if(a[mid] < value)
			return bSearch(a, value, mid+1, high);

		else
			return bSearch(a, value, low, mid-1);
	} 

	public static int binarySearch(int[] a, int value){
		int low = 0;
		int high = a.length-1;

		while (low<=high){
			int mid = low + (high - low)/2;
			int midValue = a[mid];

			if (value < midValue){
				high = mid - 1;
			}

			else if (value > midValue){
				low = mid + 1;
			}

			else
				return mid;
		}

		return -1;
	}
}