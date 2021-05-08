package test;

public class Tire{

    boolean b;

    Tire [] child;

    public Tire(){
        child=new Tire [26];
        b=false;
    }

    public void add(String str, Tire root){
        if(root==null){
            return ;
        }
        Tire cur=root;
        for(int i=0; i<str.length();i++){
            int id=str.charAt(i)-'a';
            if(cur.child[id]==null){
                 cur.child[id]=new Tire();
            }
            cur=cur.child[id];
        }
        cur.b=true;
    }

    public boolean find(String str, Tire root){
        if(root==null){
            return false;
        }
     
        Tire cur=root;
        for(int i=0; i<str.length();i++){
                int id=str.charAt(i)-'a';
                if(cur.child[id]!=null&&cur.child[id].b){
                    cur=root;
                    continue;
                }
                if(cur.child[id]==null){
                    return false;
                }
                cur=cur.child[id];
              
        }
        return true;
    }

}