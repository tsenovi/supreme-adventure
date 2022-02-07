package Task3;

public class Shelter {

    private Dog[] dogsShelter;
    private int dogsNumber;

    public Shelter(int shelterCapacity) {
        this.dogsShelter = new Dog[shelterCapacity];
        this.dogsNumber = 0;
    }

    public void addDog(Dog dog) {
        dogsShelter[dogsNumber] = dog;
        dogsNumber++;
    }

    public void adoptDog(Dog dogToAdopt) {
        for (int index = 0; index < dogsNumber; index++) {
            if (dogsShelter[index].getName().equals(dogToAdopt.getName())) {
                dogsShelter[index].adopted();
            }
        }
    }
}
