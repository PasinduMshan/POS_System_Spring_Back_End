package lk.ijse.pos_system_spring_back_end.entity.Impl;

import jakarta.persistence.*;
import lk.ijse.pos_system_spring_back_end.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "orderDetails")
public class OrderDetailsEntity implements SuperEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "orderId", nullable = false)
    private OrderEntity orderEntity;

    @ManyToOne
    @JoinColumn(name = "itemId", nullable = false)
    private ItemEntity itemEntity;

    private Integer qty;
    private Double unitPrice;
    private Double totalPrice;
}
