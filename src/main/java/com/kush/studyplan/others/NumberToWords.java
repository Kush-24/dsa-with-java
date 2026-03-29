package com.kush.studyplan.others;
public class NumberToWords {

    private static final String[] units = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private static final String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public static String convert(int number) {
        if (number == 0) {
            return "Zero";
        }
        return convertNumberToWords(number);
    }

    private static String convertNumberToWords(int number) {
        if (number < 10) {
            return units[number];
        } else if (number < 20) {
            return teens[number - 10];
        } else if (number < 100) {
            return tens[number / 10] + " " + convertNumberToWords(number % 10);
        } else if (number < 1000) {
            return units[number / 100] + " Hundred " + convertNumberToWords(number % 100);
        } else if (number < 1000000) {
            return convertNumberToWords(number / 1000) + " Thousand " + convertNumberToWords(number % 1000);
        } else if (number < 1000000000) {
            return convertNumberToWords(number / 1000000) + " Million " + convertNumberToWords(number % 1000000);
        } else {
            return convertNumberToWords(number / 1000000000) + " Billion " + convertNumberToWords(number % 1000000000);
        }
    }

    public static void main(String[] args) {
        int number = 178053;
        System.out.println(number + " -> " + convert(number));
    }
}
