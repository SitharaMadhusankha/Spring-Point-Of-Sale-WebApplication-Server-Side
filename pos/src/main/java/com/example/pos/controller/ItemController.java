package com.example.pos.controller;

import com.example.pos.dto.CustomerDTO;
import com.example.pos.dto.paginated.PaginatedIResponseItemDTO;
import com.example.pos.dto.request.ItemSaveRequestDTO;
import com.example.pos.dto.respones.ItemGetResponesDTO;
import com.example.pos.service.ItemService;
import com.example.pos.service.impl.ItemServiceIMPL;
import com.example.pos.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping(
            path = "/save"
    )
    public ResponseEntity<StandardResponse> saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO) {
        String message = itemService.saveItem(itemSaveRequestDTO);
        //ResponseEntity<StandardResponse> response= new ResponseEntity<StandardResponse>(
        //       new StandardResponse(201,"success",message), HttpStatus.CREATED

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "success", message),
                HttpStatus.CREATED
        );
    }

    @GetMapping(
            path = "/get-by-name",
            params = "name"
    )
    public List<ItemGetResponesDTO> getItemByNameAndStatus(@RequestParam String name) {
        List<ItemGetResponesDTO> itemDTOS = itemService.getItemByNameAndStatus(name);
        return itemDTOS;
    }


    @GetMapping(
            path = "/get-by-name-with-mapstruct",
            params = "name"
    )
    public List<ItemGetResponesDTO> getItemByNameAndStatusByMapstruct(@RequestParam String name) {
        List<ItemGetResponesDTO> itemDTOS = itemService.getItemByNameAndStatusByMapstruct(name);
        return itemDTOS;
    }

    @GetMapping(
            path = "/get-all-item-by-status",
            params = {"activeStatus","page","size"}
    )
    public ResponseEntity<StandardResponse> getItemsByActiveStatus(
            @RequestParam(value = "activeStatus") boolean activeStatus,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size
    ) {
        //List<ItemGetResponesDTO> itemDTOS = itemService.getItemByActiveStatus(activeStatus,page,size);
        PaginatedIResponseItemDTO paginatedIResponseItemDTO = itemService.getItemByActiveStatusWithPaginated(activeStatus,page,size);
        return  new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "success", paginatedIResponseItemDTO ),
                HttpStatus.CREATED
        );
    }

}
