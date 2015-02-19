package xinghuangxu.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RestoreIPAddresses {

	public static void main(String[] args) {
		RestoreIPAddresses ripaddres = new RestoreIPAddresses();
		List<String> rel = ripaddres.restoreIpAddresses("010010");
		ripaddres.isLegalIpInteger("010");
		System.out.println();
	}

	public List<String> restoreIpAddresses(String s) {
		return restoreIpAddresses(s, 4);
	}

	HashMap<String, List<String>> map = new HashMap<String, List<String>>();

	private List<String> restoreIpAddresses(String s, int index) {
		if (s.length() > 3 * index || s.length() == 0)
			return new ArrayList<String>();
		List<String> rel = map.get(s + ":" + index);
		if (rel == null) {
			rel = new ArrayList<String>();
			if (index == 1&&isLegalIpInteger(s)) {
				rel.add(s);
			} else {
				List<String> temp;
				for (int i = 0; i < 3 && i < s.length(); i++) {
					if (isLegalIpInteger(s.substring(0, i + 1))) {
						temp = restoreIpAddresses(s.substring(i + 1), index - 1);
						if (temp != null) {
							for (String t : temp) {
								rel.add(s.substring(0, i + 1) + "." + t);
							}
						}
					}
				}
			}
			map.put(s + ":" + index, rel);
		}
		return rel;
	}

	private boolean isLegalIpInteger(String s) {
		if (s.length() > 1 && s.charAt(0) == '0') {
			return false;
		}
		if (Integer.parseInt(s) > 255) {
			return false;
		}
		return true;
	}

}
