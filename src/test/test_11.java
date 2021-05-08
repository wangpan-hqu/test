package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class test_11 {
	
	public static void dfs(ListNode list,Stack<ListNode> stack){
        if(!stack.isEmpty()){
            list.next=stack.pop();
            list=list.next;
            dfs(list,stack);
        }

	}
	public static ListNode reverseList(ListNode head) {
		Stack<ListNode> stack =new Stack<ListNode>();

		while(head!=null){
			stack.push(new ListNode(head.val));
			head=head.next;
		}
		
		ListNode res = new ListNode(0);
		res.next=null;
 
		dfs(res,stack);

		return res.next;

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * ListNode listNode = new ListNode(1); listNode.next=new ListNode(2);
		 * listNode.next.next=new ListNode(3); listNode.next.next.next=new ListNode(4);
		 * listNode.next.next.next.next=new ListNode(5); reverseList(listNode);
		 */
		/*
		 * String string="25525511135"; String []
		 * res=string.split("[0-2]?[0-9]?[0-9]?"); for(int i=0;i<res.length;i++) {
		 * System.out.println(res[i]); }
		 */
		
		 String path="/a/../../b/../c//.//";
		 String [] str= path.split("/+");

	}
	

	
}

