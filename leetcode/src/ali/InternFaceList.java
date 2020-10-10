package ali;

public class InternFaceList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(9);
		ListNode node2 = new ListNode(6);
		ListNode node3 = new ListNode(4);
		ListNode node4 = new ListNode(5);
		ListNode node5 = new ListNode(1);
		ListNode node6 = new ListNode(8);
//		ListNode node7 = new ListNode(7);
		ListNode head = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
//		node6.next = node7;
		InternFaceList internFaceList = new InternFaceList();
		print(head);
		print(head=internFaceList.listSort(head));
//		print(internFaceList.deleteNode(head, 9));
//		internFaceList.delete(node7, node7);
		print(head=internFaceList.reverseList(head));
		print(head=internFaceList.reverseListRec(head));
		internFaceList.getListLen(head);
		internFaceList.getKNode(head, 2);
		internFaceList.getMiddleNode(head);
	}
	
	public void firstNode(ListNode head){
		ListNode p=head;
		ListNode q=head;
		while (q!=null&&q.next!=null) {
			p=p.next;
			q=q.next.next;
			if (p==q) {
				break;
			}
		}
		p=head;
		while (q!=p) {
			q=q.next;
			p=p.next;
		}
	}
	
	public ListNode mergeList(ListNode head1,ListNode head2){
		if (head1==null) {
			return head2;
		}else if (head2==null) {
			return head1;
		}
		if (head1.val<head2.val) {
			head1.next=mergeList(head1.next, head2);
			return head1;
		}else {
			head2.next=mergeList(head1, head2.next);
			return head2;
		}
		
	}

	public void getMiddleNode(ListNode head){
		ListNode p=head;
		ListNode q=head;
		while (q!=null) {
			p=p.next;
			if (q.next!=null) {
				q=q.next.next;
			}
		}
		System.out.println(p.val);
	}
	
	public void getKNode(ListNode head,int k){
		ListNode pre=head;
		while(head!=null&&k>=0){
			k--;
			if (k==0) {
				System.out.println(head.val);
			}
			head=head.next;
		}
	}
	
	public void getListLen(ListNode head){
		int k=0;
		while (head!=null) {
			head=head.next;
			k++;
		}
		System.out.println(k);
	}

	public ListNode reverseList(ListNode head) {
		if (head==null) {
			return null;
		}
		ListNode back=null,tmp;
		ListNode p=head;
		while (p!=null) {
			tmp=p.next;
			p.next=back;
			back=p;
			p=tmp;
		}
		return back;
	}
	
	public ListNode reverseListRec(ListNode head){
		if (head.next==null||head==null) {
			return head;
		}
		ListNode tmp=reverseListRec(head.next);
//		tmp.next=head;
		head.next.next=head;
		head.next=null;
		return tmp;
	}

	public ListNode deleteNode(ListNode head, int val) {
		if (head == null) {
			return null;
		}
		while (head != null && head.val == val) {
			head = head.next;
		}
		ListNode p = head;
		while (p != null) {
			if (p.next != null && p.next.val == val) {
				p.next = p.next.next;
				continue;
			}
			p = p.next;

		}
		return head;

	}

	public ListNode listSort(ListNode head) {
		ListNode p = head;
		ListNode q;
		while (p != null) {
			q = head;
			while (q != null && q.next != null) {
				if (q.val > q.next.val) {
					int t = q.val;
					q.val = q.next.val;
					q.next.val = t;

				}
				q = q.next;
			}
			p = p.next;
		}
		return head;

	}

	public static void print(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}

	static class ListNode {
		ListNode next;
		int val;

		public ListNode(int val) {
			// TODO Auto-generated constructor stub
			this.val = val;
		}
	}
	
//	public void delete(ListNode head, ListNode toDelete) {
//	if (toDelete == null) {
//		return;
//	}
//	if (toDelete.next != null) { // 要删除的是一个中间节点
//		toDelete.val = toDelete.next.val; // 将下一个节点的数据复制到本节
//		toDelete.next = toDelete.next.next;
//	} else { // 要删除的是最后一个节点！
//		if (head == toDelete) { // 链表中只有一个节点的情况
//			head = null;
//		} else {
//			ListNode node = head;
//			while (node.next != toDelete) { // 找到倒数第二个节点
//				node = node.next;
//			}
//			node.next = null;
//		}
//	}
//}

}
