import java.util.*;
import java.util.Map.Entry;
import java.lang.*;

public class Main2{
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            String s=scanner.nextLine();
            String[] data=s.split(" ");
            Map<String,Integer> map=new HashMap<>();
            if(map.containsKey(s)){
                map.put(s,map.get(data[0])+1);
            }else{
                map.put(s,1);
            }
            
            Set<Map.Entry<String,Integer>> set=map.entrySet();
            List<Entry<String,Integer>> list=new ArrayList<>();
            for(Map.Entry<String,Integer> entry:set){
				list.add(entry);
            }
            for(int i=0;i<list.size();i++){
                for(int j=1;j<list.size();j++){
                    
                    if(list.get(j).getValue()>list.get(j-1).getValue()){
                        Entry<String,Integer> t=list.get(j-1);
                        list.set(j-1,list.get(j));
                        list.set(j,t);
                    }
                }
            }
            
            for(int i=0;i<list.size()&&i<8;i++){
                String key=list.get(i).getKey().split(" ")[0];
                String line=list.get(i).getKey().split(" ")[1];
                int value=list.get(i).getValue();
                if(key.length()>16){
                    System.out.println(key.substring(key.length()-16,key.length())+" "+line+" "+value);
                }
                else {
                	System.out.println(key.substring(0,key.length())+" "+line+" "+value);
                }
            }
            
        }
    }
    

}