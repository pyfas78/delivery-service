package dev.danilovich.demo1.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record OrderRequest(
    @NotBlank(message = "Нет названия блюда")
    @Size(min = 2, max = 50, message = "Название должно быть от 2 до 50 символов")
    String dishName,

    @Positive(message = "Цена должно быть строго больше 0")
    double price
) {}
