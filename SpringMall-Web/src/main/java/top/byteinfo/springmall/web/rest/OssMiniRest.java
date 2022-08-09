package top.byteinfo.springmall.web.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("rest")
public class OssMiniRest {



    @PostMapping
    public ResponseEntity<?> upload(@RequestPart("file") MultipartFile file) {


        return ResponseEntity.ok("upload success");
    }


}
