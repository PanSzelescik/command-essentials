package pl.panszelescik.commandessentials.neoforge;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import pl.panszelescik.commandessentials.common.ModCommands;

@Mod(CommandEssentialsNeoForge.MODID)
public class CommandEssentialsNeoForge {

    public static final String MODID = "commandessentials";

    public CommandEssentialsNeoForge() {
        NeoForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void registerCommands(RegisterCommandsEvent event) {
        ModCommands.registerCommands(event.getDispatcher());
    }
}
