package p.lolamechat.papi;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import p.lolamechat.Command.LolameCommand;
import p.lolamechat.LolameChat;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Variables extends PlaceholderExpansion {

    private LolameChat plugin;
    private Map<UUID, Integer> playerNumbers = new HashMap<>();
    private int playerCounter = 0;

    public Variables(LolameChat plugin) {
        this.plugin = plugin;
    }

    @Override
    public String getIdentifier() {
        return "lolame";
    }

    @Override
    public String getAuthor() {
        return "spinnin";
    }

    @Override
    public String getVersion() {
        return "1.0.0";
    }

    @Override
    public String onPlaceholderRequest(Player player, String identifier) {
        if (player == null) {
            return "";
        }

        if (identifier.equals("numero_jugador")) {
            return getPlayerNumber(player);
        }

        return null;
    }

    private String getPlayerNumber(Player player) {
        UUID playerId = player.getUniqueId();
        if (!playerNumbers.containsKey(playerId)) {
            playerCounter++;
            playerNumbers.put(playerId, playerCounter);
        }
        return "#" + playerNumbers.get(playerId);
    }

    public void resetPlayerNumbers() {
        playerNumbers.clear();
        playerCounter = 0;
    }
}