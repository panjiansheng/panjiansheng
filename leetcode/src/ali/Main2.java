package ali;
import java.util.*;
import java.lang.*;

public class Main2{
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            int n=scanner.nextInt();
            int d=scanner.nextInt();
            int[][] data=new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    data[i][j]=scanner.nextInt();
                }
            }
            int max1=-1,max2=-1,max3=-1,max4=-1;
            for(int i=0;i<n;i++){
                int tmp=0;
                for(int j=i;j<n-d;j++){
                    tmp+=data[i][j];
                }
                if(tmp>max1){
                    max1=tmp;
                }
            }
            for(int i=0;i<n;i++){
                int tmp=0;
                for(int j=i;j<n-d;j++){
                    tmp+=data[j][i];
                }
                if(tmp>max2){
                    max2=tmp;
                }
            }
            for(int i=0;i<=n-d;i++){
                int tmp=0;
                for(int j=0;j<d;j++){
                    tmp+=data[i+j][i+j];
                }
                if(tmp>max3){
                    max3=tmp;
                }
            }
            
             for(int i=0;i<d;i++){
                int tmp=0;
                for(int j=0;j<d;j++){
                    tmp+=data[i-j][i+j];
                }
                if(tmp>max4){
                    max4=tmp;
                }
            }
            System.out.println(Math.max(max1,max2));
            
            
            
		}
    }
}