package lk.ijse.pos_system_spring_back_end.dao;

import lk.ijse.pos_system_spring_back_end.entity.Impl.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends JpaRepository<CustomerEntity, String> {

    @Query("SELECT c FROM CustomerEntity c WHERE c.cusTel = :cusTel")
    CustomerEntity findCustomerByCusTel(@Param("cusTel")String cusTel);
}
