package de.rubixdev.carpetgamerules.mixins;

import carpet.settings.ParsedRule;
import carpet.settings.SettingsManager;
import net.minecraft.server.command.ServerCommandSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value = SettingsManager.class, remap = false)
public interface SettingsManagerAccessor {
    @Invoker("notifyRuleChanged")
    void invokeNotifyRuleChanged(ServerCommandSource source, ParsedRule<?> rule, String userTypedValue);
}
