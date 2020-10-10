package prebaidu;

public class ListT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListT listT=new ListT();
		listT.exec();

	}
	
	
	public void exec() {
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
//		ListNode head=reverse(node1);
//		ListNode head=reverseLoop(node1);
//		ListNode head=mergeList(node1, node5);
		outputTail(node1);
//		output(head);
	}
	
	
	public void outputTail(ListNode root) {
		if (root==null) {
			return;
		}
		outputTail(root.next);
		System.out.print(root.val+" ");
	}
	
	
	public ListNode mergeListLoop(ListNode head1,ListNode head2) {



		ListNode head=new ListNode(-1),tmp = head;
		while (head1!=null&&head2!=null) {
			
			if (head1.val<head2.val) {
				tmp.next=head1;
				head1=head1.next;
			}else {
				tmp.next=head2;
				head2=head2.next;
			}
		}
		if (head1==null) {
			tmp.next= head2;
			
		}
		if (head2==null) {
			tmp.next=head1;
		}

		return head.next;
	}
	
	
	public ListNode mergeList(ListNode head1,ListNode head2) {
		if (head1==null) {
			return head2;
			
		}
		if (head2==null) {
			return head1;
		}
		ListNode head;
		if (head1.val<head2.val) {
			head=head1;
			head.next=mergeList(head1.next, head2);
			
		}else {
			head=head2;
			head.next=mergeList(head1, head2.next);
		}
		
		
		return head;
	}
	
	
	public ListNode reverseLoop(ListNode head) {
		ListNode back=null;
		while (head!=null) {
			ListNode tmp=head.next;
			head.next=back;
			back=head;
			head=tmp;
		}
		return back;
	}
	
	public ListNode reverse(ListNode head) {
		if (head==null) {
			return null;
		}else		if (head.next==null) {
			return  head;
		}
		ListNode tmp=reverse(head.next);
		head.next.next=head;
		head.next=null;
		return tmp;
	}
	
	
	public void output(ListNode head) {
		while (head!=null) {
			System.out.print(head.val+" ");
			head=head.next;
		}
		System.out.println();
	}
	
	
	static class ListNode{
		ListNode next;
		int val;
		
		public ListNode(int val) {
			super();
			this.next = next;
			this.val = val;
		}
		
	}

}
