package pl.panszelescik.commandessentials.quilt;

import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.loader.api.QuiltLoader;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

public class CommandEssentialsQuilt implements ModInitializer {

    @Override
    public void onInitialize(ModContainer mod) {
        QuiltLoader.getConfigDir().toFile()
    }
}
