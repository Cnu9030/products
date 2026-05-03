package com.ecom.products.Utility;

import java.util.Collections;
import java.util.concurrent.CompletableFuture;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ecom.products.DTO.PaymentResponseDTO;
import com.ecom.products.DTO.ProductResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

@Component
public class externalCalls {

    private final RestTemplate restTemplate = new RestTemplate();

    // 🔹 PRODUCT API (ASYNC)
    public CompletableFuture<ProductResponseDTO> getProductAsync(String productId) {
        return CompletableFuture.supplyAsync(() -> {
            String url = "https://69ecaf69af4ff533142b4078.mockapi.io/product?productId=" + productId;

            try {
                System.out.println("[PRODUCT API] Calling: " + url);

                String response = restTemplate.getForObject(url, String.class);
                System.out.println("[PRODUCT API] RAW: " + response);

                ObjectMapper mapper = new ObjectMapper();
                ProductResponseDTO[] products =
                        mapper.readValue(response, ProductResponseDTO[].class);

                ProductResponseDTO product =
                        (products != null && products.length > 0) ? products[0] : null;

                System.out.println("[PRODUCT API] PARSED: " + product);

                return product;

            } catch (Exception e) {
                System.err.println("[PRODUCT API] FAILED: " + productId);
                throw new RuntimeException("Product API failed", e);
            }
        });
    }

    // 🔹 PAYMENT API (ASYNC)
    public CompletableFuture<PaymentResponseDTO> getPaymentAsync(Long cardNum) {
        return CompletableFuture.supplyAsync(() -> {
            String url = "https://payment.free.beeceptor.com/auth";

            try {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                headers.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));

                String body = String.format("{\"cardNumber\":\"%s\"}", cardNum);
                HttpEntity<String> request = new HttpEntity<>(body, headers);

                System.out.println("[PAYMENT API] Calling");
                System.out.println("[PAYMENT API] Body: " + body);

                String rawXml = restTemplate.postForObject(url, request, String.class);
                System.out.println("[PAYMENT API] RAW XML: " + rawXml);

                XmlMapper xmlMapper = new XmlMapper();
                PaymentResponseDTO response =
                        xmlMapper.readValue(rawXml, PaymentResponseDTO.class);

                System.out.println("[PAYMENT API] PARSED: " + response);

                return response;

            } catch (Exception e) {
                System.err.println("[PAYMENT API] FAILED");
                throw new RuntimeException("Payment API failed", e);
            }
        });
    }
}