package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class test_14 {
    
	
	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
	       List<List<Integer>>  listall =new  ArrayList<List<Integer>>();
	       Stack<List<TreeNode>> stack = new Stack<List<TreeNode>>();
	       if(root==null)
	            return listall;
	       List<TreeNode> r=new ArrayList<TreeNode>();
	       r.add(root);
	       stack.push(r);

	       while(!stack.isEmpty()){
	          List<TreeNode> list =stack.pop();
	          List<TreeNode> temp =new ArrayList<TreeNode>();
	          List<Integer> res= new ArrayList<Integer>();
	          for(int i=0; i<list.size();i++){
	                res.add(list.get(i).val);

	                if(list.get(i).left!=null)
	                   temp.add(list.get(i).left);

	                if(list.get(i).right!=null)
	                   temp.add(list.get(i).right);
	          }
	          listall.add(res);
	          if(temp.size()>0)
	            stack.push(temp);  
	       }

	       List<List<Integer>>  ans =new  ArrayList<List<Integer>>();
	       for(int i=listall.size()-1;i>=0;i--){
	           ans.add(listall.get(i));
	       }

	       return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		TreeNode root =new TreeNode(3);
//		levelOrderBottom(root);
		
//		List<List<Integer>>  ans =new  ArrayList<List<Integer>>();
		
		String string= "A man, a plan, a canal: Panama";
		String [] str =string.split("[^a-zA-Z0-9]+");
		for(int i=0; i<str.length;i++) {
			System.out.println(str[i]);
		}
		StringBuffer stringBuffer=new StringBuffer("123");
	    stringBuffer.reverse();
	    
	    System.out.println(stringBuffer);

	}

}
