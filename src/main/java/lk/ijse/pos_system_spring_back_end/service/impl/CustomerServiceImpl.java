package lk.ijse.pos_system_spring_back_end.service.impl;

import lk.ijse.pos_system_spring_back_end.customStatusCode.SelectedErrorStatus;
import lk.ijse.pos_system_spring_back_end.dao.CustomerDao;
import lk.ijse.pos_system_spring_back_end.dto.CustomerStatus;
import lk.ijse.pos_system_spring_back_end.dto.Impl.CustomerDTO;
import lk.ijse.pos_system_spring_back_end.entity.Impl.CustomerEntity;
import lk.ijse.pos_system_spring_back_end.exception.CustomerNotFoundException;
import lk.ijse.pos_system_spring_back_end.exception.DataPersistException;
import lk.ijse.pos_system_spring_back_end.service.CustomerService;
import lk.ijse.pos_system_spring_back_end.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
        Optional<CustomerEntity> customerEntity = customerDao.findById(cusID);
        if (!customerEntity.isPresent()) {
            throw new CustomerNotFoundException("Customer not found");
        } else {
            customerEntity.get().setCusName(customerDTO.getCusName());
            customerEntity.get().setCusAddress(customerDTO.getCusAddress());
            customerEntity.get().setCusTel(customerDTO.getCusTel());
            customerEntity.get().setCusNIC(customerDTO.getCusNIC());
        }
    }

    @Override
    public void deleteCustomer(String cusID) {
        Optional<CustomerEntity> customer = customerDao.findById(cusID);
        if (!customer.isPresent()) {
            throw new CustomerNotFoundException("Customer not found");
        } else {
            customerDao.deleteById(cusID);
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<CustomerEntity> allCustomers = customerDao.findAll();
        return customerMapping.asCustomerDTOList(allCustomers);
    }

    @Override
    public CustomerStatus getCustomer(String cusID) {
        return null;
    }

    @Override
    public CustomerStatus getCustomerByTel(String cusTel) {
        CustomerEntity customerEntity = customerDao.findCustomerByCusTel(cusTel);
        if (customerEntity == null) {
            return new SelectedErrorStatus(2,"Customer not found");
        } else {
            return customerMapping.toCustomerDTO(customerEntity);
        }
    }
}
