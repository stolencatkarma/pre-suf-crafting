package com.example.presufcrafting;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.*;

public class ItemPrefixSuffixListener implements Listener {
    private static final List<String> PREFIXES = Arrays.asList("Mighty", "Swift", "Ancient", "Glowing", "Frozen", "Fiery");
    private static final List<String> SUFFIXES = Arrays.asList("of Power", "of Speed", "of Wisdom", "of the Bear", "of the Eagle", "of the Wolf");
    private final Random random = new Random();

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        ItemStack item = event.getItem();
        if (item == null || !item.hasItemMeta()) return;
        ItemMeta meta = item.getItemMeta();
        if (meta == null) return;
        // Only apply if item doesn't already have prefixes/suffixes
        if (meta.hasLore()) return;
        List<String> lore = new ArrayList<>();
        int prefixCount = 1 + random.nextInt(3);
        int suffixCount = 1 + random.nextInt(3);
        Set<Integer> usedPrefix = new HashSet<>();
        Set<Integer> usedSuffix = new HashSet<>();
        for (int i = 0; i < prefixCount; i++) {
            int idx;
            do { idx = random.nextInt(PREFIXES.size()); } while (!usedPrefix.add(idx));
            lore.add(PREFIXES.get(idx));
        }
        for (int i = 0; i < suffixCount; i++) {
            int idx;
            do { idx = random.nextInt(SUFFIXES.size()); } while (!usedSuffix.add(idx));
            lore.add(SUFFIXES.get(idx));
        }
        meta.setLore(lore);
        item.setItemMeta(meta);
    }
}
