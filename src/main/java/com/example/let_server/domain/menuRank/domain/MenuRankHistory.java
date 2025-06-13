package com.example.let_server.domain.menuRank.domain;

import com.example.let_server.domain.menu.domain.Menu;

import java.util.Date;

public class MenuRankHistory {
    private Long historyId;
    private Menu menu;
    private Date date;
    private int rank;
    private int rankDiff;
}
