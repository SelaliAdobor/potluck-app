package com.potluck.api.models;

import com.google.gson.annotations.SerializedName;

public enum IssueStatus {
    @SerializedName("Open") OPEN,
    @SerializedName("Closed") CLOSED,
    @SerializedName("Archived") ARCHIVED
}
