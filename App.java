
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Queue;

public class App {

    public static void main(String[] args) throws Exception {

        String apiKey = System.getenv("TWELVE_DATA_API_KEY");

        if (apiKey == null || apiKey.isEmpty()) {
            System.out.println("API key was not found.");
            return;
        }

        Queue<String> priceQueue = new LinkedList<>();

        HttpClient client = HttpClient.newHttpClient();

        while (true) {

            String url =
                "https://api.twelvedata.com/price?symbol=DIA&apikey="
                + apiKey;

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response =
                    client.send(
                        request,
                        HttpResponse.BodyHandlers.ofString()
                    );

            String responseBody = response.body();

            LocalDateTime timestamp = LocalDateTime.now();

            String result =
                    "Timestamp: " + timestamp
                    + " | DIA Price: "
                    + responseBody;

            priceQueue.add(result);

            System.out.println(result);
            System.out.println("Queue: " + priceQueue);
            System.out.println("-------------------------");

            Thread.sleep(15000);
        }
    }
}
