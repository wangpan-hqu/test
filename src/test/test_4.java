package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class test_4 {

	
	private static Set<List<Integer>> list;
    private  List<Integer> temp;
    public void combination(int[] candidates, int target, int index, int sum){
             if(index==candidates.length){
            	 return;       
             }
             
             temp.add(candidates[index]);
             sum=sum+candidates[index]; 
             if(sum<target){
               combination(candidates, target, index+1, sum); 
             }

             if(sum==target) {
               list.add(new ArrayList<Integer>(temp));
             }
             temp.remove(temp.size()-1);
             sum=sum-candidates[index];
             combination(candidates, target, index+1, sum);  

            
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
             Arrays.sort(candidates);
             int sum=0;
             list = new HashSet<List<Integer>> ();
             temp = new ArrayList<Integer>();
             combination(candidates, target, 0, sum);
            
            
             return new ArrayList<>(list) ;
             

    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] candidates = {10,1,2,7,6,1,5};
    	int target = 8;
    	
    	List<List<Integer>> list=new test_4().combinationSum2(candidates, target);  
	
    	for (int i = 0; i < list.size(); i++) {
    		for (int j = 0; j < list.get(i).size(); j++) {
				System.out.print(list.get(i).get(j)+"  ");
			}
    		System.out.println();
			
		}
    	
    	Set<Integer> set= new HashSet<Integer>();
    	
    	List<Integer> l = new ArrayList<Integer>(set);
    	
//    	new HashMap<Integer,Integer>().get(key);
    	
	}

}
