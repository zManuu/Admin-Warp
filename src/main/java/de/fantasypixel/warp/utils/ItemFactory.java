package de.fantasypixel.warp.utils;

import de.fantasypixel.warp.core.WarpObject;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class ItemFactory {

    private ItemStack itemStack;

    public ItemFactory(WarpObject warp) {
        this.itemStack = new ItemStack(Material.GRASS_BLOCK);
        ItemMeta meta = this.itemStack.getItemMeta();
        meta.setDisplayName(warp.getName());
        meta.setLore(Arrays.asList(
                String.valueOf(warp.getLocation().getX()),
                String.valueOf(warp.getLocation().getY()),
                String.valueOf(warp.getLocation().getZ())
        ));
        itemStack.setItemMeta(meta);
    }

    public ItemStack build() {
        return itemStack;
    }

}
