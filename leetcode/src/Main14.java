//评测题目: 实现大整数乘法，大整数用10进制的字符串表示，要求空间复杂度O(N)，时间复杂度O(N^2)

import java.util.*;
import java.lang.*;
public class Main14{

  
  public static void main(String[] args){
//    String a="12345600";
//    String b="1234567989";
   // String b="0";
    Main14 main=new Main14();
    main.exec();
  }
  
  public void exec() {
	Scanner scanner=new Scanner(System.in);
	while (scanner.hasNext()) {
		Map<Character, List<Character>> parent=new HashMap<>();
		Map<Character, Character> name=new HashMap<>();
		String s=scanner.nextLine();
		String[] data=s.split(";");
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
	  
	  stack.push(name.get(cur));
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
  
  public String multi(String a,String b){
    List<String> list=new ArrayList<>();
    for(int i=0;i<b.length();i++){
      list.add(multiOne(a,b.charAt(b.length()-i-1), i));
    }
    return add(list);

  }


  public String add(List<String> data){
    String res="0";
    for(int i=0;i<data.size();i++){
      res=addTwo(data.get(i),res);
    }
    return res;
  }


  public String addTwo(String a,String b){
    int max=a.length()>b.length()?a.length():b.length();
    StringBuilder res=new StringBuilder();
    int more=0;
    for(int i=0;i<max;i++){
      int ta,tb,num;
      if(i>=a.length()){
        ta=0;
        tb=b.charAt(b.length()-i-1)-'0';
      }else if(i>=b.length()){
        ta=a.charAt(a.length()-i-1)-'0';
        tb=0;
      }else{
        ta=a.charAt(a.length()-i-1)-'0';
        tb=b.charAt(b.length()-i-1)-'0';
      }
      num=ta+tb+more;
      if(num>=10){
        more=1;
      }else{
       more=0; 
      }
//      if(num!=0||(num==0&&res.length()==0))res.insert(0,num%10); //之前的
      res.insert(0,num%10);                                  //修改后
    }
    if(more==1){
      res.insert(0,"1");
    }
    //如果不是所有位都是0，则直接返回结果，如果所有位都是0，返回"0"
    for (int i = 0; i < res.length(); i++) {
		if (res.charAt(i)!='0') {
			return res.toString();
		}
	}
    return "0";
  }

  public String multiOne(String a,char b,int zeroCount){
    int n=a.length();
    StringBuilder res=new StringBuilder();
    int more=0;
    for(int i=n-1;i>=0;i--){
      int num=(b-'0')*(a.charAt(i)-'0')+more;
      if(num>=10){
        more=num/10;
      }else{
        more=0;
      }
      res.insert(0,num%10);
    }
    if(more==1){
      res.insert(0,"1");
    }
    for(int i=0;i<zeroCount;i++)res.append("0");
    return res.toString();

  }
  

}







