package test;

public class TrieNode {
	int freq;

    TrieNode [] child;

    public TrieNode(){
        freq=0;
        child=new TrieNode[26];
    }
}
