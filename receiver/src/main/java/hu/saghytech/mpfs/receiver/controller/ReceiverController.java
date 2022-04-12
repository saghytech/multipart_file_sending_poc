package hu.saghytech.mpfs.receiver.controller;

import hu.saghytech.mpfs.receiver.model.Product;
import hu.saghytech.mpfs.receiver.service.ReceiverService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ReceiverController {

    @Autowired
    private ReceiverService service;

    @PostMapping(value = "/receiver", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE})
    public void receiver(@RequestPart("products") List<Product> products,
                         @RequestPart("params") Map<String, String> params,
                         @RequestPart("files") List<MultipartFile> files) {
        service.receiver(products, params, files);
    }
}
