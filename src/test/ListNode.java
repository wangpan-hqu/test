package test;

public class ListNode {
	int val;
    ListNode next;
    ListNode(int x) { val = x; }
    
    public ListNode createListNode (int [] value, int i) {
    	
    	if (i<value.length) {
    		ListNode listNode= new ListNode(value[i]);
    		listNode.next=createListNode(value, i+1);
    		return listNode;
			
		}
    	
    	return null;
    }

}
