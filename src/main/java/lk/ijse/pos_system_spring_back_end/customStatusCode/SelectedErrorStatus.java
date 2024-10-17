package lk.ijse.pos_system_spring_back_end.customStatusCode;

import lk.ijse.pos_system_spring_back_end.dto.CustomerStatus;
import lk.ijse.pos_system_spring_back_end.dto.ItemStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedErrorStatus implements CustomerStatus, ItemStatus {
    private int statusCode;
    private String statusMessage;
}
