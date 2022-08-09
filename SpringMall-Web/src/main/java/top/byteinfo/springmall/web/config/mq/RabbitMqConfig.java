package top.byteinfo.springmall.web.config.mq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {
    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
    @Bean
    public Queue articleQueue() {
        return new Queue("MAXWELL_QUEUE", true);
    }

    @Bean
    public FanoutExchange maxWellExchange() {
        return new FanoutExchange("MAXWELL_EXCHANGE", true, false);
    }

    @Bean
    public Binding bindingArticleDirect() {
        return BindingBuilder.bind(articleQueue()).to(maxWellExchange());
    }

    @Bean
    public Queue emailQueue() {
        return new Queue("EMAIL_QUEUE", true);
    }

    @Bean
    public FanoutExchange emailExchange() {
        return new FanoutExchange("EMAIL_EXCHANGE", true, false);
    }

    @Bean
    public Binding bindingEmailDirect() {
        return BindingBuilder.bind(emailQueue()).to(emailExchange());
    }
}
