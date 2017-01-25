package com.htisolutions.services;

import com.htisolutions.entities.*;
import com.htisolutions.viewModels.LeaderBoardEntryViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LeaderBoardService {

    private GameDao gameDao;
    private UserDao userDao;

    @Autowired
    LeaderBoardService(GameDao gameDao, UserDao userDao) {
        this.gameDao = gameDao;
        this.userDao = userDao;
    }

   public List<LeaderBoardEntryViewModel> calculateLeaderBoard(){
       HashMap<Long, LeaderBoardEntryViewModel> leaderBoard = new HashMap<>();
       Iterable<Game> games = gameDao.findAll();

       for (Game game : games) {
           Long winnerId = game.getWinnerId();
           Long loserId = game.getLoserId();

           if (leaderBoard.containsKey(winnerId)) {
               LeaderBoardEntryViewModel winnerEntry = leaderBoard.get(winnerId);
               winnerEntry.addWin();
           } else {
               User user = userDao.findOne(winnerId);
               LeaderBoardEntryViewModel entry = new LeaderBoardEntryViewModel(user.getNickname());
               entry.addWin();

               leaderBoard.put(user.getId(), entry);
           }

           if (leaderBoard.containsKey(loserId)) {
               LeaderBoardEntryViewModel loserEntry = leaderBoard.get(loserId);
               loserEntry.addLoss();
           } else {
               User user = userDao.findOne(loserId);
               LeaderBoardEntryViewModel entry = new LeaderBoardEntryViewModel(user.getNickname());
               entry.addLoss();

               leaderBoard.put(user.getId(), entry);
           }
       }

       List<LeaderBoardEntryViewModel> leaderBoardEntries = new ArrayList<LeaderBoardEntryViewModel>(leaderBoard.values());

       Comparator<LeaderBoardEntryViewModel> leaderBoardComparator = Comparator
               .comparing((LeaderBoardEntryViewModel e)-> e.getPercentage())
               .thenComparing(e -> e.getWins());

       Collections.sort(leaderBoardEntries, leaderBoardComparator.reversed());

       int position = 1;
       for (LeaderBoardEntryViewModel entry : leaderBoardEntries) {
           entry.setPosition(position);
           position++;
       }

       return leaderBoardEntries;
   }
}
