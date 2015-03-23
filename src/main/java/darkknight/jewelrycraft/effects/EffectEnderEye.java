package darkknight.jewelrycraft.effects;

import net.minecraft.block.BlockOre;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings.Options;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Vec3;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.relauncher.ReflectionHelper;
import darkknight.jewelrycraft.item.ItemBracelet;
import darkknight.jewelrycraft.item.ItemEarrings;
import darkknight.jewelrycraft.item.ItemNecklace;
import darkknight.jewelrycraft.item.ItemRing;
import darkknight.jewelrycraft.util.JewelryNBT;

public class EffectEnderEye extends ModifierEffects
{
    private boolean originalVD = false;
    private float originalViewDistance;
    public EffectEnderEye()
    {
        super(new ItemStack(Items.ender_eye));
    }
    
    @Override
    public void action(ItemStack item, EntityPlayer player, Item jewelry)
    {
        int pos = JewelryNBT.doesModifierExist(item, modifier);
        if (jewelry instanceof ItemEarrings && pos != -1 && !player.worldObj.isRemote){
            for(Object e: player.worldObj.getEntitiesWithinAABB(EntityEnderman.class, player.boundingBox.expand(100D, 0D, 100D))){
                EntityEnderman enderman = (EntityEnderman)e;
                ReflectionHelper.setPrivateValue(EntityEnderman.class, enderman, -1, "stareTimer", "field_70826_g");
                Vec3 vec3 = player.getLook(1.0F).normalize();
                Vec3 vec31 = Vec3.createVectorHelper(enderman.posX - player.posX, enderman.boundingBox.minY + (double)(enderman.height / 2.0F) - (player.posY + (double)player.getEyeHeight()), enderman.posZ - player.posZ);
                double d0 = vec31.lengthVector();
                vec31 = vec31.normalize();
                double d1 = vec3.dotProduct(vec31);
                if (d1 > 1.0D - 0.025D / d0 && player.canEntityBeSeen(enderman)){
                    enderman.setTarget(null);
                    if (!player.isPotionActive(Potion.confusion) || player.getActivePotionEffect(Potion.confusion).getDuration() <= 80) player.addPotionEffect(new PotionEffect(Potion.confusion.id, 300, 2));
                }
            }
        }
        if (jewelry instanceof ItemNecklace && pos != -1 && !player.worldObj.isRemote){
            ChunkPosition chunkposition = player.worldObj.findClosestStructure("Stronghold", (int)player.posX, (int)player.posY, (int)player.posZ);
            if (chunkposition != null){
                Minecraft.getMinecraft().thePlayer.motionX += 0.01D * Math.signum((double)chunkposition.chunkPosX - player.posX);
                Minecraft.getMinecraft().thePlayer.motionZ += 0.01D * Math.signum((double)chunkposition.chunkPosZ - player.posZ);
            }
        }
        if (jewelry instanceof ItemBracelet && pos != -1 && !player.worldObj.isRemote && player.worldObj.getBiomeGenForCoords((int)player.posX, (int)player.posZ) == BiomeGenBase.sky && (!player.isPotionActive(Potion.moveSpeed) || player.getActivePotionEffect(Potion.moveSpeed).getDuration() < 30)) player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 140, 1));
        if (jewelry instanceof ItemBracelet && pos != -1 && !player.worldObj.isRemote && rand.nextInt(500) == 15) player.setPositionAndUpdate(player.posX + rand.nextInt(30)*(rand.nextBoolean()?-1:1), player.posY, player.posZ + rand.nextInt(30)*(rand.nextBoolean()?-1:1));
        if (jewelry instanceof ItemRing && pos != -1 && rand.nextInt(200) == 12){
            Minecraft.getMinecraft().gameSettings.setOptionFloatValue(Options.RENDER_DISTANCE, 1.0F);
            for(int i = (int)player.posX - 2; i <= (int)player.posX + 2; i++)
                for(int j = (int)player.posY - 2; j <= (int)player.posY + 2; j++)
                    for(int k = (int)player.posZ - 2; k <= (int)player.posZ + 2; k++)
                        if(player.worldObj.getBlock(i, j, k) instanceof BlockOre) 
                            player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.GRAY + "You sense some " + player.worldObj.getBlock(i, j, k).getLocalizedName() + " around you."));
        }
    }
    
    @Override
    public void onPlayerAttacked(ItemStack item, EntityPlayer player, DamageSource source, Item jewelry, float amount)
    {
        int pos = JewelryNBT.doesModifierExist(item, modifier);
        if (jewelry instanceof ItemNecklace && pos != -1 && !player.worldObj.isRemote) player.addPotionEffect(new PotionEffect(Potion.blindness.id, 100, 1));
    }
}