package test;

import java.util.ArrayList;
import java.util.List;

public interface InferfaceMain {
	
	public   float get(int x);
	boolean setFlag(Boolean [] test);
	
		
	public void main(String [] args);
	
	public static void main() {
		
	

			 List  Listlist1 = new ArrayList();
			   Listlist1.add(0);
			      List Listlist2 = Listlist1;
			        System.out.println(Listlist1.get(0) instanceof Integer);
			        System.out.println(Listlist2.get(0) instanceof Integer);
		
	}
	

}
