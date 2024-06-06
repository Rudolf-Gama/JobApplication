package com.rude.JobApplication.review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companyId);

    boolean addReview(Long companyId,Review review);

    Review getReview(Long companyId,Long reviewId);

    boolean updatereview(Long companyId, Long reviewId, Review review);

    boolean deletereview(Long companyId, Long reviewId);

}
