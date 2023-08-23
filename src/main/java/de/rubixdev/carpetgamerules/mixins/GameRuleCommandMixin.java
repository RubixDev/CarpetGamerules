package de.rubixdev.carpetgamerules.mixins;

//#if MC >= 11901
import carpet.api.settings.InvalidRuleValueException;
//#endif
import com.mojang.brigadier.context.CommandContext;
import de.rubixdev.carpetgamerules.CarpetGamerulesServer;
import net.minecraft.server.command.GameRuleCommand;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.world.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GameRuleCommand.class)
public class GameRuleCommandMixin {
    @Inject(method = "executeSet", at = @At("RETURN"))
    private static <T extends GameRules.Rule<T>> void updateCarpetSetting(
            CommandContext<ServerCommandSource> context, GameRules.Key<T> key, CallbackInfoReturnable<Integer> cir)
            //#if MC >= 11901
            throws InvalidRuleValueException
            //#endif
    {
        CarpetGamerulesServer.ruleChangeIsFromGameruleCommand = true;
        CarpetGamerulesServer.settingsManager
                //#if MC >= 11901
                .getCarpetRule(key.getName())
                //#else
                //$$ .getRule(key.getName())
                //#endif
                .set(
                        context.getSource(),
                        context.getSource().getServer().getGameRules().get(key).toString());
    }
}
