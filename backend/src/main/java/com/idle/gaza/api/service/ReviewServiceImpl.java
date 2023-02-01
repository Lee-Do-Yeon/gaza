package com.idle.gaza.api.service;

import com.idle.gaza.api.request.ReviewCreatePostRequest;
import com.idle.gaza.db.entity.Reservation;
import com.idle.gaza.db.entity.Review;
import com.idle.gaza.db.repository.ReservationRepository;
import com.idle.gaza.db.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("reviewService")
public class ReviewServiceImpl implements ReviewService{

    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    ReservationRepository reservationRepository;

    @Override
    public Review writeReview(ReviewCreatePostRequest reviewInfo) {

        int reservationId = reviewInfo.getReservationId();
        Optional<Reservation> reservationOptional = reservationRepository.findById(reservationId);
        Reservation reservation = null;
        if(reservationOptional.isPresent()){
            reservation = reservationOptional.get();
        }

        Review review = Review.builder()
                .content(reviewInfo.getContent())
                .score(reviewInfo.getScore())
                .reservationId(reservation)
                .build();

        return reviewRepository.save(review);
    }

    @Override
    public List<Review> getReviewsByUser(int userId) {
        return reviewRepository.findByUserId_UserId(userId);
    }

    @Override
    public List<Review> getReviewsByGuide(int guideId) {
        return reviewRepository.findByGuideId_GuideId(guideId);
    }
}
