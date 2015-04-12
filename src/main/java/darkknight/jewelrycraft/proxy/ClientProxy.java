package darkknight.jewelrycraft.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;
import darkknight.jewelrycraft.block.BlockList;
import darkknight.jewelrycraft.client.InventoryTabVanilla;
import darkknight.jewelrycraft.client.TabJewelry;
import darkknight.jewelrycraft.client.TabRegistry;
import darkknight.jewelrycraft.entities.EntityHalfHeart;
import darkknight.jewelrycraft.entities.EntityHeart;
import darkknight.jewelrycraft.entities.renders.HeartRender;
import darkknight.jewelrycraft.events.PlayerRenderHandler;
import darkknight.jewelrycraft.events.ScreenHandler;
import darkknight.jewelrycraft.item.render.ItemRender;
import darkknight.jewelrycraft.model.ModelDisplayer;
import darkknight.jewelrycraft.model.ModelHalfHeart;
import darkknight.jewelrycraft.model.ModelHandPedestal;
import darkknight.jewelrycraft.model.ModelHeart;
import darkknight.jewelrycraft.model.ModelJewlersCraftingBench;
import darkknight.jewelrycraft.model.ModelMolder;
import darkknight.jewelrycraft.model.ModelShadowEye;
import darkknight.jewelrycraft.model.ModelShadowHand;
import darkknight.jewelrycraft.model.ModelSmelter;
import darkknight.jewelrycraft.tileentity.TileEntityDisplayer;
import darkknight.jewelrycraft.tileentity.TileEntityHandPedestal;
import darkknight.jewelrycraft.tileentity.TileEntityJewelrsCraftingTable;
import darkknight.jewelrycraft.tileentity.TileEntityMolder;
import darkknight.jewelrycraft.tileentity.TileEntityShadowEye;
import darkknight.jewelrycraft.tileentity.TileEntityShadowHand;
import darkknight.jewelrycraft.tileentity.TileEntitySmelter;
import darkknight.jewelrycraft.tileentity.renders.TileEntityDisplayerRender;
import darkknight.jewelrycraft.tileentity.renders.TileEntityHandPedestalRender;
import darkknight.jewelrycraft.tileentity.renders.TileEntityJewelrsCraftingTableRender;
import darkknight.jewelrycraft.tileentity.renders.TileEntityMolderRender;
import darkknight.jewelrycraft.tileentity.renders.TileEntityShadowEyeRender;
import darkknight.jewelrycraft.tileentity.renders.TileEntityShadowHandRender;
import darkknight.jewelrycraft.tileentity.renders.TileEntitySmelterRender;
import darkknight.jewelrycraft.util.JewelrycraftUtil;
import darkknight.jewelrycraft.util.Variables;

public class ClientProxy extends CommonProxy
{
    @Override
    public void preInit()
    {
        ResourceLocation pedestalResourceLocation = new ResourceLocation(Variables.MODID, "textures/tileentities/BricksPedestal.png");
        TileEntityHandPedestalRender pedestalRender = new TileEntityHandPedestalRender(new ModelHandPedestal(pedestalResourceLocation), pedestalResourceLocation);
        ResourceLocation shadowResourceLocation = new ResourceLocation(Variables.MODID, "textures/tileentities/ShadowHand.png");
        TileEntityShadowHandRender shadowHandRender = new TileEntityShadowHandRender(new ModelShadowHand(shadowResourceLocation), shadowResourceLocation);
        
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySmelter.class, new TileEntitySmelterRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMolder.class, new TileEntityMolderRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityJewelrsCraftingTable.class, new TileEntityJewelrsCraftingTableRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDisplayer.class, new TileEntityDisplayerRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityShadowEye.class, new TileEntityShadowEyeRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHandPedestal.class, pedestalRender);
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityShadowHand.class, shadowHandRender);
        
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockList.displayer), new ItemRender(new TileEntityDisplayerRender(), new TileEntityDisplayer(), new ModelDisplayer()));
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockList.jewelCraftingTable), new ItemRender(new TileEntityJewelrsCraftingTableRender(), new TileEntityJewelrsCraftingTable(), new ModelJewlersCraftingBench()));
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockList.smelter), new ItemRender(new TileEntitySmelterRender(), new TileEntitySmelter(), new ModelSmelter()));
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockList.molder), new ItemRender(new TileEntityMolderRender(), new TileEntityMolder(), new ModelMolder()));
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockList.shadowEye), new ItemRender(new TileEntityShadowEyeRender(), new TileEntityShadowEye(), new ModelShadowEye()));
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockList.handPedestal), new ItemRender(pedestalRender, new TileEntityHandPedestal(), new ModelHandPedestal(pedestalResourceLocation)));
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockList.shadowHand), new ItemRender(shadowHandRender, new TileEntityShadowHand(), new ModelShadowHand(shadowResourceLocation)));
        VillagerRegistry.instance().registerVillagerSkin(3000, new ResourceLocation(Variables.MODID, "textures/entities/jeweler.png"));

        RenderingRegistry.registerEntityRenderingHandler(EntityHeart.class, new HeartRender(new ModelHeart(), 0.25F));
        RenderingRegistry.registerEntityRenderingHandler(EntityHalfHeart.class, new HeartRender(new ModelHalfHeart(), 0.25F));
        
        TabRegistry.registerTab(new InventoryTabVanilla());
        TabRegistry.registerTab(new TabJewelry());
        MinecraftForge.EVENT_BUS.register(new TabRegistry());
        MinecraftForge.EVENT_BUS.register(new PlayerRenderHandler());
        ResourceLocation jeweleryTexture = new ResourceLocation(Variables.MODID, "textures/gui/curses.png");
        MinecraftForge.EVENT_BUS.register(new ScreenHandler(Minecraft.getMinecraft(), jeweleryTexture));
    }
    
    @Override
    public void postInit()
    {
        JewelrycraftUtil.addStuff();        
    }
}