package darkknight.jewelrycraft.client.gui.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import darkknight.jewelrycraft.client.gui.container.slots.SlotBracelet;
import darkknight.jewelrycraft.client.gui.container.slots.SlotEarrings;
import darkknight.jewelrycraft.client.gui.container.slots.SlotNecklace;
import darkknight.jewelrycraft.client.gui.container.slots.SlotRing;
import darkknight.jewelrycraft.item.ItemBracelet;
import darkknight.jewelrycraft.item.ItemEarrings;
import darkknight.jewelrycraft.item.ItemNecklace;
import darkknight.jewelrycraft.item.ItemRing;

public class ContainerJewelryTab extends Container
{
    
    /**
     * @param player
     * @param inv
     * @param extra
     */
    public ContainerJewelryTab(EntityPlayer player, IInventory inv, IInventory extra)
    {
        int x, y;
        // Rings
        for(x = 0; x <= 9; x++)
            addSlotToContainer(new SlotRing(extra, x, 8 + x * 18, 7));
        // Bracelets
        for(x = 10; x <= 13; x++)
            addSlotToContainer(new SlotBracelet(extra, x, 8 + (x - 10) * 18, 26));
        // Necklaces
        for(x = 14; x <= 16; x++)
            addSlotToContainer(new SlotNecklace(extra, x, 8 + (x - 14) * 18, 45));
        // Earrings
        addSlotToContainer(new SlotEarrings(extra, 17, 8, 64));
        // Hotbar
        for(x = 0; x < 9; ++x)
            addSlotToContainer(new Slot(inv, x, 17 + x * 18, 142));
        // Inventory
        for(x = 0; x < 3; ++x)
            for(y = 0; y < 9; ++y)
                addSlotToContainer(new Slot(inv, 9 + y + x * 9, 17 + y * 18, 84 + x * 18));
    }
    
    /**
     * @param player
     * @return
     */
    @Override
    public boolean canInteractWith(EntityPlayer player)
    {
        return true;
    }
    
    /**
     * @param player
     * @param slotID
     * @return
     */
    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slotID)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)inventorySlots.get(slotID);
        if (slot != null && slot.getHasStack()){
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            if (slotID < 18){
                if (!mergeItemStack(itemstack1, 18, 18 + 36, true)) return null;
                slot.onSlotChange(itemstack1, itemstack);
            }else if (itemstack1.getItem() instanceof ItemRing){
                if (!mergeItemStack(itemstack1, 0, 10, false)) return null;
            }else if (itemstack1.getItem() instanceof ItemBracelet){
                if (!mergeItemStack(itemstack1, 10, 14, false)) return null;
            }else if (itemstack1.getItem() instanceof ItemNecklace){
                if (!mergeItemStack(itemstack1, 14, 17, false)) return null;
            }else if (itemstack1.getItem() instanceof ItemEarrings){
                if (!mergeItemStack(itemstack1, 17, 18, false)) return null;
            }else{
                if (!mergeItemStack(itemstack1, 18, 54, true)) return null;
                slot.onSlotChange(itemstack1, itemstack);
            }
            if (itemstack1.stackSize == 0) slot.putStack((ItemStack)null);
            else slot.onSlotChanged();
        }
        return itemstack;
    }
}