package lk.ijse.pos_system_spring_back_end.entity.Impl;

import jakarta.persistence.*;
import lk.ijse.pos_system_spring_back_end.dto.Impl.ItemDTO;
import lk.ijse.pos_system_spring_back_end.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "orders")
public class OrderEntity implements SuperEntity {
    @Id
    private String orderId;
    private String date;
    private double total;
    @ManyToOne
    @JoinColumn(name = "cusId",nullable = false)
    private CustomerEntity  customerEntity;
    @OneToMany(mappedBy = "orders")
    private List<OrderDetailsEntity> items;
}
