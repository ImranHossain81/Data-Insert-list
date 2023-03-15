package com.example.data_insert_listview;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Modelperson {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("student_id")
    @Expose
    private String student_id;

    @SerializedName("section")
    @Expose
    private String section;

    @SerializedName("result")
    @Expose
    private String result;


    public void setName(String name) {
        this.name = name;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getName() {
        return name;
    }

    public String getStudent_id() {
        return student_id;
    }

    public String getSection() {
        return section;
    }

    public String getResult() {
        return result;
    }
}
