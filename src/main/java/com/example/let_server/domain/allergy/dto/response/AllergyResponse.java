package com.example.let_server.domain.allergy.dto.response;

import com.example.let_server.domain.allergy.domain.Allergy;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AllergyResponse {
    private Long allergyId;
    private String allergyName;

    public static AllergyResponse of(Allergy allergy) {
        return AllergyResponse.builder()
                .allergyId(allergy.getAllergyId())
                .allergyName(allergy.getAllergyName())
                .build();
    }
}
