package hu.saghytech.mpfs.sender.util;

import hu.saghytech.mpfs.sender.model.Product;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.SneakyThrows;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    public List<Product> getProducts() {
        List<Product> list = new ArrayList<>();

        Product product = new Product();
        product.setId(1L);
        product.setName("Test Product");
        product.setDescription("Test description");

        Product product2 = new Product();
        product2.setId(2L);
        product2.setName("Test Product2");
        product2.setDescription("Test description2");

        list.add(product);
        list.add(product2);

        return list;
    }

    public Map<String, String> getParams() {
        Map<String, String> params = new HashMap<>();
        params.put("key1", "value1");
        params.put("key2", "value2");
        return params;
    }

    @SneakyThrows
    public List<File> getFiles() {
        List<File> files = new ArrayList<>();
        files.add(new ClassPathResource("/static/example.pdf").getFile());
        files.add(new ClassPathResource("/static/example2.pdf").getFile());
        return files;
    }
}
