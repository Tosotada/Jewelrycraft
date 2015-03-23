package darkknight.jewelrycraft.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import darkknight.jewelrycraft.container.ContainerJewelryTab;
import darkknight.jewelrycraft.container.JewelryInventory;
import darkknight.jewelrycraft.events.KeyBindings;

public class GuiJewelry extends GuiContainer
{
    ResourceLocation texture;
    
    /**
     * @param containerJewelryTab
     * @param texture
     */
    public GuiJewelry(ContainerJewelryTab containerJewelryTab, ResourceLocation texture)
    {
        super(containerJewelryTab);
        xSize = 194;
        ySize = 166;
        this.texture = texture;
    }
    
    /**
     * @param f
     * @param mouseX
     * @param mouseY
     */
    @Override
    public void drawGuiContainerBackgroundLayer(float f, int mouseX, int mouseY)
    {
        GL11.glColor3f(1, 1, 1);
        Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }
    
    /**
     * @param mouseX
     * @param mouseY
     */
    @Override
    public void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {}
    
    /**
     * @param charecter
     * @param key
     */
    @Override
    protected void keyTyped(char charecter, int key)
    {
        super.keyTyped(charecter, key);
        if (key == KeyBindings.inventory.getKeyCode()) mc.thePlayer.closeScreen();
    }

    @Override
    public void initGui ()
    {
        super.initGui();
        int cornerX = guiLeft;
        int cornerY = guiTop;
        this.buttonList.clear();
        TabRegistry.updateTabValues(cornerX, cornerY, TabJewelry.class);
        TabRegistry.addTabsToList(this.buttonList);
    }
}