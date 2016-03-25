package is.hi.project_aapp.Me;

/**
 * Created by hrefnaolafsdottir on 22/03/16.
 */
public class User {
    private String firstName;
    private String lastName;
    private int soberYear;
    private int soberMonth;
    private int soberDay;

    User (String firstName, String lastName, int soberDay, int soberMonth, int soberYear){
        this.firstName = firstName;
        this.lastName = lastName;
        this.soberDay = soberDay;
        this.soberMonth = soberMonth;
        this.soberYear = soberYear;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSoberYear(){
        return soberYear;
    }
    public int getSoberMonth(){
        return soberMonth;
    }
    public int getSoberDay(){
        return soberDay;
    }


    public void setSoberDay(int soberDay) {
        this.soberDay = soberDay;
    }

    public void setSoberMonth(int soberMonth) {
        this.soberMonth = soberMonth;
    }

    public void setSoberYear(int soberYear) {
        this.soberYear = soberYear;
    }
}
