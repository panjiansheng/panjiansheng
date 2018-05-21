package leetlist;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

public class LeetList {
	
	
	public ListNode	 createList(String[] vals) {
		ListNode head=new ListNode(Integer.parseInt(vals[0]));
		ListNode tmp=head;
		for (int i=1;i<vals.length;i++) {
			Integer val=Integer.parseInt(vals[i]);
			tmp.next=new ListNode(val);
			tmp=tmp.next;
		}
		
		return head;
	}

	public ListNode copyRandomList (ListNode head)  {
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
		}}
//		RandomListNode randomListNode = new RandomListNode(head.label);
//		RandomListNode headNew = randomListNode;
//		while (head.next != null) {
//			RandomListNode tmp = new RandomListNode(head.next.label);
//			randomListNode.next = tmp;
//
//			if (head.random != null) {
//				RandomListNode tmp2 = new RandomListNode(head.random.label);
//				randomListNode.random = tmp2;
//			}
//			head = head.next;
//			randomListNode = randomListNode.next;
//
//		}
//		return headNew;

	


	public TreeNode sortedListToBST(ListNode head) {
		return null;

	}
	
    public ListNode sortList(ListNode head) {
    	while (head.next!=null) {
			
		}
		return head;
        
    }
    
    public void reorderList(ListNode head) {
    	if (head==null|head.next==null) {
			return;
		}
    	ListNode tmp=head;
    	ListNode tmp2=null;
        while (tmp.next!=null) {
        	tmp2=tmp;
			tmp=tmp.next;
		}
        tmp.next=head.next;
        head.next=tmp;
        tmp2.next=null;
        
    }
    
    public boolean hasCycle(ListNode head) {
    	if (head==null) {
			return false;
		}
    	ListNode listNode=head;
    	while ( listNode!=null && listNode.next !=null) {
    		head=head.next;
    		listNode=listNode.next.next;
    		if (head==listNode) {
				return true;
			}
    		
    	}
		return false;
        
    }
    
    public ListNode detectCycle(ListNode head) {
    	if (head==null||head.next==null) {
			return null;
		}
    	ListNode fast=head;
    	ListNode slow=head;
    	ListNode first=head;
    	while (fast!=null&&fast.next!=null) {
			fast=fast.next.next;
			slow=slow.next;
			if (fast==slow) {
				while (first.next!=null) {
					ListNode tmp=fast;
					fast=fast.next;
					while (fast!=tmp) {
						if (first.next==fast) {
							return first.next;
						}else {
							fast=fast.next;
						}
					}
					first=first.next;

				}
			}
		}
    	
		return null;
        
    }
    
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeetList leetList=new LeetList();
		String[] vals=new String("1,2,3,4,5,3").split(",");
		ListNode head=leetList.createList(vals);

		ListNode listNode1=new ListNode(1);
		ListNode listNode2=new ListNode(2);
		ListNode listNode3=new ListNode(3);
		ListNode listNode4=new ListNode(4);
		ListNode listNode5=new ListNode(5);
		ListNode listNode6=new ListNode(6);
//		head=listNode1;
//		head.next=listNode2;
//		listNode2.next=listNode3;
//		listNode3.next=listNode4;
//		listNode4.next=listNode5;
//		listNode4.next=listNode3;
		//System.out.println(head);
		//leetList.reorderList(head);
		//System.out.println(head);
//		System.out.println(leetList.hasCycle(head));
//		ListNode lNode=leetList.detectCycle(head);
//		System.out.println(lNode.val);
		System.out.println(leetList.copyRandomList(head));
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
