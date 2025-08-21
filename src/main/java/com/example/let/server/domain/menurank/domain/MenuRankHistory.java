package com.example.let.server.domain.menurank.domain;

import com.example.let.server.domain.menu.domain.Menu;

import java.util.Date;

public class MenuRankHistory {
    private Long historyId;
    private Menu menu;
    private Date date;
    private int rank;
    private int rankDiff;
}
