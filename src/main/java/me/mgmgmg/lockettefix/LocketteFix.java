package me.mgmgmg.lockettefix;

import org.bukkit.plugin.java.JavaPlugin;

public final class LocketteFix extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new SignListener(), this);
        getLogger().info("Plugin enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin disabled!");
    }
}
