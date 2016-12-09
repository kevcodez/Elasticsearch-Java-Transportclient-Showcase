package de.kevcodez.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order extends AbstractEntity {

    private LocalDateTime time;
    private List<OrderItem> orderItems = new ArrayList<>();
    private BigDecimal totalPrice;
    private BigDecimal shippingCosts;
    private Customer customer;
    private Address deliveryAddress;

}
