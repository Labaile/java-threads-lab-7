import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static Callable<Integer> getCallableInteger(Scanner sc) {
        return (new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return sc.nextInt();
            }
        });
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        int val = executor.submit(getCallableInteger(new Scanner(System.in))).get();
        executor.shutdown();
    }

}