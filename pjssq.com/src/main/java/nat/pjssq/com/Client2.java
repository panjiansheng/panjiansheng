package nat.pjssq.com;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client2 {

    /**
     * Socket客户端
     */
    public static void main(String[] args) {
        try {
            //创建Socket对象
            Socket socket=new Socket("localhost",9999);
            

            
            InputStream inputStream=socket.getInputStream();//获取一个输入流，接收服务端的信息
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream);//包装成字符流，提高效率
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);//缓冲区
            String info="";
            String temp=null;//临时变量
            while((temp=bufferedReader.readLine())!=null){
                info+=temp;
                System.out.println("客户端接收服务端发送信息："+info);
            }
            
            //关闭相对应的资源
            bufferedReader.close();
            inputStream.close();

            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}