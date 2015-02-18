package xinghuangxu.leetcode;

public class DecodeWays {

	public static void main(String[] args) {
		DecodeWays dw = new DecodeWays();
		int ways = dw.numDecodings("12121212212121210");
		System.out.println(ways);
	}
	
	public int numDecodings(final String s) {
        if (s.isEmpty()) {
            return 0;
        }

        // count[start & 1] is the decode ways of s.substring(start)
        final int[] count = new int[2];

        count[(s.length() - 1) & 1] = s.charAt(s.length() - 1) > '0' ? 1 : 0;
        count[(s.length() & 1)] = 1;

        for (int start = s.length() - 2; start >= 0; start--) {
            if (s.charAt(start) > '0') {
                if (s.charAt(start) == '1' || (s.charAt(start) == '2' && s.charAt(start + 1) < '7')) {
                    count[start & 1] += count[(start + 1) & 1];
                } else {
                    count[start & 1] = count[(start + 1) & 1];
                }
            } else {
                count[start & 1] = 0;
            }
        }

        return count[0];
    }
	
	/*
	private Integer[][] ways;
	
	public int reuse=0;

	public int numDecodings(String s) {
		if (s.length() == 0)
			return 0;
		ways = new Integer[s.length()][s.length()];
		return numDecodings(s, 0, s.length() - 1);
	}

	public int numDecodings(String s, int lo, int hi) {
		if (ways[lo][hi] != null){
			reuse++;
			return ways[lo][hi];
		}	
		if (lo == hi) { // last cases
			if (isValidEncode(s.substring(lo, lo + 1))) {
				return 1;
			}
			return 0;
		}
		if (hi - lo == 1) {
			String sub = s.substring(lo, hi + 1);
			if(isValidInteger(sub)){
				int num = Integer.parseInt(sub);
				if (num > 10 && num < 27&&num!=20) {
					return 2;
				} else {
					return 1;
				}
			}else{
				return 0;
			}
			
		}
		int decodeWays = 0;
		for (int i = lo; i < lo + 2 && i < hi; i++) {
			if (isValidEncode(s.substring(lo, i + 1))) {
				decodeWays += numDecodings(s, i + 1, hi);
			}
		}
		ways[lo][hi] = decodeWays;
		return decodeWays;
	}
	
	private boolean isValidInteger(String s){
		if(s.length()>1&&s.charAt(0)=='0')return false;
		if(s.indexOf('0')!=-1&&Integer.parseInt(s)>26)return false;
		return true;
	}

	private boolean isValidEncode(String s) {
		if (s.length() == 1 && s.equals("0"))
			return false;
		if (s.length() == 2) {
			if(s.charAt(0)=='0'){
				return false;
			}
			int i = Integer.parseInt(s);
			if (i < 1 || i > 26)
				return false;
		}
		return true;
	}
	*/

}
