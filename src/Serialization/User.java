package Serialization;

import java.io.Serializable;

public class User implements Serializable {

    //field
    private long id;
    private String name;
    private String tc_no;

    //constructor
    public User(long id, String name, String tc_no) {
        this.id = id;
        this.name = name;
        this.tc_no = tc_no;
    }

        //getter-setter


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTc_no() {
        return tc_no;
    }

    public void setTc_no(String tc_no) {
        this.tc_no = tc_no;
    }

        //toString

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tc_no='" + tc_no + '\'' +
                '}';
    }
}