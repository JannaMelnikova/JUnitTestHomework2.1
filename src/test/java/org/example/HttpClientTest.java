package org.example;

import java.time.LocalDate;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import org.junit.jupiter.api.Assertions;

public class HttpClientTest {
    public HttpClient client;
    public HttpRequest request;


        @BeforeEach
        public void init () {
            client = HttpClient.builder()
                    .version("HTTP_1_1")
                    .followRedirects("NORMAL")
                    .connectTimeout(LocalDate.now()) //как реализовать (LocalDateTime.ofSeconds(20))
                    .proxy("https:/\n/\naccount.mail.ru/\n") //(ProxySelector.of(new InetSocketAddress("proxy.example.com", 80)))
                    .authenticator(true) //(Authenticator.getDefault())
                    .build();

            request = HttpRequest.builder()
                    .uri("https://account.mail.ru/")//(new URI("https://mail.ru"))
                    .headers("Content-Type", "application/json; charset=utf-8")//("Content-Type", " application/octet-stream")
                    .POST("https:/\n/\naccount.mail.ru/\napi/\nv1/\npushauth/\npush/\nsend")//(HttpRequest.BodyPublishers. ofInputStream ( () -> is))
                    .build();
    }

        @Test
        public void send200 () throws Exception {
        //Создаем объект HttpRequst()
        HttpRequest request = HttpRequest.Builder("https:/\n/\naccount.mail.ru/\napi/\nv1/\npushauth/\npush/\nsend").build();

        //Вызываем метод send()
        HttpResponse response = client.send(request, BodyHandlers.ofString()); //client.send(request, BodyHandlers.ofString());
        Assertions.assertEquals(200, response.statusCode());
    }

        @Test
        public void send404 () throws Exception {
        //Создаем объект HttpRequst()
        HttpRequest request = HttpRequest.newBuilder("https://mail.ru/unknown").build();

        //Вызываем метод send()
        HttpResponse response = client.send(request, BodyHandlers.ofString());
        Assertions.assertEquals(404, response.statusCode());
    }
    }
