import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class P6_Unit_Testing_MyArrayList<E> {
	
	private MyArrayList<E> testArrayList;
	
	@BeforeEach
	void initializeArrayList() {
		 testArrayList = new MyArrayList<E>(5);
	}
	
	//MyArrayList TESTS
	//=================
	
		//Test the size method with one element added to testArrayList object by using the add() method
		@SuppressWarnings("unchecked")
		@Test
		void testListSize() {
			testArrayList.add((E)new TrainCar(TrainCar.eType.CABOOSE,1337,"TestOwner"));
			assertEquals(1,testArrayList.size(),"Size of testArrayList should be 1 after single add()");
		}
		
		//Test the add method with 2 elements using the size() method.
		@Test
		void testListAdd() {
			testArrayList.add((E)new TrainCar(TrainCar.eType.CABOOSE,1337,"TestOwner"));
			testArrayList.add((E)new TrainCar(TrainCar.eType.ENGINE,1336,"TestOwner"));
			assertTrue(testArrayList.size() == 2,"List should have size of 2");
		}
		
		//Test the add method with more elements than the initial size (5)
		@Test
		void testListAddMore() {
			testArrayList.add((E)new TrainCar(TrainCar.eType.CABOOSE,1337,"TestOwner"));
			testArrayList.add((E)new TrainCar(TrainCar.eType.ENGINE,1336,"TestOwner"));
			testArrayList.add((E)new TrainCar(TrainCar.eType.PASSENGER,1338,"TestOwner"));
			testArrayList.add((E)new TrainCar(TrainCar.eType.PASSENGER,1339,"TestOwner"));
			testArrayList.add((E)new TrainCar(TrainCar.eType.PASSENGER,1335,"TestOwner"));
			testArrayList.add((E)new TrainCar(TrainCar.eType.PASSENGER,1334,"TestOwner"));
			assertTrue(testArrayList.size() == 6,"List should have size of 6");
		}
		
		//Test removing an entry by passing remove() the object instance.
		@Test
		void testListRemoveObjectSuccess() {
			
			testArrayList.add((E)new TrainCar(TrainCar.eType.CABOOSE,1337,"TestOwner"));
			testArrayList.add((E)new TrainCar(TrainCar.eType.ENGINE,1336,"TestOwner"));
			
			
			assertTrue(testArrayList.remove((E)new TrainCar(TrainCar.eType.CABOOSE,1337,"TestOwner")),"The caboose should have been removed");
		}
		
		//Test removing an entry that doesn't exist by passing remove() the non-existant object instance.
		@Test
		void testListRemoveObjectFail() {

			testArrayList.add((E)new TrainCar(TrainCar.eType.CABOOSE,1337,"TestOwner"));
			testArrayList.add((E)new TrainCar(TrainCar.eType.ENGINE,1336,"TestOwner"));
			
			
			assertTrue(!testArrayList.remove((E)new TrainCar(TrainCar.eType.PASSENGER,1334,"TestOwner")),"The Object does not exist");
			
		}
		
		//Test removing an entry by passing remove() the index of the entry to be erased.
		@Test
		void testListRemoveIndex() {
			testArrayList.add((E)new TrainCar(TrainCar.eType.CABOOSE,1337,"TestOwner"));
			testArrayList.add((E)new TrainCar(TrainCar.eType.ENGINE,1336,"TestOwner"));
			
			assertTrue(testArrayList.remove(0).equals((E)new TrainCar(TrainCar.eType.CABOOSE,1337,"TestOwner")),"Should have removed the caboose");
		}
		
		//Test removing a range of entries. range is (exclusive,inclusive)
		@Test
		void testListRemoveRange() {
			
			testArrayList.add((E)new TrainCar(TrainCar.eType.CABOOSE,1337,"TestOwner"));
			testArrayList.add((E)new TrainCar(TrainCar.eType.ENGINE,1336,"TestOwner"));
			testArrayList.add((E)new TrainCar(TrainCar.eType.PASSENGER,1338,"TestOwner"));
			testArrayList.add((E)new TrainCar(TrainCar.eType.PASSENGER,1339,"TestOwner"));
			testArrayList.add((E)new TrainCar(TrainCar.eType.PASSENGER,1335,"TestOwner"));
			testArrayList.add((E)new TrainCar(TrainCar.eType.PASSENGER,1334,"TestOwner"));
			
			testArrayList.removeRange(1, 3);
			
			assertTrue(testArrayList.size() == 4,"size should equal 4");
		}
		
		//Test retrieving an element from testArrayList by index.
		@Test
		void testListGetFromIndex() {
			TrainCar testCar = new TrainCar(TrainCar.eType.CABOOSE,1337,"TestOwner");
			testArrayList.add((E)testCar);
			testArrayList.add((E)new TrainCar(TrainCar.eType.ENGINE,9999,"TestOwner2"));
			assertEquals(testCar,testArrayList.get(0),"Element returned should have been 'testCar'");
		}
		
		//Test setting an existing element at index to a different instance of element
		@Test
		void testListSetElement() {
			TrainCar testCar = new TrainCar(TrainCar.eType.CABOOSE,1337,"TestOwner");
			testArrayList.add((E)testCar);
			testArrayList.add((E)new TrainCar(TrainCar.eType.ENGINE,9999,"TestOwner2"));
			testArrayList.set(1, (E)testCar);
			assertEquals(testCar,testArrayList.get(1),"Element returned should be 'testCar'");
		}
		
		//Test if the testArrayList contains an element
		@Test
		void testListContainsFalse() {
			TrainCar testCar = new TrainCar(TrainCar.eType.CABOOSE,1337,"TestOwner");
			testArrayList.add((E)new TrainCar(TrainCar.eType.ENGINE,9999,"TestOwner2"));
			assertFalse(testArrayList.contains(testCar),"testArrayList should not contain 'testCar'");
		}
	
		@Test
		void testListContainsTrue() {
			TrainCar testCar = new TrainCar(TrainCar.eType.CABOOSE,1337,"TestOwner");
			testArrayList.add((E)testCar);
			assertTrue(testArrayList.contains(testCar),"testArrayList should contain 'testCar'");
		}
		
		//Test to find the last index of an object in testArrayList
		@Test
		void testListLastIndexExist() {
			TrainCar testCar = new TrainCar(TrainCar.eType.CABOOSE,1337,"TestOwner");
			testArrayList.add((E)testCar);
			testArrayList.add((E)new TrainCar(TrainCar.eType.ENGINE,9999,"TestOwner2"));
			testArrayList.add((E)testCar);
			assertEquals(2,testArrayList.lastIndexOf(testCar),"The last index of 'testCar' should be 2");
		}
		
		@Test
		void testListLastIndexNonExist() {
			TrainCar testCar = new TrainCar(TrainCar.eType.CABOOSE,1337,"TestOwner");
			testArrayList.add((E)new TrainCar(TrainCar.eType.ENGINE,9999,"TestOwner2"));
			assertEquals(-1,testArrayList.lastIndexOf(testCar),"lastIndexOf should return -1 if the object does not exist in the array");
		}
		
		//Test clearing testArrayList to erase all elements
		@Test
		void testListClear() {
			testArrayList.add((E)new TrainCar(TrainCar.eType.CABOOSE,1337,"TestOwner"));
			testArrayList.add((E)new TrainCar(TrainCar.eType.ENGINE,1336,"TestOwner"));
			
			testArrayList.clear();
			assertTrue(testArrayList.size() == 0,"Size should equal 0");
		}
		
		//Test isEmpty() call for array
		@Test
		void testListIsEmptyTrue() {
			assertTrue(testArrayList.isEmpty(),"isEmpty() should return true if no elements are in testArrayList");
		}
		
		@Test
		void testListIsEmptyFalse() {
			testArrayList.add((E)new TrainCar(TrainCar.eType.ENGINE,99322,"TestOwner3"));
			assertFalse(testArrayList.isEmpty(),"isEmpty() should return false if elements are in testArrayList");
		}
		
		
}
