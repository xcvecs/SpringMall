package top.byteinfo.springmall.web.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.byteinfo.springmall.web.service.CollectionsCmsPreAreService;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class SpringRest {

    private CollectionsCmsPreAreService collectionsCmsPreAreService;

    @GetMapping("/preare")
    public ResponseEntity<List<?>> list(){
        List<?> list = collectionsCmsPreAreService.list();
        return ResponseEntity.ok(list);
    }
}
