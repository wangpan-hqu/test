package test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ThreadPoolExecutor;

import javax.xml.bind.DataBindingException;
import javax.xml.crypto.Data;

public class test_6 {
	
	public static int trap(int[] height) {
	     int result=0;
	     for(int l=1,r=2;l>0&&r<height.length;){
	         if(height[l-1]>height[l]){
	              l--;
	              continue;
	         }
	         if(r<height.length-1){
	        	 while(height[r+1]<height[r]){
	        		 r++;
	        		 continue;
	        	 }
	        	 while(height[r+1]>height[r]){
	        		 r++;
	        		 continue;
	        	 }
	         }
	         int temp=l;
	         while(temp+1<r){
	             result=result+(Math.min(height[l],height[r])-height[temp+1]);
	             temp++;
	         }
	         l=temp;
	         l++;
	         r++;
	    }

	   return  result;
	}	
	
	
	private static int path;

    public void DFS(int[][] grid, int [] result, int sum, int i ,int j){
    	if(i>grid.length-1)
             return;
        if(j>grid[0].length-1)
             return;
        
        
        if(i==grid.length-1&&j==grid[0].length-1){
            
        	result[0]=Math.min(result[0],sum+grid[i][j]);
            return ;
        } 
         
        
    	   DFS(grid, result, sum+grid[i][j],  i+1 ,j);
    	   
    	
        
            
    
        
    	   DFS(grid, result, sum+grid[i][j], i ,j+1);
    	    
        
        
            
  

        

    }
    
    public int minPathSum(int[][] grid) {

      int [] result = new int[1];
      result[0]=Integer.MAX_VALUE;
      DFS(grid, result, 0, 0 ,0);

      return result[0];
    }    
    
    
    
    
    

    public static int lengthOfLongestSubstring(String s) {
        if(s.length()==0)
            return 0;
        if(s.length()==1)
            return 1;

        int len=1,index=0,count=1;
        for(int i= 1;i<s.length();i++){
            if(s.substring(index,i).indexOf(s.substring(i,i+1))==-1){
                    count++;
                    len=Math.max(len,count);
                    continue;
            }
            else{
                
                index=index+s.substring(index ,i).indexOf(s.substring(i,i+1));
                count=i-index;
                index++;
                	
            }  
        }
        
        return len;

    }
    
    
    public static void DFS(String s, String [] stringall, StringBuffer string, int index, int count){
        if(index>s.length()-1)
            return;
        
        string.append(s.charAt(index)); 
        StringBuffer stringBuffer=new  StringBuffer(string);
        if(new String(stringBuffer).equals(new String(stringBuffer.reverse()))){
             stringall[count]=new String(string);
        }
        
        DFS(s, stringall, string, index+1, count);    
    }

    public static String longestPalindrome(String s) {

        StringBuffer stringBuffer=new StringBuffer("");
        String [] stringall =new String[s.length()];
        for(int i=0;i<s.length();i++){

           DFS(s.substring(i),stringall,stringBuffer, 0, i);
           stringBuffer.delete(0,stringBuffer.length());

        }
        
        int len=0;

        for(int i=1;i<stringall.length; i++){
            if(stringall[i].length()>stringall[len].length()){
            	len=i;
            }
        } 
       
        return stringall[len];
    }
    
    
    public static  int findLengthOfLCIS(int[] nums) {
        if(nums.length==0)
           return 0;
       if(nums.length==1)
           return 1;
        
        int [] count= new int [nums.length+1];
        for(int i=0;i<count.length;i++){
            count[i]=-1;
        }
        int index=0;
        for(int i=index;i<nums.length-1;i++){
            if(nums[i+1]>nums[i])
                  continue;
            count[i-index]=0;

        }
        
       int result=0;
       for(int i=count.length-1;i>=0;i--){
               if(count[i]==0){
                   return i;
               }
       }

       return 0;
       }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	int [] height= {0,1,0,2,1,0,1,3,2,1,2,1};
	//	System.out.println(trap(height));
    	

 //    System.out.println( longestPalindrome("iopsajhffgvrnyitusobwcxgwlwniqchfnssqttdrnqqcsrigjsxkzcmuoiyxzerakhmexuyeuhjfobrmkoqdljrlojjjysfdslyvckxhuleagmxnzvikfitmkfhevfesnwltekstsueefbrddxrmxokpaxsenwlgytdaexgfwtneurhxvjvpsliepgvspdchmhggybwupiqaqlhjjrildjuewkdxbcpsbjtsevkppvgilrlspejqvzpfeorjmrbdppovvpzxcytscycgwsbnmspihzldjdgilnrlmhaswqaqbecmaocesnpqaotamwofyyfsbmxidowusogmylhlhxftnrmhtnnljjhhcfvywsqimqxqobfsageysonuoagmmviozeouutsiecitrmkypwknorjjiaasxfhsftypspwhvqovmwkjuehujofiabznpipidhfxpoustquzyfurkcgmioxacleqdxgrxbldcuxzgbcazgfismcgmgtjuwchymkzoiqhzaqrtiykdkydgvuaqkllbsactntexcybbjaxlfhyvbxieelstduqzfkoceqzgncvexklahxjnvtyqcjtbfanzgpdmucjlqpiolklmjxnscjcyiybdkgitxnuvtmoypcdldrvalxcxalpwumfx"));
     
	/*
	 * StringBuffer string=new StringBuffer("22b6"); string.delete(0,
	 * string.length()); System.out.print(string);
	 */
    	
    	
	/*
	 * int [] nums= {1,3,5,4,7};
	 * 
	 * System.out.println(2*Math.pow((double)10, (double)9)>Integer.MAX_VALUE);
	 */

    	

      /*
    	int a=8,b;
    	b=a|3;
    	b>>=1;
    	System.out.println(b);    */
    	

    	
		/*
		 * StringBuffer a = new StringBuffer ("A"); StringBuffer b = new StringBuffer
		 * ("B"); String s = "abc";
		 * 
		 * // operate (a,b); // System.out.println(a + "," +b);
		 * 
		 * List<Integer> list =new ArrayList<Integer>(); Collections.sort(list);
		 */
    	
    	
    	
		/*
		 * char chr=127; chr+=1; System.out.println("???");
		 * System.out.println((int)chr);
		 * 
		 * int []i[]=new int [6][6];
		 */
    	
    	
		/*
		 * int a=5,b=6,c=7,d=8,m=2,n=2; if((m++>b)&&(n++>d)) { ; }
		 * 
		 * System.out.println(m); System.out.println(n);
		 * 
		 * 
		 * int i=1;
		 * 
		 * 
		 * while(i++<5) {
		 * 
		 * }
		 * 
		 * System.out.println(i);
		 */
    	
		/*
		 * StringBuffer a = new StringBuffer ("A"); StringBuffer b = new StringBuffer
		 * ("B"); operate (a,b); System.out.println(a + "," +b);
		 */
    	
		/*
		 * int x = 10; System.out.println(--x+" "+--x);
		 * 
		 * x = 10; System.out.println(--x+" "+x--);
		 * 
		 * x = 10; System.out.println(x--+" "+--x);
		 * 
		 * x = 10; System.out.println(x--+" "+x--);
		 */

    	 
		/*
		 * Scanner scanner = new Scanner(System.in); int n; n=scanner.nextInt();
		 * scanner.close(); int a, b, c; int [] result=new int[1]; result[0]=0;
		 * DFS(1,2,0,n,result); a=result[0]; result[0]=0; DFS(1,3,0,n,result);
		 * b=result[0]; result[0]=0; DFS(2,3,0,n,result); c=result[0];
		 * System.out.print(a+" "); System.out.print(b+" "); System.out.print(c);
		 */
         
         
		/*
		 * Calendar calendar = Calendar.getInstance(); SimpleDateFormat sdf = new
		 * SimpleDateFormat("yyyy MM dd"); String date = "2014 5 6"; //
		 * calendar.setTime(sdf.parse(date));
		 * System.out.println(calendar.get(Calendar.DAY_OF_WEEK)-1);
		 */
    	
 //   	System.out.println(LocalDate.parse("1970-01-02").getDayOfWeek());
    	Scanner scanner = new Scanner(System.in);
        int n;
        n=scanner.nextInt();
        int [][] date=new int [n][6];
        for(int i=0;i<n;i++){
            for(int j=0;j<6;j++){
                date[i][j]=scanner.nextInt();
            }
        }
        scanner.close();
       for(int i=0;i<n;i++){
          String string1=String.valueOf(date[i][0]);
          if(date[i][1]<10)
              string1=string1+"-0"+date[i][1];
          else
              string1=string1+"-"+date[i][1];
          if(date[i][2]<10)
              string1=string1+"-0"+date[i][2];
          else
              string1=string1+"-"+date[i][2];
          String string2=String.valueOf(date[i][3]);
          if(date[i][4]<10)
              string2=string2+"-0"+date[i][4];
          else
              string2=string2+"-"+date[i][4];
          if(date[i][5]<10)
              string2=string2+"-0"+date[i][5];
          else
              string2=string2+"-"+date[i][5];
          if(LocalDate.parse(string1).getDayOfWeek()==LocalDate.parse(string2).getDayOfWeek()) 
        	  
               System.out.println("True");
               
          else
               System.out.println("False");
          
          System.out.println(LocalDate.parse(string1).getDayOfWeek());
          System.out.println(LocalDate.parse(string2).getDayOfWeek());
       }
         

    
    }
        
    	
    public static void DFS(int i, int m, int count, int n, int [] result){
        if(count==n){
            result[0]=result[0]+1;
            return;
        }   
        if(count>n)
            return;
        for(int j=i;j<=m;j++){
            DFS(i,m,count+j,n,result);
        }
        return ;
    }

	public static void operate (StringBuffer x, StringBuffer y) {
		x.append(y);
		y = x;
	}
	/*
	 * public static void operate (StringBuffer x, StringBuffer y) {
	 * 
	 * System.out.println(Math.addExact(2, 3));
	 * 
	 * }
	 */
}
