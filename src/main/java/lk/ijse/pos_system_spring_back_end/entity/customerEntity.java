package lk.ijse.pos_system_spring_back_end.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "customer")
public class customerEntity {
    @Id
    private String cusId;
    private String cusName;
    private String cusAddress;
    private String cusTel;
    private String cusNIC;
}
