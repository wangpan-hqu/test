package test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.omg.DynamicAny.DynAnyFactoryPackage.InconsistentTypeCode;

public class test_1 {
	
	
	
	/*
	 * public int coinChange(int[] coins, int amount) {
	 * 
	 * Arrays.sort(coins);
	 * 
	 * recursion(coins, amount, 0, coins.length - 1);
	 * 
	 * return minCount == Integer.MAX_VALUE ? -1 : minCount; }
	 */	
    int minCount = Integer.MAX_VALUE;
    /**
     * 1、按金额从大到小，从多到少（排序，用余数一步到位）
     * 2、预判低于最优解，终止递归（可以返回最优解，不过提升有限，意义不大）
     * 3、能整除即可返回
     */
    void recursion(int[] coins, int amount, int count, int index) {
        if (index < 0 || count + amount / coins[index] >= minCount) return;
        if (amount % coins[index] == 0) {
            minCount = Math.min(minCount, count + amount / coins[index]);
            return;
        }
        for (int i = amount / coins[index]; i >= 0; i--) {
            recursion(coins, amount - i * coins[index], count + i, index - 1);
        }
    }
    
	public static void quicksort( int [][] arr, int begin, int end ) {
		
		if(begin<end) {
			int l=begin, r=end;
			int [][]temp=new int [1][2];
			temp[0][0]=arr[l][0];
			temp[0][1]=arr[l][1];
			while(l<r) {
			while(l<r&&arr[r][0]>temp[0][0])
				r--;
			
			 arr[l][0]=arr[r][0];
			 arr[l][1]=arr[r][1];
			 
			 while(l<r&&arr[l][0]<=temp[0][0]) {
			    if(arr[l][0]==temp[0][0]&&arr[l][1]>temp[0][1]) {	 
			           int f=temp[0][1];
			           temp[0][1]=arr[l][1];
			           arr[l][1]=f;
			    }
				l++;
			}
			 
			 arr[r][0]=arr[l][0];
			 arr[r][1]=arr[l][1];
			 
			}
			 arr[l][0]=temp[0][0];
			 arr[l][1]=temp[0][1];
			
			
			quicksort(arr, begin, l-1);
			quicksort(arr, r+1, end);
		}
	}
    
    public int[][] merge(int[][] arr) {
        if(arr == null || arr.length<=1)
            return arr;
        
        int [][] temp = new int [arr.length][2];
//二维数组冒泡排序
		/*
		 * for (int i = 0; i < arr.length-1; i++) { for (int j = i; j < arr.length-1;
		 * j++) { if(arr[i][0]>arr[j+1][0]) { temp[0][0]=arr[i][0];
		 * temp[0][1]=arr[i][1]; arr[i][0]=arr[j+1][0]; arr[i][1]=arr[j+1][1];
		 * arr[j+1][0]=temp[0][0]; arr[j+1][1]=temp[0][1]; } if(arr[i][0]==arr[j+1][0]){
		 * if(arr[i][1]>arr[j+1][1]){ temp[0][1]=arr[i][1]; arr[i][1]=arr[j+1][1];
		 * arr[j+1][1]=temp[0][1]; } } } }
		 */
		quicksort(arr, 0, arr.length-1);
		int i=0,k=0;
        int n = arr.length;
        while(i<n){
            int left = arr[i][0];
            int right = arr[i][1];
            while(i<n-1 && right>=arr[i+1][0]){
                right = Math.max(right,arr[i+1][1]);
                i++;
            }
            temp[k][0]=left;
            temp[k][1]=right;
            k++;
            i++;
        }
        int [] []result = new int [k--][2];
        for (int j = 0; j < result.length; j++) {
			result[j][0]=temp[j][0];
			result[j][1]=temp[j][1];
		}
        
        return result;
    }
    
    
	/*
	 * public int coinChange(int[] coins, int amount) {
	 * 
	 * Arrays.sort(coins);
	 * 
	 * int [][]dp= new int[coins.length][amount+1];
	 * 
	 * for (int i = 0; i <coins.length; i++) { dp[i][0]=0;
	 * 
	 * }
	 * 
	 * for (int i = 0; i < amount+1; i++) {
	 * 
	 * if(coins[0]!=0&&i%coins[0]!=0) dp[0][i]=-1; else
	 * if(coins[0]!=0&&i%coins[0]==0) dp[0][i]=i/coins[0]; else dp[0][i]=-1; }
	 * 
	 * 
	 * for (int i = 1; i < coins.length; i++) { for (int j = 1; j < amount+1; j++) {
	 * if(j>=coins[i]) { if(j%coins[i]==0) dp[i][j]=j/coins[i]; else{
	 * if(dp[i][j-coins[i]]==-1&&dp[i-1][j]==-1) dp[i][j]=dp[i-1][j]; else
	 * if(dp[i][j-coins[i]]==-1&&dp[i-1][j]>0) dp[i][j]=dp[i-1][j]; else
	 * if(dp[i][j-coins[i]]>0&&dp[i-1][j]==-1) dp[i][j]=dp[i][j-coins[i]]+1; else
	 * if(dp[i][j-coins[i]]>0&&dp[i-1][j]>0) dp[i][j]=Math.min(dp[i][j-coins[i]]+1,
	 * dp[i-1][j]); else dp[i][j]=dp[i-1][j]; } } else dp[i][j]=dp[i-1][j];
	 * 
	 * } }
	 * 
	 * 
	 * return dp[coins.length-1][amount]; }
	 * 
	 */
	  public int coinChange(int[] coins, int amount) {
	  
	  Arrays.sort(coins);
	  
	  int [][]dp= new int[coins.length][amount+1];
	  
	  for (int i = 0; i <dp.length; i++) { 
		  Arrays.fill(dp[i], amount+1);
		  dp[i][0]=0;
	  
	  }
	  
	
	  
	  
	  for (int i = 1; i < coins.length; i++) { 
		  for (int j = 1; j < amount+1; j++) {
			  	if(j>=coins[i])  
			  		dp[i][j]=Math.min(dp[i][j-coins[i]]+1,dp[i-1][j]); 
			  	else 
			  		dp[i][j]=dp[i-1][j];
	  
		  } 
	  }
	  
	  
    	  return dp[coins.length-1][amount]==amount+1?-1:dp[coins.length-1][amount];
      }
    	
  	 
	  
	  
	  
	  
	  
	  public static int myAtoi(String str) {
	        if(str==""||str=="+"||str=="-")
	            return 0;

	        String result="";
	        long l;
	        int i=0;
	        while(i<str.length()&&str.charAt(i)==' ')
	                      i++;
	              

	        if(i<str.length()){
	        if(('0'<=str.charAt(i)&&str.charAt(i)<='9')||str.charAt(i)=='+'||str.charAt(i)=='-') {       
	              result=result+str.charAt(i);
	              i++;
	              while(i<str.length()&&('0'<=str.charAt(i)&&str.charAt(i)<='9')){
	              result=result+str.charAt(i);
	              i++;
	              }
	              
	        }
	        else
	              return 0;
	        }

	        if(result!=""){
	            l=Long.parseLong(result);

	            if(l<-Math.pow(2,31))
	                return (int)-Math.pow(2,31) ;
	            else if(l>Math.pow(2,31)-1)
	                return (int)Math.pow(2,31)-1;
	            else
	                 return (int)l;

	        }

	        return 0;

	    }
	  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		  int[] coins = new int[3]; 
		  coins[0] = 2; 
		  coins[1] = 6; 
		  coins[2] = 8; 
	//	  coins[3]=186; 
		  
	//	  for (int i = 0; i < coins.length; i++)
	//	  { System.out.println(coins[i]); }
		  
		  int amount=12;
		 
		
//		System.out.println(new test_1().coinChange(coins, amount));
		
//		int [][] arr = {{8,10},{2,6},{1,3},{15,18},{1,2}};
		
		
		/*
		 * Arrays.sort(arr,new Comparator<int[]>() {
		 * 
		 * @Override public int compare(int[] o1, int[] o2) { // TODO Auto-generated
		 * method stub return o1[0]-o2[0]; } });
		 */
/*		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[j].length; j++) {
				System.out.print(arr[i][j]+"\t");	
			}
			System.out.println();
			}
			*/
		

/*
 * List<int[]> list = new ArrayList<int[]>(); list.add(new int[] {1,3});
 * list.add(new int[] {2,6}); list.add(new int[] {8,10}); int
 * [][]a=list.toArray(new int[list.size()][2]); for (int i = 0; i < a.length;
 * i++) { for (int j = 0; j < a[j].length; j++) {
 * System.out.print(a[i][j]+"\t"); } System.out.println(); }
 */
		
		
//二维数组快排测试
/*
 * quicksort(arr, 0, arr.length-1);
 * 
 * for (int i = 0; i < arr.length;i++) {
 * 
 * for (int j = 0; j < arr[j].length; j++)
 * 
 * System.out.print(arr[i][j]+"\t");
 * 
 * System.out.println(); }
 */		 

//区间合并测试		
/*
 * int [][]a=new test_1().merge(arr);
 * 
 * for (int i = 0; i < a.length;i++) {
 * 
 * for (int j = 0; j < a[j].length; j++) {
 * 
 * System.out.print(a[i][j]+"\t"); }
 * 
 * System.out.println(); }
 * 
 */		
/*
 * List<Integer> list=new ArrayList<Integer>(); list.add(1); list.get(0);
 * 
 * String string="112222"; string=string+'3';
 * 
 * Long.parseLong(string); int a=(int)Math.pow(2, 3); int [] index =new int[2];
 * System.out.print(a);
 */
//		  String string="+";
		  
//		  System.out.print(myAtoi(string));
		  
/*
 * StringBuffer stringBuffer=new StringBuffer("");
 * 
 * String string= String.valueOf(stringBuffer); System.out.print(stringBuffer);
 */		  
		  System.out.println(Math.log(8)/Math.log(2));
		  int []result=new int[2];
		  
//		  List<Integer> list =new ArrayList<Integer>();
		  
//		  result[0]=list.indexOf(5);
		  List<String> list = new LinkedList<String>();
//		  list.set(index, element)
		  
		  Map<Character,String> map = new HashMap<Character,String>();

//	  String string="asa";
//	  string+'a';
//		  string.charAt(index)
		  
		  
		  
	}
}
