package xinghuangxu.leetcode;

import java.util.HashMap;
import java.util.List;

import xinghuangxu.leetcode.Helper.UndirectedGraphNode;

public class CloneGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private HashMap<UndirectedGraphNode,UndirectedGraphNode> map=new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if(node==null)return null;
		UndirectedGraphNode copy=map.get(node);
		if(copy==null){
			copy=new UndirectedGraphNode(node.label);
			map.put(node, copy);
			List<UndirectedGraphNode> neighbors=node.neighbors;
			for(UndirectedGraphNode n:neighbors){
				copy.neighbors.add(cloneGraph(n));
			}
			
		}
		return copy;
		
	}

}
