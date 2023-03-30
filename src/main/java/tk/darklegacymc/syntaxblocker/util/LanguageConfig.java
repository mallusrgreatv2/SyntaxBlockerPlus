package tk.darklegacymc.syntaxblocker.util;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class LanguageConfig {
    private static File file;
    private static FileConfiguration languageFile;
    public static void setup() {
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("SyntaxBlockerPlus").getDataFolder(), "language.yml");
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        languageFile = YamlConfiguration.loadConfiguration(file);
    }
    public static FileConfiguration get() {
        return languageFile;
    }
    public static void save() {
        try {
            languageFile.save(file);
        } catch (IOException e) {
            e.printStackTrace();
            Bukkit.getLogger().info("Could not save language.yml");
        }
    }
    public static void reload() {
        languageFile = YamlConfiguration.loadConfiguration(file);
    }

    public static void setupDefaults() {
        LanguageConfig.get().addDefault("prefix", "&c&l(!) ");
        LanguageConfig.get().addDefault("unsupported-syntax", "&bSorry, but that syntax is not supported.");
        LanguageConfig.get().addDefault("sbp-command.message", "&e/sbp reload &7- &6Reloads the language and configuration.");
        LanguageConfig.get().addDefault("sbp-command.no-permission-message", "&4You do not have permission to use this command.");
        LanguageConfig.get().addDefault("sbp-command.invalid-argument", "&cInvalid argument provided. Use &e/sbp reload &cto reload.");
        LanguageConfig.get().addDefault("sbp-command.reload.failed", "&4Reloading failed. See console for details.");
        LanguageConfig.get().addDefault("sbp-command.reload.success", "&aReloading success.");
    }
}
