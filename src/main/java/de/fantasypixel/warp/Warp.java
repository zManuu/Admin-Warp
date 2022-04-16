package de.fantasypixel.warp;

import com.google.gson.Gson;
import de.fantasypixel.warp.commands.WarpCommand;
import de.fantasypixel.warp.core.WarpObject;
import de.fantasypixel.warp.listener.InventoryListener;
import de.fantasypixel.warp.utils.Constants;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Warp extends JavaPlugin {

    public static Constants CONSTANTS;
    private static Warp instance;

    public static Warp getInstance() {
        return instance;
    }

    private static Set<WarpObject> warps;

    @Override
    public void onEnable() {
        instance = this;
        CONSTANTS = new Constants();
        loadWarps();

        getCommand("warp").setExecutor(new WarpCommand());
        Bukkit.getPluginManager().registerEvents(new InventoryListener(), this);
    }

    @Override
    public void onDisable() {
        saveWarps();
    }

    public void reload() {
        saveWarps();
        warps = null;
        loadWarps();
    }

    private void saveWarps() {
        Gson gson = new Gson();
        try {
            for (WarpObject warp : warps) {
                File file = new File("plugins/RPGWarp/Warps", warp.getName() + ".json");
                if (file.exists())
                    continue;
                file.createNewFile();
                file.mkdirs();
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write(gson.toJson(warp, WarpObject.class));
                fileWriter.close();
            }
        } catch (Exception e) { e.printStackTrace(); }
    }

    private void loadWarps() {

        Gson gson = new Gson();

        warps = new HashSet<>();

        try (Stream<Path> walk = Files.walk(Paths.get("plugins/RPGWarp/Warps"))) {

            List<String> result = walk.filter(Files::isRegularFile)
                    .map(Path::toString).collect(Collectors.toList());

            for (String currentFile : result) {

                Scanner in = new Scanner(new FileReader(currentFile));
                StringBuilder b = new StringBuilder();
                while (in.hasNext()) {
                    b.append(in.next());
                }

                warps.add(gson.fromJson(b.toString(), WarpObject.class));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        for (WarpObject warp : warps) {
            System.out.println(warp.toString());
        }

    }

    public static Set<WarpObject> getWarps() {
        return warps;
    }
    public static WarpObject getWarp(String name) {
        for (WarpObject warp : warps) {
            if (warp.getName().equals(name))
                return warp;
        }
        return null;
    }
}
