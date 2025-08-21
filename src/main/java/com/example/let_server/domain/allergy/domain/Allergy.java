package com.example.let_server.domain.allergy.domain;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Allergy {
    private Long allergyId;
    private String allergyName;
}
