package com.example.let_server.domain.eater.dto.response;

import lombok.Builder;

@Builder
public record EaterRatioResponse (
        String mealType,
        Integer grade1Ration,
        Integer grade2Ration,
        Integer grade3Ration
){
}
