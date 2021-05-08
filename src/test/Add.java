package test;

import java.io.PipedInputStream;
import java.util.HashMap;
import java.util.Map;

public class Add {
   public void add(Map<Integer, int []> map,int sum,int []s,int index,int n) {
	   if(index<1)
		   return;
	   for (int i = 0; i < n; i++) {
		   
		   if(index==1&&(sum+map.get(index)[i])==0) {
		       s[0]=s[0]+1;
		   }
	       add(map, sum+map.get(index)[i], s, index-1, n);
	   }
	  return ; 
	   
	   
	
   }
	
	
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, int []> map=new HashMap<Integer, int []>();
        map.put(1, A);
        map.put(2, B);
        map.put(3, C);
        map.put(4, D);
        int [] s= {0};
 //     System.out.println(map.get(3)[1]);
        int sum=0;
        add(map, sum, s, 4, A.length);
		
		return s[0];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int [] A= {1,2}; 
		int [] B= {-2,-1};
		int [] C= {-1,2}; 
		int [] D= {0,2};
		System.out.println(new Add().fourSumCount(A, B, C, D));
		 		
		Map<Integer, Integer> map=new HashMap<Integer, Integer>();
		map.put(1, 3);
		map.put(1, 6);
		map.put(1, 9);

		System.out.print(map.get(1));
		
	}

}
