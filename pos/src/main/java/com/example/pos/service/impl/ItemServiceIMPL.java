package com.example.pos.service.impl;

import com.example.pos.dto.request.ItemSaveRequestDTO;
import com.example.pos.entity.Item;
import com.example.pos.entity.enums.MesuringUnitType;
import com.example.pos.repository.ItemRepo;
import com.example.pos.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceIMPL implements ItemService {

    @Autowired
    private ItemRepo itemRepo;


    @Override
    public String saveItem(ItemSaveRequestDTO itemSaveRequestDTO) {
        Item item = new Item(
                1,
                itemSaveRequestDTO.getItemName(),
                itemSaveRequestDTO.getMeasuringUnitType(),
                itemSaveRequestDTO.getBalanceQty(),
                itemSaveRequestDTO.getSupplier(),
                itemSaveRequestDTO.getSellingPrice(),
                true
        );
        itemRepo.save(item);
        return itemSaveRequestDTO.getItemName();
    }
}
