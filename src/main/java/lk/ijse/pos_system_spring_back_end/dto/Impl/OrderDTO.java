package lk.ijse.pos_system_spring_back_end.dto.Impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO {
    private String orderId;
    private String date;
    private double total;
    private String cusId;
    private List<ItemDTO> items;
}
