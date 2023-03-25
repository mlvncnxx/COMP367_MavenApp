package com.comp367;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.time.LocalTime;

public class App {

    public static void main(String[] args) throws IOException {

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/", new MyHandler());
        server.setExecutor(null); // creates a default executor
        server.start();

        System.out.println("Server is listening on http://localhost:8080");

    }

    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            String name ="Mel";
            String greeting = getGreetingMessage();
            String response = "<h1>" + greeting + ", " + name + "! Welcome to COMP367</h1>";
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }

        private String getGreetingMessage(){
            LocalTime time = LocalTime.now();
            if(time.isBefore(LocalTime.NOON)){
                return "Good Morning";
            }
            else if(time.isBefore(LocalTime.NOON.plusHours(6))){
                return "Good Afternoon";
            }
            else{
                return "Good Evening";
            }
        }
    }
}
