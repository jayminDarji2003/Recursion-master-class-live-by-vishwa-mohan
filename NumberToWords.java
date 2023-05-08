/*
    Q:- Write a function that convert number to words using recursion.

    ex. 
        123 --> one hundred twenty three
        1234 --> one thousand two hundren thirty four
        12345 --> twelve thousand three hundred fourty five
        123456 --> one lakh twenty three thousand four hundred fifty six
*/

public class NumberToWords {
    // fnx that convert number to words.
    public static String convertNumToWrods(int num) {
        // base case
        if (num == 0) {
            return "zero";
        }

        if (num < 0) {
            return "minus" + convertNumToWrods(Math.abs(num));
        }

        String words = "";

        // check for lakh
        if (num / 100000 > 0) {
            words = words + convertNumToWrods(num / 100000) + " lacs";
            num = num % 100000; // this will remove the first value
        }

        // check for thousand
        if (num / 1000 > 0) {
            words = words + convertNumToWrods(num / 1000) + " thousand";
            num = num % 1000;
        }
        // check for hundred
        if (num / 100 > 0) {
            words = words + convertNumToWrods(num / 100) + " hundred";
            num = num % 100;
        }
        // check for less than hundred
        if (num > 0) {
            String unitMaps[] = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                    "eleven", "twelve", "thirteen", "fifteen", "fourteen", "sixteen", "seventeen", "eighteen",
                    "nineteen" };

            String tenMaps[] = { "zero", "ten", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty",
                    "ninety" };

            if(num < 20){
                words = words + " " + unitMaps[num];
            }else{
                words = words + " " + tenMaps[num/10];
                if(num % 10 > 0){
                    words = words + " " + unitMaps[num%10];
                }
            }
        }
        return words;
    }

    public static void main(String[] args) {
        System.out.println(convertNumToWrods(123400));
    }
}
