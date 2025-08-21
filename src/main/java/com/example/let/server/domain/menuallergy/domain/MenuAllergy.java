package com.example.let.server.domain.menuallergy.domain;

import com.example.let.server.domain.allergy.domain.Allergy;
import com.example.let.server.domain.menu.domain.Menu;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MenuAllergy {
    private Long menuAllergyId;
    private Allergy allergy;
    private Menu menu;
}
