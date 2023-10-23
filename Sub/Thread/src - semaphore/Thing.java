public class Thing {
    private String thingName;

    Thing (String name) {
        this.thingName = name;
    }

    @Override
    public String toString() {
        return thingName;
    }

}
