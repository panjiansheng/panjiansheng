package leetsort;

import java.util.ArrayList;


public class Main {
	public static void main(String[] args) {
		
		ListNode node1=new ListNode(1);
		ListNode node2=new ListNode(2);
		ListNode node3=new ListNode(3);
		ListNode node4=new ListNode(4);
		ListNode node5=new ListNode(5);
		ListNode node6=new ListNode(6);
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		node5.next=node6;
		node6.next=null;
		System.out.println(node1);
		System.out.println(reverseKList(node1, 2));
	}
	
	
	public static ListNode reverseKList(ListNode head,int k){
		if (head==null) {
			return null;
		}
		int count=0;
		ListNode p=head;
		ListNode preStart=head;
		ArrayList<ListNode> list=new ArrayList<>();
		ArrayList<ListNode> result=new ArrayList<>();
		
		while(p!=null){
			if(count%k==k-1){
				list.add(preStart);
				preStart=p.next;
				p.next=null;
				p=preStart;
				count++;
				continue;
			}
			count++;
			p=p.next;
		}
		list.add(preStart);
		for(int i=0;i<list.size();i++){
			ListNode reversePartHead=revereList(list.get(i));
			result.add(reversePartHead);
		}
		ListNode resultHead=result.get(0);
		for(int i=0;i<result.size()-1;i++){
			ListNode end=result.get(i);
			while(end.next!=null)end=end.next;
			end.next=result.get(i+1);
			
		}
		return resultHead;
	}

	
	
	public static ListNode revereList(ListNode head){
		ListNode p=head;
		ListNode back=null;
		while (p!=null) {
			ListNode tmp=p.next;
			p.next=back;
			back=p;
			p=tmp;
			
		}
		return back;
	}
	
	static class ListNode{
		ListNode next;
		int val;
		public ListNode(int val) {
			// TODO Auto-generated constructor stub
			this.val=val;
			
		}
	}
}