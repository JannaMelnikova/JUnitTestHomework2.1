package org.example;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        //Создаем объект HttpClient
        HttpClient client = HttpClient.builder()
                .version("HTTP_1_1")
                .followRedirects("NORMAL")
                .connectTimeout(LocalDate.now()) //(LocalDateTime.ofSeconds(20))
                .proxy("proxy.example.com") //(ProxySelector.of(new InetSocketAddress("proxy.example.com", 80)))
                .authenticator(true) //(Authenticator.getDefault())
                .build();

        //Создаем объект HttpRequest
        HttpRequest request = HttpRequest.builder()
                .uri("https://mail.ru")//(new URI("https://mail.ru"))
                .headers("Content-Type", "application/json; charset=utf-8")//("Content-Type", " application/octet-stream")
                .POST("https:/\n/\naccount.mail.ru/\napi/\nv1/\npushauth/\npush/\nsend")//(HttpRequest.BodyPublishers. ofInputStream ( () -> is))
                .build();


        //Вызываем метод send()
        //HttpResponse response = client.send(request, BodyHandlers.ofString());
        HttpResponse response = client.send(request,POST.ofString()); 
        System.out.println(response.statusCode());
        System.out.println(response.body());
    }

}
