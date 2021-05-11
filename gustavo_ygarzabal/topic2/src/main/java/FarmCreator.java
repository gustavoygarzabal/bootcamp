public class FarmCreator extends BuildingCreator{
    @Override
    public Building createBuilding(int capacity) {
        return Farm.getInstance();
    }
}
