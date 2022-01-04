package com.aksonenko.exercise3to4;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Demo {

	public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {

		ViolationHandler vHandler = new ViolationHandler();
		ExecutorService service = Executors.newFixedThreadPool(2);

		Future future = service.submit(new Callable() {
			public Object call() throws Exception {
				vHandler.printViolators();

				return "Done";
			}
		});

		Future future2 = service.submit(new Callable() {
			public Object call() throws Exception {
				vHandler.printOutFinesByAmount();

				return "Done";
			}
		});

		service.shutdown();
	}
}
