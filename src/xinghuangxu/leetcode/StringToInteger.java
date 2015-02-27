public class StringToInteger {

	public static void main(String[] args) {
		StringToInteger sti = new StringToInteger();
		System.out.println(sti.atoi("      -11919730356x"));
	}

	public int atoi(String str) {
		int rel = 0, i = 0;
		boolean start = false;
		while (!start && i < str.length()) {
			if (str.charAt(i) == '+' || str.charAt(i) == '-'
					|| (str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
				start = true;
				break;
			} else if (str.charAt(i) != ' ') {
				return 0;
			}
			i++;
		}
		int sign = 1;
		if (i < str.length()) {
			if (str.charAt(i) == '+') {
				sign = 1;
				i++;
			} else if (str.charAt(i) == '-') {
				sign = -1;
				i++;
			}
		}
		int power = 10;
		if (start) { // process start
			while (i < str.length() && str.charAt(i) >= '0'
					&& str.charAt(i) <= '9') {
				if (sign == 1 && rel >= Integer.MAX_VALUE / 10) { // best way to
																	// determined
																	// overflow
					return Integer.MAX_VALUE;
				}
				if (sign == -1 && (-rel < Integer.MIN_VALUE / 10||(-rel == Integer.MIN_VALUE / 10&&(str.charAt(i) - '0')>8))) { //check negative overflow
					return Integer.MIN_VALUE;
				}
				rel = (str.charAt(i) - '0') + rel * power;
				i++;
			}
		}
		return rel * sign;
	}

}
