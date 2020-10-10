package leetlist;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;



public class LeetList {

	public ListNode createList(String[] vals) {
		ListNode head = new ListNode(Integer.parseInt(vals[0]));
		ListNode tmp = head;
		for (int i = 1; i < vals.length; i++) {
			Integer val = Integer.parseInt(vals[i]);
			tmp.next = new ListNode(val);
			tmp = tmp.next;
		}
		File file=new File("");
		file.list();

		return head;
	}
	
	public void backOrderPrint(ListNode head){
		if (head==null) {
			return;
		}
		backOrderPrint(head.next);
		System.out.print(head.val+" ");
	}
	
	public ListNode revereList(ListNode head){
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

	public ListNode copyRandomList(ListNode head) {
		if (head == null) {
			return null;
		}
		try {

			ByteArrayOutputStream bos = new ByteArrayOutputStream();

			ObjectOutputStream oos;

			oos = new ObjectOutputStream(bos);

			oos.writeObject(head);

			// 将流序列化成对象
			ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());

			ObjectInputStream ois = new ObjectInputStream(bis);

			return (ListNode) ois.readObject();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		// RandomListNode randomListNode = new RandomListNode(head.label);
		// RandomListNode headNew = randomListNode;
		// while (head.next != null) {
		// RandomListNode tmp = new RandomListNode(head.next.label);
		// randomListNode.next = tmp;
		//
		// if (head.random != null) {
		// RandomListNode tmp2 = new RandomListNode(head.random.label);
		// randomListNode.random = tmp2;
		// }
		// head = head.next;
		// randomListNode = randomListNode.next;
		//
		// }
		// return headNew;

	}

	public TreeNode sortedListToBST(ListNode head) {
		return null;

	}

//	public ListNode sortList(ListNode head) {
//		while (head.next != null) {
//
//		}
//		return head;
//
//	}

	public void reorderList(ListNode head) {
		if (head == null | head.next == null) {
			return;
		}
		ListNode tmp = head;
		ListNode tmp2 = null;
		while (tmp.next != null) {
			tmp2 = tmp;
			tmp = tmp.next;
		}
		tmp.next = head.next;
		head.next = tmp;
		tmp2.next = null;

	}

	public boolean hasCycle(ListNode head) {
		if (head == null) {
			return false;
		}
		ListNode listNode = head;
		while (listNode != null && listNode.next != null) {
			head = head.next;
			listNode = listNode.next.next;
			if (head == listNode) {
				return true;
			}

		}
		return false;

	}

	public void printList(ListNode pHead) {
		while (pHead != null) {

			System.out.print(pHead.val + " ");
			pHead = pHead.next;
		}
		System.out.println();
	}

	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null) {
			return null;
		}
		ListNode fast = head;
		ListNode slow = head;
		ListNode first = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				while (first.next != null) {
					ListNode tmp = fast;
					fast = fast.next;
					while (fast != tmp) {
						if (first.next == fast) {
							return first.next;
						} else {
							fast = fast.next;
						}
					}
					first = first.next;

				}
			}
		}

		return null;

	}

	public ListNode lastKNode(ListNode head, int k) {
		if (k == 0||head==null) {
			return null;
		}
		ListNode pAhead = head;
		ListNode pBehind = head;
		for (int i = 0; i < k; i++) {
			if (pAhead.next==null) {
				return null;
			}
			pAhead = pAhead.next;
		}

		while (pAhead != null) {
			pBehind = pBehind.next;
			pAhead = pAhead.next;

		}
		return pBehind;
	}
	
	public void reveList(ListNode pHead){
		ListNode pNode=pHead;
		ListNode pPre=null;
		ListNode pReverseHead=null;
		
		while (pNode!=null) {

				ListNode pNext=pNode.next;
				if (pNext==null) {
					pReverseHead=pNode;
				}
				pPre=pNode;
				pNode.next=pPre;
				pPre=pNode;
				pNode=pNext;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	public ListNode reverseList(ListNode head){
		ListNode reverseHead=null;
		ListNode pPrev=null;
		ListNode pNode=head;
		while (pNode!=null) {
			ListNode pNext=pNode.next;
			if (pNext==null) {
				reverseHead=pNode;
			}
			pNode.next=pPrev;
			pPrev=pNode;
			pNode=pNext;
		}
		return null;
	}
	
	public ListNode mergeList(ListNode head1,ListNode head2){
		if (head1==null) {
			return head2;
		}
		if (head2==null) {
			return head1;
		}
		
		ListNode pMergeNode=null;
		
		if(head1.val<head2.val){
			pMergeNode=head1;
			pMergeNode.next=mergeList(head1.next, head2);
		}else {
			pMergeNode=head2;
			pMergeNode.next=mergeList(head1, head2.next);	
		}
		
		
		
		return pMergeNode;
	}
	
	public void sortList(ListNode pHead) {
		ListNode pAhead = pHead;
		ListNode pNode = null;
		ListNode preAhead = null;
		ListNode preBehind = null;
		while (pAhead.next != null) {
			preAhead = pAhead;
			pAhead = pAhead.next;
			pNode = pHead;
			while (pNode.next != pAhead) {
				preBehind = pNode;
				pNode = pNode.next;
				if (pNode.val < pAhead.val) {
					preAhead.next = pAhead.next;
					pAhead.next = preBehind.next;
					preBehind.next = pAhead;
				}
			}
		}
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeetList leetList = new LeetList();
		String[] vals = new String("1,2,3,4,5").split(",");
		ListNode head = leetList.createList(vals);

		ListNode listNode1 = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		ListNode listNode3 = new ListNode(3);
		ListNode listNode4 = new ListNode(4);
		ListNode listNode5 = new ListNode(5);
		ListNode listNode6 = new ListNode(6);
		leetList.backOrderPrint(head);
//		leetList.printList(head);
//		leetList.lastKNode(head, 2);
//		leetList.sortList(head);
//		leetList.revereList(head);
		leetList.printList(leetList.revereList(head));
		// head=listNode1;
		// head.next=listNode2;
		// listNode2.next=listNode3;
		// listNode3.next=listNode4;
		// listNode4.next=listNode5;
		// listNode4.next=listNode3;
		// System.out.println(head);
		// leetList.reorderList(head);
		// System.out.println(head);
		// System.out.println(leetList.hasCycle(head));
		// ListNode lNode=leetList.detectCycle(head);
		// System.out.println(lNode.val);
		// System.out.println(leetList.copyRandomList(head));
	}

}

class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}

	@Override
	public String toString() {
		return "RandomListNode [label=" + label + ", next=" + next + ", random=" + random + "]";
	}

};

class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int x) {
		val = x;
	}

	@Override
	public String toString() {
		return "TreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}

	@Override
	public String toString() {
		return "ListNode [val=" + val + ", next=" + next + "]";
	}

}
