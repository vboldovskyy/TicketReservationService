package cinema;

public class Seat {
    private final Integer row;
    private final Integer place;
    private PlaceType placeType;
    public Seat(int row, int place){
        this.row=row;
        this.place=place;
        if (row>8) placeType=PlaceType.VIP;
        else if (row<4) placeType=PlaceType.NORMAL;
        else placeType=PlaceType.PREMIUM;
    }
    public Integer getRow(){
        return row;
    }
    public Integer getPlace(){
        return place;
    }
    public PlaceType getPlaceType(){
        return placeType;
    }
}
