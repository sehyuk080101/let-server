package com.example.let_server.domain.menuRank.service.impl;

import com.example.let_server.domain.menuRank.dto.response.MenuRankingDto;
import com.example.let_server.domain.menuRank.repository.MenuRankRepository;
import com.example.let_server.domain.menuRank.service.MenuRankService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MenuRankServiceImpl implements MenuRankService {

    private final MenuRankRepository menuRankRepository;

    @Scheduled(cron = "0 0 0 * * *")
    private void updateMenuScoreByWilson() {
        menuRankRepository.updateMenuScoreByWilson();
    }

    @Override
    public List<MenuRankingDto> getMenuRankings() {
        return menuRankRepository.findAllOrderByScoreDesc();
    }
}
