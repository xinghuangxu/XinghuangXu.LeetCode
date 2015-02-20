package xinghuangxu.leetcode;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

	public static void main(String[] args) {
		TextJustification tj=new TextJustification();
		String[] words={"Listen","to","many,","speak","to","a","few."};
		List<String> rel=tj.fullJustify(words, 6);
		System.out.println(rel.size());
	}
	
	 public List<String> fullJustify(String[] words, int L) {
		 List<List<String>> rows=new ArrayList<List<String>>();
		 List<String> temp=new ArrayList<String>();
		 temp.add(words[0]);
		 int curCount=words[0].length();
		 rows.add(temp);
		 for(int i=1;i<words.length;i++){
			 if(L-curCount-1>=words[i].length()){
				 rows.get(rows.size()-1).add(words[i]);
				 curCount+=(words[i].length()+1);
			 }else{
				 temp=new ArrayList<String>();
				 temp.add(words[i]);
				 curCount=words[i].length();
				 rows.add(temp);
			 }
		 }
		 List<String> rel=new ArrayList<String>();
		 for(int i=0;i<rows.size();i++){
			 if(i==rows.size()-1){
				 rel.add(Justify(rows.get(i),L,true));
			 }else{
				 rel.add(Justify(rows.get(i),L,false));
			 }
		 }
		 return rel;
	    }

	private String Justify(List<String> list,int length,boolean left) {
		StringBuilder sb=new StringBuilder();
		if(left){//left justify
			sb.append(list.get(0));
			for(int i=1;i<list.size();i++){
				sb.append(" "+list.get(i));
			}
			while(sb.length()!=length){
				sb.append(' ');
			}
		}else{//jsutify both way
			int count=0;
			for(int i=0;i<list.size();i++){
				count+=list.get(i).length();
			}
			int space=length-count;
			int spaceWidth=list.size()==1?0:space/(list.size()-1);
			String spaceString="";
			while(spaceWidth!=0){
				spaceString+=" ";
				spaceWidth--;
			}
			int remainder=list.size()==1?0:space%(list.size()-1);
			sb.append(list.get(0));
			for(int i=1;i<list.size();i++){
				if(remainder!=0){
					sb.append(spaceString+" "+list.get(i));
					remainder--;
				}else{
					sb.append(spaceString+list.get(i));
				}
			}
			while(sb.length()<length){
				sb.append(" ");
			}
		}
		return sb.toString();
	}

}
