package pl.panszelescik.commandessentials.fabric;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.loader.api.FabricLoader;
import pl.panszelescik.commandessentials.common.ModCommands;

public class CommandEssentialsFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        FabricLoader.getInstance().getConfigDir().toFile();

        CommandRegistrationCallback.EVENT.register(ModCommands::registerCommands);
    }
}
