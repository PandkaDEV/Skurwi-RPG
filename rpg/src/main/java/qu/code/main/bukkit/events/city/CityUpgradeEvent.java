package qu.code.main.bukkit.events.city;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.event.Cancellable;
import org.jetbrains.annotations.NotNull;
import qu.code.main.bukkit.events.CityEvent;
import qu.code.main.objects.City;

@Getter
@Setter
public class CityUpgradeEvent extends CityEvent implements Cancellable {

    private boolean cancelled;

    public CityUpgradeEvent(@NotNull City city){
        super(city, false);
    }

}
