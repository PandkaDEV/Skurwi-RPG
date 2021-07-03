package qu.code.main.objects.city;

import lombok.Getter;

@Getter
public enum CityHierarchy {

    OCCUPANT(0),
    THUG(0),
    THUG_MASTER(3),
    POLICE(1),
    POLICE_MASTER(2),
    POLICE_HEAD_MASTER(3),
    PRESIDENT(5);

    private final int priority;

    CityHierarchy(int priority){
        this.priority = priority;
    }

}
