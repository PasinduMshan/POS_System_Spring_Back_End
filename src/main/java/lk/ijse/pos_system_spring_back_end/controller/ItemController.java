package lk.ijse.pos_system_spring_back_end.controller;

import lk.ijse.pos_system_spring_back_end.customStatusCode.SelectedErrorStatus;
import lk.ijse.pos_system_spring_back_end.dto.CustomerStatus;
import lk.ijse.pos_system_spring_back_end.dto.Impl.CustomerDTO;
import lk.ijse.pos_system_spring_back_end.dto.Impl.ItemDTO;
import lk.ijse.pos_system_spring_back_end.dto.ItemStatus;
import lk.ijse.pos_system_spring_back_end.exception.DataPersistException;
import lk.ijse.pos_system_spring_back_end.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("api/v1/item")
public class ItemController {

    @Autowired
    ItemService itemService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveItem(@RequestBody ItemDTO itemDTO) {
        try {
            itemService.saveItem(itemDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/{itemId}")
    public ItemStatus getSelectedItem(@PathVariable("itemId") String itemId) {
        String regexForItemId = "^I\\d{3}$";
        Pattern pattern = Pattern.compile(regexForItemId);
        Matcher regexMatcher = pattern.matcher(itemId);
        if (!regexMatcher.matches()) {
            return new SelectedErrorStatus(1,"Note ID is not valid");
        }
        return itemService.getItem(itemId);
    }

}
