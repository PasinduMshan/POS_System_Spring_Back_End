package lk.ijse.pos_system_spring_back_end.dto.Impl;

import lk.ijse.pos_system_spring_back_end.dto.ItemStatus;
import lk.ijse.pos_system_spring_back_end.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDTO implements SuperDTO, ItemStatus {
    private String itemId;
    private String itemName;
    private int unitPrice;
    private int qty;
}
