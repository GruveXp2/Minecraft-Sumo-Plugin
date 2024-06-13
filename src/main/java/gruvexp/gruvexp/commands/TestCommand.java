package gruvexp.gruvexp.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class TestCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        //FUNKER IKKE! DET KOMMER IKKE OPP NOE!
        //husk å join med /menu så det dukker opp noe
        return true;
    }
}