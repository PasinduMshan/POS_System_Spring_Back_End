package lk.ijse.pos_system_spring_back_end.entity.Impl;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lk.ijse.pos_system_spring_back_end.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "items")
public class ItemEntity implements SuperEntity {
    @Id
    private String itemId;
    private String itemName;
    private int unitPrice;
    private int qty;
    @OneToMany(mappedBy = "items")
    private List<OrderDetailsEntity> orderDetails;
}
