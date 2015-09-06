package _06_EnumAndAnnotation.Item_35;

//Program to process marker annotations
import java.lang.reflect.*;

public class RunTest {
	
	public static void runTest() throws ClassNotFoundException{
		
		int tests = 0;
		int passed = 0;

		Class<?> testClass = Class.forName("Sample");

		for (Method m : testClass.getDeclaredMethods()) {

			if (m.isAnnotationPresent(Test.class)) {
				
				tests++;

				try {
					m.invoke(null);
					passed++;
				} catch (InvocationTargetException wrappedExc) {
					Throwable exc = wrappedExc.getCause();
					System.out.println(m + " failed: " + exc);
				} catch (Exception exc) {
					System.out.println("INVALID @Test: " + m);
				}
			}
		}
		System.out.printf("Passed: %d, Failed: %d%n", passed, tests - passed);
		
	}
	
	public static void runTestWithException() throws ClassNotFoundException{
		int tests = 0;
		int passed = 0;
		Class<?> testClass = Class.forName("SampleWithException");
		for (Method m : testClass.getDeclaredMethods()) {
			if (m.isAnnotationPresent(ExceptionTest.class)) {
				tests++;
				try {
					m.invoke(null);
					System.out.printf("Test %s failed: no exception%n", m);
				} catch (InvocationTargetException wrappedEx) {
					Throwable exc = wrappedEx.getCause();
					Class<? extends Exception> excType =
							m.getAnnotation(ExceptionTest.class).value();
					if (excType.isInstance(exc)) {
						passed++;
					} else {
						System.out.printf("Test %s failed: expected %s, got %s%n",
								m, excType.getName(), exc);
					}
				} catch (Exception exc) {
					System.out.println("INVALID @Test: " + m);
				}
			}
		}
		System.out.printf("Passed: %d, Failed: %d%n", passed, tests - passed);

	}
	
	public static void runTestArrayObject() throws ClassNotFoundException{
		int tests = 0;
		int passed = 0;
		Class<?> testClass = Class.forName("SampleArrayObject");
		for (Method m : testClass.getDeclaredMethods()) {
			if (m.isAnnotationPresent(ExceptionTestArrayObject.class)) {
				tests++;
				try {
					m.invoke(null);
					System.out.printf("Test %s failed: no exception%n", m);
				} catch (Throwable wrappedExc) {				
					Throwable exc = wrappedExc.getCause();
					Class<? extends Exception>[] excTypes =
						m.getAnnotation(ExceptionTestArrayObject.class).value();
					int oldPassed = passed;
					for (Class<? extends Exception> excType : excTypes) {
						if (excType.isInstance(exc)) {
							passed++;
							break;
						}
					}
					if (passed == oldPassed)
						System.out.printf("Test %s failed: %s %n", m, exc);
					}
				}
		}
		System.out.printf("Passed: %d, Failed: %d%n", passed, tests - passed);

	}
	
	public static void main(String[] args) throws Exception {

		
	}
}

