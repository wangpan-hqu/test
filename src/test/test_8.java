package test;

import java.util.Scanner;

public class test_8 {

	static int res;
    public static void BFS(String s, int E_count, int F_count){
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='E')
                E_count++;
            else
                F_count++;
        }
        
        res=Math.max(res,E_count-F_count);
    }
    
    public static void main(String [] args){
        
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
        int n=sc.nextInt();

        String s=sc.next();
        
        for(int i=n;i>=0;i--){
            for(int j=0;j<i;j++)
            BFS(s.substring(j,i),0,0);
        }
        
        System.out.println(res);
        
        
        }
    }

}
