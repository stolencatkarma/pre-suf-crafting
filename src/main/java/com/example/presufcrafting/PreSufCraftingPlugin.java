package com.example.presufcrafting;

import org.bukkit.plugin.java.JavaPlugin;

public class PreSufCraftingPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("PreSufCrafting enabled!");
        getServer().getPluginManager().registerEvents(new ItemPrefixSuffixListener(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("PreSufCrafting disabled!");
    }
}
