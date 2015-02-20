package xinghuangxu.leetcode;

public class PermutationSequence {

	public static void main(String[] args) {
		PermutationSequence ps=new PermutationSequence();
		System.out.println(ps.getPermutation(4, 2));
	}

	public String getPermutation(int n, int k) {
		boolean[] used=new boolean[n+1];
		int[] permutation=new int [n+1];
		permutation[0]=1;
		int count=1;
		for(int i=1;i<=n;i++){
			count*=i;
			permutation[i]=count;
		}
		return findPermutation(n-1,k,used,permutation);
	}

	private String findPermutation(int n, int k, boolean[] used,
			int[] permutation) {
		String s="";
		if(k==1){
			for(int i=1;i<used.length;i++){
				if(used[i]==false){
					s+=i;
				}
			}
		}else
		if(k<permutation[n]){
			for(int i=1;i<used.length;i++){
				if(used[i]==false){
					s+=i;
					used[i]=true;
					break;
				}
			}
			s+=findPermutation(n-1,k,used,permutation);
		}else{
			int count=0;
			while(k>permutation[n]){
				count++;
				k-=permutation[n];
			}
			for(int i=1;i<used.length;i++){
				if(used[i]==false){
					if(count==0){
						s+=i;
						used[i]=true;
						break;
					}else{
						count--;
					}
				}
			}
			s+=findPermutation(n-1,k,used,permutation);
		}
		return s;
	}

}
