package xinghuangxu.leetcode;

public class ZigZagConversion {

	public static void main(String[] args) {
		ZigZagConversion zzc = new ZigZagConversion();
//		System.out.println(zzc.convert("", 1).equals("")); // ACB
		System.out.println(zzc.convert("A", 1).equals("A")); // ACB
		System.out.println(zzc.convert("PAYPALISHIRING", 3).equals(
				"PAHNAPLSIIGYIR"));// PAHNAPLSIIGYIR
		System.out.println(zzc.convert("ABC", 2).equals("ACB")); // ACB
		System.out.println(zzc.convert("PAYPALISHIRING", 6).equals("PRAIIYHNPSGAIL")); // ACB
		System.out.println(zzc.convert("Apalindromeisaword,phrase,number,orothersequenceofunitsthatcanbereadthesamewayineitherdirection,withgeneralallowancesforadjustmentstopunctuationandworddividers.", 3).equals("Aiosrhem,tseoihartaaeeriwgrlasasnoctaoieplnrmiaodprs,ubroohreunefnttacneedhsmwynihrieto,iheeaalwnefrdutettpntainnwrdvdr.adew,anereqcustbaeeitdcntnlocojmsuuoddis")); // ACB
		
	}
	
	public String convert(String s, int nRows) {
		StringBuilder sb=new StringBuilder();
		if(nRows==1)return s;
		for(int i=0;i<nRows;i++){
			int gap=2*nRows-2*i-2;
			int j=i;
			while(j<s.length()){
				//if i==0
				if(i==0||i==nRows-1){
					sb.append(s.charAt(j));
					if(gap!=0){
						j=j+gap;
					}else{
						j+=2*i;
					}
					
				}else{
					sb.append(s.charAt(j));
					j=j+gap;
					if(j<s.length())sb.append(s.charAt(j));
					j=j+i*2;
				}
			}
		}
		return sb.toString();
	}

	public String convert2(String s, int nRows) {
		if(s.length()==0)return "";
		int rowLen = nRows, sLen = s.length(), columnLen = sLen/2+1; //why slen/2+1 ??????
		if(rowLen<=1)return s;
		char[][] matrix = new char[rowLen][columnLen];
		int count = sLen - 1;
		for (int j = 0; j < columnLen; j++) {
			// fill out the left
			if(j%(rowLen-1)==0){ //why rowlen-1? cause rowlen is the cycle
				for (int i = 0; i < rowLen; i++) {
					if(count>=0)matrix[i][j] = s.charAt(sLen - 1 - count);
					count--;
				}
			}else{
				if(count>=0)matrix[rowLen-j%(rowLen-1)-1][j] = s.charAt(sLen - 1 - count);
				count--;
			}
			if (count <0)
				break;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < rowLen; i++) {
			for (int j = 0; j < columnLen; j++) {
				if (matrix[i][j] != 0) {
					sb.append(matrix[i][j]);
				}
			}
		}
		return sb.toString();
	}

}
