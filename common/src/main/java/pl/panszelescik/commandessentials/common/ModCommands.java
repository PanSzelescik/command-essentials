package pl.panszelescik.commandessentials.common;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import pl.panszelescik.commandessentials.common.command.TpaCommand;

public class ModCommands {

    public static void registerCommands(CommandDispatcher<CommandSourceStack> dispatcher) {
        var tpa = new TpaCommand();
        dispatcher.register(tpa.getCommand());
    }
}
