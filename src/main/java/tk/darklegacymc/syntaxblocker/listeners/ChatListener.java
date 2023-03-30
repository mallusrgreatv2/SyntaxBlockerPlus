package tk.darklegacymc.syntaxblocker.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import tk.darklegacymc.syntaxblocker.SyntaxBlockerPlus;
import tk.darklegacymc.syntaxblocker.util.Language;
import tk.darklegacymc.syntaxblocker.util.Utils;

public class ChatListener implements Listener {

    public ChatListener(SyntaxBlockerPlus plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void onCommand(final PlayerCommandPreprocessEvent e) {
        if(e.getMessage().split(" ")[0].contains(SyntaxBlockerPlus.pluginConfig.getString("command-contains"))) {
            if(!e.getPlayer().hasPermission(SyntaxBlockerPlus.pluginConfig.getString("permission.unsupported-syntax"))) {
                e.setCancelled(true);
                Utils.sendMessage(Language.UNSUPPORTED_SYNTAX, e.getPlayer());
            }
        }
    }

}
