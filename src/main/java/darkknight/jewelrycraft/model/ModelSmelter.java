package darkknight.jewelrycraft.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSmelter extends ModelBase
{
    // fields
    ModelRenderer Support1;
    ModelRenderer Support2;
    ModelRenderer Hold1;
    ModelRenderer Hold2;
    ModelRenderer SmelterBase;
    ModelRenderer SmelterSide1;
    ModelRenderer SmelterSide2;
    ModelRenderer SmelterSide3;
    ModelRenderer SmelterSide4;
    ModelRenderer SmelterSide5;
    ModelRenderer SmelterSide6;
    ModelRenderer SmelterSide7;
    ModelRenderer SmelterSide8;
    ModelRenderer SmelterSide9;
    ModelRenderer SmelterSide10;
    ModelRenderer SmelterSide11;
    ModelRenderer SmelterSide12;
    ModelRenderer HeatSourceSide1;
    ModelRenderer HeatSourceSide2;
    ModelRenderer HeatSourceSide3;
    ModelRenderer HeatSourceSide4;
    ModelRenderer HeatSourceSide5;
    ModelRenderer HeatSourceBase;
    ModelRenderer HeatSourceSide6;
    ModelRenderer HeatSourceSide7;
    ModelRenderer HeatSourceSide8;
    ModelRenderer HeatSourceSide9;
    ModelRenderer HeatSourceSide10;
    ModelRenderer HeatSourceSide11;
    ModelRenderer HeatSourceSide12;
    
    /**
     * 
     */
    public ModelSmelter()
    {
        textureWidth = 64;
        textureHeight = 32;
        Support1 = new ModelRenderer(this, 0, 14);
        Support1.addBox(0F, 0F, 0F, 2, 15, 3);
        Support1.setRotationPoint(6F, 9F, -1F);
        Support1.setTextureSize(64, 32);
        Support1.mirror = true;
        setRotation(Support1, 0F, 0F, 0F);
        Support2 = new ModelRenderer(this, 0, 14);
        Support2.addBox(0F, 0F, 0F, 2, 15, 3);
        Support2.setRotationPoint(-8F, 9F, -1F);
        Support2.setTextureSize(64, 32);
        Support2.mirror = true;
        setRotation(Support2, 0F, 0F, 0F);
        Hold1 = new ModelRenderer(this, 0, 14);
        Hold1.addBox(0F, 0F, 0F, 2, 1, 1);
        Hold1.setRotationPoint(4F, 11F, 0F);
        Hold1.setTextureSize(64, 32);
        Hold1.mirror = true;
        setRotation(Hold1, 0F, 0F, 0F);
        Hold2 = new ModelRenderer(this, 0, 14);
        Hold2.addBox(0F, 0F, 0F, 2, 1, 1);
        Hold2.setRotationPoint(-6F, 11F, 0F);
        Hold2.setTextureSize(64, 32);
        Hold2.mirror = true;
        setRotation(Hold2, 0F, 0F, 0F);
        SmelterBase = new ModelRenderer(this, 0, 0);
        SmelterBase.addBox(0F, 0F, 0F, 4, 1, 5);
        SmelterBase.setRotationPoint(-2F, 18F, -2F);
        SmelterBase.setTextureSize(64, 32);
        SmelterBase.mirror = true;
        setRotation(SmelterBase, 0F, 0F, 0F);
        SmelterSide1 = new ModelRenderer(this, 0, 0);
        SmelterSide1.addBox(0F, 0F, 0F, 4, 2, 1);
        SmelterSide1.setRotationPoint(-2F, 16F, -3F);
        SmelterSide1.setTextureSize(64, 32);
        SmelterSide1.mirror = true;
        setRotation(SmelterSide1, 0F, 0F, 0F);
        SmelterSide2 = new ModelRenderer(this, 0, 0);
        SmelterSide2.addBox(0F, 0F, 0F, 4, 2, 1);
        SmelterSide2.setRotationPoint(-2F, 16F, 3F);
        SmelterSide2.setTextureSize(64, 32);
        SmelterSide2.mirror = true;
        setRotation(SmelterSide2, 0F, 0F, 0F);
        SmelterSide3 = new ModelRenderer(this, 0, 0);
        SmelterSide3.addBox(0F, 0F, 0F, 1, 2, 5);
        SmelterSide3.setRotationPoint(2F, 16F, -2F);
        SmelterSide3.setTextureSize(64, 32);
        SmelterSide3.mirror = true;
        setRotation(SmelterSide3, 0F, 0F, 0F);
        SmelterSide4 = new ModelRenderer(this, 0, 0);
        SmelterSide4.addBox(0F, 0F, 0F, 1, 2, 5);
        SmelterSide4.setRotationPoint(-3F, 16F, -2F);
        SmelterSide4.setTextureSize(64, 32);
        SmelterSide4.mirror = true;
        setRotation(SmelterSide4, 0F, 0F, 0F);
        SmelterSide5 = new ModelRenderer(this, 0, 0);
        SmelterSide5.addBox(0F, 0F, 0F, 1, 7, 5);
        SmelterSide5.setRotationPoint(3F, 9F, -2F);
        SmelterSide5.setTextureSize(64, 32);
        SmelterSide5.mirror = true;
        setRotation(SmelterSide5, 0F, 0F, 0F);
        SmelterSide6 = new ModelRenderer(this, 0, 0);
        SmelterSide6.addBox(0F, 0F, 0F, 1, 7, 5);
        SmelterSide6.setRotationPoint(-4F, 9F, -2F);
        SmelterSide6.setTextureSize(64, 32);
        SmelterSide6.mirror = true;
        setRotation(SmelterSide6, 0F, 0F, 0F);
        SmelterSide7 = new ModelRenderer(this, 0, 0);
        SmelterSide7.addBox(0F, 0F, 0F, 1, 7, 1);
        SmelterSide7.setRotationPoint(2F, 9F, 3F);
        SmelterSide7.setTextureSize(64, 32);
        SmelterSide7.mirror = true;
        setRotation(SmelterSide7, 0F, 0F, 0F);
        SmelterSide8 = new ModelRenderer(this, 0, 0);
        SmelterSide8.addBox(0F, 0F, 0F, 1, 7, 1);
        SmelterSide8.setRotationPoint(-3F, 9F, 3F);
        SmelterSide8.setTextureSize(64, 32);
        SmelterSide8.mirror = true;
        setRotation(SmelterSide8, 0F, 0F, 0F);
        SmelterSide9 = new ModelRenderer(this, 0, 0);
        SmelterSide9.addBox(0F, 0F, 0F, 4, 7, 1);
        SmelterSide9.setRotationPoint(-2F, 9F, 4F);
        SmelterSide9.setTextureSize(64, 32);
        SmelterSide9.mirror = true;
        setRotation(SmelterSide9, 0F, 0F, 0F);
        SmelterSide10 = new ModelRenderer(this, 0, 0);
        SmelterSide10.addBox(0F, 0F, 0F, 4, 7, 1);
        SmelterSide10.setRotationPoint(-2F, 9F, -4F);
        SmelterSide10.setTextureSize(64, 32);
        SmelterSide10.mirror = true;
        setRotation(SmelterSide10, 0F, 0F, 0F);
        SmelterSide11 = new ModelRenderer(this, 0, 0);
        SmelterSide11.addBox(0F, 0F, 0F, 1, 7, 1);
        SmelterSide11.setRotationPoint(2F, 9F, -3F);
        SmelterSide11.setTextureSize(64, 32);
        SmelterSide11.mirror = true;
        setRotation(SmelterSide11, 0F, 0F, 0F);
        SmelterSide12 = new ModelRenderer(this, 0, 0);
        SmelterSide12.addBox(0F, 0F, 0F, 1, 7, 1);
        SmelterSide12.setRotationPoint(-3F, 9F, -3F);
        SmelterSide12.setTextureSize(64, 32);
        SmelterSide12.mirror = true;
        setRotation(SmelterSide12, 0F, 0F, 0F);
        HeatSourceSide1 = new ModelRenderer(this, 0, 0);
        HeatSourceSide1.addBox(0F, 0F, 0F, 8, 2, 1);
        HeatSourceSide1.setRotationPoint(-4F, 19F, 7F);
        HeatSourceSide1.setTextureSize(64, 32);
        HeatSourceSide1.mirror = true;
        setRotation(HeatSourceSide1, 0F, 0F, 0F);
        HeatSourceSide2 = new ModelRenderer(this, 0, 0);
        HeatSourceSide2.addBox(0F, 0F, 0F, 1, 2, 12);
        HeatSourceSide2.setRotationPoint(-6F, 19F, -6F);
        HeatSourceSide2.setTextureSize(64, 32);
        HeatSourceSide2.mirror = true;
        setRotation(HeatSourceSide2, 0F, 0F, 0F);
        HeatSourceSide3 = new ModelRenderer(this, 0, 0);
        HeatSourceSide3.addBox(0F, 0F, 0F, 1, 2, 12);
        HeatSourceSide3.setRotationPoint(5F, 19F, -6F);
        HeatSourceSide3.setTextureSize(64, 32);
        HeatSourceSide3.mirror = true;
        setRotation(HeatSourceSide3, 0F, 0F, 0F);
        HeatSourceSide4 = new ModelRenderer(this, 0, 0);
        HeatSourceSide4.addBox(0F, 0F, 0F, 1, 2, 12);
        HeatSourceSide4.setRotationPoint(4F, 21F, -6F);
        HeatSourceSide4.setTextureSize(64, 32);
        HeatSourceSide4.mirror = true;
        setRotation(HeatSourceSide4, 0F, 0F, 0F);
        HeatSourceSide5 = new ModelRenderer(this, 0, 0);
        HeatSourceSide5.addBox(0F, 0F, 0F, 1, 2, 12);
        HeatSourceSide5.setRotationPoint(-5F, 21F, -6F);
        HeatSourceSide5.setTextureSize(64, 32);
        HeatSourceSide5.mirror = true;
        setRotation(HeatSourceSide5, 0F, 0F, 0F);
        HeatSourceBase = new ModelRenderer(this, 0, 0);
        HeatSourceBase.addBox(0F, 0F, 0F, 8, 1, 12);
        HeatSourceBase.setRotationPoint(-4F, 23F, -6F);
        HeatSourceBase.setTextureSize(64, 32);
        HeatSourceBase.mirror = true;
        setRotation(HeatSourceBase, 0F, 0F, 0F);
        HeatSourceSide6 = new ModelRenderer(this, 0, 0);
        HeatSourceSide6.addBox(0F, 0F, 0F, 8, 2, 1);
        HeatSourceSide6.setRotationPoint(-4F, 21F, -7F);
        HeatSourceSide6.setTextureSize(64, 32);
        HeatSourceSide6.mirror = true;
        setRotation(HeatSourceSide6, 0F, 0F, 0F);
        HeatSourceSide7 = new ModelRenderer(this, 0, 0);
        HeatSourceSide7.addBox(0F, 0F, 0F, 8, 2, 1);
        HeatSourceSide7.setRotationPoint(-4F, 21F, 6F);
        HeatSourceSide7.setTextureSize(64, 32);
        HeatSourceSide7.mirror = true;
        setRotation(HeatSourceSide7, 0F, 0F, 0F);
        HeatSourceSide8 = new ModelRenderer(this, 0, 0);
        HeatSourceSide8.addBox(0F, 0F, 0F, 1, 2, 1);
        HeatSourceSide8.setRotationPoint(-5F, 19F, 6F);
        HeatSourceSide8.setTextureSize(64, 32);
        HeatSourceSide8.mirror = true;
        setRotation(HeatSourceSide8, 0F, 0F, 0F);
        HeatSourceSide9 = new ModelRenderer(this, 0, 0);
        HeatSourceSide9.addBox(0F, 0F, 0F, 1, 2, 1);
        HeatSourceSide9.setRotationPoint(4F, 19F, 6F);
        HeatSourceSide9.setTextureSize(64, 32);
        HeatSourceSide9.mirror = true;
        setRotation(HeatSourceSide9, 0F, 0F, 0F);
        HeatSourceSide10 = new ModelRenderer(this, 0, 0);
        HeatSourceSide10.addBox(0F, 0F, 0F, 1, 2, 1);
        HeatSourceSide10.setRotationPoint(4F, 19F, -7F);
        HeatSourceSide10.setTextureSize(64, 32);
        HeatSourceSide10.mirror = true;
        setRotation(HeatSourceSide10, 0F, 0F, 0F);
        HeatSourceSide11 = new ModelRenderer(this, 0, 0);
        HeatSourceSide11.addBox(0F, 0F, 0F, 1, 2, 1);
        HeatSourceSide11.setRotationPoint(-5F, 19F, -7F);
        HeatSourceSide11.setTextureSize(64, 32);
        HeatSourceSide11.mirror = true;
        setRotation(HeatSourceSide11, 0F, 0F, 0F);
        HeatSourceSide12 = new ModelRenderer(this, 0, 0);
        HeatSourceSide12.addBox(0F, 0F, 0F, 8, 2, 1);
        HeatSourceSide12.setRotationPoint(-4F, 19F, -8F);
        HeatSourceSide12.setTextureSize(64, 32);
        HeatSourceSide12.mirror = true;
        setRotation(HeatSourceSide12, 0F, 0F, 0F);
    }
    
    /**
     * @param entity
     * @param f
     * @param f1
     * @param f2
     * @param f3
     * @param f4
     * @param f5
     */
    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5);
        Support1.render(f5);
        Support2.render(f5);
        Hold1.render(f5);
        Hold2.render(f5);
        SmelterBase.render(f5);
        SmelterSide1.render(f5);
        SmelterSide2.render(f5);
        SmelterSide3.render(f5);
        SmelterSide4.render(f5);
        SmelterSide5.render(f5);
        SmelterSide6.render(f5);
        SmelterSide7.render(f5);
        SmelterSide8.render(f5);
        SmelterSide9.render(f5);
        SmelterSide10.render(f5);
        SmelterSide11.render(f5);
        SmelterSide12.render(f5);
        HeatSourceSide1.render(f5);
        HeatSourceSide2.render(f5);
        HeatSourceSide3.render(f5);
        HeatSourceSide4.render(f5);
        HeatSourceSide5.render(f5);
        HeatSourceBase.render(f5);
        HeatSourceSide6.render(f5);
        HeatSourceSide7.render(f5);
        HeatSourceSide8.render(f5);
        HeatSourceSide9.render(f5);
        HeatSourceSide10.render(f5);
        HeatSourceSide11.render(f5);
        HeatSourceSide12.render(f5);
    }
    
    /**
     * @param model
     * @param x
     * @param y
     * @param z
     */
    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    /**
     * @param f
     * @param f1
     * @param f2
     * @param f3
     * @param f4
     * @param f5
     */
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
    }
}
