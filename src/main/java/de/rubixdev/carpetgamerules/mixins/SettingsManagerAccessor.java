package de.rubixdev.carpetgamerules.mixins;

import carpet.settings.SettingsManager;
import me.fallenbreath.conditionalmixin.api.annotation.Condition;
import me.fallenbreath.conditionalmixin.api.annotation.Restriction;
import org.spongepowered.asm.mixin.Mixin;

//#if MC >= 11600
//#else
//$$ import carpet.settings.ParsedRule;
//$$ import net.minecraft.server.command.ServerCommandSource;
//$$ import org.spongepowered.asm.mixin.gen.Invoker;
//#endif

@Restriction(require = @Condition(value = "minecraft", versionPredicates = "<1.16"))
@Mixin(value = SettingsManager.class, remap = false)
public interface SettingsManagerAccessor {
    //#if MC >= 11600
    //#else
    //$$ @Invoker("notifyRuleChanged")
    //$$ void invokeNotifyRuleChanged(ServerCommandSource source, ParsedRule<?> rule, String userTypedValue);
    //#endif
}
