package net.antgire.mastercraft.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class CreativeTab {
    public static final CreativeModeTab MASTER_TAB = new CreativeModeTab("mastertab") {
        public ItemStack makeIcon()
        {
            return new ItemStack(ModItems.COIN.get());
        }
    };
}
