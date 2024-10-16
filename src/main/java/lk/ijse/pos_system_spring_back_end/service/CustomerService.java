package lk.ijse.pos_system_spring_back_end.service;

import lk.ijse.pos_system_spring_back_end.dto.Impl.CustomerDTO;
import lk.ijse.pos_system_spring_back_end.exception.DataPersistException;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDTO customerDTO) throws DataPersistException;
    void updateCustomer(String cusID, CustomerDTO customerDTO);
    void deleteCustomer(String cusID);
    List<CustomerDTO> getAllCustomers();
    CustomerDTO getCustomer(String cusID);
}
