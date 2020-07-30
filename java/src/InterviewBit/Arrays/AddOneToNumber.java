package InterviewBit.Arrays;


import java.util.*;

//Given a non-negative number represented as an array of digits,
//
//add 1 to the number ( increment the number represented by the digits ).
//
//The digits are stored such that the most significant digit is at the head of the list.
//
//Example:
//
//If the vector has [1, 2, 3]
//
//the returned vector should be [1, 2, 4]
//
//as 123 + 1 = 124.
public class AddOneToNumber {
    public static void main(String[] args) {
        int[] ints = {1, 9, 9};
        ArrayList<Integer> intList = new ArrayList<Integer>(ints.length);
        for (int i : ints) {
            intList.add(i);
        }
        ArrayList<Integer> result = plusOne(intList);
        System.out.println(result);
    }

    public static ArrayList<Integer> plusOne(ArrayList<Integer> list) {
        ArrayList<Integer> result = new ArrayList<>();
        int carry = 1;
        for (int i = list.size() - 1; i >= 0; i--) {
            int number = list.get(i)  + carry;
            carry = number / 10;
            result.add(number % 10);
        }
        if(carry!=0)
            result.add(carry);
        Collections.reverse(result);
        return result;
    }
}
