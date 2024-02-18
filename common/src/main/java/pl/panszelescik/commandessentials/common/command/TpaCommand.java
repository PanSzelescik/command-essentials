package pl.panszelescik.commandessentials.common.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;

public class TpaCommand implements Command<CommandSourceStack> {

    private static final String NAME = "tpa";

    private static final String PLAYER = "player";

    public LiteralArgumentBuilder<CommandSourceStack> getCommand() {
        return Commands.literal(NAME)
                .then(Commands.argument(PLAYER, EntityArgument.player())
                        .executes(this));
    }

    @Override
    public int run(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        var to = EntityArgument.getPlayer(context, PLAYER);
        var from = context.getSource().getPlayer();

        if (from == null) return 0;
        if (from.equals(to)) return 0;

        from.sendSystemMessage(Component
                .literal("Teleporting to ")
                .append(to.getName())
                .append("..."));

        from.teleportTo(to.serverLevel(), to.getX(), to.getY(), to.getZ(), to.getYRot(), to.getXRot());

        from.sendSystemMessage(Component
                .literal("Teleported to ")
                .append(to.getName())
                .append("!"));
        from.sendSystemMessage(Component
                .literal("Teleported ")
                .append(from.getName())
                .append(" to you!"));
        return 1;
    }
}
