package com.pra.dp.sing;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingletonClient {

	public static void main(String[] args) throws InterruptedException {
		
		CountDownLatch latch = new CountDownLatch(1);		
		ExecutorService es = Executors.newFixedThreadPool(200);
		
		for(int i = 0; i< 20000; i++) {
			es.execute(new Thread(new Client(latch)));
		}
		//Thread.sleep(1000);
		latch.countDown();
		
		es.shutdown();

	}

}

class Client implements Runnable{
	CountDownLatch latch = null;
	public Client(CountDownLatch latch) {
		this.latch = latch;		
	}
	
	@Override
	public void run() {
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Singleton s = Singleton.getInstance();
		System.out.println(s);
	}
}
