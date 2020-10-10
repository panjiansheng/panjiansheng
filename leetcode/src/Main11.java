import java.sql.Date;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.CountDownLatch;




public class Main11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main11 main = new Main11();
		main.exec3();
		// System.out.println("good".substring(1, 4));
		// main.dfs("good");
	}

	public void exec3() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int len=scanner.nextInt();
			int ap=scanner.nextInt();
			int ax=scanner.nextInt();
			int adir=scanner.nextInt();
			int bp=scanner.nextInt();
			int bx=scanner.nextInt();
			int bdir=scanner.nextInt();
			
			if (ax>bx) {
				int tx=ax;
				int tp=ap;
				int tdir=adir;
				ax=bx;
				ap=bp;
				adir=bdir;
				bx=tx;
				bp=tp;
				bdir=tdir;
			}
			
			int sum=0;
			if (bx+bdir*bp>=len&&bdir>0) {
				sum+=1;
			}
			if (ax+adir*ap<0&&adir<0) {
				sum+=1;
			}
			if (adir==bdir&&adir>0) {
				if (bx+bp>=len) {
					sum+=1;
					if (ax+ap>=len) {
						sum+=1;
					}
				}
				
			}
			System.out.println(sum);
		}
		scanner.close();
	}

	public void exec2() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			xout = scanner.nextInt();
			yout = scanner.nextInt();
			int[][] data = new int[n][m];
			for (int i = 0; i < data.length; i++) {
				for (int j = 0; j < data[0].length; j++) {
					data[i][j] = scanner.nextInt();
				}
			}
			map = new int[n][m];
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[0].length; j++) {
					if (data[i][j] != 0) {
						map[i][j] = 1;
					}
					for (int k = 0; k < data[i][j]; k++) {
						if (i - k >= 0) {
							map[i - k][j] = 1;
						}
						if (i + k < data.length) {
							map[i + k][j] = 1;
						}
						if (j - k >= 0) {
							map[i][j - k] = 1;
						}
						if (j + k < data[0].length) {
							map[i][j + k] = 1;
						}
					}
				}
			}
			
			bfs(new Point(x, y), new Point(xout, yout), map);
			//System.out.println(num);
			

		}
		scanner.close();
	}
	
	
	
	int[][] map=null;

	int num=Integer.MAX_VALUE;
	int xout,yout;
	public void dfs(int[][] data,int x,int y,int s) {
		//System.out.println(new Point(x, y));
		if (x<0||y<0||x>=data.length||y>=data[0].length) {
			return;
		}
		if (map[x][y]==1) {
			return;
		}
		if (x==xout&&y==yout) {
			num=s<num?s:num;
		}
		
		s++;
		data[x][y]=1;
		dfs(data, x-1, y, s);
		dfs(data, x+1, y, s);
		dfs(data, x, y-1, s);
		dfs(data, x, y+1, s);
		data[x][y]=0;
	
		
	}
	
	int[][] dir=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
	public void bfs(Point s,Point e,int[][] map) {
		Queue<Point> queue=new ArrayDeque<>();
		
		s.step=0;
		map[s.x][s.y]=1;
		queue.add(s);
		while (!queue.isEmpty()) {
			s=queue.poll();
			if (s.x==xout&&s.y==yout) {
				System.out.println(s.step);
				return;
			}
			for (int i = 0; i < 4; i++) {
				Point t=new Point(0, 0);
				t.x=s.x+dir[i][0];
				t.y=s.y+dir[i][1];
				if (t.x<0||t.x>=map.length||t.y<0||t.y>=map[0].length) {
					continue;
				}
				if (map[t.x][t.y]==0) {
					t.step=s.step+1;
					map[t.x][t.y]=1;
					queue.add(t);
				}
			}
		}
		
		System.out.println("-1");

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

	public void exec() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int H = scanner.nextInt();
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			int h = scanner.nextInt();
			int s = scanner.nextInt();
			float sum = 0;
			// for (int i = 0; i < s; i++) {
			// if (sum<h) {
			// sum+=x;
			// }else if (sum>H) {
			// sum=H;
			// }else if(sum>=h&&x>=y){
			// sum=sum+x-y;
			// }else if(sum==h&&x<y){
			// sum=h;
			// }
			// }
			// System.out.println((float)h/x);
			if (x < y) {
				if (s > (float) h / x) {
					sum = h;
				} else {
					sum = x * s;
				}
			} else if (x >= y) {
				float t = (float) h / x;
				if (s <= t) {
					sum = x * s;
				} else if (s > t) {
					sum += x * t + (x - y) * ((float) s - t);
				}
			}
			if (sum > H) {
				sum = H;
			}
			int res = Math.round(sum);

			System.out.println(res);
		}
		scanner.close();
	}

}
