package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class test_2 {
	
		public static void add( Map<Character,String> map, String digits,List<String> list, int index, String string ){
	       if(index>digits.length()-1)
	           return;
	       String temp=map.get(digits.charAt(index));
	       for(int i=0;i<temp.length();i++){
	           if(index==digits.length()-1){
	              list.add(string+temp.charAt(i));
	              continue;
	           }
	           add( map, digits, list, index+1, string+temp.charAt(i) );
	       }
	       return;


	    }
	    public static List<String> letterCombinations(String digits) {
	        Map<Character,String> map = new HashMap<Character,String>();
	        map.put('2',"abc");
	        map.put('3',"def");
	        map.put('4',"ghi");
	        map.put('5',"jkl");
	        map.put('6',"mno");
	        map.put('7',"pqrs");
	        map.put('8',"tuv");
	        map.put('9',"wxyz");

	        List<String> list = new ArrayList<String>();
	        String string="";
	        add( map, digits, list, 0, string );

	        return list;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list;
		list=letterCombinations("23");
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i)+"  ");
		}
		
		
	}

}
