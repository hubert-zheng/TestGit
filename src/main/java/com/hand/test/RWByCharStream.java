package com.hand.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class RWByCharStream {
	public static void main(String[] args) {
		try {
			//File file = new File("text.xml");
			FileInputStream fis = new FileInputStream("text.xml");//字节输入流
			FileOutputStream fos = new FileOutputStream("newtext.xml"); //字节输出流
			InputStreamReader isr = new InputStreamReader(fis,"UTF-8");//转换成字符输入流
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");//字符输出流
			
			BufferedReader br = new BufferedReader(isr);
//			BufferedWriter bw = new BufferedWriter(osw);//换行被忽略了
			PrintWriter pw = new PrintWriter(osw); //打印输出流
			//PrintWriter pw = new  PrintWriter(osw,true);//第二个参数表示在close之前自动调用flush方法，强制输出
			
			String input;
			while ((input = br.readLine())!= null) {
//				bw.write(input);  //换行被忽略了,可在最后+"\n"
				pw.println(input);
			}	
			pw.flush();//如果写出的数据没写满缓冲区时，pw缓冲流被关闭，则有可能造成数据丢失，所以在缓冲流关闭之前，调用flush()将缓冲区的内容强制输出
			
			br.close();
//			bw.close();
			pw.close();
			isr.close();
			fis.close();
			osw.close();
			fos.close();

			System.out.println("done");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
