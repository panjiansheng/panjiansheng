package dfsbfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import javax.xml.crypto.Data;

public class Main {

	public static void main(String[] args) {
		Main dfsBfs=new Main();
		dfsBfs.migong();
		

	}
	
	public void migong(){
		Scanner scanner = new Scanner(System.in);
		int[][] data = init(scanner);
		dfs(data,0,0,1);
//		bfs(data);
//		dfsLoop(data);
		for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
	}

	public int[][] init(Scanner scanner) {

		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int[][] data = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				data[i][j] = scanner.nextInt();
			}
		}
		return data;

	}

	public void dfsLoop(int[][] data){
		int n = data.length;
		int m = data[0].length;
		int s=1;
		int num=Integer.MAX_VALUE;
		stack.push(new Point(0, 0,1));
		int count=0;
		while (!stack.isEmpty()) {
			Point tmp=stack.pop();
			
			if (tmp.pre!=null&&count==0) {
				data[tmp.pre.x][tmp.pre.y]=0;
			}
			if (data[tmp.x][tmp.y]==1) {
				continue;
			}
			if (tmp.x==n-1&&tmp.y==m-1) {
				System.out.println(tmp.step);
				if (s<num) {
					num=s;
					for (int i = 0; i < stack.size(); i++) {
						list.add(stack.get(i));
					}
				}
			}
			count--;
			data[tmp.x][tmp.y]=1;
			int step=tmp.step;
			if (tmp.x+1<n&&data[tmp.x+1][tmp.y]==0) {
				stack.push(new Point(tmp.x+1, tmp.y,step+1,tmp));
			}
			if (tmp.x-1>=0&&data[tmp.x-1][tmp.y]==0) {
				stack.push(new Point(tmp.x-1, tmp.y,step+1,tmp));
			}
			if (tmp.y+1<m&&data[tmp.x][tmp.y+1]==0) {
				stack.push(new Point(tmp.x, tmp.y+1,step+1,tmp));
			}
			if (tmp.y-1>=0&&data[tmp.x][tmp.y-1]==0) {
				stack.push(new Point(tmp.x, tmp.y-1,step+1,tmp));
			}
//			data[tmp.x][tmp.y]=0;
			System.out.println(tmp);
		}
	}
	
	Stack<Point> stack=new Stack<>();
	List<Point> list=new ArrayList<>();
	int num=Integer.MAX_VALUE;
	public void dfs(int[][] data,int x,int y,int s) {
		//System.out.println(new Point(x, y));
		int n = data.length-1;
		int m = data[0].length-1;
		
		if (x<0||y<0||x>n||y>m) {
			return;
		}
		if (data[x][y]==1) {
			return;
		}
		stack.push(new Point(x, y));
		if (x==n&&y==m) {
			if (s<num) {
				num=s;
				for (int i = 0; i < stack.size(); i++) {
					list.add(stack.get(i));
				}
			}
		}
		
		s++;
		data[x][y]=1;
		dfs(data, x-1, y, s);
		dfs(data, x+1, y, s);
		dfs(data, x, y-1, s);
		dfs(data, x, y+1, s);
		data[x][y]=0;
		stack.pop();
		
	}

	public void bfs(int[][] data) {
		int n = data.length;
		int m = data[0].length;
		int[][] map=new int[n][m];

		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(0, 0,1));
		int count = 0;
		int min = Integer.MAX_VALUE;
		int step=1;
		while (!queue.isEmpty()) {
			Point tmp = queue.poll();
			if (tmp.x==n-1&&tmp.y==m-1) {
				System.out.println(tmp.step);
				List<Point> res=new ArrayList<>();
				while(tmp!=null){
					res.add(tmp);
					tmp=tmp.pre;
					
				}
				for (int i = 0; i < res.size(); i++) {
					System.out.println(res.get(res.size()-1-i));
				}
				return;
			}
			step=tmp.step;
			data[tmp.x][tmp.y]=1;
			if (tmp.x+1<n&&data[tmp.x+1][tmp.y]==0) {
				queue.add(new Point(tmp.x+1, tmp.y,step+1,tmp));
			}
			if (tmp.x-1>=0&&data[tmp.x-1][tmp.y]==0) {
				queue.add(new Point(tmp.x-1, tmp.y,step+1,tmp));
			}
			if (tmp.y+1<m&&data[tmp.x][tmp.y+1]==0) {
				queue.add(new Point(tmp.x, tmp.y+1,step+1,tmp));
			}
			if (tmp.y-1>=0&&data[tmp.x][tmp.y-1]==0) {
				queue.add(new Point(tmp.x, tmp.y-1,step+1,tmp));
			}
//			step++;
//			System.out.println(tmp);

		}
		
		

	}

	class Point {
		int x;
		int y;
		int step;
		Point pre;
		
		public Point(int x, int y) {
			// TODO Auto-generated constructor stub
			this.x = x;
			this.y = y;
		}
		
		public Point(int x, int y,int level) {
			// TODO Auto-generated constructor stub
			this.x = x;
			this.y = y;
			this.step=level;
		}
		
		public Point(int x, int y,int level,Point pre) {
			// TODO Auto-generated constructor stub
			this.x = x;
			this.y = y;
			this.step=level;
			this.pre=pre;
		}

		@Override
		public String toString() {
			 return "("+x+","+y+")";
		}
		
	}
}
