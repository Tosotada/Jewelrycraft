package darkknight.jewelrycraft;
import java.util.ArrayList;
import java.util.List;

import darkknight.jewelrycraft.item.ItemList;
import darkknight.jewelrycraft.util.JewelryNBT;
import darkknight.jewelrycraft.util.JewelrycraftUtil;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class CreativeTabLiquids extends CreativeTabs
{
	public static ArrayList<ItemStack> metal = new ArrayList<ItemStack>();

	public CreativeTabLiquids(String par2Str) 
	{
		super(par2Str);
		metal.add(new ItemStack(Items.gold_ingot));
		metal.add(new ItemStack(Items.iron_ingot));
	}

	@Override
	public Item getTabIconItem()
	{
		return ItemList.bucket;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void displayAllReleventItems(List par1List)
	{
		int index = 0, index2 = 0;
		while(index < OreDictionary.getOreNames().length)
		{
			while(index2 < OreDictionary.getOres(OreDictionary.getOreNames()[index]).size())
			{
				if(OreDictionary.getOres(OreDictionary.getOreNames()[index]).get(index2).getUnlocalizedName().toLowerCase().contains("ingot") && !metal.contains(OreDictionary.getOres(OreDictionary.getOreNames()[index]).get(index2)))
					metal.add(OreDictionary.getOres(OreDictionary.getOreNames()[index]).get(index2));
				index2++;
			}
			index2 = 0;
			index++;
		}   
		for(int i = 0; i < metal.size(); i++) par1List.add(ItemList.bucket.getModifiedItemStack(metal.get(i)));
	}

}
