package net.outmoded.elytrafix;

import com.destroystokyo.paper.event.player.PlayerElytraBoostEvent;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;


public class ElytraListener implements Listener {

    @EventHandler
    public void onPlayerElytraBoostEvent(PlayerElytraBoostEvent event){
        Player player = event.getPlayer();
        if (player.isGliding()){
            player.setCooldown(event.getItemStack().getType(), 100);
        }




    }
    @EventHandler
    public void onPlayerItemDamageEvent(PlayerItemDamageEvent event){
        ItemStack itemStack = event.getItem();
        if (itemStack.getType() == Material.ELYTRA){
            ItemMeta meta = itemStack.getItemMeta();
            Damageable damageable = (Damageable) meta;
            meta.setEnchantable(1);
            if (!damageable.hasMaxDamage()){
                damageable.setMaxDamage(750);
                itemStack.setItemMeta(damageable);

            }


        }


    }

    @EventHandler
    public void onInventoryClickEvent(InventoryClickEvent event){
        ItemStack itemStack = event.getCurrentItem();
        ItemMeta meta = itemStack.getItemMeta();
        Damageable damageable = (Damageable) meta;
        if (itemStack.getType() == Material.ELYTRA){

            if (!damageable.hasMaxDamage()){
                damageable.setMaxDamage(750);
                itemStack.setItemMeta(damageable);

            }


        }


    }

    @EventHandler
    public void onPrepareAnvilEvent(PrepareAnvilEvent event){
        ItemStack firstItem = event.getInventory().getFirstItem();
        ItemStack secondItem = event.getInventory().getSecondItem();

        if (firstItem != null && firstItem.getType() == Material.ELYTRA) {
            if (secondItem != null && secondItem.getType() == Material.ENCHANTED_BOOK) {
                // Block the combination by setting the result to null
                event.setResult(null);
            }
        }
    }




}
