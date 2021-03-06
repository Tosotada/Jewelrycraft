package darkknight.jewelrycraft.damage;

import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import net.minecraft.util.DamageSource;

/**
 * @author Sorin
 */
public class DamageSourceList
{
    public static DamageSource shadows, weak, blackHeart;
    private static boolean isInitialized = false;
    
    /**
     * @param e
     */
    public static void postInit(FMLPostInitializationEvent e)
    {
        if (!isInitialized){
            shadows = new DamageSource("shadows").setDamageBypassesArmor().setDamageIsAbsolute();
            blackHeart = new DamageSource("blackHeart").setDamageBypassesArmor().setDamageIsAbsolute();
            weak = new DamageSource("weak").setDamageBypassesArmor();
            isInitialized = true;
        }
    }
}
