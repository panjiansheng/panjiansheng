import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main8 {
	public static void main(String[] args) {
		
		Main8 main=new Main8();
		main.solve();

	}
	

	public void solve() {
		Scanner scanner=new Scanner(System.in);
		while (scanner.hasNext()) {
			String s=scanner.nextLine();
			String[] data=s.split(" ");
			int[] nums=new int[data.length];
			for(int i=0;i<data.length;i++){
				nums[i]=Integer.parseInt(data[i]);
			}
			int k=scanner.nextInt();
			int[] heapData=new int[k];
			for(int i=0;i<k;i++){
				heapData[i]=nums[i];
			}
			buildHeap(heapData);
			for(int i=k;i<nums.length;i++){
				if(heapData[0]<nums[i]){
					heapData[0]=nums[i];
					heapMinify(heapData, 0, k);
				}
			}
			System.out.println(heapData[0]);
		}
	}
	
	
	public void buildHeap(int[] data){
		for(int i=data.length/2-1;i>=0;i--){
			heapMinify(data, i, data.length);
		}
	}
	
	public void heapMinify(int[] data,int index,int size) {
		int l=2*(index+1)-1;
		int r=2*(index+1);
		int largest=index;
		if(l<size&&data[l]<data[index]){
			largest=l;
		}
		if(r<size&&data[r]<data[largest]){
			largest=r;
		}
		if(largest!=index){
			swap(data, largest, index);
			heapMinify(data, largest, size);
		}
	}
	
	public void swap(int[] data, int i, int j) {
		int t = data[i];
		data[i] = data[j];
		data[j] = t;
	}

}