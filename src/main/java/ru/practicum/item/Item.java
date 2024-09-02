package ru.practicum.item;

import lombok.Data;
import ru.practicum.request.ItemRequest;

@Data
public class Item {
    private Long id;
    private String name;
    private String description;
    private Boolean available;
    private Long owner;
    private ItemRequest request;

    public boolean isAvailable() {
        return available;
    }
}
