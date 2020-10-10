
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;



public class Main21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main21 main=new Main21();
		main.exec2();
	}
	
	
	public void	 exec3(){
		Scanner scanner=new Scanner(System.in);
		while (scanner.hasNext()) {
			
		}
		scanner.close();
	}
	
	public void exec2() {
		Scanner scanner=new Scanner(System.in);
		while (scanner.hasNext()) {
			String s=scanner.nextLine();
			String[] data=s.split(",");
			int n=Integer.parseInt(data[0])	;
			long start=getTime(data[1]);
			long end=getTime(data[2]);
			if (n<3||end<start) {
				System.out.println("incorrect data");
				continue;
			}
			long bwt=(end-start)/1000;
			int count=1;
			int sum=0;
			boolean flag=true;
			while (flag) {
				for (int i = 1; i < n+1; i++) {
					sum+=5*60;
					if (sum>=bwt) {
						System.out.println(count+";"+i+"-"+i);
						flag=false;
						break;
					}
					
					sum+=10*60;
					if (sum>=bwt) {
						System.out.print(count+";"+i+"-");
						if(i!=n)System.out.println(n+1);
						else {
							System.out.println(1);
						}
						flag=false;
						break;
					}
				}

				count++;
			}

		}
		scanner.close();
	}
	
	public long getTime(String s) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long time=0;
		try {
			Date d=sdf.parse(s);
			//System.out.println(d);
			 time=d.getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return time;
		
	}
	
	public void exec() {
		Scanner scanner=new Scanner(System.in);
		while (scanner.hasNext()) {
			HashMap<Integer,Character> map=new HashMap<>();
			HashMap<Integer, List<Integer>> parent=new HashMap<>();
			String s=scanner.nextLine();
			String[] data=s.split(";");
			int start=1;
			try {
				for (int i = 0; i < data.length; i++) {
					String[] tmp=data[i].split(",");
					int id=Integer.parseInt(tmp[0]);
					Character ch=tmp[1].charAt(0);
					int par=Integer.parseInt(tmp[2]);
					map.put(id, ch);
					List<Integer> list=parent.get(par);
					if (list==null) {
						list=new ArrayList<>();
						
					}
					list.add(id);
					parent.put(par, list);
					if (par==0) {
						start=id;
					}
					
				}
				dfs(map, parent, start);
				System.out.println();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("incorrect data");
				stack.clear();
				end=false;
				continue;
			}

			
		}
		scanner.close();
	}
	
	Stack<Integer> stack=new Stack<>();
	boolean end=false;
	public void dfs(Map<Integer, Character> map,Map<Integer, List<Integer>> parent,int index) {
		stack.push(index);
		List<Integer> list=parent.get(index);
		if (list==null) {
			for (int i = 0; i < stack.size(); i++) {
				if (i!=0) {
					System.out.print("-");
				}
				System.out.print(map.get(stack.get(i)));
			}
			if(!end)System.out.print(";");
		}else {
			for (int i = 0; i < list.size(); i++) {
				if (i==list.size()-1) {
					end=true;
				}else {
					end=false;
				}
				dfs(map, parent, list.get(i));

			}
		}
		stack.pop();
	}

}
