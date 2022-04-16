package de.fantasypixel.warp.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class JsonLocation {

    private final int x;
    private final int y;
    private final int z;
    private final String world;

    public JsonLocation(Location location) {
        this.x = location.getBlockX();
        this.y = location.getBlockY();
        this.z = location.getBlockZ();
        this.world = location.getWorld().getName();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    @Override
    public String toString() {
        return "JsonLocation{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", world='" + world + '\'' +
                '}';
    }

    public Location toLocation() {
        return new Location(Bukkit.getWorld(world), x, y, z);
    }

}
