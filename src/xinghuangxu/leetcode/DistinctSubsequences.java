package xinghuangxu.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class DistinctSubsequences {

	public static void main(String[] args) {
		DistinctSubsequences ds = new DistinctSubsequences();
		System.out.println(ds.numDistinct("adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc","bcddceeeebecbc"));
	}
	
	public int numDistinct(String S, String T) {
		int ssize=S.length(),tsize=T.length();
		int[][] count=new int[tsize+1][ssize+1];
		for(int i=0;i<ssize;i++){
			count[0][i]=1;
		}
		
		/*
		 * T(0...j)in S(0...i) 
		 * 
		 * c[j+1][i+1]=c[j+1][i] //not using s[i]
		 *             +c[j][i]  //use s[i] when s[i]=t[j]
		 */
		for(int i=0;i<ssize;i++){
			for(int j=0;j<tsize;j++){
				count[j+1][i+1]=count[j+1][i];
				if(S.charAt(i)==T.charAt(j)){
					count[j+1][i+1]+=count[j][i];
				}
			}
		}
		return count[tsize][ssize];
		
	}
	/*Solution 2
	int count;
	public int numDistinct(String S, String T) {
		count=0;
		HashMap<Character,List<Integer>> fre = new HashMap<Character,List<Integer>>();
		for(int i=0;i<T.length();i++){
			if(!fre.containsKey(T.charAt(i))){
				fre.put(T.charAt(i),new ArrayList<Integer>());
			}
		}
		for(int i=0;i<S.length();i++){
			if(fre.containsKey(S.charAt(i))){
				fre.get(S.charAt(i)).add(i);
			}
		}
		find(-1,0,T,fre);
		return count;
	}
	
	private void find(int sindex,int tindex,String T, HashMap<Character,List<Integer>> fre ){
		if(tindex==T.length()){
			count++;
		}else{
			List<Integer> l=fre.get(T.charAt(tindex));
			for(int i=0;i<l.size();i++){
				if(l.get(i)>sindex){
					find(l.get(i),tindex+1,T,fre);
				}
			}
		}	
	}
	*/
	
	
	/*Solution 1
	int count;
	public int numDistinct(String S, String T) {
		
		count=0;
		find(S,T,0,"");
		return count;
	}
	
	private void find(String S,String T, int index,String prefix){
		if(prefix.length()==T.length()){
			count++;
		}else{
			for(int i=0;i<S.length();i++){
				if(S.charAt(i)==T.charAt(index)){
					find(S.substring(i), T,index+1,prefix+S.charAt(i));
				}
			}
		}	
	}
	*/

}
