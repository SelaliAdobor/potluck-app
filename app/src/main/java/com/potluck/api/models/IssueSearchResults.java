package com.potluck.api.models;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@AutoValue
public abstract class IssueSearchResults {
    @SerializedName("metadata")
    public abstract Metadata metadata();
    @SerializedName("issues")
    public abstract List<Issue> issues();

    public abstract Node_IssueSearchResults node();

    public static TypeAdapter<IssueSearchResults> typeAdapter(Gson gson) {
        return new AutoValue_IssueSearchResults.GsonTypeAdapter(gson);
    }
}
