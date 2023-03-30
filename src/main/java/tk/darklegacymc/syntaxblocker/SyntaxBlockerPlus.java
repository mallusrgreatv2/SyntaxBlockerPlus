package tk.darklegacymc.syntaxblocker;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import tk.darklegacymc.syntaxblocker.listeners.ChatListener;
import tk.darklegacymc.syntaxblocker.listeners.SBPListener;
import tk.darklegacymc.syntaxblocker.util.LanguageConfig;

import javax.annotation.Syntax;
import java.util.Objects;


public final class SyntaxBlockerPlus extends JavaPlugin {
    public static FileConfiguration pluginConfig;
    public static SyntaxBlockerPlus plugin;
    @Override
    public void onEnable() {
        // Plugin startup logic
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        LanguageConfig.setup();
        LanguageConfig.setupDefaults();
        LanguageConfig.get().options().copyDefaults(true);
        LanguageConfig.save();
        pluginConfig = this.getConfig();
        plugin = this;
        new ChatListener(this);
        Objects.requireNonNull(this.getCommand("sbp")).setExecutor(new SBPListener());
        this.getLogger().info("Enabled SyntaxBlockerPlus.");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        this.getLogger().info("Disabled SyntaxBlockerPlus.");
    }
}
