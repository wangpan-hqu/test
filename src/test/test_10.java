package test;

import java.util.ArrayList;
import java.util.List;

public class test_10 {
	
	public static int maximalRectangle(char[][] matrix) {
	    if(matrix.length*matrix[0].length==0)
	        return 0;
	    int [] row= new int[matrix.length*matrix[0].length];
	    int [] column= new int[matrix.length*matrix[0].length];
	     
	     if(matrix[0][0]==1){
	         row[0]=1;
	         column[0]=1;
	     }
	     

	     for(int i=1;i<matrix.length;i++){
	         if(matrix[i][0]==1){
	            column[i]=1+column[i-1];
	         }
	     }

	     for(int i=1;i<matrix[0].length;i++){
	         if(matrix[0][i]==1){
	            row[i]=1+row[i-1];
	         }
	     }

	     for(int i=1;i<matrix.length;i++){
	         for(int j=1;j<matrix[0].length;j++){
	             if(matrix[i][j]==1){
	                row[i]=1+row[j-1];
	                column[j]=1+column[i-1];
	             }
	         }
	     }

	     int res=0;
	     for(int i=0;i<row.length;i++){
	         if(row[i]>0&&column[i]>0)
	            res=Math.max(res, row[i]*column[i]);
	         else if(row[i]==0||column[i]==0)
	            res=Math.max(res, row[i]==0?column[i]:row[i]);
	     }

	     return res;
	       


	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  StringBuffer stringBuffer=new StringBuffer("123");
		  stringBuffer.append('a');
		  stringBuffer.reverse();
		  System.out.print(Integer.MAX_VALUE);
		 

	}
}
