package p.lolamechat;

import org.bukkit.plugin.java.JavaPlugin;
import p.lolamechat.Chat.ChatHandler;
import p.lolamechat.Command.LolameCommand;
import p.lolamechat.papi.Variables;

public final class LolameChat extends JavaPlugin {
    private ChatHandler chatHandler;

    @Override
    public void onEnable() {
        chatHandler = new ChatHandler(this);
        getCommand("lolamechat").setExecutor(new LolameCommand());

        getServer().getPluginManager().registerEvents(chatHandler, this);

        chatHandler.setChatEnabled(true);
        chatHandler.setChatFormatEnabled(true);


        if (getServer().getPluginManager().getPlugin("PlaceholderAPI") != null) {
            new Variables(this).register();
        } else {
            getLogger().warning("PlaceholderAPI no encontrado. Algunos placeholders no funcionarán.");
        }
    }

    @Override
    public void onDisable() {
    }
}
