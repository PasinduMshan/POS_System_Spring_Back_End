package lk.ijse.pos_system_spring_back_end.service.impl;

import lk.ijse.pos_system_spring_back_end.customStatusCode.SelectedErrorStatus;
import lk.ijse.pos_system_spring_back_end.dao.ItemDao;
import lk.ijse.pos_system_spring_back_end.dto.Impl.ItemDTO;
import lk.ijse.pos_system_spring_back_end.dto.ItemStatus;
import lk.ijse.pos_system_spring_back_end.entity.Impl.CustomerEntity;
import lk.ijse.pos_system_spring_back_end.entity.Impl.ItemEntity;
import lk.ijse.pos_system_spring_back_end.exception.CustomerNotFoundException;
import lk.ijse.pos_system_spring_back_end.exception.DataPersistException;
import lk.ijse.pos_system_spring_back_end.exception.ItemNotFoundException;
import lk.ijse.pos_system_spring_back_end.service.ItemService;
import lk.ijse.pos_system_spring_back_end.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
        Optional<ItemEntity> itemEntity = itemDao.findById(itemId);
        if (!itemEntity.isPresent()) {
            throw new ItemNotFoundException("Item not found");
        } else {
            itemEntity.get().setItemName(itemDTO.getItemName());
            itemEntity.get().setUnitPrice(itemDTO.getUnitPrice());
            itemEntity.get().setQty(itemDTO.getQty());
        }
    }

    @Override
    public void deleteItem(String itemId) {
        Optional<ItemEntity> itemEntity = itemDao.findById(itemId);
        if (!itemEntity.isPresent()) {
            throw new ItemNotFoundException("Item not found");
        } else {
            itemDao.deleteById(itemId);
        }
    }

    @Override
    public List<ItemDTO> getAllItems() {
        List<ItemEntity> allItems = itemDao.findAll();
        return itemMapping.asItemDTOList(allItems);
    }

    @Override
    public ItemStatus getItem(String itemId) {
        if (itemDao.existsById(itemId)) {
            var itemEntity = itemDao.getReferenceById(itemId);
            return itemMapping.toItemDTO(itemEntity);
        } else {
            return new SelectedErrorStatus(2,"Customer not found");
        }
    }
}
