package test;

import java.util.*;

import javax.sound.sampled.LineListener;

public class test {

	/*
	 * private static int count=0;
	 * 
	 * public static void recursion() { count++; recursion();
	 * 
	 * }
	 */
	/*
	 * public static int location(int[] coins, List<Integer> list, int temp) { int
	 * m=0; for(int i=list.size()-1; i>=0;i--) {
	 * 
	 * if(list.get(i)!=temp) { m=list.get(i); break; }
	 * 
	 * }
	 * 
	 * for (int i = 0; i < coins.length; i++) { if (coins[i] == m) return i; }
	 * 
	 * return 0; }
	 * 
	 * public static int compute(int[] coins, int amount, List<Integer> list, int
	 * count, int s) { s = s - coins[count+1]; for(int j=0;j<list.size();j++){
	 * if(list.get(j)==coins[count+1]) { list.remove(j); break; } } for (int i =
	 * count+1; i >= 0&&coins[i]>0;) { s = s + coins[i]; if (s == amount) {
	 * list.add(coins[i]); return list.size(); } if (s < amount) {
	 * list.add(coins[i]); // Collections.sort(list); // Collections.reverse(list);
	 * continue; } else if (s > amount) { s = s - coins[i]; i--; if (i
	 * ==-1&&list.size()!=0) { if ((list.get(0) == list.get(list.size() -
	 * 1))&&(list.get(0) == coins[0])) { // list.remove(0); return -1; } else {
	 * return compute(coins, amount, list, location(coins, list,coins[i+1]) - 1, s);
	 * } } continue; } } return -1; }
	 */	
	public static boolean isEnd(int []coins_count) {
		for(int i=1;i<coins_count.length;i++) {
			if(coins_count[i]!=0)
				return false;
		}
		
		
		return true;
		
	}
	
public static int coinChage(int [] coins, int ammout ) { 
	  int s=0;
	  int sum=0;
	  int [] coins_count =new int[coins.length];
	  for(int i= coins.length-1; i>=0&&coins[i]>0;) 
	  { 
		 sum=sum+coins[i];
		 
		 
		 if(sum==ammout) 
		 { 
			 coins_count[i]++;
			 for(int k=0;k<coins_count.length;k++) {
				 System.out.println(coins_count[k]);
			 }
			 return s+1; 
		  
		 }
		 
		 
		 if(sum<ammout) {
			 coins_count[i]++;
			 s++;
			 continue;
		 } 
		 else if(sum>ammout) 
		 { 
			 sum=sum-coins[i]; 
			 i--;
			 if(i==-1) {
				 if (isEnd(coins_count)) {
					 return -1;
				 } 
				else 
				{
					for(int j=1;j<coins_count.length;j++) {
						if(coins_count[j]!=0) {
							i=j;
							break;
						}	
					}
					sum=sum-coins[i];
					coins_count[i]--;
					s--;
					for(int l=0;l<i-1;l++) {
						while(coins_count[l]!=0) {
								sum=sum-coins[l];
								coins_count[l]--;
								s--;
						}
				
					}
					i--;
				}
			  }
			  continue; 
		  }
	  } 
	  
	  return -1;
	  
	  }
	 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * byte [] a="呵呵".getBytes(); System.out.print(a.length);
		 */

		/*
		 * for (int i = 0; i < args.length; i++) {
		 * System.out.println("参数"+(i+1)+":"+args[i]); }
		 * System.out.println("-Xmx"+Runtime.getRuntime().maxMemory()/1000/1000+"M");
		 */
		/*
		 * try { recursion(); } catch (Throwable e) { // TODO: handle exception
		 * System.out.println("deep of calling =" + count); e.printStackTrace(); }
		 */
		/*
		 * List<Integer> list= new LinkedList<Integer>(); list.add(1); list.add(2);
		 * System.out.println(list.size()); System.out.println(list.get(1));
		 */

//		Scanner sc =new Scanner(System.in);
/*		int[] coins = new int[4];
		coins[0] = 83;
		coins[1] = 408;
		coins[2] = 419;
		coins[3]=186;
		Arrays.sort(coins);
		
		for (int i = 0; i < coins.length; i++) {
			System.out.println(coins[i]);
		}
		
		int amount=6249; 

		System.out.println(coinChage(coins, amount));
		
		
		
		
		
		Scanner sc= new Scanner(System.in);
        while(sc.hasNext()) {
        int n=sc.nextInt();
        int m=sc.nextInt();
        int [] list1=new int[n];
//        if(n!=0)
*/      //     int [] list1=new int[n];
 //       }
	
		/*
		 * int s=coins[coins.length-1]; int count=coins.length-2;
		 * 
		 * List<Integer>list= new LinkedList<Integer>(); list.add(s);
		 */	
		  //System.out.println(coinChage(coins, amount));
		  
//		  System.out.println(compute(coins, amount, list, count, s)); 
			
		  
		  /*
			 * for (int i =0; i < list.size(); i++) { System.out.println(list.get(i)); }
			 */
		 
             
//	}
	/*
	 * public static int recusion(int[] coins, int amount ,int s,int sum) {
	 * 
	 * if(amount==0) { return s+0; }
	 * 
	 * for (int i = 0; i < coins.length; i++) { if ((sum+coins[i])==amount) { s=s+1;
	 * }
	 * 
	 * }
	 * 
	 * return -1;
	 * 
	 * }
	 * 
	 * 
	 */
		
		
		String  string ="1001";
		//sc.nextLine();
     
     List<String> list= new ArrayList<String>();
     for(int i=0; i<string.length()-3;i++) {
    	 
    	 if( (0<= string.charAt(i)-'0'&&string.charAt(i)-'0'<=9)&&
    		 (0<=string.charAt(i+1)-'0'&&string.charAt(i)-'0'<=9)&&
    		 (0<=string.charAt(i+2)-'0'&&string.charAt(i)-'0'<=9)&&
    		  (0<=string.charAt(i+3)-'0'&&string.charAt(i)-'0'<=9)){
    		   
    		   int n=Integer.parseInt(string.substring(i,i+4));
    	       if(1000<=n&&n<=3999) {
    		   list.add(string.substring(i,i+4)); 
    	       }
    	 
    	 }
     }
     
     for(int i=0;i<list.size();i++) {
    	 System.out.print(list.get(i)+" ");
     }
     
     System.out.println();
             

	}
}
