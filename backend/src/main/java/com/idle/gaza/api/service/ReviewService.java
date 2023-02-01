package com.idle.gaza.api.service;

import com.idle.gaza.api.request.ReviewCreatePostRequest;
import com.idle.gaza.db.entity.Review;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface ReviewService {
    Review writeReview(ReviewCreatePostRequest reviewInfo);
    List<Review> getReviewsByUser(int userId);
    List<Review> getReviewsByGuide(int guideId);
    Optional<Review> getReviewById(int reviewId);
}
