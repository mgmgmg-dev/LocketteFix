package me.mgmgmg.lockettefix;

import org.bukkit.block.Sign;
import org.bukkit.block.sign.Side;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class SignListener implements Listener {
    @EventHandler(priority = EventPriority.LOW)
    @SuppressWarnings("all")
    public void onInteract(PlayerInteractEvent event) {
        // Right click on sign detection
        if (event.getAction() != Action.RIGHT_CLICK_BLOCK) return;
        if (!(event.getClickedBlock().getState() instanceof Sign sign)) return;

        // Block placing detection (alternative right-click)
        if (event.getPlayer().isSneaking() && event.getPlayer().getInventory().getItemInMainHand() != null) return;

        // Text comparison
        if (isPrivate(sign)) event.setCancelled(true);
    }

    public boolean isPrivate(Sign sign) {
        return switch (sign.getSide(Side.FRONT).getLine(0)) {
            default -> false;
            case "[Private]", "[More Users]" -> true;
        } || switch (sign.getSide(Side.BACK).getLine(0)) {
            default -> false;
            case "[Private]", "[More Users]" -> true;
        };
    }
}
