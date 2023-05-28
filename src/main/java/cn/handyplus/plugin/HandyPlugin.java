package cn.handyplus.plugin;

import cn.handyplus.lib.InitApi;
import cn.handyplus.lib.util.SqlManagerUtil;
import cn.handyplus.plugin.util.ConfigUtil;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * 主类
 *
 * @author handy
 **/
public class HandyPlugin extends JavaPlugin {
    private static HandyPlugin INSTANCE;

    /**
     * 启用处理
     */
    @Override
    public void onEnable() {
        INSTANCE = this;
        InitApi initApi = InitApi.getInstance(this);
        // 加载配置文件
        ConfigUtil.init();
        // 初始化
        initApi.initCommand("cn.handyplus.plugin.command")
                .initListener("cn.handyplus.plugin.listener")
                .enableSql("cn.handyplus.plugin.enter");
    }

    /**
     * 关闭处理
     */
    @Override
    public void onDisable() {
        // 关闭数据源
        SqlManagerUtil.getInstance().close();
    }

    /**
     * 获取插件唯一实例
     *
     * @return HandyPlugin
     */
    public static HandyPlugin getInstance() {
        return INSTANCE;
    }

}