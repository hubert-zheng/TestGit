package com.hand.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class WriterFile extends Thread {
	File file;
	int block;
	int L = 100;
	/**
	 * File
	 *            |***        |+++
	 * |-----------***---------+++--------------------------|
	 * 		|---
	 */
	
	/**
	 * 1			2			 3			  4			   5(2)
	 * |------------|------------|------------|------------|------------|
	 *当前0xL			1xL
	 * 
	 * @param f
	 * @param b
	 */
	public WriterFile(File f,int b){
		this.file = f;
		this.block = b;
	}
	
	@Override
	public void run() {
		try {
		//通过这个类你可以读写到当前文件的任何一个位置	
		RandomAccessFile raf = new RandomAccessFile(file, "rw");//rw可读可写
		raf.seek((block-1)*L);
		raf.writeBytes("this is block:::"+block+"\n");
		
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
