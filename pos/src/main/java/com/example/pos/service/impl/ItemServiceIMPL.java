package com.example.pos.service.impl;

import com.example.pos.dto.paginated.PaginatedIResponseItemDTO;
import com.example.pos.dto.request.ItemSaveRequestDTO;
import com.example.pos.dto.respones.ItemGetResponesDTO;
import com.example.pos.entity.Item;
import com.example.pos.exception.NotFoundException;
import com.example.pos.repository.ItemRepo;
import com.example.pos.service.ItemService;
import com.example.pos.util.mappers.ItemMapper;
import com.sun.jdi.request.DuplicateRequestException;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceIMPL implements ItemService {

    @Autowired
    private ItemRepo itemRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ItemMapper itemMapper;
    @Override
    public String saveItem(ItemSaveRequestDTO itemSaveRequestDTO) {
        Item item=modelMapper.map(itemSaveRequestDTO,Item.class);
        item.setActiveState(true);
        if(!itemRepo.existsById(item.getItemId())){
            itemRepo.save(item);
            return item.getItemId()+"saved successfully";
        }
        throw new DuplicateRequestException("alredy Added");
    }
//use modal mapper
    @Override
    public List<ItemGetResponesDTO> getItemByNameAndStatus(String name) {

        List<Item> items =itemRepo.findAllByItemNameEqualsAndActiveStateEquals(name,true);
        if(items.size()>0){
            List<ItemGetResponesDTO> itemGetResponesDTOS=modelMapper.map(items,new TypeToken<List<ItemGetResponesDTO>>(){}.getType());
            return itemGetResponesDTOS;
        }else{
            throw new RuntimeException("Not Found");
        }

    }
//use mapstruct
    @Override
    public List<ItemGetResponesDTO> getItemByNameAndStatusByMapstruct(String name) {
        List<Item> items =itemRepo.findAllByItemNameEqualsAndActiveStateEquals(name,true);
        if(items.size()>0){
            List<ItemGetResponesDTO> itemGetResponesDTOS=itemMapper.entityListToDtoList(items);
            return itemGetResponesDTOS;
        }else{
            throw new RuntimeException("Not Found");
        }

    }

    @Override
    public List<ItemGetResponesDTO> getItemByActiveStatus(boolean activeStatus) {
        List<Item> items =itemRepo.findAllByActiveStateEquals(activeStatus);
        if(items.size()>0){
            List<ItemGetResponesDTO> itemGetResponesDTOS=itemMapper.entityListToDtoList(items);
            return itemGetResponesDTOS;
        }else{
            throw new NotFoundException("Not Found");
        }
    }

    @Override
    public PaginatedIResponseItemDTO getItemByActiveStatusWithPaginated(boolean activeStatus, int page, int size) {
        Page<Item> items =itemRepo.findAllByActiveStateEquals(activeStatus, PageRequest.of(page,size));
        if(items.getSize()<1){
            throw new NotFoundException("No Data");
        }
        PaginatedIResponseItemDTO paginatedIResponseItemDTO = new PaginatedIResponseItemDTO(
            itemMapper.ListDTOToPage(items),
                2
        );

        return paginatedIResponseItemDTO;
    }


}
