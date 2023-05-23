package com.example.demo.services;

import java.util.List;
import java.util.concurrent.ExecutionException;

import com.example.demo.models.IBook;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;

public class bookService {
	public static boolean createBook(IBook book) throws InterruptedException, ExecutionException {
		try {
			Firestore dbFirestore = FirestoreClient.getFirestore();
			Query query = dbFirestore.collection("book").whereEqualTo("name", book.getName()).whereEqualTo("coordinates",
					book.getCoords());
			ApiFuture<QuerySnapshot> querySnapshot = query.get();
			List<QueryDocumentSnapshot> documents = querySnapshot.get().getDocuments();
			if (!documents.isEmpty()) {
				return false;
			}
			DocumentReference documentReference = dbFirestore.collection("book").document();
			documentReference.set(book).get();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
