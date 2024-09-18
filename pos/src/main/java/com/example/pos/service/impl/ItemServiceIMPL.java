package com.example.pos.service.impl;

import com.example.pos.dto.request.ItemSaveRequestDTO;
import com.example.pos.entity.Item;
import com.example.pos.repository.ItemRepo;
import com.example.pos.service.ItemService;
import com.sun.jdi.request.DuplicateRequestException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceIMPL implements ItemService {

    @Autowired
    private ItemRepo itemRepo;
    @Autowired
    private ModelMapper modelMapper;

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


}
