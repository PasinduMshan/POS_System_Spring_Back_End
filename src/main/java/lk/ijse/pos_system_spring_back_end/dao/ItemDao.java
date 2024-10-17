package lk.ijse.pos_system_spring_back_end.dao;

import lk.ijse.pos_system_spring_back_end.entity.Impl.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDao extends JpaRepository<ItemEntity,String> {
}
