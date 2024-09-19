package com.example.pos.service;

import com.example.pos.dto.paginated.PaginatedIResponseItemDTO;
import com.example.pos.dto.request.ItemSaveRequestDTO;
import com.example.pos.dto.respones.ItemGetResponesDTO;

import java.util.List;

public interface ItemService {
    String saveItem(ItemSaveRequestDTO itemSaveRequestDTO);

    List<ItemGetResponesDTO> getItemByNameAndStatus(String name);

    List<ItemGetResponesDTO> getItemByNameAndStatusByMapstruct(String name);

    List<ItemGetResponesDTO> getItemByActiveStatus(boolean activeStatus);

    PaginatedIResponseItemDTO getItemByActiveStatusWithPaginated(boolean activeStatus, int page, int size);
}
