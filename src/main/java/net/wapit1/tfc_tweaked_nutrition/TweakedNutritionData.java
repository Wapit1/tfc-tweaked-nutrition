package net.wapit1.tfc_tweaked_nutrition;

import net.dries007.tfc.common.capabilities.food.NutritionData;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.util.Mth;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.callback.CallbackInfo;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// The value here should match an entry in the META-INF/mods.toml file

@Mixin(NutritionData.class)
public class TweakedNutritionData {

    private float tweakedDefaultNutritionValue, tweakedDefaultDairyNutritionValue;
    private float[] rawNutrients;
    private float maxRawNutrient;
    @Shadow @Final private float[] nutrients;

    public void TweakedNutritionData(float startingFood,float startingDairy)
    {
        this.tweakedDefaultNutritionValue = startingFood;
        this.tweakedDefaultDairyNutritionValue = startingDairy;
        this.rawNutrients = new float[]{startingFood*maxRawNutrient ,startingFood*maxRawNutrient ,startingFood*maxRawNutrient ,startingFood*maxRawNutrient ,startingDairy*maxRawNutrient};

        this.injectCalculateNutrition(new CallbackInfo("",true));
        return;
    }


    @Inject(method = "addNutrients",at = @At("HEAD"),cancellable = false)
    public void injectAddNutrients(net.dries007.tfc.common.capabilities.food.FoodData data, CallbackInfo ci)
    {
        this.rawNutrients[0] += data.grain(); //grain
        this.rawNutrients[1] += data.fruit(); //fruit
        this.rawNutrients[2] += data.vegetables(); //veg
        this.rawNutrients[3] += data.protein(); //protein
        this.rawNutrients[4] += data.dairy(); //dairy


        this.injectCalculateNutrition(ci);
        return;


    }
    @Inject(method = "calculateNutrition",at = @At("HEAD"),cancellable = false)
    public void injectCalculateNutrition(CallbackInfo ci)
    {
        //TODO change to an curve
        for (int i = 0; i < rawNutrients.length; ++i) {
            nutrients[i] = Mth.inverseLerp(rawNutrients[i], 0, maxRawNutrient);
        }
        ci.cancel();
        return;


    }

}