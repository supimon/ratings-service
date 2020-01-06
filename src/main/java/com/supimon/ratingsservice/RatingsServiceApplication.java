package com.supimon.ratingsservice;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.IOException;

@SpringBootApplication
public class RatingsServiceApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(RatingsServiceApplication.class, args);

		FileInputStream serviceAccount =
				new FileInputStream("src/main/resources/chefapp-eeae0-firebase-adminsdk-tujtr-198a71e00a.json");

		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.setDatabaseUrl("https://chefapp-eeae0.firebaseio.com")
				.build();

		FirebaseApp.initializeApp(options);
	}

}
