package gruvexp.gruvexp.tasks;

import gruvexp.gruvexp.Main;
import gruvexp.gruvexp.sumodata.Bar;
import gruvexp.gruvexp.sumodata.Board;
import gruvexp.gruvexp.sumodata.SumoData;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class PreBattle extends BukkitRunnable {
    int time = 0;

    BossBar bar;

    @Override
    public void run() {

        Main.activeBattle = 1;
        if (time == 0) {
            Bukkit.broadcastMessage(ChatColor.GRAY + "Temporary short wait time");
            bar  = Bar.GetBar(0); //endrer bar nr 1
            Bar.SetVisible(bar, true);
        }
        Bar.SetProgress(bar, (120d-time)/120); //starter på maks og minker med 1/120 hver gang

        if (time > 69 && time%10 == 0) {
            for (Player p:Bukkit.getOnlinePlayers()) {
                p.sendMessage("Tournament starting in "+(12 - time/10));
            }
        }
        if (time > 119) {
            Board.createTourneyBoard(SumoData.playerList);  // scoreboard med alle
                                                            // playersane som registrerte seg

            Bar.SetVisible(bar, false);
            SumoData.startNextTourney(false); //starter den første turneen
            for (Player p : SumoData.playerList) {
                p.teleport(new Location(Bukkit.getWorld("Sumo"), -110.5, 31.0, -152.5));
            }

            cancel(); // stopper runnable
        }
        time++;
    }
}
