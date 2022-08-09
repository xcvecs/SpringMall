package top.byteinfo.springmall.web.service.impl;

import org.springframework.stereotype.Service;
import top.byteinfo.springmall.web.service.CollectionsCmsPreAreService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CollectionsCmsPreAreServiceImpl implements CollectionsCmsPreAreService {
    @Override
    public List<?> list() {
        return new ArrayList<>();
    }
}
