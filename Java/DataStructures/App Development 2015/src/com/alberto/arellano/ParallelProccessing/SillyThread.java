package com.alberto.arellano.ParallelProccessing;

public class SillyThread extends Thread{
	//	An interface allows you to create a class that can only be used to
	//	do subclassing. When you do subclassing you can override methods
	public void run(){
		for (int i = 0; i < 3; i++) {
			System.out.println("Thread id: "
                               +Thread.currentThread().getName());
			try {
				Thread.currentThread().sleep(100);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args){
        	for (int threadCnt = 0; threadCnt < 3; threadCnt++) {
           		 SillyThread aSillyThread =  new SillyThread();
           		 aSillyThread.start();

       		 }
	}
}
