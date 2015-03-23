package darkknight.jewelrycraft.curses;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class CurseGreed extends Curse
{    
    public CurseGreed(int id, String name, int text)
    {
        super(id, name, text);
    }
    
    @Override
    public void action(World world, EntityPlayer player)
    {
    }
    
    @Override
    public boolean itemToss()
    {
        return true;
    }
    
    public String getDescription()
    {
        return "You might need that later";
    }
}