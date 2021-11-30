package mods.officialy.getindustrial.mixin;

import com.mojang.authlib.minecraft.client.MinecraftClient;
import mods.officialy.getindustrial.GetIndustrial;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class ClientMixin {
/*
    @Inject(method = "<init>", at = @At(target = "Ljava/lang/Thread;currentThread()Ljava/lang/Thread;", value = "INVOKE_ASSIGN"))
    public void inject(RunArgs args, CallbackInfo ci) {
        GetIndustrial.load();
    }
*/
}
