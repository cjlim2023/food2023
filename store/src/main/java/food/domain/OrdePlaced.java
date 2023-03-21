package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrdePlaced extends AbstractEvent {

    private Long id;
    private String foodid;
    private String option;
    private String address;
}
