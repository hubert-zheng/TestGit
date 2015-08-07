package com.hand.test;

import java.io.File;

public class MultiWriterFile {
	static File file = new File("text.txt");
	
	public static void main(String[] args) {
		if(file.exists()){
			file.delete(); // 若当前文件不存在，RandomAccessFile都会自动创建文件，保证每次写入都是新的文件，不会被之前的版本影响
		}	
		new WriterFile(file, 1).start();
		new WriterFile(file, 2).start();
		new WriterFile(file, 3).start();
		new WriterFile(file, 4).start();
		new WriterFile(file, 5).start();
	}
}
