package tk.darklegacymc.syntaxblocker.listeners;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tk.darklegacymc.syntaxblocker.SyntaxBlockerPlus;
import tk.darklegacymc.syntaxblocker.util.Language;
import tk.darklegacymc.syntaxblocker.util.LanguageConfig;
import tk.darklegacymc.syntaxblocker.util.Utils;

import javax.annotation.Nonnull;
import java.util.Objects;

public class SBPListener implements CommandExecutor {
    public boolean onCommand(@Nonnull CommandSender sender, @Nonnull Command command, @Nonnull String label, @Nonnull String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            System.out.println(Objects.requireNonNull(SyntaxBlockerPlus.pluginConfig.getString("permission.slash-sbp")));
            System.out.println(sender.hasPermission(Objects.requireNonNull(SyntaxBlockerPlus.pluginConfig.getString("permission.slash-sbp"))));
            if (!sender.hasPermission(Objects.requireNonNull(SyntaxBlockerPlus.pluginConfig.getString("permission.slash-sbp")))) {
                Utils.sendMessage(Language.SBP_NO_PERMISSION_MESSAGE, player);
                return true;
            }
            if(args.length == 0) {
                Utils.sendMessage(Language.SBP_INVALID_ARGUMENTS, player);
                return true;
            }

            if (args[0].equals("reload")) {
                try {
                    LanguageConfig.reload();
                    SyntaxBlockerPlus.plugin.reloadConfig();
                    Utils.sendMessage(Language.SBP_RELOAD_SUCCESS, player);
                } catch (Exception error) {
                    error.printStackTrace();
                    Utils.sendMessage(Objects.requireNonNull(Language.SBP_RELOAD_FAILED), player);
                }
            } else {
                Utils.sendMessage(Objects.requireNonNull(LanguageConfig.get().getString("sbp-command.invalid-argument")), player);
                return true;
            }
        } else {
            sender.sendMessage("Console cannot execute this command.");
            return true;
        }
        return true;
    }
}