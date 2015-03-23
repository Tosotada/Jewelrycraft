package darkknight.jewelrycraft.container;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import darkknight.jewelrycraft.client.GuiGuide;

public class GuiTabModifiers extends GuiTab
{
    int maxPages;
    public GuiTabModifiers(int id)
    {
        super("Modifiers", id);
    }
    
    /**
     * @return
     */
    @Override
    public ItemStack getIcon()
    {
        return new ItemStack(Items.blaze_powder);
    }
    
    /**
     * @param gui
     * @param x
     * @param y
     * @param page
     */
    @Override
    public void drawBackground(GuiGuide gui, int x, int y, int page)
    {
        String text = "";
        int xPos = page % 2 == 0 ? 107 : -35;
        switch(page)
        {
            case 1:
                text = "Although you can add anything as a modifier, only some objects have an effect. In this tab you can find all of modifiers that have a use and what they do, in the form of a story/riddle/poem. However different jewellery have different effects for the same modifier.";
                Page.addTextPage(gui, gui.getLeft() + xPos, gui.getTop(), text);
                break;
            case 2:
                text = "The ancient ones talked about a rising fire in your heart. Fret do not, for flames do not burn, but water might sting a turn. Watch your step, do not be cocky, for its protection is a bit sloppy.";
                Page.addImageTextPage(gui, gui.getLeft() + xPos, gui.getTop() - 7, new ItemStack(Items.blaze_powder), text, 40f, true);
                break;
            case 3:
                text = "Light and swift as a feather can be good all together. Enemies miss and get confused, this power can be abused. Against an arrow you can't compare, so move around, don't just stare. Fire is your enemy and weakness is the penalty.";
                Page.addImageTextPage(gui, gui.getLeft() + xPos, gui.getTop() - 7, new ItemStack(Items.feather), text, 40f, true);
                break;
            case 4:
                text = "Endermen may tolerate you, end portals are near too, you may find ore that is true. But be careful, for the power may make you dizzy, blind you if you're a sissy, worsen your vision if you're unaware and shift positions everywhere.";
                Page.addImageTextPage(gui, gui.getLeft() + xPos, gui.getTop() - 7, new ItemStack(Items.ender_eye), text, 40f, true);
                break;
        }
    }
    
    /**
     * @return
     */
    @Override
    public int getMaxPages()
    {
        return 4;
    }
    
    /**
     * @param gui
     * @param x
     * @param y
     * @param page
     */
    @Override
    public void drawForeground(GuiGuide gui, int x, int y, int page)
    {}
}
