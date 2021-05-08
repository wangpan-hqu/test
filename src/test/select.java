package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class select {
	
	public static void main(String [] args) {
		double E_elec=50*Math.pow(10, -9);
		double d=10;
		double E_amp=1.3*Math.pow(10, -15);
		double k=2*Math.pow(10, 6);
		double c=5*8*Math.pow(10, 6);
		double E=40;
		double E_nor=40;
		double E_cur=40;
		double Threshold=3;
		
		double a=5,b=5,n=5,m=5;
		double trust_com=0;
		double trust_nor=0;	
		double trust_en=0;
		List<Double> list= new ArrayList<>();
		List<Double> list_1= new ArrayList<>();
		//list.add(0.5);
		for(int i=0;i<=200;i++){
		   E_nor-=2.0*E_elec*k+E_amp*d*d*k;
		   trust_nor=(1+0.9*n)/(1+0.9*(n+m));
		   n++;
		   if(i<50) {
			   trust_com=(1+0.9*a)/(1+0.9*(a+b));
		       a++;
		       E_cur-=2.0*E_elec*k+E_amp*d*d*k;
			   if(E_cur<Threshold)
					trust_en=0;
			  else {
				  trust_en=1-(Math.abs(E_cur-E_nor)/E)-new Random().nextInt(10)*0.005;
					
			  }
			   list.add(2/5.0*(trust_com+trust_en)+0.5*1/5.0);
		   }
		   else {
			   b++;
			   trust_com=(0.9*a)/(0.9*(a+b)+1);
			   E_cur-=1*E_elec*k; 
				if(E_cur<Threshold)
					trust_en=0;
				else {
					trust_en=1-(Math.abs(E_cur-E_nor)/E);
					
				}
				list.add(2/5.0*(trust_com+trust_en)+0.5*1/5.0);
		   }
		   list_1.add(2/5.0*(trust_nor+(1-new Random().nextInt(10)*0.005))+0.5*1/5.0);
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
