package qu.code.main.bukkit.events.city;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.event.Cancellable;
import org.jetbrains.annotations.NotNull;
import qu.code.main.bukkit.events.CityEvent;
import qu.code.main.objects.City;

@Setter
@Getter
public class CityDeleteEvent extends CityEvent implements Cancellable {

    private boolean cancelled;

    public CityDeleteEvent(@NotNull City city){
        super(city, true);
    }

}
