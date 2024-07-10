package eu.xap3y.example.v1_8_R1;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class v1_8_R1 {

    public static ItemStack getGlassItem() {
        Material material = Material.STAINED_GLASS_PANE;
        return new ItemStack(material, 1, (short) 14);
    }

}
