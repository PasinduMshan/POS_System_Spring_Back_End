package lk.ijse.pos_system_spring_back_end.controller;

import lk.ijse.pos_system_spring_back_end.customStatusCode.SelectedErrorStatus;
import lk.ijse.pos_system_spring_back_end.dto.CustomerStatus;
import lk.ijse.pos_system_spring_back_end.dto.Impl.CustomerDTO;
import lk.ijse.pos_system_spring_back_end.exception.CustomerNotFoundException;
import lk.ijse.pos_system_spring_back_end.exception.DataPersistException;
import lk.ijse.pos_system_spring_back_end.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveCustomer(@RequestBody CustomerDTO customerDTO) {
        System.out.println(customerDTO);
        try {
            customerService.saveCustomer(customerDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/{cusTel}")
    public ResponseEntity<CustomerStatus> getSelectedCustomer(@PathVariable("cusTel") String cusTel) {
        String regexForTel = "^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$";
        Pattern pattern = Pattern.compile(regexForTel);
        Matcher regexMatcher = pattern.matcher(cusTel);
        if (!regexMatcher.matches()) {
            return new ResponseEntity<>(new SelectedErrorStatus(1, "Customer Tel No is not valid"), HttpStatus.BAD_REQUEST);
        }
        CustomerStatus customerStatus = customerService.getCustomerByTel(cusTel);
        if (customerStatus == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customerStatus, HttpStatus.OK);
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/{cusId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("cusId") String cusID) {
        System.out.println(cusID);
        String regexForCusId = "^C\\d{3}$";
        Pattern pattern = Pattern.compile(regexForCusId);
        Matcher regexMatcher = pattern.matcher(cusID);
        try {
            if (!regexMatcher.matches()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            customerService.deleteCustomer(cusID);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CustomerNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{cusId}")
    public ResponseEntity<Void> updateCustomer(@PathVariable ("cusId") String cusID, @RequestBody CustomerDTO customerDTO) {
        String regexForCusId = "^C\\d{3}$";
        Pattern pattern = Pattern.compile(regexForCusId);
        Matcher regexMatcher = pattern.matcher(cusID);
        try {
            if (!regexMatcher.matches() && customerDTO == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            customerService.updateCustomer(cusID, customerDTO);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CustomerNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
