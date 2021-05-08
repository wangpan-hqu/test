package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Pattern;

public class test_7 {

	
	 public static boolean DFS(int [][] result, int index, String s ){
	       
	       if((result[0][1]>result[0][0])||(result[1][1]>result[1][0])||(result[2][1]>result[2][0]))
	            return false;
	       if(index==s.length()){
	           if((result[0][1]!=result[0][0])||(result[1][1]!=result[1][0])||(result[2][1]!=result[2][0]))
	            return false;
	       }
	        if(index<s.length()){
	            if(s.charAt(index)=='(')
	                result[0][0]=result[0][0]+1;  
	            else if(s.charAt(index)==')')
	                result[0][1]= result[0][1]+1;
	            else if(s.charAt(index)=='[')
	                result[1][0]=result[1][0]+1;
	            else if(s.charAt(index)==']')
	                result[1][1]=result[1][1]+1;
	            else if(s.charAt(index)=='{')
	                result[2][0]=result[2][0]+1;
	            else 
	                result[2][1]=result[2][1]+1;
	            
	            DFS(result, index+1, s);
	        }
	       
	        
	        return true;
	    }
	    public static boolean isValid(String s) {

	        int [][] result = new int [3][2];
	        for(int i=0;i<3;i++){
	            for(int j=0;j<2;j++){
	                result[i][j]=0;
	            }
	        }

	        return DFS(result,0,s);

	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String s= "({}[])";
     //   ||Pattern.matches("\\[\\]", s)||Pattern.matches("\\{\\}", s)
		/*
		 * StringBuffer stringBuffer=new StringBuffer(s);
		 * while(Pattern.matches("\\(\\)", stringBuffer)){ String
		 * string=s.replaceAll("\\(\\)", "");
		 * 
		 * // s=s.replaceAll("\\[\\]", ""); // s=s.replaceAll("\\{\\}", ""); }
		 */
		
//		  System.out.println(s.replaceAll("(\\(\\))*(\\[\\])*(\\{\\})*", "")); 
		
		 	  System.out.print(Pattern.matches("-?\\d\\d*\\.?((e\\d+)|(e-\\d+))?","0"));
		  
		  
		 
	}
	
	static boolean b;

	   public static void DFS(String s){
	       if(s.length()==0){
	           b=true;
	           return;
	       }

	       if(!s.replaceAll("\\(\\)", "").equals(s))
	    	   DFS(s.replaceAll("\\(\\)", ""));
	       

	       if(!s.replaceAll("\\[\\]", "").equals(s)){
	           DFS(s.replaceAll("\\[\\]", ""));
	       }

	       if(!s.replaceAll("\\{\\}", "").equals(s)){
	           DFS(s.replaceAll("\\{\\}", ""));
	       }
	       return;
	   }


}
