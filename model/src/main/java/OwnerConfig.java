import org.aeonbits.owner.Config;

public interface OwnerConfig extends Config {

    @Key("server.url")
    @DefaultValue("https://www.google.ru")
    String url();
}
