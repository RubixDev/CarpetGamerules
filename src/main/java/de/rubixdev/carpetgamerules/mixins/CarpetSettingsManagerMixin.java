package de.rubixdev.carpetgamerules.mixins;

import carpet.settings.SettingsManager;
import carpet.utils.Messenger;
import carpet.utils.Translations;
import de.rubixdev.carpetgamerules.CarpetGamerulesServer;
import net.minecraft.server.command.ServerCommandSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SettingsManager.class)
public class CarpetSettingsManagerMixin {
    @Inject(
            method = "listAllSettings",
            at = @At(value = "INVOKE", target = "Lcarpet/settings/SettingsManager;getCategories()Ljava/lang/Iterable;"),
            remap = false)
    private void printCarpetGamerulesVersion(ServerCommandSource source, CallbackInfoReturnable<Integer> cir) {
        Messenger.m(
                source,
                "g CarpetGamerules ",
                "g " + Translations.tr("ui.version", "version") + ": ",
                "g " + CarpetGamerulesServer.VERSION);
    }
}
