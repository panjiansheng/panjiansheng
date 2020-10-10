package zte;

import java.io.File;
import java.util.Scanner;

public class FileUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String graphFilePath;
        if(args.length == 0)
            graphFilePath = "data.txt";
        else
            graphFilePath = args[0];
        
        String graphContent = FileUtil.read(graphFilePath);
        NonDirectedGraph graph = new NonDirectedGraph(graphContent);
        graph.unweightedShortestPath();
        graph.showDistance();
	}

	
	public static String read(String graphFilePath) {
			StringBuilder sb=new StringBuilder();
			Scanner scanner=null;
			try {
				scanner=new Scanner(new File(graphFilePath));
			} catch (Exception e) {
				// TODO: handle exception
			}
			while (scanner.hasNext()) {
				//System.out.println(scanner.nextLine());
				sb.append(scanner.nextLine()).append("\n");
			}
			String res= sb.substring(0,sb.length()-1).toString();
			System.out.println(res);
			scanner.close();
			return res;
	}
}
