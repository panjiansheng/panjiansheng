package nat.pjssq.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Connections {

	
    public static void main(String[] args) {
		init();
	}
	public static void init() {

		try {
			ServerSocket serverSocket1 = new ServerSocket(8888);

			ServerSocket serverSocket2 = new ServerSocket(9999);

			System.out.println("服务端已启动，等待客户端连接..");
			while (true) {
				Socket socket1 = serverSocket1.accept();// 侦听并接受到此套接字的连接,返回一个Socket对象
				while (true) {
					Socket socket2 = serverSocket2.accept();
					// 根据输入输出流和客户端连接
					InputStream inputStream = socket1.getInputStream();// 得到一个输入流，接收客户端传递的信息
					InputStreamReader inputStreamReader = new InputStreamReader(inputStream);// 提高效率，将自己字节流转为字符流
					BufferedReader bufferedReader = new BufferedReader(inputStreamReader);// 加入缓冲区
					String temp = null;
					String info = "";
					while ((temp = bufferedReader.readLine()) != null) {
						info += temp;
						System.out.println(info);
						OutputStream outputStream = socket2.getOutputStream();// 获取一个输出流，向服务端发送信息
						PrintWriter printWriter = new PrintWriter(outputStream);// 将输出流包装成打印流
						printWriter.println(temp);
						printWriter.flush();
						System.out.println("已接收到客户端连接");
						System.out.println(
								"服务端接收到客户端信息：" + info + ",当前客户端ip为：" + socket1.getInetAddress().getHostAddress());
					}
					

					OutputStream outputStream = socket1.getOutputStream();// 获取一个输出流，向服务端发送信息
					PrintWriter printWriter = new PrintWriter(outputStream);// 将输出流包装成打印流
					printWriter.print("你好，服务端已接收到您的信息");
					printWriter.flush();
					socket1.shutdownOutput();// 关闭输出流

					// 关闭相对应的资源
					printWriter.close();
					outputStream.close();
					bufferedReader.close();
					inputStream.close();

				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
