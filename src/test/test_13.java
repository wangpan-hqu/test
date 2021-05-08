package test;

public class test_13 {
	
	
	public static TreeNode binarySearch( int l, int r,int [] nums){
		
        if(l<=r){
        	TreeNode treeNode=new TreeNode(nums[(l+r)/2]);

        	treeNode.left =binarySearch(l,(l+r)/2-1,nums);

        	treeNode.right =binarySearch((l+r)/2+1,r,nums);
        	
        	return treeNode;

        }
        
        
        return null;
        
        
        
    }
    public static TreeNode sortedArrayToBST(int[] nums) {
      

      return binarySearch(0, nums.length-1, nums);

    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int [] nums=new int [] {-10,-3,0,5,9};
      
      sortedArrayToBST(nums);
	}

}
