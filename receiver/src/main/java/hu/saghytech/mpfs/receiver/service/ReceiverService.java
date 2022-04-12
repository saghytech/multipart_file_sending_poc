package hu.saghytech.mpfs.receiver.service;

import hu.saghytech.mpfs.receiver.model.Product;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ReceiverService {

    private Logger LOGGER = LoggerFactory.getLogger(ReceiverService.class);

    public void receiver(List<Product> products, Map<String, String> params, List<MultipartFile> files) {
        LOGGER.info(String.valueOf(products));
        writeIntoFile("/tmp/products.txt", products.toString().getBytes());
        LOGGER.info(String.valueOf(params));
        writeIntoFile("/tmp/params.txt", params.toString().getBytes());
        files.forEach(file -> {
            try {
                writeIntoFile("/tmp/" + file.getOriginalFilename(), file.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

    private void writeIntoFile(String path, byte[] data) {
        try {
            Files.write(Paths.get(path), data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
