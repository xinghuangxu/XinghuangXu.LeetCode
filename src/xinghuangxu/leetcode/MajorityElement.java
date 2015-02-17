package xinghuangxu.leetcode;

public class MajorityElement {

	public static void main(String[] args) {
		MajorityElement me=new MajorityElement();
		System.out.println(me.majorityElement(new int[]{1,2,3,4,5,5,5,5}));
		 
	}
	
	public int majorityElement(int[] num) {
        int key=num[0];
        int count=1;
        for(int i=1;i<num.length;i++){
        	if(num[i]==key){
        		count++;
        	}else{
        		if(count>0){
        			count--;
        		}else{
        			key=num[i];
        			count=1;
        		}
        	}
        }
        return key;
    }

}
