package Task3;

public class App {

    public static void main(String[] args) {

        Dog dog1 = new Dog("Tara", "brown", 140709,
                """
                         /^ ^\\
                        / 0 0 \\
                        V\\ Y /V
                         / - \\
                         |    \\
                         || (__V""");
        Dog dog2 = new Dog("Butch", "black", 950926,
                """
                         / / \\__/ \\ \\
                         \\/| /\\/\\ |\\/
                          _||o o ||_
                         /. .\\__/. .\\
                        / . .(__) . .\\
                        \\ .  /__\\  . /
                         \\__/\\__/\\__/""");
        Dog dog3 = new Dog("Ralph", "gray", 991203,
                """
                        /^-----^\\
                        V  o o  V
                         |  Y  |
                          \\ Q /
                          / - \\
                          |    \\
                          |     \\     )
                          || (___\\====""");
        Dog dog4 = new Dog("Tarzan", "white", 201213,
                """
                             |\\_/|                 \s
                             | @ @   Woof!\s
                             |   <>              _ \s
                             |  _/\\------____ ((| |))
                             |               `--' |  \s
                         ____|_       ___|   |___.'\s
                        /_/_____/____/_______|""");

        Shelter myShelter = new Shelter(10);

        myShelter.addDog(dog1);
        myShelter.addDog(dog2);
        myShelter.addDog(dog3);
        myShelter.addDog(dog4);

        myShelter.adoptDog(dog1);
        myShelter.adoptDog(dog4);

        dog1.getDetails();
        dog2.getDetails();
    }
}
