package qingzhixing.weird_items.mixin;

import net.minecraft.server.MinecraftServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
public class ServerHelloWorldMessageMixin {
    @Unique
    private static final Logger LOGGER = LogManager.getLogger(ServerHelloWorldMessageMixin.class);

    @Inject(at = @At("HEAD"), method = "loadWorld()V")
    private void printLoadWorldMessage(CallbackInfo ci) {
        LOGGER.info("Hello World!");
        LOGGER.info("青纸星已被注入您的世界,小心 :P !!!");
    }
}
