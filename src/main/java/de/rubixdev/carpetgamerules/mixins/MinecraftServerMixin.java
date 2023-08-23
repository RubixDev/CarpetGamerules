package de.rubixdev.carpetgamerules.mixins;

import me.fallenbreath.conditionalmixin.api.annotation.Condition;
import me.fallenbreath.conditionalmixin.api.annotation.Restriction;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;

//#if MC >= 11500
//#else
//$$ import com.google.gson.JsonElement;
//$$ import de.rubixdev.carpetgamerules.CarpetGamerulesServer;
//$$ import net.minecraft.world.level.LevelGeneratorType;
//$$ import org.spongepowered.asm.mixin.injection.At;
//$$ import org.spongepowered.asm.mixin.injection.Inject;
//$$ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//#endif

// 1.14 Carpet did not yet have the `onServerLoadedWorlds` method for extensions, so we must manually call it.
@Restriction(require = @Condition(value = "minecraft", versionPredicates = "<1.15"))
@Mixin(MinecraftServer.class)
public class MinecraftServerMixin {
    //#if MC >= 11500
    //#else
    //$$ @SuppressWarnings("DataFlowIssue") // the cast isn't invalid
    //$$ @Inject(method = "loadWorld", at = @At("RETURN"))
    //$$ private void serverLoadedWorld(String name, String serverName, long seed, LevelGeneratorType generatorType, JsonElement generatorSettings, CallbackInfo ci) {
    //$$     CarpetGamerulesServer.INSTANCE.onServerLoadedWorlds((MinecraftServer) (Object) this);
    //$$ }
    //#endif
}
