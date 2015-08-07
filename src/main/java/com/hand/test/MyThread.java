package com.hand.test;

public class MyThread extends Thread {
	
	private String name;
	
	public MyThread(String name){
		this.name = name;
	}

	@Override
	public void run() {
		for(int i = 0; i<10 ; i++){
			System.out.println(name+":"+i);
		}
//		super.run();  //不管是否调用父类RUN方法都可以运行线程
	}
	
	
}
