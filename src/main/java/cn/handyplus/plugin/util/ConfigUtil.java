package cn.handyplus.plugin.util;

import cn.handyplus.lib.util.HandyConfigUtil;
import org.bukkit.configuration.file.FileConfiguration;

/**
 * 配置类
 *
 * @author handy
 */
public class ConfigUtil {
    public static FileConfiguration CONFIG, LANG_CONFIG;

    /**
     * 初始化加载文件
     */
    public static void init() {
        // 加载config
        CONFIG = HandyConfigUtil.loadConfig();
        // 加载语言文件
        LANG_CONFIG = HandyConfigUtil.loadLangConfig(CONFIG.getString("language"));
    }

}