package net.antgire.mastercraft.item;

import net.antgire.mastercraft.MasterCraft;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MasterCraft.MOD_ID);

    public static final RegistryObject<Item> COIN = ITEMS.register("coin",
            () -> new Item(new Item.Properties().tab(CreativeTab.MASTER_TAB)));

    public static final RegistryObject<Item> RAW_OXYNIA = ITEMS.register("raw_oxynia",
            () -> new Item(new Item.Properties().tab(CreativeTab.MASTER_TAB)));

    public static final RegistryObject<Item> OXYNIA = ITEMS.register("oxynia",
            () -> new Item(new Item.Properties().tab(CreativeTab.MASTER_TAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
