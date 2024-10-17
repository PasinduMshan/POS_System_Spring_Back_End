package lk.ijse.pos_system_spring_back_end.service.impl;

import lk.ijse.pos_system_spring_back_end.dao.ItemDao;
import lk.ijse.pos_system_spring_back_end.dto.Impl.ItemDTO;
import lk.ijse.pos_system_spring_back_end.dto.ItemStatus;
import lk.ijse.pos_system_spring_back_end.entity.Impl.CustomerEntity;
import lk.ijse.pos_system_spring_back_end.entity.Impl.ItemEntity;
import lk.ijse.pos_system_spring_back_end.exception.DataPersistException;
import lk.ijse.pos_system_spring_back_end.service.ItemService;
import lk.ijse.pos_system_spring_back_end.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemDao itemDao;

    @Autowired
    Mapping itemMapping;

    @Override
    public void saveItem(ItemDTO itemDTO) throws DataPersistException {
        ItemEntity saveItem = itemDao.save(itemMapping.toItemEntity(itemDTO));
        if (saveItem == null) {
            throw new DataPersistException("Item not saved");
        }
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
