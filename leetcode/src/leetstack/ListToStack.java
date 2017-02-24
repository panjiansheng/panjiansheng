package leetstack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class ListToStack {

	public ArrayList<Integer> listA=new ArrayList<>();
	public ArrayList<Integer> listB=new ArrayList<>();
	
	public void checkString(){
		boolean result=true;
		String s="[][]()()[()]";
		HashMap<Character, Character> map=new HashMap<>();
		map.put(']', '[');
		map.put(')', '(');
		char[] chars=s.toCharArray();
		Stack<Character> stack=new Stack<>();
		for (int i = 0; i < chars.length; i++) {
			if (!stack.isEmpty()) {
				Character tmp=stack.lastElement();
				
				if (stack.lastElement()!=map.get(chars[i])) {
					System.out.println(tmp);
					stack.push(chars[i]);
				}else {
					stack.pop();
				}
			}else {
				stack.push(chars[i]);
			}

		}
		if (!stack.isEmpty()) {
			result=false;
		}
		
		System.out.println(result);
	}
	
	public void push(Integer data){
		listA.add(data);
	}
	
	public Integer pop(){
		for (int i = 0; i < listA.size(); i++) {
			
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a="北京市";
		ListToStack listToStack=new ListToStack();
		listToStack.checkString();
		System.out.println(a.substring(0,a.length()-1));
		
	}

}
