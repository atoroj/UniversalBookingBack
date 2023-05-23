package com.example.demo.services;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.example.demo.models.ILogin;
import com.example.demo.models.IUser;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class userService {
	public static boolean createUser(IUser user) throws InterruptedException, ExecutionException {
		try {
			Firestore dbFirestore = FirestoreClient.getFirestore();
			Query query = dbFirestore.collection("user").whereEqualTo("email", user.getEmail()).whereEqualTo("name",
					user.getName());
			ApiFuture<QuerySnapshot> querySnapshot = query.get();
			List<QueryDocumentSnapshot> documents = querySnapshot.get().getDocuments();
			if (!documents.isEmpty()) {
				return false;
			}
			DocumentReference documentReference = dbFirestore.collection("user").document();
			documentReference.set(user).get();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static IUser viewUser(String userName) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		DocumentReference documentReference = dbFirestore.collection("test").document(userName);
		ApiFuture<DocumentSnapshot> future = documentReference.get();
		DocumentSnapshot document = future.get();
		IUser user;
		if (document.exists()) {
			user = document.toObject(IUser.class);
			return user;
		}
		return null;
	}

	public static int checkLogin(ILogin login) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		// Get a reference to the collection "users".
		CollectionReference loginCollection = dbFirestore.collection("user");
		String email = login.getEmail();
		String password = login.getPassword();
		// Build of the query
		Query query = loginCollection.whereEqualTo("email", email).whereEqualTo("password", password);
		// Obtain data from the query
		ApiFuture<QuerySnapshot> future = query.get();
		QuerySnapshot querySnapshot = future.get();
		// Verify if we found the documents
		if(!querySnapshot.isEmpty()) {
			for (QueryDocumentSnapshot document : querySnapshot.getDocuments()) {
	            // Obtener el valor del campo "rol"
	            Integer rol = document.getLong("rol").intValue();
	            if (rol == 1) {
	                return 1;
	            } else {
	                return 0;
	            }
	        }
		}
		return -1;
	}	
}
