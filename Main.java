package state.com;
//This program can be used to convert a number to words

import java.util.*;
import java.text.DecimalFormat;
class NumberToWord
{
        private static String finalResult;
        //string type array for two digits numbers
        private static final String[] twodigits = {"", " Sepuluh", " Dua Puluh", " Tiga Puluh", " Empat Puluh", " Lima Puluh", " Enam Puluh", " Tujuh Puluh", " Delapan Puluh", " Sembilan Puluh"};
        //string type array for one digit numbers
        private static final String[] onedigit = {"", " Satu", " Dua", " Tiga", " Empat", " Lima", " Enam", " Tujuh", " Delapan", " Sembilan", " Sepuluh", " Sebelas", " Dua belas", " Tiga belas", " Empat belas", " Lima belas", " Enam belas", " Tujuh belas", " Delapan belas", " Sembilan belas"};
        //defining constructor of the class
        private NumberToWord()
        { }
//        method that converts a number to words (up to 1000)
        private static String convertUptoThousand(int number)
        {
                String soFar;
                if (number % 100 < 20)
                {
                        soFar = onedigit[number % 100];
                        number = number/ 100;
                }
                else
                {
                        soFar = onedigit[number % 10];
                        number = number/ 10;
                        soFar = twodigits[number % 10] + soFar;
                        number = number/ 10;
                }
                if (number == 0)
                        return soFar;
                if (number == 1)
                        return "Seratus" + soFar;
                return onedigit[number] + " Ratus " + soFar;
        }

        public static String convertNumberToWord(long number)
        {
                if (number == 0)
                {
                        return "zero";
                }
                String num = Long.toString(number);
                String pattern = "000000000";
                DecimalFormat decimalFormat = new DecimalFormat(pattern);
                num = decimalFormat.format(number);

                if (Integer.parseInt(num) >= 100000000) {
                        System.out.println("Melebihi  batas");
                }else {
                        int millions = Integer.parseInt(num.substring(0, 3));
                        int hundredThousands = Integer.parseInt(num.substring(3, 6));
                        int thousands = Integer.parseInt(num.substring(6, 9));
                        String tradMillions;
                        switch (millions) {
                                case 0:
                                        tradMillions = "";
                                        break;
                                case 1:
                                        tradMillions = convertUptoThousand(millions) + " Juta ";
                                        break;
                                default:
                                        tradMillions = convertUptoThousand(millions) + " Juta ";
                        }
                        String result = tradMillions;
                        String tradHundredThousands;
                        switch (hundredThousands) {
                                case 0:
                                        tradHundredThousands = "";
                                        break;
                                case 1:
                                        tradHundredThousands = "Seribu";
                                        break;
                                default:
                                        tradHundredThousands = convertUptoThousand(hundredThousands) + " Ribu ";
                        }
                        result = result + tradHundredThousands;
                        String tradThousand;
                        tradThousand = convertUptoThousand(thousands);
                        result = result + tradThousand;
                        finalResult =  result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");

                }
                return finalResult;
        }
        //main() method
        public static void main(String args[])
        {
                Scanner numberScanner = new Scanner(System.in);
                System.out.println("Ubah angka menjadi huruf. Tolong masukan angka (max 100000000):");
                Long theNumber = Long.valueOf(numberScanner.nextLine());
                System.out.println(convertNumberToWord(theNumber));

//                Test Case Examples
//                System.out.println(convertNumberToWord(9));
//                System.out.println(convertNumberToWord(11));
//                System.out.println(convertNumberToWord(21123221));
//                System.out.println(convertNumberToWord(1101));
//                System.out.println(convertNumberToWord(19812));
//                System.out.println(convertNumberToWord(674319));
//                System.out.println(convertNumberToWord(909087531));
//                System.out.println(convertNumberToWord(159999999));
//                System.out.println(convertNumberToWord(1000000));
//                System.out.println(convertNumberToWord(3000200));
//                System.out.println(convertNumberToWord(700000));
//                System.out.println(convertNumberToWord(9000000));
        }
}