package com.idle.gaza.api.service;

import com.idle.gaza.api.request.ReviewCreatePostRequest;
import com.idle.gaza.db.entity.Review;

public interface ReviewService {
    Review writeReview(ReviewCreatePostRequest reviewInfo);
}
