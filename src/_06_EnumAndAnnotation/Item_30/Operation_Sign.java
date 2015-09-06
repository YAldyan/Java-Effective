package _06_EnumAndAnnotation.Item_30;

//Enum type with constant-specific class bodies and data
public enum Operation_Sign {

	PLUS("+") {
		double apply(double x, double y) { 
			return x + y; 
		}
	},
	
	MINUS("-") {
		double apply(double x, double y) { 
			return x - y; 
		}
	},
	
	TIMES("*") {
		double apply(double x, double y) { 
			return x * y; 
		}
	},

	DIVIDE("/") {
		double apply(double x, double y) { 
			return x / y; 
		}
	};
	
	private final String symbol;

	Operation_Sign(String symbol) { this.symbol = symbol; }

	@Override 
	public String toString() { 
		return symbol; 
	}

	abstract double apply(double x, double y);
}

