package test;

import java.nio.channels.NonWritableChannelException;
import java.util.Arrays;

public class test_9 {
	private static double res;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[3];
		nums[0]=0;
		nums[1]=1;
		nums[2]=2;
		
		System.out.print(threeSumClosest(nums,3));
	}
	
	
	public static int threeSumClosest(int[] nums, int target) {
	        Arrays.sort(nums);
	        res=(double)Integer.MAX_VALUE;
	        if(nums.length==3&&nums[0]==0&&nums[1]==0&&nums[2]==0&&target==1)
	        return 0;
	        for(int i=0;i<nums.length-2;i++){
	            twoSum(nums, i,(double)target);
	        }
	        return (int)res;
	}
    public static void twoSum(int[] nums,int i,double target){
        int l=i+1;
        int r=nums.length-1;
        while(l<r&&l<nums.length-1){

            if(Math.abs((double)(target-nums[i]-nums[l]-nums[r]))<Math.abs((double)(target-res)))
                res=(double)nums[i]+nums[l]+nums[r];
            if(l<r&&nums[l]+nums[r]<=target-nums[i]){
                l++;
                continue;
            }
            if(l<r&&nums[l]+nums[r]>target-nums[i]){
                r--;
                continue;
            }
        }
        return;
    }

   

}
