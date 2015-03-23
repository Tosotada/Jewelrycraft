package darkknight.jewelrycraft.events;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.client.event.RenderPlayerEvent;
import org.lwjgl.opengl.GL11;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import darkknight.jewelrycraft.entities.renders.RenderHelper;
import darkknight.jewelrycraft.lib.Reference;
import darkknight.jewelrycraft.model.ModelMask;
import darkknight.jewelrycraft.tileentity.renders.MaskRender;
import darkknight.jewelrycraft.util.PlayerUtils;

public class PlayerRenderHandler
{
    ModelMask maskModel = new ModelMask();
    MaskRender mask = new MaskRender();
    
    public static String[] infamyCache = new String[] {};
    
    @SubscribeEvent
    public void renderScreen(RenderPlayerEvent.Specials.Post event)
    {        
        if (infamyCache != null)
        {
            Iterator<EntityPlayer> players = event.entityPlayer.worldObj.playerEntities.iterator();
            
            while(players.hasNext())
            {
                EntityPlayer player = players.next();
                if (checkPlayerInfamy(player.getDisplayName()) && event.entityPlayer.getDisplayName().equals(player.getDisplayName()))
                {
                    float yaw = player.prevRotationYawHead + (player.rotationYawHead - player.prevRotationYawHead) * event.partialRenderTick;
                    float yawOffset = player.prevRenderYawOffset + (player.renderYawOffset - player.prevRenderYawOffset) * event.partialRenderTick;
                    float pitch = player.prevRotationPitch + (player.rotationPitch - player.prevRotationPitch) * event.partialRenderTick;
                    GL11.glPushMatrix();
                    GL11.glColor4f(1, 1, 1, 1);
                    GL11.glRotatef(yawOffset, 0, -1, 0);
                    GL11.glRotatef(yaw - 90, 0, 1, 0);
                    GL11.glRotatef(pitch, 0, 0, -1);
                    GL11.glRotatef(90F, 0, 1F, 0F);
                    RenderHelper.translateToHeadLevel(player);
                    GL11.glScalef(1.6f, 1.6f, 1.6f);
                    GL11.glTranslatef(-0.25F, -0.25F, -0.25F);
                    mask.doRender(event.entityPlayer, 0F, 0F, 0F, 0F, 0F);
                    GL11.glPopMatrix();
                }
            }
        }
    }

    /**
     * @param string
     * @return
     */
    private boolean checkPlayerInfamy(String string)
    {
        for (int i = 0; i < infamyCache.length; i++)
            if (infamyCache[i].equals(string)) return true;
        
        return false;
    }
}
