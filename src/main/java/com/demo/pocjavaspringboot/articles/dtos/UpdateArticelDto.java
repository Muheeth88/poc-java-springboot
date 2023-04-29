package com.demo.pocjavaspringboot.articles.dtos;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
public class UpdateArticelDto {
    
    @NonNull
    private String title;

    @NonNull
    private String body;

    @Nullable
    private String subTitle;
}
