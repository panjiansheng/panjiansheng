package huawei;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Map.Entry;

public class Main {

	public static void main(String[] args) {
		Main huawei=new Main();
//		huawei.numberOfOne();
//		huawei.likeValue();
//		huawei.intBack();
//		huawei.stringBack();
//		huawei.Nsum();
//		huawei.lengthOfLastString();
//		huawei.calCharNum();
//		huawei.mingmingRandom();
//		huawei.sortTable();
//		huawei.noRepetInt();
//		huawei.calCharacterNum();
//		huawei.backSentense();
//		huawei.sortString();
		huawei.movePoint();
	}
	
	
	//识别有效IP地址和掩码并进行分类统计
	public void verifyIP(){
		Scanner scanner=new Scanner(System.in);
		ArrayList<String> list=new ArrayList<>();
		while (scanner.hasNext()) {
			list.add(scanner.nextLine());
		}
		Integer dInteger;
	}
	 
	//坐标移动
	public void movePoint(){
		Scanner scanner=new Scanner(System.in);
		while (scanner.hasNext()) {
			String data=scanner.nextLine();
			String[] ds=data.split(";");
			int x=0;
			int y=0;
			for (int i = 0; i < ds.length; i++) {
				if (!ds[i].equals("")&&movePointVerify(ds[i])) {
					char[] chs=ds[i].toCharArray();
					int t=Integer.parseInt(ds[i].substring(1, ds[i].length()));
					switch (chs[0]) {
					case 'A':
						x=x-t;
						break;

					case 'D':
						x=x+t;
						break;
						case 'W':
							y=y+t;
							break;
						case 'S':
							y=y-t;
							break;
					default:
						break;
					}
				}
			}
			System.out.println(x+","+y);
			
		}
	}
	
	public boolean movePointVerify(String data){
		//System.out.println(data);
		char[] chs=data.toCharArray();
		Character[] preDef={'A','D','W','S'};
	List<Character> preList= Arrays.asList('A','D','W','S');
		if (chs.length>3) {
			return false;
		}
		if(!preList.contains(chs[0]))return false;
		for (int i = 1; i < chs.length; i++) {
			if (chs[i]>'9'||chs[i]<'0') {
				return false;
			}
		}
		return true;
	}
	
	
	//字符串字典排序
	public void sortString(){
		Scanner scanner=new Scanner(System.in);
		while (scanner.hasNext()) {

			int n=scanner.nextInt();
			scanner.nextLine();
			ArrayList<String> list=new ArrayList<>();
			for(int i=0;i<n;i++){
				list.add(scanner.nextLine());
			}
			for(int i=0;i<n;i++){
				for (int j = 1; j < n-i; j++) {
					if (list.get(j).compareTo(list.get(j-1))<0) {
						String t=list.get(j-1);
						list.set(j-1, list.get(j));
						list.set(j, t);
					}
				}
			}
			for (String string : list) {
				System.out.println(string);
			}
			
		}
	}
	
	//句子逆序
	public String reverse(String sentence){
			String data=sentence;
			String[] ds=data.split(" ");
			StringBuffer sb=new StringBuffer();
			for(int k=ds.length-1;k>0;k--){
				sb.append(ds[k]+" ");
			}
			sb.append(ds[0]);
			return sb.toString();

	}
	
	//句子逆序
	public void backSentense(){
		Scanner scanner=new Scanner(System.in);
		while (scanner.hasNext()) {
			String data=scanner.nextLine();
			String[] ds=data.split(" ");
			for(int k=ds.length-1;k>=0;k--){
				System.out.print(ds[k]+" ");
			}
			System.out.println();
		}

	}
	
	//字符个数统计
	public void calCharacterNum(){
		Scanner scanner=new Scanner(System.in);
		while (scanner.hasNext()) {
			String data=scanner.nextLine();
			int num=0;
			char[] ds=data.toCharArray();
			Set<Character> set=new HashSet<>();
			for(int i=0;i<ds.length;i++){
				int tmp=(int)ds[i];
				if (tmp>=0&&tmp<=127) {
					set.add(ds[i]);
				}
			}
				
			System.out.println(set.size());
		}
	}
	
	//提取不重复的正数
	public void noRepetInt() {
		Scanner scanner=new Scanner(System.in);
		while (scanner.hasNext()) {
			Integer data=scanner.nextInt();
			Integer result=0;
			int index=0;
			Set<Integer> set=new HashSet<>();
			while (data!=0) {
				int num=data%10;
				if (!set.contains(num)) {
					set.add(num);
					result=(int) (result+num*Math.pow(10, index));
					index++;
				}
				data=data/10;
			}
			char[] ds=result.toString().toCharArray();
			int low=0;int high=ds.length-1;
			while (low<high) {
				char tmp=ds[low];
				ds[low]=ds[high];
				ds[high]=tmp;
				low++;
				high--;
			}
			String t=new String(ds);
			result=Integer.parseInt(t);
			System.out.println(result);
		}
	}
	
	
	public void sortTable(){
		Scanner scanner=new Scanner(System.in);
		Map<Integer, Integer> map=new TreeMap<>();
		while (scanner.hasNext()) {
			int n=scanner.nextInt();
			for (int i = 0; i < n; i++) {

				int key=scanner.nextInt();
				int value=scanner.nextInt();
				if (!map.containsKey(key)) {
					map.put(key, value);
				}else {
					map.put(key, map.get(key)+value);
				}
			}
			Set<Entry<Integer, Integer>> set=map.entrySet();
			Iterator<Entry<Integer, Integer>> it=set.iterator();
			for (Entry<Integer, Integer> entry : set) {
				System.out.println(entry.getKey()+" "+entry.getValue()	);
			}
		}
	}
	
	public void mingmingRandom(){
		Scanner scanner=null;
		try {
			scanner = new Scanner(new File("resource/mingmingRandom.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int n=scanner.nextInt();
		Set<Integer> set=new HashSet<>();
		ArrayList<Integer> list=new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int data=scanner.nextInt();
			set.add(data);
			
		}
		Object[] data=set.toArray();
		n=data.length;
		for(int i=0;i<n;i++){
			for(int j=1;j<n-i;j++){
				if ((int)data[j]<(int)data[j-1]) {
					swap(data, j, j-1);
				}
			}
		}
		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i]);
		}
		scanner.close();
		
		
	}
	
	//明明的随机数
	public void mingmingRandom2(){
		Scanner scanner=null;
		try {
			scanner = new Scanner(new File("resource/mingmingRandom.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (scanner.hasNext()) {
			int n=scanner.nextInt();
			Map<Integer, Integer> map=new HashMap<>();
			for (int i = 0; i < n; i++) {
				int data=scanner.nextInt();
				if (!map.containsKey(data)) {
					map.put(data, 1);
				}else {
					map.put(data,map.get(data)+1);
				}
			}
			
			Set<Entry<Integer, Integer>> entries=map.entrySet();
			Iterator<Entry<Integer, Integer>> it=entries.iterator();
			Integer[] ct=new Integer[entries.size()];
			Integer[] data=new Integer[entries.size()];
			int index=0;
			while (it.hasNext()) {
				Map.Entry<java.lang.Integer, java.lang.Integer> entry = (Map.Entry<java.lang.Integer, java.lang.Integer>) it
						.next();
				data[index]=entry.getKey();
				ct[index]=entry.getValue();
				index++;
			}
			n=data.length;
			for(int i=0;i<n;i++){
				for(int j=1;j<n-i;j++){
					if (ct[j]>ct[j-1]) {
						swap(ct, j, j-1);
						swap(data, j, j-1);
					}
				}
			}
			
			for (int i = 0; i < ct.length; i++) {
				System.out.println(data[i]);
			}
		}

		scanner.close();
	}
	
	
	public void swap(Object[] data,int a,int b){
		Object t=data[a];
		data[a]=data[b];
		data[b]=t;
	}
	
	public void calCharNum(){
		Scanner scanner=new Scanner(System.in);
		String data=scanner.nextLine();
		Character ch=scanner.nextLine().toCharArray()[0];
		int count=0;
		for (int i = 0; i < data.length(); i++) {
			Character ch2=data.charAt(i);
			if (Character.toLowerCase(ch)==Character.toLowerCase(ch2)) {
				
				count++;
			}
		}
		System.out.println(count);
		scanner.close();
	}
	
	public void lengthOfLastString(){
		Scanner scanner=new Scanner(System.in);
		//String data=scanner.nextLine();
		String data="agdsg sdg";
		String[] da=data.split(" ");
		System.out.println(da[da.length-1].length());
	}
	
	
	public static int count(int m,int n){
		
		return 0;
	}
	

	
	
	public void stringBack(){
		Scanner scanner=new Scanner(System.in);
//		String data=scanner.nextLine();
		String data="agagd";
		for (int i = 0; i < data.length(); i++) {
			System.out.print(data.charAt(data.length()-i-1));
		}
	}
	
	public void intBack(){
		Scanner scanner=new Scanner(System.in);
		//Integer data=scanner.nextInt();
		Integer data=783;
		while (data!=0) {
			System.out.print(data%10);
			data=data/10;
		}
	}
	
	public void likeValue(){
		Scanner scanner=new Scanner(System.in);
		//float data=scanner.nextFloat();
		float data=7.5f;
		float tmp=(int)data;
		float result;
		if (data-tmp>=0.5f) {
			result=tmp+1;
		}else {
			result=tmp;
		}

		
		System.out.println((int)result);
	}
	
	
	public void numberOfOne(){
		Scanner scanner=new Scanner(System.in);
		//Integer data=scanner.nextInt();
		Integer data=7;
		int count=0;
		while (data!=0) {
			int tmp=data%2;
			if (tmp==1) {
				count++;
			}
			data=data>>1;
		}
		
		System.out.println(count);
	}
	

	public void print(Object o){
		System.out.println(o);
	}
}
