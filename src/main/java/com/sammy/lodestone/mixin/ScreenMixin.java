package com.sammy.lodestone.mixin;

import com.sammy.lodestone.handlers.screenparticle.ScreenParticleHandler;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Screen.class)
final class ScreenMixin {
	@Inject(at = @At("HEAD"), method = "renderBackground(Lnet/minecraft/client/gui/GuiGraphics;)V")
	private void lodestone$beforeBackgroundParticle(GuiGraphics guiGraphics, CallbackInfo ci) {
		ScreenParticleHandler.renderEarliestParticles();
	}
}
