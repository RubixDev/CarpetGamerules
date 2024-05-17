package de.rubixdev.carpetgamerules.mixins;

import carpet.settings.SettingsManager;
import org.spongepowered.asm.mixin.Mixin;

//#if MC < 11600
//$$ import carpet.settings.ParsedRule;
//$$ import net.minecraft.server.command.ServerCommandSource;
//$$ import org.spongepowered.asm.mixin.gen.Invoker;
//#endif

@Mixin(value = SettingsManager.class, remap = false)
public interface SettingsManagerAccessor {
    //#if MC < 11600
    //$$ @Invoker("notifyRuleChanged")
    //$$ void invokeNotifyRuleChanged(ServerCommandSource source, ParsedRule<?> rule, String userTypedValue);
    //#endif
}
