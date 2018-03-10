package com.potluck.api;

import com.potluck.api.models.IssueSearchResults;
import com.potluck.api.models.IssueStatus;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface Issues {
    @GET("issues")
    Single<IssueSearchResults> searchIssues(@Query("page") Integer page,
                                            @Query("per_page") Integer issuesPerPage,
                                            @Query("status")IssueStatus status,
                                            @Query("lat")Double latitude,
                                            @Query("lng")Double longitude,
                                            @Query("search")String searchTerms);
}
