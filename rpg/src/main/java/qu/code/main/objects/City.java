package qu.code.main.objects;

import com.google.common.collect.Maps;
import qu.code.main.objects.city.CityHierarchy;

import java.util.Map;

public class City {

    protected final int id;

    protected final Map<User, CityHierarchy> hierarchyMap = Maps.newLinkedHashMap();

}
