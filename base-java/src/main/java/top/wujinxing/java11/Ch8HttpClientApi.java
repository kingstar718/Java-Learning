package top.wujinxing.java11;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * @author wujinxing
 * @date 2022-09-23
 */
@Slf4j
public class Ch8HttpClientApi {

    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create("https://www.hao123.com")).build();

        //同步
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        log.info("status:{}, sync:{}", response.statusCode(), response.body());

        //异步
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(s -> log.info("then accept: {}", s))
                .join();
    }

}
