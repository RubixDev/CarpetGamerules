package de.rubixdev.carpetgamerules.mixins;

import carpet.settings.ParsedRule;
import org.spongepowered.asm.mixin.Mixin;

//#if MC < 11600
//$$ import carpet.settings.SettingsManager;
//$$ import de.rubixdev.carpetgamerules.CarpetGamerulesServer;
//$$ import de.rubixdev.carpetgamerules.CarpetGamerulesSettings;
//$$ import net.minecraft.server.command.ServerCommandSource;
//$$ import org.spongepowered.asm.mixin.injection.At;
//$$ import org.spongepowered.asm.mixin.injection.Redirect;
//#endif

// In 1.15 and below, Carpet did not notify custom settings managers of rule changes.
// Therefore, we must manually do that.
@Mixin(value = ParsedRule.class, remap = false)
public class ParsedRuleMixin {
    //#if MC < 11600
    //$$ @Redirect(
    //$$         method =
    //$$                 "set(Lnet/minecraft/server/command/ServerCommandSource;Ljava/lang/Object;Ljava/lang/String;)Lcarpet/settings/ParsedRule;",
    //$$         at =
    //$$         @At(
    //$$                 value = "INVOKE",
    //$$                 target =
    //$$                         "Lcarpet/settings/SettingsManager;notifyRuleChanged(Lnet/minecraft/server/command/ServerCommandSource;Lcarpet/settings/ParsedRule;Ljava/lang/String;)V"))
    //$$ private void notifyCustomSettingsManager(
    //$$         SettingsManager instance, ServerCommandSource source, ParsedRule<?> rule, String userTypedValue) {
    //$$     if (rule.field.getDeclaringClass() == CarpetGamerulesSettings.class) {
    //$$         ((SettingsManagerAccessor) CarpetGamerulesServer.settingsManager)
    //$$                 .invokeNotifyRuleChanged(source, rule, userTypedValue);
    //$$     } else {
    //$$         ((SettingsManagerAccessor) instance).invokeNotifyRuleChanged(source, rule, userTypedValue);
    //$$     }
    //$$ }
    //#endif
}
