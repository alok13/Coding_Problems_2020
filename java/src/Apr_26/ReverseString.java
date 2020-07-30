package Apr_26;

public class ReverseString {
    public static void main(String[] args) {
        //char[] input = {'I', ' ', 'l', 'o', 'v', 'e', ' ', 'T', 'a', 'x', 'i', 'f', 'y'};
        char[] input = {'I', 'l', 'o', 'v', 'e', 'T', 'a', 'x', 'i', 'f', 'y'};
        //char[] input = {};//{'I', 'l', 'o', 'v', 'e', 'T', 'a', 'x', 'i', 'f', 'y'};
        for (char c : input)
            System.out.print(c);

        System.out.println();
        char[] result = reverseWords(input);
        for (char c : result)
            System.out.print(c);
    }

    public static char[] reverseWords(char [] input) {
        if(input==null || input.length==0)
            return input;

        int start=0;
        for(int end=0;end<input.length;end++){
            if (input[end] == ' '){
                reverseSingleWord(input,start,end-1);
                start=end+1;
            }
        }
        reverseSingleWord(input,start,input.length-1);
        return input;
    }

    public static void reverseSingleWord(char[] input, int start, int end){
        while(start<end){
            char temp=input[start];
            input[start]=input[end];
            input[end]=temp;
            start++;
            end--;
        }
    }
}
