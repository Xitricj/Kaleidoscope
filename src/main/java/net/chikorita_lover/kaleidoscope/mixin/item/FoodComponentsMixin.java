package net.chikorita_lover.kaleidoscope.mixin.item;

import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponents;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FoodComponents.class)
public class FoodComponentsMixin {
    @Shadow @Final public static FoodComponent COOKIE;
    @Shadow @Final public static FoodComponent GLOW_BERRIES;
    @Shadow @Final public static FoodComponent SWEET_BERRIES;

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void modifyFoodComponents(CallbackInfo ci) {
        ((FoodComponentAccessor) COOKIE).setSnack(true);
        ((FoodComponentAccessor) GLOW_BERRIES).setSnack(true);
        ((FoodComponentAccessor) SWEET_BERRIES).setSnack(true);
    }
}
