package finalexam;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main2 main2=new Main2();
		main2.exec();
	}

	public void exec() {
		int[] data=new int[]{2,4,7,3,6};
//		insertSort(data);
//		selectSort(data);
		
		print(data);
	}
	
	public void quickSort() {
		
	}
	
	//选择排序
	public void selectSort(int[] data) {
		for (int i = 0; i < data.length; i++) {
			int minIndex=i;
			for (int j = i; j < data.length; j++) {
				if (data[j]<data[minIndex]) {
					minIndex=j;
				}
				
			}
			swap(data, minIndex, i);
		}
	}
	
	// 插入排序
	public void insertSort(int[] data) {
		for (int i = 1; i < data.length; i++) {
			int j = i - 1;
			int tmp = data[i];
			if (data[j] > data[i]) {
				while (j >= 0&&data[j]>tmp) {
					data[j + 1] = data[j];
					j--;
				}
				data[j + 1] = tmp;
			}
		}
	}
	
	public void swap(int[] data,int a,int b) {
		int t=data[a];
		data[a]=data[b];
		data[b]=t;
	}
	
	public void print(int[] data) {
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i]+" ");
		}
		System.out.println();
	}
	
}
