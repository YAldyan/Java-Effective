package _05_Generic.Item_29;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

public class Utama {
	
	public static void viewFavorites(){
		
		Favorites f = new Favorites();
		
		f.putFavorite(String.class, "Java");
		f.putFavorite(Integer.class, 0xcafebabe);
		f.putFavorite(Class.class, Favorites.class);
	
		String favoriteString = f.getFavorite(String.class);
	
		int favoriteInteger = f.getFavorite(Integer.class);
		
		Class<?> favoriteClass = f.getFavorite(Class.class);
	
		System.out.printf("%s %x %s%n", favoriteString, 
										favoriteInteger, favoriteClass.getName());
	}
	
	public static void viewFavoritesHeterogenous(){
		
		Favorites f = new Favorites();
		
		f.putFavoriteHeterogenous(String.class, "13");
		f.putFavoriteHeterogenous(Double.class, 15.0);
		f.putFavoriteHeterogenous(Class.class, Favorites.class);
	
		String favoriteString = f.getFavorite(String.class);
	
		Double favoriteInteger = f.getFavorite(Double.class);
		
		Class<?> favoriteClass = f.getFavorite(Class.class);
	
		System.out.println(favoriteString+" "+favoriteInteger+" "+favoriteClass.getName());
	}
	
	// Use of asSubclass to safely cast to a bounded type token
	public static Annotation getAnnotation(AnnotatedElement element, 
			 							String annotationTypeName) {
		
		Class<?> annotationType = null; // Unbounded type token
		
		try {
			annotationType = Class.forName(annotationTypeName);
		} catch (Exception ex) {	
			throw new IllegalArgumentException(ex);
		}

		return element.getAnnotation(annotationType.asSubclass(Annotation.class));
	}

	// Typesafe heterogeneous container pattern - client
	public static void main(String[] args) {
		viewFavorites();
		
		viewFavoritesHeterogenous();
	}


}
