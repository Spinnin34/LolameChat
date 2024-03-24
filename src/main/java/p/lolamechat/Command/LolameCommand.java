package p.lolamechat.Command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import p.lolamechat.Format.MessageUtils;

public class LolameCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Este comando solo puede ser ejecutado por un jugador.");
            return false;
        }

        Player player = (Player) sender;


        if (cmd.getName().equalsIgnoreCase("lolamechat")) {
            if (args.length == 0) {


                player.sendMessage(MessageUtils.sendCenteredMessage(" "));
                player.sendMessage(MessageUtils.sendCenteredMessage("§x§2§D§9§C§7§8ʟ§x§3§2§A§7§8§0ᴏ§x§3§8§B§2§8§8ʟ§x§3§D§B§D§9§0ᴀ§x§4§3§C§8§9§8ᴍ§x§4§8§D§3§A§0ᴇ §x§4§E§D§E§A§8ᴄ§x§5§3§E§9§B§0ʜ§x§5§9§F§4§B§8ᴀ§x§5§E§F§F§C§0ᴛ"));
                player.sendMessage(MessageUtils.sendCenteredMessage(" "));
                player.sendMessage(MessageUtils.sendCenteredMessage("§x§F§F§C§5§A§0ᴘʟᴜɢɪɴ ᴅᴇ ᴄʜᴀᴛ ᴅᴇ ʟᴏʟᴀᴍᴇ sᴛᴜᴅɪᴏ"));
                player.sendMessage(MessageUtils.sendCenteredMessage(" "));
                player.sendMessage(MessageUtils.sendCenteredMessage("§7By the Developer ©Spinnin34"));
                player.sendMessage(MessageUtils.sendCenteredMessage(" "));
            }
            return true;
        }

        return false;
    }
}
