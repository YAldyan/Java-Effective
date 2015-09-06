package _06_EnumAndAnnotation.Item_30;

/*
 * kita wajib override method apply jika
 * kita membuat tipe enum baru, dan compiler
 * juga akan mengingatkah jikalau sampai itu 
 * terjadi
 */
//Enum type with constant-specific method implementations
public enum Operation_Method {

	PLUS { 
			double apply(double x, double y)
			{
				return x + y;
			} 
	},
	
	MINUS { 
			double apply(double x, double y)
			{
				return x - y;
			} 
	},
	
	TIMES { 
			double apply(double x, double y)
			{
				return x * y;
			} 
	},
	
	DIVIDE { 
			double apply(double x, double y)
			{
				return x / y;
			} 
	};
	
	abstract double apply(double x, double y);
}