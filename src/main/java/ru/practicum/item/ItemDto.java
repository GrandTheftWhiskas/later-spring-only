package ru.practicum.item;

import lombok.Data;
import ru.practicum.request.ItemRequest;

@Data
public class ItemDto {
    private Long id;
    private String name;
    private String description;
    private Boolean available;
    private Long owner;
    private ItemRequest request;
}
