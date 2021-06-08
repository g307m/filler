package xyz.grantlmul.filler;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("filler")
public class Filler
{
    private static final Logger LOGGER = LogManager.getLogger();

    public static final Item ITEM_STEEL_NUGGET  = new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS));
    public static final Item ITEM_STEEL_INGOT   = new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS));
    //public static final Item ITEM_STEEL_BLOCK   = new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS));

    public static final Block BLOCK_STEEL_BLOCK = new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL).harvestLevel(2).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL));

    public static final BlockItem BLOCKITEM_STEEL_BLOCK = new BlockItem(BLOCK_STEEL_BLOCK, new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS));

    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "filler");
    private static final DeferredRegister<Item>  ITEMS  = DeferredRegister.create(ForgeRegistries.ITEMS,  "filler");

    public static final RegistryObject<Item>  REG_ITEM_STEEL_NUGGET  = ITEMS.register("steel_nugget",() -> ITEM_STEEL_NUGGET);
    public static final RegistryObject<Item>  REG_ITEM_STEEL_INGOT   = ITEMS.register("steel_ingot", () -> ITEM_STEEL_INGOT);
    public static final RegistryObject<Item>  REG_ITEM_STEEL_BLOCK   = ITEMS.register("steel_block", () -> BLOCKITEM_STEEL_BLOCK);

    public static final RegistryObject<Block> REG_BLOCK_STEEL_BLOCK  = BLOCKS.register("steel_block",() -> BLOCKITEM_STEEL_BLOCK.getBlock());

    public Filler() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("Filler preinit");
    }
}
