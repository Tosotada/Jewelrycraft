package darkknight.jewelrycraft.item;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import darkknight.jewelrycraft.JewelrycraftMod;
import darkknight.jewelrycraft.block.BlockList;

public class ItemList
{
	public static Item     thiefGloves;
	public static Item     shadowIngot;
	public static Item     molds;
	public static Item     clayMolds;
	public static Item     crystal;
	public static ItemRing     ring;
	public static ItemNecklace     necklace;
	public static Item     guide;
	public static ItemMoltenMetalBucket     bucket;

	private static boolean isInitialized = false;

	public static void preInit(FMLPreInitializationEvent e)
	{
		if (!isInitialized)
		{
			thiefGloves = new ItemThiefGloves().setUnlocalizedName("Jewelrycraft.thiefGloves").setTextureName("jewelrycraft:thiefGloves").setCreativeTab(JewelrycraftMod.jewelrycraft);
			shadowIngot = new Item().setUnlocalizedName("Jewelrycraft.ingotShadow").setTextureName("jewelrycraft:ingotShadow").setCreativeTab(JewelrycraftMod.jewelrycraft);
			molds = new ItemMolds().setUnlocalizedName("Jewelrycraft.mold").setTextureName("Mold").setCreativeTab(JewelrycraftMod.jewelrycraft);
			clayMolds = new ItemClayMolds().setUnlocalizedName("Jewelrycraft.mold").setTextureName("Mold").setCreativeTab(JewelrycraftMod.jewelrycraft);
			ring = (ItemRing) new ItemRing().setUnlocalizedName("Jewelrycraft.ring").setTextureName("jewelrycraft:ring");
			crystal = new ItemCrystal().setUnlocalizedName("Jewelrycraft.crystal").setTextureName("jewelrycraft:crystal").setCreativeTab(JewelrycraftMod.jewelrycraft);
			necklace = (ItemNecklace) new ItemNecklace().setUnlocalizedName("Jewelrycraft.necklace").setTextureName("jewelrycraft:necklace");
			guide = new ItemGuide().setUnlocalizedName("Jewelrycraft.guide").setTextureName("jewelrycraft:guide").setCreativeTab(JewelrycraftMod.jewelrycraft);
			bucket = (ItemMoltenMetalBucket) new ItemMoltenMetalBucket().setUnlocalizedName("Jewelrycraft.bucket");

			GameRegistry.registerItem(thiefGloves, "thiefGloves");
			GameRegistry.registerItem(shadowIngot, "shadowIngot");
			GameRegistry.registerItem(molds, "molds");
			GameRegistry.registerItem(clayMolds, "clayMolds");
			GameRegistry.registerItem(ring, "ring");
			GameRegistry.registerItem(necklace, "necklace");
			GameRegistry.registerItem(crystal, "crystal");
			GameRegistry.registerItem(guide, "guide");
			GameRegistry.registerItem(bucket, "moltenMetalBucket");

			isInitialized = true;
		}
	}
}
