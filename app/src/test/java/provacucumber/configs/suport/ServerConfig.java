package provacucumber.configs.suport;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:properties/${ENV}.properties","classpath:properties/local.properties"})
public interface ServerConfig extends Config {

    @Key("url")
    String url();

    @Key("port")
    int port();

    @Key("path")
    String path();


}
