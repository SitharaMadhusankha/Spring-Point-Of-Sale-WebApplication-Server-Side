package com.example.pos.util.mappers;

import com.example.pos.dto.respones.ItemGetResponesDTO;
import com.example.pos.entity.Item;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    List<ItemGetResponesDTO>entityListToDtoList(List<Item> items);

    //Page<Item> items
    List<ItemGetResponesDTO>ListDTOToPage(Page<Item>items);

}
