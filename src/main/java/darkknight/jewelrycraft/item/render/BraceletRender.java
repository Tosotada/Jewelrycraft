package darkknight.jewelrycraft.item.render;

import org.lwjgl.opengl.GL11;
import cpw.mods.fml.common.Loader;
import darkknight.jewelrycraft.model.ModelBracelet;
import darkknight.jewelrycraft.util.Variables;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class BraceletRender extends TileEntitySpecialRenderer
{
    public ModelBracelet bracelet = new ModelBracelet();
    ResourceLocation texture = new ResourceLocation(Variables.MODID, "textures/entities/Bracelet.png");
    
    @Override
    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale)
    {
    }
    
    public void doRender(Entity entity, double x, double y, double z, float f, float g)
    {
        GL11.glPushMatrix();
        Minecraft.getMinecraft().renderEngine.bindTexture(texture);
        if ((float)z != -1) bracelet.render(entity, 0F, 0F, 0F, (float)z, f, 1.0F);
        if (Loader.isModLoaded("alpaca") /*&& fiskfille.alpaca.AlpacaAPI.isAlpacaClient((EntityPlayer)entity)*/){
            GL11.glTranslatef(1F, 0F, -9F);
            GL11.glRotatef(25F, 1F, 0F, 0F); 
            GL11.glRotatef(-25F, 0F, 1F, 0F); 
        }
        else GL11.glTranslatef(0F, 3F, 0F);
        if ((float)x != -1) bracelet.render(entity, 0F, 0F, 0F, (float)x, (float)y, 1.0F);
        GL11.glPopMatrix();
    }
}