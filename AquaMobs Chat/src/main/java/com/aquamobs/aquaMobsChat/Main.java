package com.aquamobs.aquaMobsChat;

import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.logging.Level;

public final class Main extends JavaPlugin {

    private static Main plugin;

    private BukkitAudiences adventure;

    public @NonNull BukkitAudiences adventure() {
        if(this.adventure == null) {
            throw new IllegalStateException("Tried to access Adventure when the plugin was disabled!");
        }
        return this.adventure;
    }

    @Override
    public void onEnable() {

        this.adventure = BukkitAudiences.create(this);

        VaultHook.setupChat();
        VaultHook.setupEconomy();
        VaultHook.setupPermissions();

        getServer().getLogger().log(Level.INFO, "AMChat has started!");

        getServer().getPluginManager().registerEvents(new ChatFormatting(), this);

    }

    @Override
    public void onDisable() {
        getServer().getLogger().log(Level.INFO, "AMChat Plugin has stopped!");

    }

}