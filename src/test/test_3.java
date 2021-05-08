package test;

import java.util.ArrayList;
import java.util.List;

public class test_3 {
	
	    public static List<List<Integer>> list;
	    public  List<Integer> temp;
	 
	  
	    
	    public void combination(int[] candidates, int target, int index, int []count, int sum){
	             if(index<candidates.length){
	                 while(sum<target){
	                    temp.add(candidates[index]);
	                    sum=sum+candidates[index];
	                    count[index]++;   
	                }
	                while(count[index]!=-1){
	                    if(sum==target) {
	                      List<Integer> s=new ArrayList<Integer>();
	                      s.addAll(temp);
	                      list.add(s);
	                    }
	                    temp.remove((Integer)candidates[index]);
	                    sum=sum-candidates[index];
	                    count[index]--;
	                    combination(candidates, target, index+1,  count, sum);      
	                }
	             }

	             return;
	    }
	    public List<List<Integer>> combinationSum(int[] candidates, int target) {
	             int sum=0;
	             int []count=new int[candidates.length];
	             for(int i=0;i<count.length;i++){
	                 count[i]=-1;
	             }
	             list = new ArrayList<List<Integer>> ();
	             temp = new ArrayList<Integer>();
	             combination(candidates, target, 0,  count, sum);

	             return list;

	    }
	    public static void main(String[] args) {
		// TODO Auto-generated method stub
	    	int [] candidates = {2,3,5};
	    	int target = 8;
	    	
	    	new test_3().combinationSum(candidates, target);
	    	
	    	for (int i = 0; i < list.size(); i++) {
	    		for (int j = 0; j < list.get(i).size(); j++) {
					System.out.print(list.get(i).get(j)+"  ");
				}
	    		System.out.println();
				
			}

	    }

}
