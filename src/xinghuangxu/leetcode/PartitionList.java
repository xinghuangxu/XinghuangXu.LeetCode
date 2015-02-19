package xinghuangxu.leetcode;

public class PartitionList {

	public static void main(String[] args) {
		int[] num={1,4,3,2,5,2};
		ListNode l1=new ListNode(0);
		ListNode end=l1,temp;
		for(int n:num){
			temp=new ListNode(n);
			end.next=temp;
			end=temp;
		}
		PartitionList pl=new PartitionList();
		pl.partition(l1.next, 3);
		System.out.println();
	}

	public ListNode partition(ListNode head, int x) {
		ListNode startSamllList=new ListNode(0),endSmallList=startSamllList,
				temp=head,next,startBigList=new ListNode(0),endBigList=startBigList;
		while(temp!=null){
			next=temp.next;
			if(temp.val<x){ //to small list
				endSmallList.next=temp;
				endSmallList=temp;
			}else{//to big list
				endBigList.next=temp;
				endBigList=temp;
			}
			temp=next;
		}
		if(startSamllList==endSmallList){
			endBigList.next=null;
			return startBigList.next;
		}else{
			endBigList.next=null;
			endSmallList.next=startBigList.next;
			return startSamllList.next;
		}
	}

}
