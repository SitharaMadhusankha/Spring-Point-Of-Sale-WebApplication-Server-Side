package com.example.pos.dto.paginated;

import com.example.pos.dto.respones.ItemGetResponesDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedIResponseItemDTO {
    List<ItemGetResponesDTO> list;
    private long datacount;
}
