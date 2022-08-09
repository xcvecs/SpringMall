package top.byteinfo.springmall.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.byteinfo.springmall.web.service.IOArticleService;
import top.byteinfo.springmall.web.service.UtilsTbArticleService;

import javax.servlet.http.HttpServletRequest;

@RestController
public class Test {
    @Autowired
    UtilsTbArticleService UtilsTbArticleService;
    @Autowired
    IOArticleService IOArticleService;

    @GetMapping("/rest/1")
    public String t1(HttpServletRequest request) {

        UtilsTbArticleService.se1();
        return "success";
    }

    @GetMapping("/")
    public String t0(HttpServletRequest request) {

       return UtilsTbArticleService.se1();
    }
    @GetMapping("/11")
    public String t(HttpServletRequest request) {

        return IOArticleService.se2();
    }
}
