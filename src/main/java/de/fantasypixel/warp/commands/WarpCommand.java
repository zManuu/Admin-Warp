package de.fantasypixel.warp.commands;

import de.fantasypixel.warp.Warp;
import de.fantasypixel.warp.core.WarpObject;
import de.fantasypixel.warp.utils.ItemFactory;
import de.fantasypixel.warp.utils.JsonLocation;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class WarpCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player))
            return true;

        Player player = (Player) sender;

        if (args.length == 0) {

            if (!player.hasPermission("rpg.commands.admin.warp")) {
                player.sendMessage(Warp.CONSTANTS.noPerms);
                return true;
            }

            Inventory gui = Bukkit.createInventory(null, 54, "§5§lWarps");
            for (WarpObject warp : Warp.getWarps()) {
                gui.addItem(new ItemFactory(warp).build());
            }
            player.openInventory(gui);

        } else if (args.length == 1) {

            if (!player.hasPermission("rpg.commands.admin.warp.set")) {
                player.sendMessage(Warp.CONSTANTS.noPerms);
                return true;
            }

            if (args[0].equals("reload")) {
                Warp.getInstance().reload();
                player.sendMessage(Warp.CONSTANTS.prefix + "§aDie Warps wurden neu geladen!");
                return true;
            }

            if (Warp.getWarp(args[0]) != null) {
                player.sendMessage(Warp.CONSTANTS.prefix + "§cEin Warp mit diesem Namen gibt es bereits!");
                return true;
            }

            JsonLocation location = new JsonLocation(player.getLocation());
            Warp.getWarps().add(new WarpObject(location, args[0]));

            player.sendMessage(Warp.CONSTANTS.prefix + "§7Du hast den Warp §a\"" + args[0] + "\"§7 erstellt!");

        } else
            player.sendMessage(Warp.CONSTANTS.wrongArgs);

        return false;
    }
}
