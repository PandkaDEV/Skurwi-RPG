package qu.code.main.bukkit.events;

import lombok.Getter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import qu.code.main.objects.City;

@Getter
public class CityEvent extends Event {

    protected final City city;

    protected final HandlerList handlerList = new HandlerList();

    public CityEvent(@NotNull City city, boolean async){
        super(async);
        this.city = city;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}
