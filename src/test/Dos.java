package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dos {

	public static void main(String [] args) {
		double E_elec=50*Math.pow(10, -9);
		double d=10;
		double E_amp=1.3*Math.pow(10, -15);
		double k=2*Math.pow(10, 6);
		double c=5*8*Math.pow(10, 6);
		double E=40;
		double E_nor=40;
		double E_cur=40;
		double Threshold=1;
		
		double a=5,b=5,n=5,m=5;
		double trust_com=0;
		double trust_nor=0;		
		double trust_en=0;
		List<Double> list= new ArrayList<>();
		List<Double> list_1= new ArrayList<>();
		for(int i=0;i<=200;i++){
			E_nor-=2.0*E_elec*k+E_amp*d*d*k;
			trust_nor=(1+0.9*n)/(1+0.9*(n+m));
			n++;
		   if(i<50) {
			  
		       E_cur-=2.0*E_elec*k+E_amp*d*d*k;
		       if(E_cur<0) {
				    trust_en=0;
				    b++;
					trust_com=(0.9*a)/(0.9*(a+b)+1);
			   }
		       else if(E_cur<Threshold) {
					trust_en=0;
					trust_com=(1+0.9*a)/(1+0.9*(a+b));
					a++;
			   }
			  else {
					trust_en=1-(Math.abs(E_cur-E_nor)/E)-new Random().nextInt(10)*0.005;
					trust_com=(1+0.9*a)/(1+0.9*(a+b));
					a++;
			  }
		       
		   }
		   else {
			  
			   E_cur-=5.0*E_elec*k+2*E_amp*d*d*k; 
			   if(E_cur<0) {
				     trust_en=0;
					 b++;
					 trust_com=(0.9*a)/(0.9*(a+b)+1);
			   }
			   else if(E_cur<Threshold) {
					 trust_en=0;
					 trust_com=(1+0.9*a)/(1+0.9*(a+b));
					 a++;
				}
				else {
					 trust_en=1-(Math.abs(E_cur-E_nor)/E);
					 trust_com=(1+0.9*a)/(1+0.9*(a+b));
					 a++;
					
				}
		   }
		   list.add(1/4.0*(0.5+trust_com)+1/2.0*trust_en);
	       list_1.add(1/4.0*(0.5+trust_nor)+1/2.0*(1-new Random().nextInt(10)*0.005));
		}
		
		
		for(int i=0;i<=200;i++) {
			if(i%10==0)
				System.out.print(i+",");
		}
		System.out.println();
		for(int i=0;i<list.size();i++) {
			if(i%10==0)
			  System.out.print(list.get(i)+",");
		}
		System.out.println();
		for(int i=0;i<list_1.size();i++) {
			if(i%10==0)
			  System.out.print(list_1.get(i)+",");
		}
	}
			
	
	
}
