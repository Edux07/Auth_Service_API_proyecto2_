package com.example.authservice_proyecto2.common.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class userRequest {
    @NotNull
    private String email;
    @NotNull
    private String password;
}
