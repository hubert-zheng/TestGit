package com.hand.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * Hello world!
 *
 */

public class App 
{
	
    public static void main( String[] args )
    {	
    	try {
    		
			FileInputStream fis = new FileInputStream("mv.mp4");
			BufferedInputStream bis = new BufferedInputStream(fis,6000000);
			
			FileOutputStream fos = new FileOutputStream("new_mv.mp4");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			
			byte input[] = new byte[100000]; //存放读取到的字节流
			int count = 0; 
			long rbefore = System.currentTimeMillis();//输出从1970开始计算到当前时间点，所经历过的毫秒数
			while (bis.read(input) != -1) {
				bos.write(input); //写入文件
				count++;
			}
			bis.close();
			fis.close();
			bos.close();
			fos.close();
			System.out.println(System.currentTimeMillis()-rbefore+"ms--毫秒");
			System.out.println("读取了"+count+"次");
    	
    	} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    /**
     * 遍历文件夹
     * @param dir 需要遍历的文件夹
     * @param tab 文件夹缩进
     */
    public static void printFiles(File dir,int tab){
    	if(dir.isDirectory()){
    		File next[] = dir.listFiles(); //文件数组传入文件夹下文件或文件夹
    		for(int i =0;i<next.length;i++){
    			for(int j=0;j<tab;j++){
    				System.out.print("   "); //输出缩进
    			}
    			System.out.println(next[i].getName());//输出当前名称
    			if(next[i].isDirectory()){      //输出文件名
    				printFiles(next[i],tab+1);//递归调用当前文件夹下的文件
    			}
    		}
    	}
    }
}
