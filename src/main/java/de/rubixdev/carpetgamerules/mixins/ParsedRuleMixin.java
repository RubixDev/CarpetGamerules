package de.rubixdev.carpetgamerules.mixins;

import carpet.settings.ParsedRule;
import carpet.settings.SettingsManager;
import de.rubixdev.carpetgamerules.CarpetGamerulesServer;
import de.rubixdev.carpetgamerules.CarpetGamerulesSettings;
import net.minecraft.server.command.ServerCommandSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = ParsedRule.class, remap = false)
public class ParsedRuleMixin {
    @Redirect(
            method =
                    "set(Lnet/minecraft/server/command/ServerCommandSource;Ljava/lang/Object;Ljava/lang/String;)Lcarpet/settings/ParsedRule;",
            at =
                    @At(
                            value = "INVOKE",
                            target =
                                    "Lcarpet/settings/SettingsManager;notifyRuleChanged(Lnet/minecraft/server/command/ServerCommandSource;Lcarpet/settings/ParsedRule;Ljava/lang/String;)V"))
    private void notifyCustomSettingsManager(
            SettingsManager instance, ServerCommandSource source, ParsedRule<?> rule, String userTypedValue) {
        if (rule.field.getDeclaringClass() == CarpetGamerulesSettings.class) {
            ((SettingsManagerAccessor) CarpetGamerulesServer.settingsManager)
                    .invokeNotifyRuleChanged(source, rule, userTypedValue);
        } else {
            ((SettingsManagerAccessor) instance).invokeNotifyRuleChanged(source, rule, userTypedValue);
        }
    }
}
