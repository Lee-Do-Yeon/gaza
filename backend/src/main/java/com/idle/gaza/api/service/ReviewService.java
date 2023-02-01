package com.idle.gaza.api.service;

import com.idle.gaza.api.request.ReviewCreatePostRequest;
import com.idle.gaza.db.entity.Review;

import java.util.List;

public interface ReviewService {
    Review writeReview(ReviewCreatePostRequest reviewInfo);
    List<Review> getReviewsByUser(int userId);
    List<Review> getReviewsByGuide(int guideId);
}
