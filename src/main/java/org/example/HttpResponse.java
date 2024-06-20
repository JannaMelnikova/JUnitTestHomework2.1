package org.example;

public class HttpResponse  {
int statusCode;
    // Метод для проверки, является кода ошибки
switch(statusCode.strip().toUpperCase()) {
        case 200: {
            System.out.println("Succeded");
            break;

        }
        case 404:
            System.out.println("Failed");
            break;

        default:
            System.out.println("Система зависла, необходимо перезагрузить");
            break;


    }
}
