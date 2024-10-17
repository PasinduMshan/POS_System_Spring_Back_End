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
@Table(name = "customer")
public class CustomerEntity implements SuperEntity {
    @Id
    private String cusId;
    private String cusName;
    private String cusAddress;
    private String cusTel;
    private String cusNIC;
    @OneToMany(mappedBy = "customer")
    private List<OrderEntity> orderList;
}
