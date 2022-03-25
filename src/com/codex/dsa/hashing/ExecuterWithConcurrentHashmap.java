package com.codex.dsa.hashing;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecuterWithConcurrentHashmap {

	public final static int thread = 3;
	public static Map<String, Integer> threadSafeMap = null;
	public static long averageTime = 0;

	public static void main(String[] args) throws InterruptedException {

		for (int i = 0; i < 10; i++) {

			threadSafeMap = new ConcurrentHashMap<>();
			long time = System.currentTimeMillis();
			ExecutorService service = Executors.newFixedThreadPool(thread);

			for (int j = 0; j < thread; j++) {
				service.execute(new Runnable() {

					@Override
					public void run() {

						for (int i = 0; i < 100000; i++) {
							Integer num = (int) Math.ceil(Math.random() * 100000);
/*							Integer value = threadSafeMap.get(String
									.valueOf(num));
*/							threadSafeMap.put(String.valueOf(num), num);
						}

					}
				});
			}
			
			service.shutdown();
            service.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
            long timeUsed = (System.nanoTime() - time) / 1000000L;
            averageTime += timeUsed;
            System.out.println("All threads are completed in "+ timeUsed + " ms");
		}
		
		System.out.println("The average time is " + averageTime / 10 + " ms");

	}

}
