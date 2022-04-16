package de.fantasypixel.warp.listener;

import de.fantasypixel.warp.Warp;
import org.bukkit.Effect;
import org.bukkit.EntityEffect;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player))
            return;

        if (event.getClickedInventory() == null)
            return;

        if (!event.getView().getTitle().equals("§5§lWarps"))
            return;

        if (event.getCurrentItem() == null)
            return;

        event.setCancelled(true);
        event.setResult(Event.Result.DENY);

        Player player = (Player) event.getWhoClicked();

        String warpName = event.getCurrentItem().getItemMeta().getDisplayName();

        player.teleport(Warp.getWarp(warpName).getLocation().toLocation());
        player.sendTitle("§6§l" + warpName, "", 10, 20, 10);
        player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
        player.playEffect(player.getLocation(), Effect.ENDER_SIGNAL, 1);

    }

}
