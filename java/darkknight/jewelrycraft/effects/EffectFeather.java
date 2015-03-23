package darkknight.jewelrycraft.effects;

import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import darkknight.jewelrycraft.damage.DamageSourceList;
import darkknight.jewelrycraft.item.ItemBracelet;
import darkknight.jewelrycraft.item.ItemEarrings;
import darkknight.jewelrycraft.item.ItemNecklace;
import darkknight.jewelrycraft.item.ItemRing;
import darkknight.jewelrycraft.util.JewelryNBT;
import darkknight.jewelrycraft.util.PlayerUtils;

public class EffectFeather extends ModifierEffects
{
    public EffectFeather()
    {
        super(new ItemStack(Items.feather));
    }
    
    @Override
    public void action(ItemStack item, EntityPlayer player, Item jewelry)
    {
        int pos = JewelryNBT.doesModifierExist(item, modifier);
        NBTTagCompound playerInfo = PlayerUtils.getModPlayerPersistTag(player, "Jewelrycraft");
        // Positive earrings
        if (jewelry instanceof ItemEarrings && pos != -1){
            AxisAlignedBB axisalignedbb = player.boundingBox.expand(1.0D, 1.0D, 1.0D);
            List list = player.worldObj.getEntitiesWithinAABB(EntityArrow.class, axisalignedbb);
            if (!player.worldObj.isRemote && list != null && !list.isEmpty()){
                Iterator iterator = list.iterator();
                while (iterator.hasNext()){
                    EntityArrow arrow = (EntityArrow)iterator.next();
                    if (rand.nextInt(3) == 0 && (arrow.shootingEntity == null || !(arrow.shootingEntity.equals(player)) || arrow.canBePickedUp == 0)) arrow.setDead();
                }
            }
        }
        // Positive bracelet
        if (jewelry instanceof ItemBracelet && pos != -1){
            if (player.motionY < 0) player.motionY *= 0.6D;
            player.setAIMoveSpeed(player.getAIMoveSpeed() / 2);
            player.fallDistance = 0F;
        }
    }
    
    @Override
    public void onEntityAttacked(ItemStack item, EntityPlayer player, Entity target, Item jewelry, float amount)
    {
        int pos = JewelryNBT.doesModifierExist(item, modifier);
        NBTTagCompound playerInfo = PlayerUtils.getModPlayerPersistTag(player, "Jewelrycraft");
        NBTTagCompound enemyData = target.getEntityData();
        if (jewelry instanceof ItemRing && pos != -1 && enemyData.getInteger("reAttacked") == 0){
            enemyData.setInteger("reAttacked", enemyData.getInteger("reAttacked") + 1);
            target.attackEntityFrom(DamageSource.causePlayerDamage(player), amount / 2F);
            if (rand.nextInt(2) == 0){
                enemyData.setInteger("stunTime", 50);
                enemyData.setBoolean("stunned", true);
            }
            playerInfo.setBoolean("weakDamage", true);
        }
        if (enemyData.getInteger("reAttacked") == 1) enemyData.setInteger("reAttacked", 0);
    }
    
    @Override
    public void onPlayerAttacked(ItemStack item, EntityPlayer player, DamageSource source, Item jewelry, float amount)
    {
        int pos = JewelryNBT.doesModifierExist(item, modifier);
        NBTTagCompound playerInfo = PlayerUtils.getModPlayerPersistTag(player, "Jewelrycraft");
        if (jewelry instanceof ItemNecklace && pos != -1 && rand.nextInt(4) == 0 && source != DamageSourceList.weak && source != DamageSource.inFire && source != DamageSource.onFire && source != DamageSource.lava){
            player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.GRAY + "The necklace protected you from taking damage!"));
            playerInfo.setBoolean("negateDamage", true);
        }
        // Negative necklace
        if (jewelry instanceof ItemNecklace && pos != -1 && (source == DamageSource.inFire || source == DamageSource.onFire || source == DamageSource.lava) && source != DamageSourceList.weak) player.attackEntityFrom(DamageSourceList.weak, amount * 3F);
        // Negative earrings
        if (jewelry instanceof ItemEarrings && pos != -1 && source.damageType.equals("arrow") && source != DamageSourceList.weak) player.attackEntityFrom(DamageSourceList.weak, amount * 2F);
    }
}
