package lk.ijse.pos_system_spring_back_end.service;

import lk.ijse.pos_system_spring_back_end.dto.Impl.ItemDTO;
import lk.ijse.pos_system_spring_back_end.dto.ItemStatus;
import lk.ijse.pos_system_spring_back_end.exception.DataPersistException;

import java.util.List;

public interface ItemService {
    void saveItem(ItemDTO itemDTO) throws DataPersistException;
    void updateItem(String itemId, ItemDTO itemDTO);
    void deleteItem(String itemId);
    List<ItemDTO> getAllItems();
    ItemStatus getItem(String itemId);
}
