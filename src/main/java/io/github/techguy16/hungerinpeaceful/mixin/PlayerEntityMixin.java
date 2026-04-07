package io.github.techguy16.hungerinpeaceful.mixin;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.Difficulty;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Player.class)
public class PlayerEntityMixin {
    @Redirect(
            method = "aiStep()V",
            at = @At(value = "FIELD",
                    opcode = Opcodes.GETSTATIC,
                    target = "Lnet/minecraft/world/Difficulty;PEACEFUL:Lnet/minecraft/world/Difficulty;"))
    private Difficulty getDifficulty() {
        return Difficulty.NORMAL;
    }


}
