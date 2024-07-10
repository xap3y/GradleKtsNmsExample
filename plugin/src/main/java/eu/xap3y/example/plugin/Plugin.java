package eu.xap3y.example.plugin;


import eu.xap3y.example.plugin.listener.PlayerJoinListener;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public final class Plugin extends JavaPlugin {

    public static ItemStack item;

    @Override
    public void onEnable() {
        String nmsVersion = Bukkit.getServer().getClass().getPackage().getName();
        if (nmsVersion.contains("v1_8_")) {
            item = eu.xap3y.example.v1_8_R1.v1_8_R1.getGlassItem();
        } else if (nmsVersion.contains("v1_13_")) {
            item = eu.xap3y.example.v1_13_R1.v1_13_R1.getGlassItem();
        } else {
            item = new ItemStack(Material.DIRT);
        }

        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
    }

}
