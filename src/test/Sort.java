package test;

public class Sort {
	
	public static void mergeSort(int left, int right, int []nums, int[] temp) {
		
		if(left==right)
			return;
		int mid=left+(right-left)/2;
		
		mergeSort(left, mid, nums ,temp);
		
		mergeSort(mid+1, right, nums, temp);
		
		merge(left, mid, right, nums, temp);
	}
	
	public static void merge (int l, int mid,int r, int [] nums, int [] temp) {
		for(int i=l; i<=r; i++) {
			temp[i]=nums[i];
		}
		
		int i=l;
		int j=mid+1;
		
		for(int k=l; k<=r; k++) {
			if(i==mid+1){
				nums[k]=temp[j];
				j++;
			}
			else if(j==r+1){
				nums[k]=temp[i];
				i++;
			}
			else if(temp[i]<=temp[j]){
				nums[k]=temp[i];
				i++;
			}
			else {
				nums[k]=temp[j];
				j++;
			}
		}
	}

	
	private Sort() {
		
	}

	public static void quicksort( int [] arr, int begin, int end ) {
		
		if(begin<end) {
			int 
			l=begin,
			r=end,
			temp=arr[l];
			while(l<r) {
			while(l<r&&arr[r]>temp)
				r--;
			
			 arr[l]=arr[r];
			 
			 while(l<r&&arr[l]<=temp)
				l++;
			 
			 arr[r]=arr[l];
			}
			arr[l]=temp;
			
			quicksort(arr, begin, l-1);
			quicksort(arr, r+1, end);
		}
		
		
	}
	
	public static void heapSort(int [] nums, int heapsize){
		bulidHeap(nums);
		
		for(int i=nums.length-1; i>=0; i--) {
			
			swap(nums, 0, i);
			heapify(nums, 0, --heapsize);
		}
		
		
	}
	
	
	public static void bulidHeap(int [] nums) {
		int last=(nums.length-1-1)/2;
		for(int i=last; i>=0; --i) {
			heapify(nums, i, nums.length);
		}
	}
	
	
	
	public static void heapify(int [] nums, int i, int heapsize){
		
		int l=2*i+1;
		int r=2*i+2;
		int largest=i;
		if(l<heapsize&&nums[l]>nums[largest]) {
			largest=l;
		}
		
		if(r<heapsize&&nums[r]>nums[largest]){
			largest=r;
		}
		if(largest!=i) {
			swap(nums, i, largest);
			heapify(nums, largest, heapsize);
		}
		
	}
	
	public static void swap(int [] nums, int l, int r) {
		int temp=nums[l];
		nums[l]=nums[r];
		nums[r]=temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int a[]= {3,2,6,5,8};
		
		//quicksort(a, 0, a.length-1);
		heapSort(a, 5);
		for (int i = 0; i < a.length; i++) {
			
			System.out.print(a[i]+"\t");
			
		}
	}

}
