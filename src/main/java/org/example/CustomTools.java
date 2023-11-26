package org.example;

public class CustomTools {

    public static int howManyElementsInAnArray(int[] array,int elementToBeFound){
        if(array.length == 0){ //Error message in case empty array...or should I use Exception?
            return -999;
        }
        int counter = 0;
        for (int j : array) {
            if (j == elementToBeFound) {
                counter++;
            }
        }
        return counter;
    }

    //_______________________________________________________

    public static boolean isNumberACrescentSequence(int number){

        if (number > -10 && number < 10) {
            return false;
        }

        int previousDigit = -1;

        while(number != 0){
            int digit = number%10;

            if(digit >= previousDigit && previousDigit !=-1) {
                return false;
            }

            previousDigit = digit;
            number/=10;
        }
        return true;
    }

    public static boolean isCapucua(int n){
        int digit = 0;
        int nCopy = n;
        int sum = 0;
        if(n == 0){
            return true;
        }
        while(n!=0){
            digit = n%10;
            sum = (sum*10)+digit;
            n/=10;
        }
        return nCopy == sum;
    }

    public static boolean areNumberAlgarismsEqual(int number){

        if (number > -10 && number < 10) {
            return true;
        }

        int previousDigit = -999;

        while(number != 0){
            int digit = number%10;

            if(digit != previousDigit && previousDigit !=-999) {
                return false;
            }

            previousDigit = digit;
            number/=10;
        }
        return true;
    }

    public static boolean isAmstrongNumber(int number){ //Só resulta até 999
        if(number < 10 && number >=1){
            return true;
        }

        if(number < 1){
            return false;
        }

        if(number > 999){
            return false;
        }

        int digit;
        int nCopy = number;
        int sum = 0;
        while(number!=0){
            digit = number%10;
            sum += (int) Math.pow(digit,3);
            number/=10;
        }

        return nCopy == sum;
    }

    public static int baseLineCalculator(int sequence){
        if(sequence <=1){
            return -999;
        }
        int pow = sequence-1;
        return (int) Math.pow(10,pow);
    }



}
