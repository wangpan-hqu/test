package test;

import java.util.Stack;

public class test_12 {
	
	public static String removeKdigits(String num, int k) {
	      if(k==0)
	        return num;
	      if(k>=num.length())
	        return  "0";
	      Stack<Character> stack = new Stack<Character>();

	      for(int i=0; i<num.length(); i++){
	          
	          if(!stack.isEmpty()&&num.charAt(i)<stack.lastElement()){
	              if(k>0){
	                stack.pop();
	                k--; 
	              }   
	          }



	           if(!stack.isEmpty())
	              stack.push(num.charAt(i));
	           else if(stack.isEmpty()&&num.charAt(i)!='0')
	              stack.push(num.charAt(i));
	           else if(stack.isEmpty()&&num.charAt(i)=='0')
	               k--;

	      }

	      if(stack.isEmpty())
	         return "0";

	      if(k>0){
	          if(!stack.isEmpty())
	              stack.pop();
	          k--;
	      }

	      String res="";

	      for(int i=0;i<stack.size();i++){
	          res=res+stack.elementAt(i);
	      }
	      
	      
	      
	      return res;
	 
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		removeKdigits("1111111", 3);
	}

}
