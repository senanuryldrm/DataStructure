public class Car implements Comparable{
    private String make;
    private String model;
    private int horsePower;
    public Car(String make, String model,int horseP){
        this.make=make;
        this.model=model;
        this.horsePower=horseP;
    }

    @Override
    public int compareTo(Object o) {
        Car c=((Car)o);
        if(this.horsePower==c.horsePower)
            return 0;
        else if(this.horsePower>c.horsePower)
            return 1;
        else
            return -1;
    }

    public String toString(){
        return this.make+" "+this.model+" Horspower is..:"+this.horsePower;
    }
}
