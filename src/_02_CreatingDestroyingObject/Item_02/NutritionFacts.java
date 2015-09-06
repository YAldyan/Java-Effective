package _02_CreatingDestroyingObject.Item_02;

//Telescoping constructor pattern - does not scale well!
public class NutritionFacts {
	
	@SuppressWarnings("unused")
	private final int servingSize; // (mL) required
	
	@SuppressWarnings("unused")
	private final int servings; // (per container) required
	
	@SuppressWarnings("unused")
	private final int calories; // optional
	
	@SuppressWarnings("unused")
	private final int fat; // (g) optional
	
	@SuppressWarnings("unused")
	private final int sodium; // (mg) optional
	
	//@SuppressWarnings("unused")
	//private final int s; // (g) optional
	
	@SuppressWarnings("unused")
	private final int carbohydrate ;
	
	public NutritionFacts(int servingSize, int servings) {
		this(servingSize, servings, 0);
	}
	
	public NutritionFacts(int servingSize, int servings, int calories) {
		this(servingSize, servings, calories, 0);
	}
	
	public NutritionFacts(int servingSize, int servings, int calories, int fat) {
		this(servingSize, servings, calories, fat, 0);
	}
	
	public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium) {
		this(servingSize, servings, calories, fat, sodium, 0);
	}
	
	public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
			this.servingSize = servingSize;
			this.servings = servings;
			this.calories = calories;
			this.fat = fat;
			this.sodium = sodium;
			this.carbohydrate = carbohydrate;
	}
}


// perhatikan kode program di-atas.
// topic pembahasan yang sekarang adalah mengenai contructror dengan argument
// yang banyak, sehingga semakin banyak argumen yang harus di-inisialisasi
// maka semakin banyak pula constructor yang akan kita buat.
// cara ini terlalu ribet dan sulit dibaca, client mungkin saja
// salah mengerti dan meng-input angka yang salah.

// pola di-atas disebut dengan nama : constructor pattern.

// cara pemanggilannya seperti di-bawah ini.

// NutritionFacts cocaCola = new NutritionFacts(240, 8, 100, 0, 35, 27);
