package xinghuangxu.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
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
	
	class Node{
		Node parent;
		int depth;
		String val;
		public Node(Node parent,int depth,String val){
			this.parent=parent;
			this.depth=depth;
			this.val=val;
		}
	}
	public List<List<String>> findLadders(String start, String end,
			Set<String> dict) {
		List<List<String>> rel=new ArrayList<List<String>>();
		int maxDepth=this.ladderLength(start, end, dict);
		
		Queue<Node> queue = new ArrayDeque<Node>();
		queue.add(new Node(null,1,start));
		Node wordNode, newWordNode;
		String word,newWord;
		int N = start.length();
		char newChar;
		while (!queue.isEmpty()) {
			wordNode = queue.poll();
			word=wordNode.val;
			if(wordNode.depth>=maxDepth)break;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < 26; j++) {
					newChar = (char) ('a' + j);
					newWord = word.substring(0, i) + newChar
							+ word.substring(i + 1);
					if (dict.contains(newWord)) {
						newWordNode=new Node(wordNode,wordNode.depth+1,newWord);
						if (newWord.equals(end)) {
							rel.add(createList(newWordNode));
						}else{
							queue.add(newWordNode);
						}
						
					}
				}
			}
		}
		return rel;
	}

	private List<String> createList(Node node) {
		List<String> rel=new LinkedList<String>();
		while(node!=null){
			rel.add(0,node.val);
			node=node.parent;
		}
		return rel;
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
