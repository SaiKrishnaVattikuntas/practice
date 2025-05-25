package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Employee;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.*;

public class CompletableFeature {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException, Exception {

        ObjectMapper mapper = new ObjectMapper();
        List<Employee> employeeList = mapper.readValue(new File("Employee.json"), new TypeReference<List<Employee>>() {
        });
        System.out.println(employeeList.size());
        employeeList.stream().forEach((employee) -> System.out.println(employee.getEmployeeId()));
        ExecutorService threadPoolExecutor = Executors.newFixedThreadPool(5);
        /*CompletableFuture completableFuture = CompletableFuture.runAsync(()-> System.out.println(Thread.currentThread().getName()+ " Running Async..."), threadPoolExecutor);
        completableFuture.get();
        CompletableFuture completableFuture1 = CompletableFuture.runAsync(()-> System.out.println(Thread.currentThread().getName()+ " Running Async..."));
        completableFuture1.get();*/
        CompletableFuture completableFuture2 = CompletableFuture.supplyAsync(()-> " Running Async...").thenApply(s->  s + "World" );
        CompletableFuture<String> future = CompletableFuture
                .supplyAsync(() -> "Hello")
                .thenApply(s -> s + " World")
                .thenApply(String::toUpperCase);
        System.out.println("Printing.." +  completableFuture2.get() +"   " + future.get());

    }
}
