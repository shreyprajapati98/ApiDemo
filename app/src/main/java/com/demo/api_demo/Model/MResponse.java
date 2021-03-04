package com.demo.api_demo.Model;

import com.google.gson.annotations.SerializedName;

public class MResponse {
    @SerializedName("id")
    private Integer id;
    @SerializedName("name")
    private String name;
    @SerializedName("body")
    private String body;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public MResponse(Integer id, String name, String body){
        this.id=id;
        this.name = name;
        this.body = body;
    }
}
