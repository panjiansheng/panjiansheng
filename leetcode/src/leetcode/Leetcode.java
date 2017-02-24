package leetcode;

import java.util.ArrayList;






public class Leetcode {

	
    public class ListNode {
        public int val;
        public ListNode next = null;

       public ListNode(int val) {
           this.val = val;
        }
    }
    
    

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

	public boolean Find(int[][] array, int target) {
		try {

			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array[0].length; i++) {
					if (array[i][j] == target) {
						return true;
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return false;
	}

	public String replaceSpace(StringBuffer str) {
		String temp = str.toString();
		return temp.replace(" ", "%20");
	}
	
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
    	if (listNode==null) {
			return new ArrayList<>();
		}
    	ArrayList<Integer> arrayList=new ArrayList<>();
    	ArrayList<Integer> tmp=new ArrayList<>();
    	while(listNode.next!=null){
    		arrayList.add(listNode.val);
    		listNode=listNode.next;
    	}
    	for(int i=0;i<arrayList.size();i++){
    		tmp.add(arrayList.get(arrayList.size()-1));
    	}
    	return tmp;
    }

	public static void main(String[] args) {
		int[][] array = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } };
		System.out.println(new Leetcode().Find(array, 7));
	}
}
