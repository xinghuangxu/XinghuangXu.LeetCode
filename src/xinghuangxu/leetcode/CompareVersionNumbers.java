package xinghuangxu.leetcode;

public class CompareVersionNumbers {

	public static void main(String[] args) {
		CompareVersionNumbers cvn = new CompareVersionNumbers();
		System.out.println(cvn.compareVersion("1.0", "1"));
	}

	public int compareVersion(String version1, String version2) {
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");
		int max = Math.max(v1.length, v2.length);
		if (v1.length > v2.length) {
			String[] temp=new String[v1.length];
			for(int i=0;i<v2.length;i++){
				temp[i]=v2[i];
			}
			for(int i=v2.length;i<v1.length;i++){
				temp[i]="0";
			}
			v2=temp;
		} else if (v1.length < v2.length) {
			String[] temp=new String[v2.length];
			for(int i=0;i<v1.length;i++){
				temp[i]=v1[i];
			}
			for(int i=v1.length;i<v2.length;i++){
				temp[i]="0";
			}
			v1=temp;
		}
		
		for (int i = 0; i < max; i++) {
			if (Integer.parseInt(v1[i]) > Integer.parseInt(v2[i])) {
				return 1;
			} else if (Integer.parseInt(v1[i]) < Integer.parseInt(v2[i])) {
				return -1;
			}
		}
		return 0;
	}

}
