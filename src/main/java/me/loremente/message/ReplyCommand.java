package me.loremente.message;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class ReplyCommand implements CommandExecutor {

    private Message main;

    public ReplyCommand(Message main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            Player player = (Player)sender;

            if (args.length >= 2) {
                if (main.getRecentMessages().containsKey(player.getUniqueId())) {
                    UUID uuid = main.getRecentMessages().get(player.getUniqueId());
                    if (Bukkit.getPlayer(uuid) != null) {
                        Player target = Bukkit.getPlayer(uuid);

                    } else {
                    player.sendMessage(ChatColor.RED + "Il player con cui stavi scrivendo è andato offline");
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "Non hai messaggi!");
                }

            } else {
              player.sendMessage(ChatColor.RED + "Usa /reply <Messaggio>");
            }
        }

        return false;
    }
}
