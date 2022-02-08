package Task1;

public class VideoStore {

    private Movie[] storeResources;
    private User[] users;
    private Admin admin;
    private int usersNumber;
    private int resourcesNumber;

    public VideoStore() {
        this.users = new User[10];
        this.storeResources = new Movie[50];
        this.admin = new Admin();
        this.usersNumber = 0;
        this.resourcesNumber = 0;
    }

    public void setStoreResources(Movie resource) {
        storeResources[resourcesNumber] = resource;
        resourcesNumber++;
    }

    public void setStoreUser(User resource) {
        users[usersNumber] = resource;
        usersNumber++;
    }

    public User getUser(int i) {
        return users[i];
    }

    public Admin getAdmin() {
        return admin;
    }

    public int getUsersNumber() {
        return usersNumber;
    }

//  public void logout() {
//      runAccountFeatures();
//  }
}
