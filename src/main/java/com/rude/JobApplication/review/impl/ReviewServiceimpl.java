package com.rude.JobApplication.review.impl;

import com.rude.JobApplication.company.Company;
import com.rude.JobApplication.company.CompanyService;
import com.rude.JobApplication.review.Review;
import com.rude.JobApplication.review.ReviewRepository;
import com.rude.JobApplication.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceimpl implements ReviewService {
private final ReviewRepository reviewRepository;
private final CompanyService companyService;


    public ReviewServiceimpl(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews =reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public boolean addReview(Long companyId,Review review) {
       Company company= companyService.findcompanybyid(companyId);
        if(company != null){
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }else {
        return false;}
    }

    @Override
    public Review getReview(Long companyId, Long reviewId) {
        List<Review> reviews=reviewRepository.findByCompanyId(companyId);
        return reviews.stream()
        .filter(review-> review.getId().equals(reviewId))
        .findFirst()
        .orElse(null);
    }

    @Override
    public boolean updatereview(Long companyId, Long reviewId, Review review) {
        if(companyService.findcompanybyid(companyId) != null)
        {
            review.setCompany(companyService.findcompanybyid(companyId));
            review.setId(reviewId);
            reviewRepository.save(review);
            return true;
        }else return false;
    }

    @Override
    public boolean deletereview(Long companyId, Long reviewId) {
        if(companyService.findcompanybyid(companyId) !=null &&reviewRepository.existsById(reviewId)) {
           Review review=reviewRepository.findById(reviewId).orElse(null);
                   Company company=review.getCompany();
                   company.getReviews().remove(review);
                   review.setCompany(null);
                   companyService.updateCompany(companyId,company);
                   reviewRepository.deleteById(reviewId);
            return true;
        }else return false;
    }


}
