package com.supimon.ratingsservice.resource;

import com.supimon.ratingsservice.models.RatingModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingsServiceResource {

    @RequestMapping("/{chefId}")
    public double getRating(@PathVariable("chefId") String chefId){

        return getAllRating(chefId)
                .stream()
                .mapToDouble(obj -> obj.getRating()).average().orElse(0.0);
    }

    private List<RatingModel> getAllRating(String chefId){
        return Collections.singletonList(
                new RatingModel(4.5, "EMP23")
        );
    }
}
