package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class test_5 {

	private List<List<Integer>> listall;
    public boolean chongfu(List<Integer> list){
        
        for(int i=0; i<list.size()-1;i++){
            for(int j=i+1;j<list.size();j++){
                if(list.get(i)==list.get(j))
                   return true;
            }
        }


        return false;
    }
    public void DFS(int[] nums, List<Integer> list, int index){
      
        if(index==nums.length){
            listall.add(new ArrayList<Integer>(list));
            return;
         }
         for(int i=0;i<nums.length;i++){
            list.add(nums[i]);
            if(list.size()==1)
                DFS(nums, list, index+1);     
            else{
                if(!chongfu(list))
                    DFS(nums, list, index+1);
            }
            list.remove(list.size()-1);
         }

    }

    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list=new ArrayList<Integer>();
        listall = new ArrayList<List<Integer>>();
        DFS(nums, list, 0);
        return listall;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		new test_5().permute(a);
		int [][]matrix= {
		                {1,2,3},
		                {4,5,6},
		                {7,8,9}};
		
		   int [][] temp=matrix.clone();
	       for(int i=0;i<matrix.length;i++){
	           int k=matrix.length-1;
	           for(int j=0; k>=0&&j<matrix.length;){
	               matrix[i][j]=temp[k][i];
	               j++;
	               k--;
	           }
	       }

	    }
	
	
	
		
	}


