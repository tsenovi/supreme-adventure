package Task1;

import java.util.Scanner;

public class App {

     static Scanner console = new Scanner(System.in);

     public static void main(String[] args) {

          VideoStore myVideoStore = new VideoStore();
          storeUsers(myVideoStore);
          storeResources(myVideoStore);
          String email;
          int password;

          do {
               System.out.println("Enter e-mail: ");
               email = console.nextLine();
               System.out.println("Enter password: ");
               password = Integer.parseInt(console.nextLine());
          } while (!Authenticator.isLegitAccount(myVideoStore, email, password));


     }

     private static void storeUsers(VideoStore myVideoStore){
          myVideoStore.setStoreUser(new User("Petar Petrov","petar.petrov@mail.bg", 2020));
          myVideoStore.setStoreUser(new User("Kiril Kirillov","kiril.kirillov@mail.bg", 1919));
     }

     private static void storeResources(VideoStore myVideoStore) {
          myVideoStore.setStoreResources(new Movie("Greenland"));
          myVideoStore.setStoreResources(new Movie("Interstellar"));
     }
}
