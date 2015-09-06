package _06_EnumAndAnnotation.Item_33;

import java.util.EnumMap;
import java.util.Map;

// Using a nested EnumMap to associate data with enum pairs
public enum Phase_EnumMap {
	
	SOLID, LIQUID, GAS;
	
	public enum Transition {

		MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID),

		BOIL(LIQUID, GAS), CONDENSE(GAS, LIQUID),

		SUBLIME(SOLID, GAS), DEPOSIT(GAS, SOLID);

		final Phase_EnumMap src;

		final Phase_EnumMap dst;

		Transition(Phase_EnumMap src, Phase_EnumMap dst) {
			this.src = src;
			this.dst = dst;
		}

		//Initialize the phase transition map
		private static final Map<Phase_EnumMap, Map <Phase_EnumMap,Transition>> m = 
				new EnumMap <Phase_EnumMap, Map<Phase_EnumMap,Transition>>
							(Phase_EnumMap.class);

		static {
			for (Phase_EnumMap p : Phase_EnumMap.values())
				m.put(p,new EnumMap<Phase_EnumMap,Transition>(Phase_EnumMap.class));

			for (Transition trans : Transition.values())
				m.get(trans.src).put(trans.dst, trans);
		}
		public static Transition from(Phase_EnumMap src, Phase_EnumMap dst) {
			return m.get(src).get(dst);
		}
	}
}
