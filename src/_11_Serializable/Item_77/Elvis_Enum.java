package _11_Serializable.Item_77;

import java.util.Arrays;

//Enum singleton - the preferred approach
public enum Elvis_Enum {

	INSTANCE;

	private String[] favoriteSongs = { "Hound Dog", "Heartbreak Hotel" };

	public void printFavorites() {
		System.out.println(Arrays.toString(favoriteSongs));
	}
}

