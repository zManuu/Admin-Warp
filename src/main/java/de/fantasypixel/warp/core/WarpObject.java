package de.fantasypixel.warp.core;

import de.fantasypixel.warp.utils.JsonLocation;

public class WarpObject {

    private final JsonLocation location;
    private final String name;

    public WarpObject(JsonLocation location, String name) {
        this.location = location;
        this.name = name;
    }

    public JsonLocation getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "WarpObject{" +
                "location=" + location.toString() +
                ", name='" + name + '\'' +
                '}';
    }
}
