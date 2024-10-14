package lk.ijse.pos_system_spring_back_end.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class customerDTO {
    private String cusId;
    private String cusName;
    private String cusAddress;
    private String cusTel;
    private String cusNIC;
}
