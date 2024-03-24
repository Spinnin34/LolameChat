package p.lolamechat.Chat;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public class ChatHandler implements Listener {

    private FileConfiguration config;
    private JavaPlugin plugin;
    private Map<Character, String> fontMappings;
    private boolean chatEnabled;
    private boolean chatFormatEnabled;

    public ChatHandler(JavaPlugin plugin) {
        this.plugin = plugin;
        this.fontMappings = createFontMappings();
    }




    private Map<Character, String> createFontMappings() {
        // Define aquí tus mapeos de letra a letra con la fuente que deseas
        Map<Character, String> mappings = new HashMap<>();

        // Mapeos para letras minúsculas
        mappings.put('a', "ᴀ");
        mappings.put('b', "ʙ");
        mappings.put('c', "ᴄ");
        mappings.put('d', "ᴅ");
        mappings.put('e', "ᴇ");
        mappings.put('f', "ғ");
        mappings.put('g', "ɢ");
        mappings.put('h', "ʜ");
        mappings.put('i', "ɪ");
        mappings.put('j', "ᴊ");
        mappings.put('k', "ᴋ");
        mappings.put('l', "ʟ");
        mappings.put('m', "ᴍ");
        mappings.put('n', "ɴ");
        mappings.put('o', "ᴏ");
        mappings.put('p', "ᴘ");
        mappings.put('q', "ǫ");
        mappings.put('r', "ʀ");
        mappings.put('s', "s");
        mappings.put('t', "ᴛ");
        mappings.put('u', "ᴜ");
        mappings.put('v', "ᴠ");
        mappings.put('w', "ᴡ");
        mappings.put('x', "x");
        mappings.put('y', "ʏ");
        mappings.put('z', "ᴢ");
        // ... agrega más mapeos según tus necesidades

        // Mapeos para letras mayúsculas
        mappings.put('A', "ᴀ");
        mappings.put('B', "ʙ");
        mappings.put('C', "ᴄ");
        mappings.put('D', "ᴅ");
        mappings.put('E', "ᴇ");
        mappings.put('F', "ғ");
        mappings.put('G', "ɢ");
        mappings.put('H', "ʜ");
        mappings.put('I', "ɪ");
        mappings.put('J', "ᴊ");
        mappings.put('K', "ᴋ");
        mappings.put('L', "ʟ");
        mappings.put('M', "ᴍ");
        mappings.put('N', "ɴ");
        mappings.put('O', "ᴏ");
        mappings.put('P', "ᴘ");
        mappings.put('Q', "ǫ");
        mappings.put('R', "ʀ");
        mappings.put('S', "s");
        mappings.put('T', "ᴛ");
        mappings.put('U', "ᴜ");
        mappings.put('V', "ᴠ");
        mappings.put('W', "ᴡ");
        mappings.put('X', "x");
        mappings.put('Y', "ʏ");
        mappings.put('Z', "ᴢ");
        mappings.put('%', " ");
        // ... agrega más mapeos según tus necesidades

        return mappings;
    }


    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        if (!chatEnabled) {
            // Chat deshabilitado, no hacer nada
            return;
        }

        Player jugador = event.getPlayer();
        String mensajeOriginal = event.getMessage();
        StringBuilder mensajeFormateado = new StringBuilder("");

        if (chatFormatEnabled) {
            for (char letra : mensajeOriginal.toCharArray()) {
                String letraFormateada = fontMappings.getOrDefault(letra, String.valueOf(letra));
                mensajeFormateado.append(letraFormateada);
            }
        } else {
            mensajeFormateado.append(mensajeOriginal);
        }

        String mensajeFinal = "§x§2§D§9§C§7§8" + jugador.getName() + " " + "§7»&f" + " " + mensajeFormateado.toString();

        event.setFormat(ChatColor.translateAlternateColorCodes('&', mensajeFinal));
    }

    public void setChatEnabled(boolean enabled) {
        this.chatEnabled = enabled;
    }

    public void setChatFormatEnabled(boolean enabled) {
        this.chatFormatEnabled = enabled;
    }
}
