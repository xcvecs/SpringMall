package top.byteinfo.springmall.web.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Slf4j
public class GlobalHandlerExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        try (PrintWriter writer = response.getWriter()) {
            writer.write("");
        } catch (Exception e) {
            log.error("响应输出失败！原因如下：", e);
        }
        return null;
    }
}
