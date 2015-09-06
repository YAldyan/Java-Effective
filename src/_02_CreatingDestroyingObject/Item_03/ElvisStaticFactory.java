package _02_CreatingDestroyingObject.Item_03;


//Singleton with static factory
public class ElvisStaticFactory {

	private static final ElvisStaticFactory INSTANCE = new ElvisStaticFactory();

	private ElvisStaticFactory() {};

	public static ElvisStaticFactory getInstance() { return INSTANCE; }

	public void leaveTheBuilding() {} ;
}

// membuat kelas singleton dengan static factory.