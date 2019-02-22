package com.kakaopage.global.crm.extraction.description;

import com.google.gson.annotations.SerializedName;
import com.kakaopage.global.crm.extraction.Step;

import java.util.List;


public class Extraction {
    private String name;
    private String expireAt;

    @SerializedName("define")
    private List<Definition> definitions;

    @SerializedName("do")
    private Transformation transformation;

    public List<Step> serialize() {
        return null;
    }

    public List<Definition> getDefinitions() {
        return definitions;
    }

    public Transformation getTransformation() {
        return transformation;
    }

    public String getName() {
        return name;
    }
}
