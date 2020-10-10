package ali;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.List;

public class FileTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileTest fileTest=new FileTest();
		//fileTest.fileTest();
		fileTest.steamByteTest();
		//fileTest.readerTest();
	}
	
	private void fileTest() {
		File file=new File("C://");
		if (file.isDirectory()) {
			String[] files=file.list();
			for (String string : files) {
				
				if (string.toLowerCase().endsWith(".bin")) {
					System.out.println(string);
				}
				
			}
		}
	}
	
	private void steamByteTest(){
		try {
			FileInputStream fin=new FileInputStream("c://"+"TI_InstallLog.txt");
			BufferedInputStream bin=new BufferedInputStream(fin);
			byte[] buff=new byte[100];
			int len;
			while ((len=bin.read(buff))!=-1) {
				System.out.write(buff,0,len);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	private void readerTest() {
		try {
			InputStreamReader reader=new InputStreamReader(new FileInputStream("c://"+"TI_InstallLog.txt"),"utf-16");
			BufferedReader bufferedReader=new BufferedReader(reader);
			char[] chars=new char[30];
			int count=0;
			String tString=null;
//			while ((tString=bufferedReader.readLine())!=null) {
//				//System.out.println(tString);
//			}
			while ((count=reader.read(chars))!=-1) {
				for (int i = 0; i < count; i++) {
					System.out.print(chars[i]);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
