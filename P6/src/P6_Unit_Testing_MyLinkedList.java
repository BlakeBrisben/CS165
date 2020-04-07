import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class P6_Unit_Testing_MyLinkedList<E> {

	private MyLinkedList<E> testLinkedList;
	
	@BeforeEach
	void initializeArrayList() {
		 testLinkedList = new MyLinkedList<E>();
	}
	
	//MyLinkedList TESTS
	//=================
	
		//Test the size method with one element added to testLinkedList object by using the add() method
		@SuppressWarnings("unchecked")
		@Test
		void testListSize() {
			testLinkedList.add((E)new TrainCar(TrainCar.eType.CABOOSE,1337,"TestOwner"));
			assertEquals(1,testLinkedList.size(),"Size of testLinkedList should be 1 after single add()");
		}
		
		//Test the add method with 2 elements using the size() method.
		@Test
		void testListAdd() {
			assertTrue(false,"fill in this test case");
		}
		
		//Test the add method with an element and index using the get() method.
		@Test
		void testListAddIndex() {
			TrainCar testCar = new TrainCar(TrainCar.eType.CABOOSE, 99494,"TestOwner3");
			testLinkedList.add((E)new TrainCar(TrainCar.eType.TANKER,4325,"TestOwner1"));
			testLinkedList.add((E)new TrainCar(TrainCar.eType.ENGINE,9999,"TestOwner2"));
			testLinkedList.add(0,(E) testCar);
			assertEquals(testCar,testLinkedList.get(0),"testCar should have been added to the front of testLinkedList");
		}
		
		//Test high level adding functions
		@Test
		void testListAddFirst() {
			assertTrue(false,"fill in this test case");
		}
		
		@Test
		void testListAddLast() {
			assertTrue(false,"fill in this test case");
		}
		
		@Test
		void testListAddLastIndex() {
			assertTrue(false,"fill in this test case");
		}
		
		@Test
		void testListAddMiddleIndex() {
			assertTrue(false,"fill in this test case");

		}
		
		@Test
		void testListPush() {
			assertTrue(false,"fill in this test case");
		}
		

		//Test removing an entry by passing remove() the object instance.
		@Test
		void testListRemoveObjectSuccess() {
			TrainCar testCar = new TrainCar(TrainCar.eType.CABOOSE,1337,"TestOwner");
			testLinkedList.add((E)testCar);
			testLinkedList.remove(testCar);
			assertEquals(0,testLinkedList.size(),"Size of testLinkedList after removing all elements should be 0");
		}
		
		//Test removing an entry that doesn't exist by passing remove() the non-existant object instance.
		@Test
		void testListRemoveObjectFail() {
			assertTrue(false,"fill in this test case");
		}
		
		//Test removing an entry by passing remove() the index of the entry to be erased.
		@Test
		void testListRemoveIndex() {
			testLinkedList.add((E)new TrainCar(TrainCar.eType.TANKER,4325,"TestOwner1"));
			testLinkedList.remove(0);
			assertEquals(0,testLinkedList.size(),"Size of testLinkedList after removing only entry at 0 should be 0");
		}
		
		//Test removing a range of entries. range is (exclusive,inclusive)
		@Test
		void testListRemoveRange() {
			assertTrue(false,"fill in this test case");
		}
		
		@Test
		void testListRemoveRangeFirst() {
			assertTrue(false,"fill in this test case");

		}
		
		//Test high level removing functions
		@Test
		void testListRemoveLast() {
			TrainCar testCar1 = new TrainCar(TrainCar.eType.CABOOSE,43764,"TestOwner3");
			TrainCar testCar2 = new TrainCar(TrainCar.eType.CABOOSE,49394,"TestOwner3");
			testLinkedList.add((E)testCar2);
			testLinkedList.add((E)testCar1);
			testLinkedList.removeLast();
			assertEquals(testCar2,testLinkedList.peek(),"testCar1 should have been removed to the back of testLinkedList");
		}
		
		@Test
		void testListRemoveFirst() {
			TrainCar testCar1 = new TrainCar(TrainCar.eType.CABOOSE,43764,"TestOwner3");
			TrainCar testCar2 = new TrainCar(TrainCar.eType.CABOOSE,49394,"TestOwner3");
			testLinkedList.add((E)testCar2);
			testLinkedList.add((E)testCar1);
			testLinkedList.removeFirst();
			assertEquals(testCar1,testLinkedList.get(0),"testCar2 should have been removed to the front of testLinkedList");
		}
		
		@Test
		void testListPop() {
			TrainCar testCar1 = new TrainCar(TrainCar.eType.CABOOSE,43764,"TestOwner3");
			TrainCar testCar2 = new TrainCar(TrainCar.eType.CABOOSE,49394,"TestOwner3");
			testLinkedList.add((E)testCar1);
			testLinkedList.add((E)testCar2);
			assertEquals(testCar1,testLinkedList.pop(),"testCar2 should have been removed from the front of testLinkedList");
		}
		
		//Test retrieving an element from testLinkedList by index.
		@Test
		void testListGetFromIndex() {
			assertTrue(false,"fill in this test case");
		}
		
		@Test
		void testListPeek() {
			TrainCar testCar = new TrainCar(TrainCar.eType.CABOOSE,1337,"TestOwner");
			testLinkedList.add((E)testCar);
			testLinkedList.add((E)new TrainCar(TrainCar.eType.ENGINE,9999,"TestOwner2"));
			assertEquals(testCar,testLinkedList.peek(),"Peek should look at the first element in testLinkedList");
		}
		
		//Test setting an existing element at index to a different instance of element
		@Test
		void testListSetElement() {
			assertTrue(false,"fill in this test case");
		}
		
		//Test if the testLinkedList contains an element
		@Test
		void testListContainsFalse() {
			TrainCar testCar = new TrainCar(TrainCar.eType.CABOOSE,1337,"TestOwner");
			testLinkedList.add((E)new TrainCar(TrainCar.eType.ENGINE,9999,"TestOwner2"));
			assertFalse(testLinkedList.contains(testCar),"testLinkedList should not contain 'testCar'");
		}
	

		
		//Test to find the last index of an object in testLinkedList
		@Test
		void testListLastIndexExist() {
			assertTrue(false,"fill in this test case");
		}
		
		@Test
		void testListLastIndexNonExist() {
			TrainCar testCar = new TrainCar(TrainCar.eType.CABOOSE,1337,"TestOwner");
			testLinkedList.add((E)new TrainCar(TrainCar.eType.ENGINE,9999,"TestOwner2"));
			assertEquals(-1,testLinkedList.lastIndexOf(testCar),"lastIndexOf should return -1 if the object does not exist in the array");
		}
		
		
		//Test clearing testLinkedList to erase all elements
		@Test
		void testListCleaer() {
			assertTrue(false,"fill in this test case");
		}
		
		//Test isEmpty() call for array
		@Test
		void testListIsEmptyTrue() {
			assertTrue(testLinkedList.isEmpty(),"isEmpty() should return true if no elements are in testLinkedList");
		}
		
		@Test
		void testListIsEmptyFalse() {
			testLinkedList.add((E)new TrainCar(TrainCar.eType.ENGINE,99322,"TestOwner3"));
			assertFalse(testLinkedList.isEmpty(),"isEmpty() should return false if elements are in testLinkedList");
		}
		
		
		//Test indexOf()
		@Test
		void testListIndexOf() {
			TrainCar testCar = new TrainCar(TrainCar.eType.CABOOSE,1337,"TestOwner");
			testLinkedList.add((E)testCar);
			testLinkedList.add((E)new TrainCar(TrainCar.eType.ENGINE,99322,"TestOwner3"));
			assertEquals(0,testLinkedList.indexOf(testCar),"index of testCar should be 0");
			
		}
				
		
}
