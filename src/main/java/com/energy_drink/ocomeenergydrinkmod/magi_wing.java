package com.energy_drink.ocomeenergydrinkmod;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.LivingEntity;

public class magi_wings extends HumanoidModel<LivingEntity>
{


    public magi_wings(float size)
    {
        super(size, 0, 16, 16);

        ModelRenderer Wings;
        ModelRenderer wing1;
        ModelRenderer wing2;

        Wings = new ModelRenderer(this);
        Wings.setRotationPoint(0.0F, -8.0F, 0.0F);


        wing1 = new ModelRenderer(this);
        wing1.setRotationPoint(-1.0F, 0.0F, -1.25F);
        Wings.addChild(wing1);
        setRotationAngle(wing1, 0.0F, -0.6545F, 0.0F);
        wing1.setTextureOffset(0, 0).addBox(1.524F, -9.0F, 0.3653F, 13.0F, 16.0F, 0.0F, 0.0F, false);

        wing2 = new ModelRenderer(this);
        wing2.setRotationPoint(1.0F, 0.0F, -1.25F);
        Wings.addChild(wing2);
        setRotationAngle(wing2, 0.0F, 0.6545F, 0.0F);
        wing2.setTextureOffset(0, 0).addBox(-14.524F, -9.0F, 0.3653F, 13.0F, 16.0F, 0.0F, 0.0F, true);

        bipedBody.addChild(Wings);
    }

//	@Override
//	public void setRotationAngles(LivingEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
//	{
//	}

//	@Override
//	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
//		Wings.render(matrixStack, buffer, packedLight, packedOverlay);
//	}

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z)
    {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}