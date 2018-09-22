package ns.task.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableRabbit
public class RabbitConfig {

    public static final String QUEUE_ADD_PRODUCT = "addProduct";
    public static final String QUEUE_GET_PRODUCTS = "listProducts";
    public static final String EXCHANGE_PRODUCTS = "exchangeProducts";
    public static final String ROUTING_KEY_ADD_PRODUCT = "routingKeyAdd";
    public static final String ROUTING_KEY_GET_PRODUCTS = "routingKeyGet";


    @Bean
    public Queue addProductQueue() {
        return new Queue(QUEUE_ADD_PRODUCT, true);
    }

    @Bean
    public Queue getProductsQueue() {
        return new Queue(QUEUE_GET_PRODUCTS, true);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(EXCHANGE_PRODUCTS);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setExchange(directExchange().getName());
        template.setMessageConverter(jsonMessageConverter());
        template.setReplyTimeout(10000);

        return template;
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Binding addProductBinding() {
        return BindingBuilder.bind(addProductQueue())
                .to(directExchange())
                .with(ROUTING_KEY_ADD_PRODUCT);
    }

    @Bean
    public Binding getProductsBinding() {
        return BindingBuilder.bind(getProductsQueue())
                .to(directExchange())
                .with(ROUTING_KEY_GET_PRODUCTS);
    }
}
