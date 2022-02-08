/*
    Only add/edit code where it is stated in the description.
*/

import java.util.HashSet;
import java.util.Set;

public class HeavenlyBody {

    private final Key key;

    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public enum BodyTypes {
        PLANET,
        DWARF_PLANET,
        MOON
    }

    public HeavenlyBody(String name, double orbitalPeriod, BodyTypes bodyType) {

        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
        this.key = new Key(name,bodyType);
    }

//    public String getName() {
//        return name;
//    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

//    public BodyTypes getBodyType() {
//        return bodyType;
//    }

    public Key getKey() {
        //System.out.println("in getKey() : key name = "+this.key.getName() +" bodytype = "+this.key.getBodyType());
        return this.key;
    }

    public boolean addSatellite(HeavenlyBody moon) {
        return this.satellites.add(moon);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }

    public static Key makeKey(String name,BodyTypes bodyType){
        return new Key(name,bodyType);
    }

    @Override
    public String toString() {
        return (this.getKey().getName() +": "+this.getKey().getBodyType().toString()+", "+this.orbitalPeriod);
    }

    @Override
    public final boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }

        System.out.println("obj.getClass() is " + obj.getClass());
        System.out.println("this.getClass() is " + this.getClass());
        if ((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }

        String objName = ((HeavenlyBody) obj).getKey().getName();
        return this.getKey().getName().equals(objName);
    }

    @Override
    public final int hashCode() {

        return this.getKey().getName().hashCode() + 57;
    }
    public static final class Key{
        private String name;
        private BodyTypes bodyType;

        private Key(String name, BodyTypes bodyType) {
            this.name = name;
            this.bodyType = bodyType;
        }
        public String getName() {
            return name;
        }
        public BodyTypes getBodyType() {
            return bodyType;
        }
        @Override
        public int hashCode() {
            return (this.name.hashCode() + this.bodyType.hashCode() + 5);
        }
        @Override
        public boolean equals(Object obj) {
            if(this == obj){
                return true;
            }
            if(obj instanceof Key){
                if(this.name.equals(((Key)obj).getName()) &&
                        this.bodyType.equals(((Key)obj).getBodyType())){
                    return true;
                }
            }
            return false;
        }

        @Override
        public String toString() {
            return this.name +": "+this.bodyType;
        }
    }
}