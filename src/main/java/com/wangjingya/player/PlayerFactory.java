package com.wangjingya.player;

import com.wangjingya.player.Player;
import com.wangjingya.player.impl.AIRobotPlayer;
import com.wangjingya.player.impl.ConsolerPlayer;
import com.wangjingya.player.impl.RandomRobotPlayer;
import com.wangjingya.player.impl.SimpleRobotPlayer;

public class PlayerFactory {
    public Player getPlayer(String playerType){
        if(playerType == null){
            return null;
        }
        if(playerType.equalsIgnoreCase("RANDOMROBOTPLAYER")){
            return new RandomRobotPlayer();
        }else if(playerType.equalsIgnoreCase("SIMPLEROBOTPLAYER")){
            return new SimpleRobotPlayer();
        }else if(playerType.equalsIgnoreCase("AIROBOTPLAYER")){
            return new AIRobotPlayer();
        }else if(playerType.equalsIgnoreCase("CONSOLERPLAYER")){
            return new ConsolerPlayer();
        }
        return null;
    }
}
