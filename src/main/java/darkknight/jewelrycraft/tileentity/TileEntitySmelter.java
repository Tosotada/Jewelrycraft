package darkknight.jewelrycraft.tileentity;

import java.util.Random;
import darkknight.jewelrycraft.config.ConfigHandler;
import darkknight.jewelrycraft.util.JewelryNBT;
import darkknight.jewelrycraft.util.JewelrycraftUtil;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntitySmelter extends TileEntity
{
    public int melting, flow, n = 0, p = 0;
    public boolean hasMetal, hasMoltenMetal, isDirty, pouring;
    public ItemStack metal, moltenMetal;
    public float quantity, pouredQuantity = 0.1f;
    
    /**
     * 
     */
    public TileEntitySmelter()
    {
        melting = 0;
        pouring = false;
        flow = 0;
        quantity = 0f;
        hasMetal = false;
        hasMoltenMetal = false;
        metal = new ItemStack(Item.getItemById(0), 0, 0);
        moltenMetal = new ItemStack(Item.getItemById(0), 0, 0);
        isDirty = false;
    }
    
    /**
     * @param nbt
     */
    @Override
    public void writeToNBT(NBTTagCompound nbt)
    {
        super.writeToNBT(nbt);
        nbt.setInteger("melting", melting);
        nbt.setFloat("quantity", quantity);
        nbt.setBoolean("hasMetal", hasMetal);
        nbt.setBoolean("hasMoltenMetal", hasMoltenMetal);
        nbt.setBoolean("pouring", pouring);
        NBTTagCompound tag = new NBTTagCompound();
        NBTTagCompound tag1 = new NBTTagCompound();
        metal.writeToNBT(tag);
        nbt.setTag("metal", tag);
        moltenMetal.writeToNBT(tag1);
        nbt.setTag("moltenMetal", tag1);
    }
    
    /**
     * @param nbt
     */
    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
        melting = nbt.getInteger("melting");
        quantity = nbt.getFloat("quantity");
        hasMetal = nbt.getBoolean("hasMetal");
        hasMoltenMetal = nbt.getBoolean("hasMoltenMetal");
        pouring = nbt.getBoolean("pouring");
        metal = new ItemStack(Item.getItemById(0), 0, 0);
        metal.readFromNBT(nbt.getCompoundTag("metal"));
        moltenMetal = new ItemStack(Item.getItemById(0), 0, 0);
        moltenMetal.readFromNBT(nbt.getCompoundTag("moltenMetal"));
    }
    
    /**
     * 
     */
    @Override
    public void updateEntity()
    {
        super.updateEntity();
        Random rand = new Random();
        if (isDirty){
            worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
            isDirty = false;
        }
        if (p > 0) --p;
        else p = 5;
        if (n == 0 && p == 0){
            flow += 16;
            if (flow >= 16 * 20) n = 1;
        }
        if (n == 1 && p == 0){
            flow -= 16;
            if (flow <= 0) n = 0;
        }
        if (hasMetal) for(int l = 0; l < 2; ++l)
            worldObj.spawnParticle("flame", xCoord + rand.nextFloat(), (double)yCoord + 0.3F, zCoord + rand.nextFloat(), 0.0D, 0.0D, 0.0D);
        if (rand.nextInt(65) == 0){
            double d5 = xCoord + rand.nextFloat();
            double d7 = yCoord;
            double d6 = zCoord + rand.nextFloat();
            worldObj.playSound(d5, d7, d6, "liquid.lavapop", 0.2F + rand.nextFloat() * 0.2F, 0.9F + rand.nextFloat() * 0.15F, false);
        }
        if (hasMetal && !hasMoltenMetal){
            boolean isOre = JewelrycraftUtil.isOre(metal);
            if (melting > 0) melting--;
            if (melting == 0){
                hasMetal = false;
                if (!isOre){
                    if(JewelryNBT.ingot(metal) == null) moltenMetal = metal;
                    else moltenMetal = JewelryNBT.ingot(metal);
                }
                else{
                    moltenMetal = JewelrycraftUtil.getIngotFromOre(metal);
                    moltenMetal.stackSize *= 2;
                }
                hasMoltenMetal = true;
                if (!isOre) quantity = 0.1f * metal.stackSize;
                else quantity = 0.2f * metal.stackSize;
                metal = new ItemStack(Item.getItemById(0), 0, 0);
                melting = -1;
                isDirty = true;
            }
        }else if (hasMoltenMetal){
            boolean isOre = JewelrycraftUtil.isOre(metal);
            if (melting > 0) melting--;
            if (melting == 0){
                hasMetal = false;
                if (!isOre) moltenMetal.stackSize += metal.stackSize;
                else moltenMetal.stackSize += metal.stackSize * 2;
                if (!isOre) quantity += 0.1f * metal.stackSize;
                else quantity += 0.2f * metal.stackSize;
                metal = new ItemStack(Item.getItemById(0), 0, 0);
                melting = -1;
                isDirty = true;
            }
        }
        TileEntityMolder me = null;
        if (worldObj.getBlockMetadata(xCoord, yCoord, zCoord) == 0 && worldObj.getTileEntity(xCoord, yCoord, zCoord - 1) != null && worldObj.getTileEntity(xCoord, yCoord, zCoord - 1) instanceof TileEntityMolder) me = (TileEntityMolder)worldObj.getTileEntity(xCoord, yCoord, zCoord - 1);
        else if (worldObj.getBlockMetadata(xCoord, yCoord, zCoord) == 1 && worldObj.getTileEntity(xCoord + 1, yCoord, zCoord) != null && worldObj.getTileEntity(xCoord + 1, yCoord, zCoord) instanceof TileEntityMolder) me = (TileEntityMolder)worldObj.getTileEntity(xCoord + 1, yCoord, zCoord);
        else if (worldObj.getBlockMetadata(xCoord, yCoord, zCoord) == 2 && worldObj.getTileEntity(xCoord, yCoord, zCoord + 1) != null && worldObj.getTileEntity(xCoord, yCoord, zCoord + 1) instanceof TileEntityMolder) me = (TileEntityMolder)worldObj.getTileEntity(xCoord, yCoord, zCoord + 1);
        else if (worldObj.getBlockMetadata(xCoord, yCoord, zCoord) == 3 && worldObj.getTileEntity(xCoord - 1, yCoord, zCoord) != null && worldObj.getTileEntity(xCoord - 1, yCoord, zCoord) instanceof TileEntityMolder) me = (TileEntityMolder)worldObj.getTileEntity(xCoord - 1, yCoord, zCoord);
        if (pouring && pouredQuantity > 0f){
            quantity -= 0.01f;
            pouredQuantity -= 0.01f;
            me.quantity += 0.01f;
            if (!me.hasMoltenMetal){
                me.moltenMetal = moltenMetal;
                me.hasMoltenMetal = true;
            }
            if (pouredQuantity <= 0f){
                pouring = false;
                pouredQuantity = 0.1f;
                me.cooling = ConfigHandler.INGOT_COOLING_TIME;
            }
            if (quantity <= 0f){
                quantity = 0f;
                hasMoltenMetal = false;
                moltenMetal = new ItemStack(Item.getItemById(0), 0, 0);
                me.cooling = ConfigHandler.INGOT_COOLING_TIME;
            }
            me.isDirty = true;
        }
    }
    
    /**
     * @return
     */
    @Override
    public Packet getDescriptionPacket()
    {
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        writeToNBT(nbttagcompound);
        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, nbttagcompound);
    }
    
    /**
     * @param net
     * @param packet
     */
    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet)
    {
        readFromNBT(packet.func_148857_g());
        worldObj.func_147479_m(xCoord, yCoord, zCoord);
    }
}
