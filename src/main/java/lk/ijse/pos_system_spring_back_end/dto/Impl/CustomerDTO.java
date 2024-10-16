package lk.ijse.pos_system_spring_back_end.dto.Impl;

import lk.ijse.pos_system_spring_back_end.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO implements SuperDTO {
    private String cusId;
    private String cusName;
    private String cusAddress;
    private String cusTel;
    private String cusNIC;
}
