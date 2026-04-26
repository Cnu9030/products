package com.ecom.products.Utility;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ecom.products.Entity.payment;

@Component
public class externalCalls {

    private final RestTemplate restTemplate = new RestTemplate();

    public CompletableFuture<payment> validateAndFetch(String productId, Long cardNum) {
        // Call 1: GET Product (Dynamic ID)
        CompletableFuture<String> productCall = CompletableFuture.supplyAsync(() -> {
            String url = "https://69ecaf69af4ff533142b4078.mockapi.io/product?productId=" + productId;
            return restTemplate.getForObject(url, String.class);
        });

        // Call 2: POST Payment (XML Response from Beeceptor)
        CompletableFuture<payment> paymentCall = CompletableFuture.supplyAsync(() -> {
            String url = "https://payment.free.beeceptor.com/auth";
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setAccept(java.util.Collections.singletonList(MediaType.APPLICATION_XML));
            
            // Using the cardNumber from your JSON image
            String body = "{\"cardNumber\":\"" + cardNum + "\"}";
            HttpEntity<String> request = new HttpEntity<>(body, headers);
            
            return restTemplate.postForObject(url, request, payment.class);
        });

        // Combine with 60s timeout
        return CompletableFuture.allOf(productCall, paymentCall)
                .orTimeout(60, TimeUnit.SECONDS)
                .thenApply(v -> paymentCall.join());
    }
}
