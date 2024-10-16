package lk.ijse.pos_system_spring_back_end.service.impl;

import lk.ijse.pos_system_spring_back_end.dao.CustomerDao;
import lk.ijse.pos_system_spring_back_end.dto.Impl.CustomerDTO;
import lk.ijse.pos_system_spring_back_end.entity.Impl.CustomerEntity;
import lk.ijse.pos_system_spring_back_end.exception.DataPersistException;
import lk.ijse.pos_system_spring_back_end.service.CustomerService;
import lk.ijse.pos_system_spring_back_end.util.Mapping;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDao customerDao;

    @Autowired
    Mapping customerMapping;

    @Override
    public void saveCustomer(CustomerDTO customerDTO) throws DataPersistException {
        CustomerEntity saveCustomer = customerDao.save(customerMapping.toCustomerEntity(customerDTO));
        if (saveCustomer == null) {
            throw new DataPersistException("Customer not saved");
        }
    }

    @Override
    public void updateCustomer(String cusID, CustomerDTO customerDTO) {

    }

    @Override
    public void deleteCustomer(String cusID) {

    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return List.of();
    }

    @Override
    public CustomerDTO getCustomer(String cusID) {
        return null;
    }
}
