package lk.ijse.pos_system_spring_back_end.service.impl;

import lk.ijse.pos_system_spring_back_end.dto.Impl.ItemDTO;
import lk.ijse.pos_system_spring_back_end.dto.ItemStatus;
import lk.ijse.pos_system_spring_back_end.exception.DataPersistException;
import lk.ijse.pos_system_spring_back_end.service.ItemService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {
    @Override
    public void saveItem(ItemDTO itemDTO) throws DataPersistException {

    }

    @Override
    public void updateItem(String itemId, ItemDTO itemDTO) {

    }

    @Override
    public void deleteItem(String itemId) {

    }

    @Override
    public List<ItemDTO> getAllItems() {
        return List.of();
    }

    @Override
    public ItemStatus getItem(String itemId) {
        return null;
    }
}
