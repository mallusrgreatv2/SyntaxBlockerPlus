package tk.darklegacymc.syntaxblocker.util;

import org.bukkit.entity.Player;

public class Utils {
    public static void sendMessage(String message, Player player) {
        String newMessage = message.replaceAll("&", "§");
        String prefix = LanguageConfig.get().getString("prefix").replaceAll("&", "§");
        player.sendMessage(prefix + newMessage);
    }
}
