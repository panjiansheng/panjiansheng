
import java.util.*;
import java.io.DataInput;
import java.lang.*;
public class Main15{

  
  public static void main(String[] args){

    Main15 main=new Main15();
    main.exec();
  }
  
  public void exec() {
	Scanner scanner=new Scanner(System.in);
	while (scanner.hasNext()) {
		Map<Character, List<Character>> parent=new HashMap<>();
		Map<Character, Character> name=new HashMap<>();
		stack.clear();
		result.clear();
		String s=scanner.nextLine();
		String[] data=s.split(";");
		for (int i = 0; i < data.length; i++) {
			data[i]=data[i].trim();
		}
		if (data.length<3) {
			System.out.println("incorrect data");
			continue;
		}
		for (int i = 0; i < data.length; i++) {
			name.put(data[i].charAt(0), data[i].charAt(2));
			if (parent.get(data[i].charAt(4))==null) {
				List<Character > list=new ArrayList<>();
				
				list.add(data[i].charAt(0));
				parent.put(data[i].charAt(4), list);
			}else {
				parent.get(data[i].charAt(4)).add(data[i].charAt(0));
			}
			
		}
		dfs('1', name, parent);
		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i));
			if(i!=result.size()-1)System.out.print(";");
		}
		System.out.println();
		
	}
	scanner.close();
}
  Stack<Character> stack=new Stack<>();
  List<String> result=new ArrayList<>();
  public void dfs(Character cur,Map<Character, Character> name,Map<Character, List<Character>> parent) {
	  
	  if(cur!=null){
		  stack.push(name.get(cur));
	  }else {
		return;
	}
	List<Character> childs=parent.get(cur);
	if (childs==null) {
		String tmp="";
		for (int i = 0; i < stack.size(); i++) {
			if(i!=0){
				tmp=tmp+"-"+stack.get(i);
			}else {
				tmp=""+stack.get(i);
			}
		}
		result.add(tmp);
		return;
	}
	for (int i = 0; i < childs.size(); i++) {
		
		dfs(childs.get(i), name, parent);
		stack.pop();
	}

}
  

  

}







