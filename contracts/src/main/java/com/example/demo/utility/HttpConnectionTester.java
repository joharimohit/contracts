package com.example.demo.utility;

import com.example.demo.httpServices.HttpServiceProvider;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class HttpConnectionTester {

    public static void main(String args[]){
        HttpServiceProvider httpServiceProvider= new HttpServiceProvider();
        try {
            httpServiceProvider.callUri("http://localhost:8080/iconcile/contracts?name=temp");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
