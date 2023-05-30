package com.techie.blog.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class CategoryDto {
    private Integer id;
    private String categoryTitle;
    private String categoryDescription;
}
