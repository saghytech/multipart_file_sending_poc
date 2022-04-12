package hu.saghytech.mpfs.sender.service;

import hu.saghytech.mpfs.sender.model.Product;
import hu.saghytech.mpfs.sender.util.Producer;
import java.io.File;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class MultipartSenderService {

    @Autowired
    private Producer producer;

    public void sendMultipartMessage() {
        final WebClient webClient = WebClient.builder().build();
        webClient.post()
                .uri("http://localhost:8080/receiver")
                .contentType(MediaType.MULTIPART_FORM_DATA)
            .body(BodyInserters.fromMultipartData(buildMultipartBody(producer.getFiles(), producer.getProducts(), producer.getParams())))
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    private MultiValueMap<String, HttpEntity <?>> buildMultipartBody(List<File> files, List<Product> products, Map<String, String> params) {
        MultipartBodyBuilder builder = new MultipartBodyBuilder();
        files.forEach(file -> builder.part("files", new FileSystemResource(file)));
        builder.part("products", products);
        builder.part("params", params);
        return builder.build();
    }
}
