package food.domain;

import food.CustomerApplication;
import food.domain.OrdePlaced;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Order_table")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String customerid;

    private String foodid;

    private String option;

    private String address;

    private String status;

    @PostPersist
    public void onPostPersist() {
        OrdePlaced ordePlaced = new OrdePlaced(this);
        ordePlaced.publishAfterCommit();
    }

    public static OrderRepository repository() {
        OrderRepository orderRepository = CustomerApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }

    public void cancle() {
        OrderCanceled orderCanceled = new OrderCanceled(this);
        orderCanceled.publishAfterCommit();
    }

    public static void updateStatus(DeliveryConfirmed deliveryConfirmed) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryConfirmed.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

    }

    public static void updateStatus(FoodPicked foodPicked) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(foodPicked.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

    }

    public static void updateStatus(CookStarted cookStarted) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(cookStarted.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

    }
}
