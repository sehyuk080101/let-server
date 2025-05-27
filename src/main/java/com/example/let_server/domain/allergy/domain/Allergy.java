package com.example.let_server.domain.allergy.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Allergy {
    private Long allergyId;
    private String allergyName;
}
