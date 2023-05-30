package com.techie.blog.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class CategoryDto {
    private Integer id;
    @NotEmpty(message ="Title should not be empty")
    @Size(min=5,max=15,message="Description should be min=5 / max=15")
    private String categoryTitle;
    @NotEmpty(message = "Description should not be empty")
    @Size(min=10,max=50,message="Description should be min=10 /max=50")
    private String categoryDescription;
}
