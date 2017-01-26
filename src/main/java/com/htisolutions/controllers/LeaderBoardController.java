package com.htisolutions.controllers;

import com.htisolutions.services.LeaderBoardService;
import com.htisolutions.viewModels.LeaderBoardEntryViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/leaderboard")
public class LeaderBoardController {

    private LeaderBoardService leaderBoardService;

    @Autowired
    LeaderBoardController(LeaderBoardService leaderBoardService) {
        this.leaderBoardService = leaderBoardService;
    }

    @RequestMapping()
    public ModelAndView index() {
        List<LeaderBoardEntryViewModel> leaderboardEntries = leaderBoardService.calculateLeaderBoard();

        ModelAndView model = new ModelAndView("views/leaderboard");
        model.addObject("leaderboardEntries", leaderboardEntries);
        return model;
    }
}
