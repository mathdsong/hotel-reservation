package model;

public class FreeRoom extends Room{

    public FreeRoom(String roomNumber, RoomType enumeration) {
        super(roomNumber, (double) 0, enumeration);
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
