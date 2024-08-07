package net.wapit1.tfc_tweaked_nutrition;


import net.dries007.tfc.common.capabilities.food.FoodData;
import net.dries007.tfc.common.capabilities.food.NutritionData;
import net.dries007.tfc.common.capabilities.food.TFCFoodData;
import net.dries007.tfc.config.TFCConfig;
import net.minecraftforge.fml.common.Mod;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.callback.CallbackInfo;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(TFCFoodData.class)
public class TweakedTFCFoodData {

    @Shadow @Final private NutritionData nutritionData;

    @Inject(method = "tick",at = @At("HEAD"),cancellable = false)
    public void injectTick(CallbackInfo ci){
        float passiveNutrientLoss =  (TFCConfig.SERVER.passiveExhaustionModifier.get().floatValue() * -0.001f);
        nutritionData.addNutrients(new FoodData(0,
                0,
                0,
                passiveNutrientLoss,
                passiveNutrientLoss,
                passiveNutrientLoss,
                passiveNutrientLoss,
                passiveNutrientLoss,
                0.01f));

    }

}
