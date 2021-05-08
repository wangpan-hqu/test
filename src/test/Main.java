package test;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.plaf.InputMapUIResource;


public class Main{

  
	
    public static void main(String[] args){
	     
    	Scanner scanner= new Scanner(System.in);
	    

		/*
		 * while(scanner.hasNext()){
		 * 
		 * 
		 * String string= scanner.next();
		 * 
		 * if(string.length()=="horse".length()) { System.out.println("horse");
		 * continue; } int count=0; String s1="cat"; for(int i=0; i<s1.length();i++) {
		 * if(string.charAt(i)!=s1.charAt(i)) count++; }
		 * 
		 * if(count==1||count==0) System.out.println("cat"); else
		 * System.out.println("pig");
		 * 
		 * 
		 * }
		 */
    	System.out.println(Runtime.getRuntime().availableProcessors());
    	System.out.println("Right");
    	System.out.println("Left   aaa");   
	       
    	
    }
	
	
    
 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public  static void mergeSort(int left, int right, int []nums, int[] temp) {
		
		if(left==right)
			return;
		int mid=left+(right-left)/2;
		
		mergeSort(left, mid, nums ,temp);
		
		mergeSort(mid+1, right, nums, temp);
		
		merge(left, mid, right, nums, temp);
	}
	
	public static void merge (int l, int mid,int r, int [] nums, int [] temp) {
		for(int i=l; i<=r; i++) {
			temp[i]=nums[i];
		}
		
		int i=l;
		int j=mid+1;
		
		for(int k=l; k<=r; k++) {
			if(i==mid+1){
				nums[k]=temp[j];
				j++;
			}
			else if(j==r+1){
				nums[k]=temp[i];
				i++;
			}
			else if(temp[i]<=temp[j]){
				nums[k]=temp[i];
				i++;
			}
			else {
				nums[k]=temp[j];
				j++;
			}
		}
	}


   
}

	    
		    
		   

