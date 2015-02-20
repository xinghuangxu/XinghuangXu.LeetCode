package xinghuangxu.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SimplifyPath {

	public static void main(String[] args) {
		SimplifyPath sp=new SimplifyPath();
		///a/./b/../../c
		//
		System.out.println(sp.simplifyPath("/a/./b///../c/../././../d/..//../e/./f/./g/././//.//h///././/..///"));
	}

	public String simplifyPath(String path) {
		String[] folders=path.split("\\/");
		Stack<String> stack=new Stack<String>();
		for(int i=1;i<folders.length;i++){
			if(!folders[i].equals("")){
				if(folders[i].equals("..")){
					if(stack.isEmpty()){
						stack.push("/");
					}else{
						stack.pop();
					}
				}else if(!folders[i].equals(".")){
					stack.push(folders[i]);
				}
			}
		}
		StringBuilder sb=new StringBuilder();
		List<String> list=new ArrayList<String>();
		while(!stack.isEmpty()){
			list.add(stack.pop());
		}
		for(int i=list.size()-1;i>-1;i--){
			if(list.get(i).equals("/")){
				sb.append("/");
			}else{
				sb.append("/"+list.get(i));
			}
		}
		if(sb.length()==0)return "/";
		
		return sb.toString().replaceAll("/+", "/");
	}

}
