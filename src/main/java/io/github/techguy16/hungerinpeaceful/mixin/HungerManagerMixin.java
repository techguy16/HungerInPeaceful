package io.github.techguy16.hungerinpeaceful.mixin;

import net.minecraft.world.food.FoodData;
import net.minecraft.world.level.Level;
import net.minecraft.world.Difficulty;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(FoodData.class)
// Lnet/minecraft/entity/player/PlayerEntity;jump()V
public abstract class HungerManagerMixin {
    @Redirect(
        method = "tick(Lnet/minecraft/world/entity/player/Player;)V",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/level/Level;getDifficulty()Lnet/minecraft/world/Difficulty;"
//					shift = At.Shift.AFTER
        )
    )
    public Difficulty hungerOnPeaceful(Level level) {
        Difficulty originalDifficulty = level.getDifficulty();
        if (originalDifficulty.equals(Difficulty.PEACEFUL)) {
			    return Difficulty.EASY;
		    }
		    return originalDifficulty;
    }
}
