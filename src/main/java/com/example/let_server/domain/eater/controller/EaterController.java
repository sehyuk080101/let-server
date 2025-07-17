package com.example.let_server.domain.eater.controller;

import com.example.let_server.domain.eater.docs.EaterDocs;
import com.example.let_server.domain.eater.dto.response.EaterRatioResponse;
import com.example.let_server.domain.eater.dto.response.EaterResponse;
import com.example.let_server.domain.eater.service.EaterService;
import com.example.let_server.global.common.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/eater")
public class EaterController implements EaterDocs {
    private final EaterService eaterService;

    @GetMapping("/{grade}")
    @Override
    public ResponseEntity<BaseResponse<List<EaterResponse>>> getByGrade(@PathVariable Long grade) {
        return BaseResponse.of(eaterService.findByGrade(grade));
    }

    @GetMapping("/meal-rate")
    @Override
    public ResponseEntity<BaseResponse<List<EaterRatioResponse>>> getMealRateByGrade(
            @RequestParam(required = false) String mealType) {
        return BaseResponse.of(eaterService.getEaterRation(mealType));
    }

    @GetMapping("/not-eaten")
    @Override
    public ResponseEntity<BaseResponse<Integer>> getNotEaterCount() {
        return BaseResponse.of(eaterService.getNotEaterCount());
    }

    @GetMapping("/month/meal-rate")
    @Override
    public ResponseEntity<BaseResponse<List<EaterRatioResponse>>> getMealRateByMonth(){
        return BaseResponse.of(eaterService.getEaterRationMonthly());
    }
}
