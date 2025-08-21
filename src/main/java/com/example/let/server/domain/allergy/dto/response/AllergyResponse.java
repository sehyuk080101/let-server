package com.example.let.server.domain.allergy.dto.response;

import com.example.let.server.domain.allergy.domain.Allergy;
import lombok.*;

@Getter
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
