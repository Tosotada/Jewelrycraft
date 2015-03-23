package darkknight.jewelrycraft.curses;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import darkknight.jewelrycraft.lib.Reference;

public class CurseList
{
    private static Curse rotten, flaming, blind, greed, infamy;
    private static boolean isInitialized = false;
    
    /**
     * @param e
     */
    public static void preInit(FMLPreInitializationEvent e)
    {
        if (!isInitialized){
            rotten = new CurseRottenHeart(0, Reference.MODNAME + ":" + "Rotten Heart", 0);
            flaming = new CurseFlamingSoul(1, Reference.MODNAME + ":" + "Flaming Soul", 0);
            greed = new CurseGreed(2, Reference.MODNAME + ":" + "Greed", 0);
            blind = new CurseBlind(3, Reference.MODNAME + ":" + "Blind", 0);
            infamy = new CurseInfamy(4, Reference.MODNAME + ":" + "Infamy", 0);
            isInitialized = true;
        }
    }
}
