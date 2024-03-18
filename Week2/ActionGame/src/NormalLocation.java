public abstract class NormalLocation extends Location{

    public NormalLocation(Player p, String locationName){
        super(p , locationName);
    }

    @Override
    public boolean onLocation(){

        return true;
    }


}
