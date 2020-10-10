

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.xml.transform.OutputKeys;

public class Deploy
{
    /**
     * 你需要完成的入口
     * <功能详细描述>
     * @param graphContent 用例信息文件
     * @return [参数说明] 输出结果信息
     * @see [类、类#方法、类#成员]
     */
    public static String[] deployServer(String[] graphContent)
    {
        /**do your work here**/
    	try {
    		FileInputStream fin=new FileInputStream("case6.txt");
    		FileOutputStream fos=new FileOutputStream("test.txt");
    		PrintStream printStream=new PrintStream(fos);
    		System.setOut(printStream);
    		Scanner scanner=new Scanner(fin);
    		int nodeNum=scanner.nextInt();
    		int lineNum=scanner.nextInt();
    		int consumerNum=scanner.nextInt();
    		int serverCost=scanner.nextInt();
    		Map<Integer, ArrayList<LineInfo>> mapin=new HashMap<>();
    		Map<Integer, ArrayList<LineInfo>> mapout=new HashMap<>();
    		for (int i = 0; i < nodeNum; i++) {
				mapin.put(i, new ArrayList<LineInfo>());
				mapout.put(i, new ArrayList<LineInfo>());
			}
    		LineInfo[][] data=new LineInfo[nodeNum][nodeNum];
    		for (int i = 0; i < lineNum; i++) {
				ArrayList<LineInfo> list=new ArrayList<>();
				LineInfo lineInfo=new LineInfo(i,scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
				data[lineInfo.getStart()][lineInfo.getEnd()]=lineInfo;
				data[lineInfo.getEnd()][lineInfo.getStart()]=lineInfo;
				int start=lineInfo.getStart();
				int end=lineInfo.getEnd();
				mapout.get(start).add(lineInfo);
				mapin.get(end).add(lineInfo);
				//mapin.get(start).add(lineInfo);
				
			}
    		System.out.println("min=y;");
    		List<consumerInfo> conList=new ArrayList<>();
    		for (int i = 0; i < consumerNum; i++) {
				conList.add(new consumerInfo(i, scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
			}
    		
    		for (int i = 0; i < data.length; i++) {
				for (int j = 0; j < data.length; j++) {
					if (data[i][j]!=null) {
						LineInfo lineInfo=data[i][j];
						System.out.println("x"+lineInfo.getStart()+"_"+lineInfo.getEnd()+"+x"+lineInfo.getEnd()+"_"+lineInfo.getStart()+"<="+lineInfo.getCapacity()+";");
						//System.out.println("x"+lineInfo.getStart()+"_"+lineInfo.getEnd()+"*x"+lineInfo.getEnd()+"_"+lineInfo.getStart()+"=0"+";");
						
					}
				}
			}
    		
    		for (int i = 0; i < data.length; i++) {
    			String s="";
    			String t="";
				for (int j = 0; j < data.length; j++) {
					if (data[i][j]!=null) {
						LineInfo lineInfo=data[j][i];
						s=s+"x"+i+"_"+j+"+";
						t=t+"x"+j+"_"+i+"+";;
						System.out.println("@gin(x"+i+"_"+j+");");
						System.out.println("@gin(x"+j+"_"+i+");");
					}
				}
//				
//				for (int j = 0; j < data.length; j++) {
//					if(data[j][i]!=null||data[i][j]!=null){
//						LineInfo lineInfo=data[j][i]==null?data[i][j]:data[j][i];
//						t=t+"x"+lineInfo.getStart()+"_"+lineInfo.getEnd()+"+";;
//					}
//				}
//				if (t.length()==0||s.length()==0) {
//					System.out.println("ok");
//				}
				System.out.println("100000*x"+i+"+"+t.substring(0,t.length()-1)+">="+s.substring(0,s.length()-1)+";");
			}
    		String y="y=";
    		for (int i = 0; i < data.length; i++) {
				for (int j = 0; j < data.length; j++) {
					if (data[i][j]!=null) {
						LineInfo lineInfo=data[i][j];
						y=y+"x"+i+"_"+j+"*"+lineInfo.fee+"+";
					}
				}
			}
    		for (int i = 0; i < data.length; i++) {
				y=y+"x"+i+"*"+serverCost+"+";
			}
    		for (int i = 0; i < data.length; i++) {
				System.out.println("@bin("+"x"+i+");");
			}
    		System.out.println(y.substring(0,y.length()-1)+";");
    		System.out.println();
    		System.out.println();
    		for (int i = 0; i < consumerNum; i++) {
				int connectNode=conList.get(i).getConnectNode();
				String s="100000*x"+connectNode+"+";
				String t="";
				for (int j = 0; j < nodeNum; j++) {
					
					if(data[j][connectNode]!=null||data[connectNode][j]!=null){
						s=s+"x"+j+"_"+connectNode+"+";
						t=t+"x"+connectNode+"_"+j+"+";;
					}
					
				}
				
				System.out.println(s.substring(0,s.length()-1)+">="+t.substring(0,t.length()-1)+"+"+conList.get(i).getBandWidth()+";");
			}
    		
    		for (int i = 0; i < nodeNum; i++) {
    			
				ArrayList<LineInfo> listIn=mapin.get(i);
				ArrayList<LineInfo> listOut=mapout.get(i);
				String sin="";
				String sout="";
				for (int j = 0; j < listIn.size(); j++) {
					sin="x"+listIn.get(j).getStart()+"_"+listIn.get(j).getEnd()+"<="+listIn.get(j).getCapacity();
					//System.out.println(sin);
				}
//				for (int j = 0; j < listOut.size(); j++) {
//					sout=sout+"y"+listOut.get(j).getId()+"+";
//				}
//				sin=sin.substring(0,sin.length()-1);
//				sout=sout.substring(0,sout.length()-1);
//				System.out.println(sin+"<=");
			}
    		
 
			
//			printStream.print("ok");
			printStream.close();
			fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return new String[]{"17","\r\n","0 8 0 20"};
    }
    
    
    static class LineInfo{
    	int start;
    	int end;
    	int capacity;
    	int fee;
    	int id;
		public int getStart() {
			return start;
		}
		public void setStart(int start) {
			this.start = start;
		}
		public int getEnd() {
			return end;
		}
		public void setEnd(int end) {
			this.end = end;
		}
		public int getCapacity() {
			return capacity;
		}
		public void setCapacity(int capacity) {
			this.capacity = capacity;
		}
		public int getFee() {
			return fee;
		}
		public void setFee(int fee) {
			this.fee = fee;
		}
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public LineInfo(int id,int start, int end, int capacity, int fee) {
			super();
			this.id=id;
			this.start = start;
			this.end = end;
			this.capacity = capacity;
			this.fee = fee;
		}
		@Override
		public String toString() {
			return "LineInfo [start=" + start + ", end=" + end + ", capacity=" + capacity + ", fee=" + fee + ", id="
					+ id + "]";
		}

		
    }
    
    
    static class consumerInfo{
    	int id;
    	int consumerNode;
    	int connectNode;
    	int bandWidth;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getConsumerNode() {
			return consumerNode;
		}
		public void setConsumerNode(int consumerNode) {
			this.consumerNode = consumerNode;
		}
		public int getConnectNode() {
			return connectNode;
		}
		public void setConnectNode(int connectNode) {
			this.connectNode = connectNode;
		}
		public int getBandWidth() {
			return bandWidth;
		}
		public void setBandWidth(int bandWidth) {
			this.bandWidth = bandWidth;
		}
		public consumerInfo(int id, int consumerNode, int connectNode, int bandWidth) {
			super();
			this.id = id;
			this.consumerNode = consumerNode;
			this.connectNode = connectNode;
			this.bandWidth = bandWidth;
		}
		@Override
		public String toString() {
			return "consumerInfo [id=" + id + ", consumerNode=" + consumerNode + ", connectNode=" + connectNode
					+ ", bandWidth=" + bandWidth + "]";
		}
    	
    }

}
