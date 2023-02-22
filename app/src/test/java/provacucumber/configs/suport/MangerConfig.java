package provacucumber.configs.suport;

import org.aeonbits.owner.ConfigCache;

public class MangerConfig {

    private MangerConfig() {}

    public static ServerConfig getConfiguration() {
        return ConfigCache.getOrCreate(ServerConfig.class);
    }
}
