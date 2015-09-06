package _04_ClassesAndInterfaces.Item_16;

import java.util.Collection;
import java.util.HashSet;

//Broken - Inappropriate use of inheritance!
public class InstrumentedHashSet<E> extends HashSet<E> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8648043768418805229L;
	//The number of attempted element insertions
	private int addCount = 0;

	public InstrumentedHashSet() {
	}

	public InstrumentedHashSet(int initCap, float loadFactor) {
		super(initCap, loadFactor);
	}

	@Override 
	public boolean add(E e) {
		addCount++;
		return super.add(e);
	}

	/*
	 * penggunaan method ini pada awalnya menyebabkan jumlah nilai
	 * di dalam Collection menjadi 2 kali dari jumlah sebenarnya
	 * karena method akan memanggil fungsi add dua kali, dikarena-
	 * kan adanya pemanggilan method addAll di superclass-nya,
	 * subclass panggil addAll dan superclass panggil addAll
	 */
	@Override 
	public boolean addAll(Collection<? extends E> c) {
		
		/*
		 * 1. addCount menghitung jumlah nilai dari collection c
		 * 2. nilai di addCount berubah menjadi 3
		 * 3. super.addAll(c) menyebabkan method add(E e) pada kelas ini di-eksekusi
		 * 4. dan hasil akhirnya bisa dilihat sendiri, addCount menjadi 6   
		 */
		
		addCount += c.size();
		return super.addAll(c);
	}

	/*
	 * override addAll dengan menggunakan fungsi iterator
	 * sehingga nilai dari koleksi di-insert satu demi satu
	 * ke dalam objec
	 */
//	@Override 
//	public boolean addAll(Collection<? extends E> c) {
//		
//		Iterator<? extends E> iterator = c.iterator();
//		
//		while(iterator.hasNext()){
//			add(iterator.next());
//		}
//		
//		return true;
//	}
	
	public int getAddCount() {
		return addCount;
	}
}

