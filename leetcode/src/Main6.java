import java.awt.Checkbox;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main6{

    /*请完成下面这个函数，实现题目要求的功能*/
    /*当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^ */
    /******************************开始写代码******************************/
    static int run(int[][] data){
		
    	return 0;
    }
   /******************************结束写代码******************************/

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] data=new int[3][3];
      
        String numbers = new String();
        int x=-1,y=-1;
        for(int rows=0; rows<3; rows++){
        	int j=0;
            for(String n: scan.nextLine().split(" ")){
                if (Integer.parseInt(n)==0) {
					x=rows;y=j;
				}
            	data[rows][j++]=Integer.parseInt(n);
                
            }
        }
 
//        int res = run(data);
      Main6 main=new Main6();
      main.dfs(data, x, y);
      System.out.println(main.result.size());
      int kk=1;
      kk++;
//        System.out.println(String.valueOf(res));
    }
    
    public static boolean check(int[][] data){
    	for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data.length; j++) {
				if (data[i][j]!=((i*3+j+1)%10)) {
					return false;
				}
			}
		}
    	
    	return true;
    }
    
    Stack<Integer> stack=new Stack<>();
    List<Integer> result=new ArrayList<>();
    int[][] map=new int[3][3];
    public void dfs(int[][] data,int x,int y) {
    	if (map[x][y]==1) {
			return;
		}
		if (check(data)) {
			if (stack.size()<result.size()||result.size()==0) {
				result=new ArrayList<>(stack);
				
			}
			return;
		}
		stack.push(data[x][y]);
//		data[x][y]=-Math.abs(data[x][y]);
		map[x][y]=1;
		if (x>0) {
			
			swap(data, x, y, x-1, y);
			
			dfs(data, x-1, y);
			swap(data, x, y, x-1, y);
		}
		if (x<2) {
			swap(data, x, y, x+1, y);
			dfs(data, x+1, y);
			swap(data, x, y, x+1, y);
		}
		if (y>0) {
			swap(data, x, y, x, y-1);
			dfs(data, x, y-1);
			swap(data, x, y, x, y-1);
		}
		if (y<2) {
			swap(data, x, y, x, y+1);
			dfs(data, x, y+1);
			swap(data, x, y, x, y+1);
		}
		stack.pop();
		map[x][y]=0;
	}
    
    
    public void swap(int[][] data,int x1,int y1,int x2,int y2) {
		int tmp=data[x1][y1];
		data[x1][y1]=data[x2][y2];
		data[x2][y2]=tmp;
	}
}

