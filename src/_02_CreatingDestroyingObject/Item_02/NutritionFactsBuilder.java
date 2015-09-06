package _02_CreatingDestroyingObject.Item_02;

//Builder Pattern
public class NutritionFactsBuilder {

	@SuppressWarnings("unused")
	private final int servingSize;
	
	@SuppressWarnings("unused")
	private final int servings;
	
	@SuppressWarnings("unused")
	private final int calories;
	
	@SuppressWarnings("unused")
	private final int fat;
	
	@SuppressWarnings("unused")
	private final int sodium;
	
	@SuppressWarnings("unused")
	private final int carbohydrate;

	public static class Builder {
		//Required parameters
		private final int servingSize;
		private final int servings;

		//Optional parameters - initialized to default values
		private int calories = 0;
		private int fat = 0;
		private int carbohydrate = 0;
		private int sodium = 0;

		public Builder(int servingSize, int servings) {
			this.servingSize = servingSize;
			this.servings = servings;	
		}

		public Builder calories(int val){ 
			calories = val; 
			
			return this; 
		}
		
		public Builder fat(int val){ 
			fat = val; 
			
			return this; 
		}
		
		public Builder carbohydrate(int val){ 
			carbohydrate = val; 
			
			return this; 
		}
		
		public Builder sodium(int val){ 
			sodium = val; 
			
			return this; 
		}

		public NutritionFactsBuilder build() {
			return new NutritionFactsBuilder(this);
		}
	}

	private NutritionFactsBuilder(Builder builder) {
		servingSize = builder.servingSize;
		servings = builder.servings;
		calories = builder.calories;
		fat = builder.fat;
		sodium = builder.sodium;
		carbohydrate = builder.carbohydrate;
	}
}

// pola ini adalah pola builder pattern.
// pola ini membuat client tahu, tiap-tiap
// nilai untuk masing-masing variabel.
// sehingga menghindarkan dari kesalahan
// mengenai mismatch value.

// cara pemanggilannya menjadi seperti di-bawah ini.

// NutritionFacts cocaCola = new NutritionFacts.
//                Builder(240, 8). calories(100).sodium(35).carbohydrate(27).build();
