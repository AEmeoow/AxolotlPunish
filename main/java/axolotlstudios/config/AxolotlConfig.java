package axolotlstudios.config;

import axolotlstudios.AxolotlPunish;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum AxolotlConfig {

    PREFIX("prefix", "&d&lAXOLOTL&f&lPUNISH &8⋙ "),

    //*********************** DEFAULT PAGE | DEFAULT PAGE ***********************//

    DEFAULT_PAGE_TITLE("defaultpage.gui-title", "HOMEPAGE"),
    DEFAULT_PAGE_SLOTS("defaultpage.slots", 27),

    //*********************** DEFAULT PAGE | BAN PAGE ***********************//

    DEFAULT_PAGE_BAN_DNAME("defaultpage.bansystem.display-name", "#FF0995&lBANS"),

    DEFAULT_PAGE_BAN_LORE("defaultpage.bansystem.lore", Arrays.asList(
            "",
            "&fPlayers breaking rules worthy",
            "&fof a ban? Select this option!",
            "",
            "&e⋙ Click to Continue."
    )),

    DEFAULT_PAGE_BAN_MATERIAL("defaultpage.bansystem.material", Material.PAPER),

    DEFAULT_PAGE_BAN_SLOT("defaultpage.bansystem.slot", 10),

    //*********************** DEFAULT PAGE | KICK PAGE ***********************//

    DEFAULT_PAGE_KICK_DNAME("defaultpage.kicksystem.display-name", "#FF0995&lKICKS"),

    DEFAULT_PAGE_KICK_LORE("defaultpage.kicksystem.lore", Arrays.asList(
            "",
            "&fPlayers breaking rules worthy",
            "&fof a kick? Select this option!",
            "",
            "&e⋙ Click to Continue."
    )),

    DEFAULT_PAGE_KICK_MATERIAL("defaultpage.kicksystem.material", Material.PAPER),

    DEFAULT_PAGE_KICK_SLOT("defaultpage.kicksystem.slot", 12),

    //*********************** DEFAULT PAGE | WARN PAGE ***********************//

    DEFAULT_PAGE_WARN_DNAME("defaultpage.warnsystem.display-name", "#FF0995&lWARNS"),

    DEFAULT_PAGE_WARN_LORE("defaultpage.warnsystem.lore", Arrays.asList(
            "",
            "&fPlayers breaking rules worthy",
            "&fof a warn? Select this option!",
            "",
            "&e⋙ Click to Continue."
    )),

    DEFAULT_PAGE_WARN_MATERIAL("defaultpage.warnsystem.material", Material.PAPER),

    DEFAULT_PAGE_WARN_SLOT("defaultpage.warnsystem.slot", 14),



    //*********************** DEFAULT PAGE | MUTE PAGE ***********************//

    DEFAULT_PAGE_MUTE_DNAME("defaultpage.mutesystem.display-name", "#FF0995&lMUTES"),

    DEFAULT_PAGE_MUTE_LORE("defaultpage.mutesystem.lore", Arrays.asList(
            "&8Staff Utility",
            "",
            "&fPlayers breaking rules worthy",
            "&fof a mute? Select this option!",
            "",
            "&e⋙ Click to Continue."
    )),

    DEFAULT_PAGE_MUTE_MATERIAL("defaultpage.mutesystem.material", Material.PAPER),

    DEFAULT_PAGE_MUTE_SLOT("defaultpage.mutesystem.slot", 16),

    //*********************** MUTE PAGE  ***********************//
    MUTE_PAGE_TITLE("mutepage.gui_title", "MUTEPAGE"),
    MUTE_PAGE_SLOTS("mutepage.slots", 27),

    MUTE_PAGE_CHAT_ABUSE_TIER1_DISPLAY_NAME("mutepage.chatabuse_tier1.display_name", "#FF0995&lCHAT ABUSE &8- &fTier 1"),
    MUTE_PAGE_CHAT_ABUSE_TIER1_LORE("mutepage.chatabuse_tier1.lore", Arrays.asList(
            "",
            "&fInfo:",
            "&5- &fAdd stuff here in the config.",
            "",
            "&e⋙ Click to Continue."
    )),
    MUTE_PAGE_CHAT_ABUSE_TIER1_MATERIAL("mutepage.chatabuse_tier1.material", Material.PAPER),
    MUTE_PAGE_CHAT_ABUSE_TIER1_SLOT("mutepage.chatabuse_tier1.slot", 11),
    MUTE_TIER_1TEMPLATE_NAME("mutepage.chatabuse_tier1.template-name", "ChatAbuseTier1"),

    MUTE_PAGE_CHAT_ABUSE_TIER2_DISPLAY_NAME("mutepage.chatabuse_tier2.display_name", "#FF0995&lCHAT ABUSE &8- &fTier 2"),
    MUTE_PAGE_CHAT_ABUSE_TIER2_LORE("mutepage.chatabuse_tier2.lore", Arrays.asList(
            "",
            "&fInfo:",
            "&5- &fAdd stuff here in the config.",
            "",
            "&e⋙ Click to Continue."
    )),
    MUTE_PAGE_CHAT_ABUSE_TIER2_MATERIAL("mutepage.chatabuse_tier2.material", Material.PAPER),
    MUTE_PAGE_CHAT_ABUSE_TIER2_SLOT("mutepage.chatabuse_tier2.slot", 13),
    MUTE_TIER_2TEMPLATE_NAME("mutepage.chatabuse_tier2.template-name", "ChatAbuseTier2"),

    MUTE_PAGE_CHAT_ABUSE_TIER3_DISPLAY_NAME("mutepage.chatabuse_tier3.display_name", "#FF0995&lCHAT ABUSE &8- &fTier 3"),
    MUTE_PAGE_CHAT_ABUSE_TIER3_LORE("mutepage.chatabuse_tier3.lore", Arrays.asList(
            "",
            "&fInfo:",
            "&5- &fAdd stuff here in the config.",
            "",
            "&e⋙ Click to Continue."
    )),
    MUTE_PAGE_CHAT_ABUSE_TIER3_MATERIAL("mutepage.chatabuse_tier3.material", Material.PAPER),
    MUTE_PAGE_CHAT_ABUSE_TIER3_SLOT("mutepage.chatabuse_tier3.slot", 15),

    MUTE_TIER_3TEMPLATE_NAME("mutepage.chatabuse_tier3.template-name", "ChatAbuseTier3"),

    //*********************** KICK PAGE  ***********************//
    KICK_PAGE_TITLE("kickpage.gui_title", "KICKPAGE"),
    KICK_PAGE_SLOTS("kickpage.slots", 27),

    KICK_PAGE_CHAT_ABUSE_TIER1_DISPLAY_NAME("kickpage.kicklevel_tier1.display_name", "#FF0995&lKICK LEVEL &8- &fTier 1"),
    KICK_PAGE_CHAT_ABUSE_TIER1_LORE("kickpage.kicklevel_tier1.lore", Arrays.asList(
            "",
            "&fInfo:",
            "&5- &fAdd stuff here in the config.",
            "",
            "&e⋙ Click to Continue."
    )),
    KICK_PAGE_CHAT_ABUSE_TIER1_MATERIAL("kickpage.kicklevel_tier1.material", Material.PAPER),
    KICK_PAGE_CHAT_ABUSE_TIER1_SLOT("kickpage.kicklevel_tier1.slot", 11),

    KICK_TIER_1TEMPLATE_NAME("kickpage.kicklevel_tier1.template-name", "KickLevel1"),

    KICK_PAGE_CHAT_ABUSE_TIER2_DISPLAY_NAME("kickpage.kicklevel_tier2.display_name", "#FF0995&lKICK LEVEL &8- &fTier 2"),
    KICK_PAGE_CHAT_ABUSE_TIER2_LORE("kickpage.kicklevel_tier2.lore", Arrays.asList(
            "",
            "&fInfo:",
            "&5- &fAdd stuff here in the config.",
            "",
            "&e⋙ Click to Continue."
    )),
    KICK_PAGE_CHAT_ABUSE_TIER2_MATERIAL("kickpage.kicklevel_tier2.material", Material.PAPER),
    KICK_PAGE_CHAT_ABUSE_TIER2_SLOT("kickpage.kicklevel_tier2.slot", 13),
    KICK_TIER_2TEMPLATE_NAME("kickpage.kicklevel_tier2.template-name", "KickLevel2"),

    KICK_PAGE_CHAT_ABUSE_TIER3_DISPLAY_NAME("kickpage.kicklevel_tier3.display_name", "#FF0995&lKICK LEVEL &8- &fTier 3"),
    KICK_PAGE_CHAT_ABUSE_TIER3_LORE("kickpage.kicklevel_tier3.lore", Arrays.asList(
            "",
            "&fInfo:",
            "&5- &fAdd stuff here in the config.",
            "",
            "&e⋙ Click to Continue."
    )),
    KICK_PAGE_CHAT_ABUSE_TIER3_MATERIAL("kickpage.kicklevel_tier3.material", Material.PAPER),
    KICK_PAGE_CHAT_ABUSE_TIER3_SLOT("kickpage.kicklevel_tier3.slot", 15),

    KICK_TIER_3TEMPLATE_NAME("kickpage.kicklevel_tier3.template-name", "Tier3"),



    //*********************** WARN PAGE  ***********************//
    WARN_PAGE_TITLE("warnpage.gui_title", "WARNPAGE"),
    WARN_PAGE_SLOTS("warnpage.slots", 27),

    WARN_PAGE_CHAT_ABUSE_TIER1_DISPLAY_NAME("warnpage.warnlevel_tier1.display_name", "#FF0995&lWARN LEVEL &8- &fTier 1"),
    WARN_PAGE_CHAT_ABUSE_TIER1_LORE("warnpage.warnlevel_tier1.lore", Arrays.asList(
            "",
            "&fInfo:",
            "&5- &fAdd stuff here in the config.",
            "",
            "&e⋙ Click to Continue."
    )),
    WARN_PAGE_CHAT_ABUSE_TIER1_MATERIAL("warnpage.warnlevel_tier1.material", Material.PAPER),
    WARN_PAGE_CHAT_ABUSE_TIER1_SLOT("warnpage.warnlevel_tier1.slot", 11),

    WARN_TIER_1TEMPLATE_NAME("warnpage.warnlevel_tier1.template-name", "WarnLevel1"),

    WARN_PAGE_CHAT_ABUSE_TIER2_DISPLAY_NAME("warnpage.warnlevel_tier2.display_name", "#FF0995&lWARN LEVEL &8- &fTier 2"),
    WARN_PAGE_CHAT_ABUSE_TIER2_LORE("warnpage.warnlevel_tier2.lore", Arrays.asList(
            "",
            "&fInfo:",
            "&5- &fAdd stuff here in the config.",
            "",
            "&e⋙ Click to Continue."
    )),
    WARN_PAGE_CHAT_ABUSE_TIER2_MATERIAL("warnpage.warnlevel_tier2.material", Material.PAPER),
    WARN_PAGE_CHAT_ABUSE_TIER2_SLOT("warnpage.warnlevel_tier2.slot", 13),
    WARN_TIER_2TEMPLATE_NAME("warnpage.warnlevel_tier2.template-name", "WarnLevel2"),

    WARN_PAGE_CHAT_ABUSE_TIER3_DISPLAY_NAME("warnpage.warnlevel_tier3.display_name", "#FF0995&lWARN LEVEL &8- &fTier 3"),
    WARN_PAGE_CHAT_ABUSE_TIER3_LORE("warnpage.warnlevel_tier3.lore", Arrays.asList(
            "",
            "&fInfo:",
            "&5- &fAdd stuff here in the config.",
            "",
            "&e⋙ Click to Continue."
    )),
    WARN_PAGE_CHAT_ABUSE_TIER3_MATERIAL("warnpage.warnlevel_tier3.material", Material.PAPER),
    WARN_PAGE_CHAT_ABUSE_TIER3_SLOT("warnpage.warnlevel_tier3.slot", 15),

    WARN_TIER_3TEMPLATE_NAME("warnpage.warnlevel_tier3.template-name", "WarnLevel3"),

    //*********************** BAN PAGE  ***********************//
    BAN_PAGE_TITLE("banpage.gui_title", "BANPAGE"),
    BAN_PAGE_SLOTS("banpage.slots", 36),

    BAN_PAGE_UNFAIRADVANTAGE_DISPLAY_NAME("banpage.unfair-advantage.display_name", "#FF0995&lUNFAIR ADVANTAGE"),
    BAN_PAGE_UNFAIRADVANTAGE_LORE("banpage.unfair-advantage.lore", Arrays.asList(
            "",
            "&fInfo:",
            "&5- &fAdd stuff here in the config.",
            "",
            "&e⋙ Click to Continue."
    )),
    BAN_PAGE_UNFAIRADVANTAGE_MATERIAL("banpage.unfair-advantage.material", Material.TNT),
    BAN_PAGE_UNFAIRADVANTAGE_SLOT("banpage.unfair-advantage.slot", 11),
    BAN_UNFAIRADV_TEMPLATE_NAME("banpage.unfair-advantage.template-name", "UnfairAdvantage"),

    BAN_PAGE_XRAY_DISPLAY_NAME("banpage.xray.display_name", "#FF0995&lXRAY"),
    BAN_PAGE_XRAY_LORE("banpage.xray.lore", Arrays.asList(
            "",
            "&fInfo:",
            "&5- &fAdd stuff here in the config.",
            "",
            "&e⋙ Click to Continue."
    )),
    BAN_PAGE_XRAY_MATERIAL("banpage.xray.material", Material.DIAMOND_ORE),
    BAN_PAGE_XRAY_SLOT("banpage.xray.slot", 13),
    BAN_XRAY_TEMPLATE_NAME("banpage.xray.template-name", "XRAY"),

    BAN_PAGE_ABUSING_GLITCHES_DISPLAY_NAME("banpage.abusing-glitches.display_name", "#FF0995&lABUSING GLITCHES"),
    BAN_PAGE_ABUSING_GLITCHES_LORE("banpage.abusing-glitches.lore", Arrays.asList(
            "",
            "&fInfo:",
            "&5- &fAdd stuff here in the config.",
            "",
            "&e⋙ Click to Continue."
    )),
    BAN_PAGE_ABUSING_GLITCHES_MATERIAL("banpage.abusing-glitches.material", Material.BARRIER),
    BAN_PAGE_ABUSING_GLITCHES_SLOT("banpage.abusing-glitches.slot", 15),

    BAN_ABUSINGLITCHES_TEMPLATE_NAME("banpage.abusing-glitches.template-name", "AbusingGlitches"),

    BAN_PAGE_ALT_GRINDING_DISPLAY_NAME("banpage.alt-grinding.display_name", "#FF0995&lALT GRINDING"),
    BAN_PAGE_ALT_GRINDING_LORE("banpage.alt-grinding.lore", Arrays.asList(
            "",
            "&fInfo:",
            "&5- &fAdd stuff here in the config.",
            "",
            "&e⋙ Click to Continue."
    )),
    BAN_PAGE_ALT_GRINDING_MATERIAL("banpage.alt-grinding.material", Material.ANVIL),
    BAN_PAGE_ALT_GRINDING_SLOT("banpage.alt-grinding.slot", 21),
    BAN_ALTGRINDING_TEMPLATE_NAME("banpage.alt-grinding.template-name", "AltGrinding"),

    BAN_PAGE_COMMUNITY_MISCONDUCT_DISPLAY_NAME("banpage.community-misconduct.display_name", "#FF0995&lALT GRINDING"),
    BAN_PAGE_COMMUNITY_MISCONDUCT_LORE("banpage.community-misconduct.lore", Arrays.asList(
            "",
            "&fInfo:",
            "&5- &fAdd stuff here in the config.",
            "",
            "&e⋙ Click to Continue."
    )),
    BAN_PAGE_COMMUNITY_MISCONDUCT_MATERIAL("banpage.community-misconduct.material", Material.CLOCK),
    BAN_PAGE_COMMUNITY_MISCONDUCT_SLOT("banpage.community-misconduct.slot", 23),
    BAN_COMMISCONDUCT_TEMPLATE_NAME("banpage.community-misconduct.template-name", "CommunityMisconduct"),

    ;

    private final String path;
    private Object value;

    AxolotlConfig(String path, Object value) {
        this.path = path;
        this.value = value;
    }

    public static void reloadConfig() {
        final AxolotlPunish plugin = (AxolotlPunish) AxolotlPunish.getPlugin();

        plugin.reloadConfig();
        FileConfiguration fileConfiguration = plugin.getConfig();

        boolean needSaving = false;
        for (AxolotlConfig configValue : values()) {
            if (fileConfiguration.contains(configValue.getPath())) {
                configValue.setValue(fileConfiguration.getString(configValue.getPath()));
            } else {
                needSaving = true;
                if (configValue.getValue() instanceof Material) {
                    plugin.getConfig().set(configValue.path, ((Material)configValue.getValue()).name());
                } else {
                    plugin.getConfig().set(configValue.path, configValue.getValue());
                }
            }
        }

        if (needSaving) plugin.saveConfig();
    }

    public String getPath() {
        return path;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String asString() {
        return String.valueOf(this.value);
    }

    public String asStringC() {
        return AxolotlPunish.c(this.asString());
    }

    public int asInt() {
        return Integer.parseInt(this.asString());
    }

    public List<String> asStringList() {
        return (List<String>) this.value;
    }

    public List<String> asStringCList() {
        return this.asStringList().stream().map(AxolotlPunish::c).collect(Collectors.toList());
    }

    public Material asMaterial() {
        return Material.getMaterial(this.asString());
    }
}
