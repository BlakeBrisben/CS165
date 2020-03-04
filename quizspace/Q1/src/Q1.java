/**
 * Created by Ryan Becwar on 1/27/18
 */
public class Q1 {

    /**
     * A recursive method which calculates the number of blocks in a stacked traingle of
     * the structure below determined by the number of rows.  The 1st row from the top
     * has 1 block, the 2nd two blocks, the 3rd 3 blocks, ect.
     *
     * triangle(3) : 6
     *      
     *     [__]
     *   [__][__]
     * [__][__][__]
     *
     * Do not use any loops (for or while loops) to complete this method.
     * @param rows an int representing the number of rows in the triangle
     * @return an int representing the number of blocks in the triangle
     */
    public static int triangle(int rows){
    	
    	
    	return triangle(rows, 0);
    	
        
    }
    
    public static int triangle(int rows, int total)
    {
    	if(rows == 1)
    	{
    		return 1 + total;
    	}
    	else 
    	{
    		total += rows;
    		return triangle(rows-1, total);
    	}
    }


    /**
     * A recursive method that takes a String and returns the String in reverse order.
     * Do not use any loops (for or while loops) or any built in reverse functions
     * to complete this method.
     * @param str the string to be reversed
     * @return the reversed string
     */
    public static String reverseString(String str){
    	
    	return reverseString(str.toCharArray(), 0);
    	
    }
    
    public static String reverseString(char[] str, int index)
    {
    	char temp;
    	
       	
    	if(index == str.length/2)
    	{
    		String newStr = new String(str);
    		return newStr;
    	}
    	else
    	{
    		temp = str[index];
    		str[index] = str[str.length-index - 1];
    		str[str.length-index - 1] = temp;
    		
    		return reverseString(str, index+1);
    		
    	}
    }


    public static void main(String[] args){
        //You may wish to write additional test code to handle edge cases
        //Test code for the triangle method method
        System.out.println(triangle(1)); // 1
        System.out.println(triangle(5)); // 15
        System.out.println(triangle(124)); // 7750

        // Test code for the reverseString method
        System.out.println(reverseString("hello")); // olleh
        System.out.println(reverseString(".sdrawkcab si sihT")); //This is backwards
    }
}
