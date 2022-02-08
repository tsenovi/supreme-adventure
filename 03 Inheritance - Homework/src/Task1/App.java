package Task1;

public class App {

    public static void main(String[] args) {
        VideoStore myVideoStore = new VideoStore();
        storeUsers(myVideoStore);
        storeResource(myVideoStore);

        InputOutput.getCredentials(myVideoStore);
        Account currentAccount = InputOutput.getAccountType(myVideoStore);

        do {
            if (currentAccount instanceof Admin) {
                //1. Create user account
                //2. See all users
                //3. See all movies
                //4. See all rented movies and who rented them
                //5. Logout
            } else {
                //1. See rented movies by you. Return movie
                //2. See all free movies. Rent a movie.
                //3. Logout
            }
        } while (currentAccount.isLoggedIn());

    }

    private static void storeUsers(VideoStore myVideoStore) {
        myVideoStore.setStoreUser(new User("Petar Petrov", "petar.petrov@mail.bg", "2020"));
        myVideoStore.setStoreUser(new User("Kiril Kirillov", "kiril.kirillov@mail.bg", "1919"));
    }

    private static void storeResource(VideoStore myVideoStore) {
        myVideoStore.setStoreResource(new Movie("Greenland"));
        myVideoStore.setStoreResource(new Movie("Interstellar"));
    }
}
