package food.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import food.config.kafka.KafkaProcessor;
import food.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    CookingRepository cookingRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrdePlaced'"
    )
    public void wheneverOrdePlaced_LoadOrderInfo(
        @Payload OrdePlaced ordePlaced
    ) {
        OrdePlaced event = ordePlaced;
        System.out.println(
            "\n\n##### listener LoadOrderInfo : " + ordePlaced + "\n\n"
        );

        // Sample Logic //
        Cooking.loadOrderInfo(event);
    }
}
