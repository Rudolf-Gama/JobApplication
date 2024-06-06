package com.rude.JobApplication.review;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company/{companyId}")
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
@GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId) {
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }
@PostMapping("/reviews")
    public ResponseEntity<String> addReview(@PathVariable Long companyId,@RequestBody Review review ){
     boolean isreviewsaved=  reviewService.addReview(companyId,review);
     if(isreviewsaved)
       return new ResponseEntity<>("review has been added",HttpStatus.OK);
     else{
         return new ResponseEntity<>("review has not been added",HttpStatus.NOT_FOUND);
     }
}

@GetMapping("/reviews/{reviewId}")
public ResponseEntity<Review> getReview(@PathVariable Long companyId,@PathVariable Long reviewId){
        return new ResponseEntity<>(reviewService.getReview(companyId, reviewId),HttpStatus.OK) ;
}
@PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updatereview(@PathVariable Long companyId,@PathVariable Long reviewId,@RequestBody Review review) {
   boolean updated=reviewService.updatereview(companyId,reviewId,review);
   if(updated)
    return new ResponseEntity<>("Review updated",HttpStatus.OK);
   else
       return new ResponseEntity<>(" Review not updated",HttpStatus.BAD_REQUEST);
}

@DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deletereview(@PathVariable Long companyId,@PathVariable Long reviewId){
        boolean deletereview=reviewService.deletereview(companyId,reviewId);
    if(deletereview)
        return new ResponseEntity<>("Review deleted",HttpStatus.OK);
    else
        return new ResponseEntity<>(" Review not deleted",HttpStatus.BAD_REQUEST);
}
}
