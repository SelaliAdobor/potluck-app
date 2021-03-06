package com.potluck.api.models;


import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import io.reactivex.annotations.Nullable;

@AutoValue
public abstract class Pagination {
    @SerializedName("next_page")
    public abstract int nextPageNumber();

    @SerializedName("entries")
    public abstract int entries();

    @SerializedName("next_page_url")
    @Nullable
    public abstract String nextPageUrl();

    @SerializedName("page")
    public abstract int currentPage();

    @SerializedName("pages")
    public abstract int pageCount();

    @SerializedName("per_page")
    public abstract int itemsPerPage();

    public abstract Node_Pagination node();

    public static TypeAdapter<Pagination> typeAdapter(Gson gson) {
        return new AutoValue_Pagination.GsonTypeAdapter(gson);
    }
}