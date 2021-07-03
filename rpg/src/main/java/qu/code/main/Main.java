package qu.code.main;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;
import qu.code.api.API;
import qu.code.api.objects.ApiConfig;
import qu.code.api.objects.ApiPlugin;
import qu.code.main.objects.City;

public class Main extends JavaPlugin {

    @Getter protected static ApiPlugin plugin;

    public void onEnable(){

        //SIEMA KURWO seeoe dedede dede dede


        City city = new City(1);
        plugin = API.createApiPlugin(this);
        ApiConfig config = plugin.getConfig();
        config.load(false);

    }

}
