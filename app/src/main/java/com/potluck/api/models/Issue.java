package com.potluck.api.models;


import com.google.android.gms.maps.model.LatLng;
import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class Issue {

    @SerializedName("id")
    public abstract int id();

    @SerializedName("status")
    public abstract IssueStatus status();

    @SerializedName("summary")
    public abstract String summary();

    @SerializedName("description")
    public abstract String description();

    @SerializedName("lat")
    public abstract Double latitude();

    @SerializedName("lng")
    public abstract Double longitude();

    public LatLng latLng(){
        return new LatLng(latitude(),longitude());
    }
    public abstract Node_Issue node();

    public static TypeAdapter<Issue> typeAdapter(Gson gson) {
        return new AutoValue_Issue.GsonTypeAdapter(gson);
    }
}