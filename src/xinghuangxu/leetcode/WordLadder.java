package xinghuangxu.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

	public static void main(String[] args) {
		String start = "red";
		String end = "tax";
		Set<String> dict = new HashSet<String>();
		String[] array = { "ted","tex","red","tax","tad","den","rex","pee" };
		for (String s : array) {
			dict.add(s);
		}
		WordLadder wl = new WordLadder();
//		System.out.println(wl.ladderLength(start, end, dict));
		List<List<String>> rel= wl.findLadders(start, end, dict);
		System.out.println("");
	}
	
	class Node implements Comparable<Node>{
		List<Node> parents=new LinkedList<Node>();
		HashSet<Node> neighbors=new HashSet<Node>();
		int dist;
		String val;
		public Node(String val){
			this.val=val;
			this.dist=Integer.MAX_VALUE;
		}
		@Override
		public int compareTo(Node o) {
			if(this.dist>o.dist){
				return 1;
			}else if (this.dist==o.dist){
				return 0;
			}
			return -1;
		}
		
	}
	public List<List<String>> findLadders(String start, String end,
			Set<String> dict) {
		//get all the nodes
		Node startNode=new Node(start);
		startNode.dist=1;
		Node endNode=new Node(end);
		List<Node> allNode=new ArrayList<Node>();
		allNode.add(startNode);
		allNode.add(endNode);
		for(String w:dict){
			allNode.add(new Node(w));
		}
		
		//construct the edges
		HashSet<Node> neighbors;
		String word1,word2;
		int diff;
		for(int i=0;i<allNode.size();i++){
			neighbors=allNode.get(i).neighbors;
			word1=allNode.get(i).val;
			for(int j=i+1;j<allNode.size();j++){
				diff=0;word2=allNode.get(j).val;
				for(int k=0;k<word1.length();k++){
					if(word1.charAt(k)!=word2.charAt(k)){
						diff++;
						if(diff>1)break;
					}
				}
				if(diff==1){
					neighbors.add(allNode.get(j));
					allNode.get(j).neighbors.add(allNode.get(i));
				}
			}
		}
		
		//union search
		PriorityQueue<Node> pq=new PriorityQueue<Node>();
		pq.add(startNode);
		Node temp;
		while(!pq.isEmpty()){
			temp=pq.poll();
			if(temp==endNode)break;
			for(Node v:temp.neighbors){
				if(temp.dist+1<=v.dist){
					v.parents.add(temp);
					v.dist=temp.dist+1;
					pq.remove(v);
					pq.add(v);
				}
			}
		}
		List<List<String>> seqs=new LinkedList<List<String>>();
		List<String> seq=new LinkedList<String>();
		createList(startNode,endNode,seq,seqs);
		return seqs;
	}

	private void createList(Node start,Node end, List<String> seq,List<List<String>> seqs) {
		seq.add(0,end.val);
		if(start==end){
			List<String> clone=new ArrayList<String>(seq);
			seqs.add(clone);
		}else{
			for(Node n:end.parents){
				createList(start,n,seq,seqs);
			}
		}
		seq.remove(0);
	}


	public int ladderLength(String start, String end, Set<String> dict) {
		HashMap<String, Integer> disCount = new HashMap<String, Integer>();
		disCount.put(start, 1);
		Queue<String> queue = new ArrayDeque<String>();
		queue.add(start);
		String word, newWord;
		int N = start.length();
		char newChar;
		while (!queue.isEmpty()) {
			word = queue.poll();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < 26; j++) {
					newChar = (char) ('a' + j);
					newWord = word.substring(0, i) + newChar
							+ word.substring(i + 1);
					if (!disCount.containsKey(newWord)
							&& dict.contains(newWord)) {
						if (newWord.equals(end)) {
							return disCount.get(word) + 1;
						}
						disCount.put(newWord, disCount.get(word) + 1);
						queue.add(newWord);
					}
				}
			}
		}
		return 0;
	}

}
