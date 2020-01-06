package com.supimon.ratingsservice.resource;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.supimon.ratingsservice.models.RatingModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/ratings")
public class RatingsServiceResource {

    @RequestMapping("/{chefId}")
    public Double getRating(@PathVariable("chefId") String chefId) throws InterruptedException, ExecutionException {

        Firestore db = FirestoreClient.getFirestore();
        CollectionReference chefRating = db.collection("ratings");
        // Create a query against the collection.
        Query query = chefRating.whereEqualTo("chefId", chefId);

        ApiFuture<QuerySnapshot> querySnapshot = query.get();

        List<QueryDocumentSnapshot> documents = querySnapshot.get().getDocuments();

        RatingModel ratingModel = new RatingModel();

        for (QueryDocumentSnapshot document : documents) {
            ratingModel.setUserId(document.getString("chefId"));
            ratingModel.setRating(document.getDouble("rating"));
        }

        return ratingModel.getRating();
    }
}
