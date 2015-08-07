package com.hand.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriter {
	public static void main(String[] args) {
		try {
			
			
			//非常便捷地操作纯文本数据，若想要写出原始的字节流，推荐使用FileInputStream
			FileReader fr = new FileReader("test.txt");
			BufferedReader br = new BufferedReader(fr);
			
			
			FileWriter fw = new FileWriter("new_text.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			
			String line;
			while ((line = br.readLine())!=null) {
				bw.write(line+"\n");
			}
			bw.flush();
			
			bw.close();
			fw.close();
			br.close();
			fr.close();
		System.out.println("done");
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
