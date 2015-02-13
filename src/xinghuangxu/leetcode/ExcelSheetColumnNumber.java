package xinghuangxu.leetcode;

public class ExcelSheetColumnNumber {

	public static void main(String[] args) {
		ExcelSheetColumnNumber escn = new ExcelSheetColumnNumber();
		System.out.println(escn.titleToNumber("AZAZ"));
		System.out.println(escn.convertToTitle(35204));
	}

	public int getIndex(char c) {
		return c - 'A' + 1;
	}

	public int titleToNumber(String s) {
		int base = 26;
		int multiplier = 1;
		int sum = 0;
		String columnTitle = s;
		for (int i = columnTitle.length() - 1; i > -1; i--) {
			sum += this.getIndex(columnTitle.charAt(i)) * multiplier;
			multiplier *= base;
		}
		return sum;
	}

	public String convertToTitle(int n) {
		int base = 26,temp=n;
		StringBuilder sb= new StringBuilder();
		while(temp!=0){
			if(temp%base==0){
				sb.append('Z');
				temp=temp/base-1;
			}else{
				sb.append((char)('A'+temp%base-1));
				temp=temp/base;
			}
		}
		return sb.reverse().toString();
	}
}
