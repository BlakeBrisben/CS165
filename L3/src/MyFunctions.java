
public class MyFunctions implements TestingFunctions{

	public int greatestCommonDivisor(int a, int b)
	{
		if(a < 0 || b < 0)
			return -1;
		
		int q, r;
		
		if(a == 0)
			return b;
		else if(b == 0)
			return a;
		
		
		q = a/b;
		r = a%b;
		
		
		
		return greatestCommonDivisor(b,r);
		
		
	}
	
	public void reverseWindow(int[] arr, int index1, int index2) throws IndexOutOfBoundsException
	{
		int temp;
		
		
		if(index1 > index2)
		{
			temp = index1;
			index1 = index2;
			index2 = temp;
		}
		
		int mid = index2 - index1;
		
		if(mid % 2 == 1)
		{
			mid = mid/2 +1;
		}
		else
		{
			mid = mid/2;
		}
		
		for(int i = 0; i < mid; i++)
		{
			temp = arr[index1 + i];
			arr[index1+i] = arr[index2-1-i];
			arr[index2-1-i] = temp;
			
		}
		
	}
	
}
