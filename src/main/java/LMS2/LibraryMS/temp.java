//package LMS2.LibraryMS;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.scheduling.annotation.EnableAsync;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.concurrent.CompletableFuture;
//
//@SpringBootApplication
//@EnableAsync
//public class Task2 {
//
//    public static void main(String[] args) {
//        SpringApplication.run(ExpressionEvaluationApplication.class, args);
//    }
//}
//
//@Component
//class ExpressionEvaluator {
//
//    private final RestTemplate restTemplate;
//
//    public ExpressionEvaluator(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }
//
//    @Async
//    public CompletableFuture<String> evaluateExpression(String expression) {
//        // Make the API call to evaluate the expression
//        String apiUrl = "http://api.mathjs.org/v4/" + expression;
//        String result = restTemplate.getForObject(apiUrl, String.class);
//        return CompletableFuture.completedFuture(result);
//    }
//}
//
//@Component
//class ExpressionProcessor {
//
//    private final ExpressionEvaluator expressionEvaluator;
//
//    public ExpressionProcessor(ExpressionEvaluator expressionEvaluator) {
//        this.expressionEvaluator = expressionEvaluator;
//    }
//
//    public void processExpressions(List<String> expressions) {
//        int batchSize = 50;
//        int rateLimit = 50;
//        int totalExpressions = expressions.size();
//
//        // Process expressions in batches
//        for (int i = 0; i < totalExpressions; i += batchSize) {
//            int endIndex = Math.min(i + batchSize, totalExpressions);
//            List<String> batch = expressions.subList(i, endIndex);
//
//            // Evaluate expressions asynchronously
//            List<CompletableFuture<String>> futures = evaluateExpressionsAsync(batch);
//
//            // Wait for all evaluations to complete
//            CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
//
//            // Retrieve the results from the completed futures
//            List<String> results = futures.stream()
//                    .map(CompletableFuture::join)
//                    .toList();
//
//            // Display the results on the console
//            for (int j = 0; j < results.size(); j++) {
//                String expression = batch.get(j);
//                String result = results.get(j);
//                System.out.println(expression + " => " + result);
//            }
//
//
//        }
