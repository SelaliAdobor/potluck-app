package com.potluck.api.models;


import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class Metadata {
    @SerializedName("pagination")
    public abstract Pagination pagination();

    public abstract Node_Metadata node();

    public static TypeAdapter<Metadata> typeAdapter(Gson gson) {
        return new AutoValue_Metadata.GsonTypeAdapter(gson);
    }
}