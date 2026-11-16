package com.enderdevelopment.plugin;

import java.util.ArrayList;
import java.util.List;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements CommandExecutor {
    private static final Color LAPIS_COLOR = Color.fromRGB(38, 97, 156);
    private NamespacedKey itemKey;

    @Override
    public void onEnable() {
        itemKey = new NamespacedKey(this, "lapis_gear_item");
        registerRecipes();
        if (getCommand("lapisgear") != null) {
            getCommand("lapisgear").setExecutor(this);
        }
    }

    @Override
    public void onDisable() {
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage(Component.text("Only players can receive the lapis gear set.", NamedTextColor.RED));
            return true;
        }
        for (ItemStack item : equipmentSet()) {
            player.getInventory().addItem(item);
        }
        player.sendMessage(Component.text("You received the complete Lapis Lazuli set.", NamedTextColor.AQUA));
        return true;
    }

    private List<ItemStack> equipmentSet() {
        List<ItemStack> items = new ArrayList<>();
        items.add(createArmor(Material.LEATHER_HELMET, "Lapis Lazuli Helmet", "Protective lapis lazuli armor."));
        items.add(createArmor(Material.LEATHER_CHESTPLATE, "Lapis Lazuli Chestplate", "Protective lapis lazuli armor."));
        items.add(createArmor(Material.LEATHER_LEGGINGS, "Lapis Lazuli Leggings", "Protective lapis lazuli armor."));
        items.add(createArmor(Material.LEATHER_BOOTS, "Lapis Lazuli Boots", "Protective lapis lazuli armor."));
        items.add(createTool(Material.DIAMOND_SWORD, "Lapis Lazuli Sword", "A sharp blade infused with lapis."));
        items.add(createTool(Material.DIAMOND_PICKAXE, "Lapis Lazuli Pickaxe", "A durable pickaxe infused with lapis."));
        items.add(createTool(Material.DIAMOND_AXE, "Lapis Lazuli Axe", "A powerful axe infused with lapis."));
        items.add(createTool(Material.DIAMOND_SHOVEL, "Lapis Lazuli Shovel", "A sturdy shovel infused with lapis."));
        items.add(createTool(Material.DIAMOND_HOE, "Lapis Lazuli Hoe", "A refined hoe infused with lapis."));
        return items;
    }

    private ItemStack createArmor(Material material, String name, String description) {
        ItemStack item = new ItemStack(material);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        meta.setColor(LAPIS_COLOR);
        applyMeta(meta, name, description);
        item.setItemMeta(meta);
        return item;
    }

    private ItemStack createTool(Material material, String name, String description) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        applyMeta(meta, name, description);
        item.setItemMeta(meta);
        return item;
    }

    private void applyMeta(ItemMeta meta, String name, String description) {
        meta.displayName(Component.text(name, NamedTextColor.BLUE));
        meta.lore(List.of(Component.text(description, NamedTextColor.GRAY)));
        meta.getPersistentDataContainer().set(itemKey, PersistentDataType.STRING, "lapis_lazuli");
    }

    private void registerRecipes() {
        registerArmorRecipe("helmet", createArmor(Material.LEATHER_HELMET, "Lapis Lazuli Helmet", "Protective lapis lazuli armor."), " L ", "LLL", "   ");
        registerArmorRecipe("chestplate", createArmor(Material.LEATHER_CHESTPLATE, "Lapis Lazuli Chestplate", "Protective lapis lazuli armor."), "L L", "LLL", "LLL");
        registerArmorRecipe("leggings", createArmor(Material.LEATHER_LEGGINGS, "Lapis Lazuli Leggings", "Protective lapis lazuli armor."), "LLL", "L L", "L L");
        registerArmorRecipe("boots", createArmor(Material.LEATHER_BOOTS, "Lapis Lazuli Boots", "Protective lapis lazuli armor."), "   ", "L L", "L L");
        registerToolRecipe("sword", createTool(Material.DIAMOND_SWORD, "Lapis Lazuli Sword", "A sharp blade infused with lapis."), "L", "L", "S");
        registerToolRecipe("pickaxe", createTool(Material.DIAMOND_PICKAXE, "Lapis Lazuli Pickaxe", "A durable pickaxe infused with lapis."), "LLL", " S ", " S ");
        registerToolRecipe("axe", createTool(Material.DIAMOND_AXE, "Lapis Lazuli Axe", "A powerful axe infused with lapis."), "LL", "LS", " S");
        registerToolRecipe("shovel", createTool(Material.DIAMOND_SHOVEL, "Lapis Lazuli Shovel", "A sturdy shovel infused with lapis."), "L", "S", "S");
        registerToolRecipe("hoe", createTool(Material.DIAMOND_HOE, "Lapis Lazuli Hoe", "A refined hoe infused with lapis."), "LL", " S", " S");
    }

    private void registerArmorRecipe(String key, ItemStack result, String... shape) {
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(this, "lapis_" + key), result);
        recipe.shape(shape);
        recipe.setIngredient('L', Material.LAPIS_LAZULI);
        Bukkit.addRecipe(recipe);
    }

    private void registerToolRecipe(String key, ItemStack result, String... shape) {
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(this, "lapis_" + key), result);
        recipe.shape(shape);
        recipe.setIngredient('L', Material.LAPIS_BLOCK);
        recipe.setIngredient('S', Material.STICK);
        Bukkit.addRecipe(recipe);
    }
}
