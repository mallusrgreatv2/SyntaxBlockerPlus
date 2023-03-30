package tk.darklegacymc.syntaxblocker.util;

public class Language {
    private static String getLanguage(String arg) {
        return LanguageConfig.get().getString(arg);
    }
    public static String PREFIX = getLanguage("prefix");
    public static String UNSUPPORTED_SYNTAX = getLanguage("unsupported-syntax");
    public static String SBP_MESSAGE = getLanguage("sbp-command.message");
    public static String SBP_NO_PERMISSION_MESSAGE = getLanguage("sbp-command.no-permission-message");
    public static String SBP_INVALID_ARGUMENTS = getLanguage("sbp-command.invalid-argument");
    public static String SBP_RELOAD_FAILED = getLanguage("sbp-command.reload.failed");
    public static String SBP_RELOAD_SUCCESS = getLanguage("sbp-command.reload.success");
}
