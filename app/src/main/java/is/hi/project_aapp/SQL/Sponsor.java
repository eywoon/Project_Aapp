package is.hi.project_aapp.SQL;

/**
 * Created by hrefnaolafsdottir on 17/03/16.
 */
public class Sponsor {
    private String name;
    private int phoneNo;

    private Sponsor(String name, int phoneNo){
        this.name = name;
        this.phoneNo = phoneNo;
    }

    String getName(){
        return this.name;
    }
    int getPhoneNo(){
        return this.phoneNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }
}
