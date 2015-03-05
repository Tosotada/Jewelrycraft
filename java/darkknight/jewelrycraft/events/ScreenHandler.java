package darkknight.jewelrycraft.events;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.event.entity.player.PlayerOpenContainerEvent;
import org.lwjgl.opengl.GL11;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import darkknight.jewelrycraft.curses.Curse;

public class ScreenHandler extends Gui
{
    private Minecraft mc;
    public static NBTTagCompound tagCache;
    public static int cooldown;
    static ResourceLocation texture;
    static ResourceLocation hearts = new ResourceLocation("jewelrycraft", "textures/gui/hearts.png");
    
    public ScreenHandler(Minecraft mc, ResourceLocation tex)
    {
        super();
        this.mc = mc;
        texture = tex;
    }
    
    @SubscribeEvent
    public void renderScreen(RenderGameOverlayEvent event)
    {
        if (event.isCancelable() || event.type != ElementType.ALL || tagCache == null) return;
        if (!mc.gameSettings.showDebugInfo && !(mc.currentScreen instanceof GuiChat)){
            int count = 0;
            int size = 32;
            ScaledResolution resolution = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
            if (tagCache.hasKey("cursePoints") && tagCache.getInteger("cursePoints") > 0){
                mc.renderEngine.bindTexture(texture);
                for(Curse curse: Curse.getCurseList()){
                    if (tagCache.hasKey(curse.getName()) && tagCache.getInteger(curse.getName()) > 0){
                        Gui.drawRect(0, (size / 2 + 6) * count, 24 + mc.fontRenderer.getStringWidth(curse.getName().split(":")[1]), 4 + (size / 2 + 6) * count + 16, 0xaf000000);
                        Gui.drawRect(2, 2 + (size / 2 + 6) * count, 22 + mc.fontRenderer.getStringWidth(curse.getName().split(":")[1]), 2 + (size / 2 + 6) * count + 16, 0x95700064);
                        count++;
                    }
                }
                count = 0;
                for(Curse curse: Curse.getCurseList())
                    if (tagCache.hasKey(curse.getName()) && tagCache.getInteger(curse.getName()) > 0){
                        int tag = curse.getID();
                        GL11.glPushMatrix();
                        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                        GL11.glDisable(GL11.GL_LIGHTING);
                        GL11.glScalef(0.5f, 0.5f, 0.0f);
                        drawTexturedModalRect(4, 4 + (size + 12) * count, tag % size * size, tag / size * size, size, size);
                        GL11.glPopMatrix();
                        count++;
                    }
                count = 0;
                size = 16;
                for(Curse curse: Curse.getCurseList())
                    if (tagCache.hasKey(curse.getName()) && tagCache.getInteger(curse.getName()) > 0){
                        int tag = curse.getID();
                        mc.fontRenderer.drawStringWithShadow(curse.getName().split(":")[1], 20, 7 + (size + 6) * count, 16777215);
                        if (tagCache.getInteger(curse.getName()) == 2){
                            mc.renderEngine.bindTexture(hearts);
                            GL11.glPushMatrix();
                            GL11.glEnable(GL11.GL_BLEND);
                            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
                            GL11.glColor4f(1f, 1f, 1f, 0.5f);
                            drawTexturedModalRect(15 + mc.fontRenderer.getStringWidth(curse.getName().split(":")[1]), 8 + (size + 6) * count, 3 * size, 0, size, size);
                            GL11.glPopMatrix();
                        }
                        count++;
                    }
            }
            mc.renderEngine.bindTexture(hearts);
            count = 0;
            if (tagCache.getFloat("BlueHeart") > 0){
                for(int i = 0; i < (int)tagCache.getFloat("BlueHeart") / 2; i++)
                    drawTexturedModalRect(2 + 13 * i, resolution.getScaledHeight() / 2 - 25 + 16 * count, 0 * size, 0 * size, size, size);
                if (tagCache.getFloat("BlueHeart") % 2 != 0) drawTexturedModalRect(2 + 13 * ((int)tagCache.getFloat("BlueHeart") / 2), resolution.getScaledHeight() / 2 - 25 + 16 * count, 0 * size, 1 * size, size, size);
            }
            count++;
            if (tagCache.getFloat("BlackHeart") > 0){
                for(int i = 0; i < MathHelper.ceiling_float_int((tagCache.getFloat("BlackHeart")) / 2.0F); i++)
                    drawTexturedModalRect(2 + 13 * i, resolution.getScaledHeight() / 2 - 25 + 16 * count, 1 * size, 0 * size, size, size);
                if (tagCache.getFloat("BlackHeart") % 2 != 0) drawTexturedModalRect(2 + 13 * ((int)tagCache.getFloat("BlackHeart") / 2), resolution.getScaledHeight() / 2 - 25 + 16 * count, 1 * size, 1 * size, size, size);
            }
            count++;
            if (tagCache.getFloat("WhiteHeart") > 0)
                drawTexturedModalRect(2, resolution.getScaledHeight() / 2 - 25 + 16 * count, 2 * size, 1 * size, size, size);
        }
    }
}