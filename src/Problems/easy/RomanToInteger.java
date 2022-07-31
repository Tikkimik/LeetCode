package Problems.easy;

public class RomanToInteger {
    public int romanToInt(String s) {
        char[] ch = String.valueOf(s).toCharArray();
        int current = 0;
        int previous = 0;
        int arabicSum = 0;

        for (char c : ch) {
            switch (c) {
                case 'I':
                    current = 1;
                    break;
                case 'V':
                    current = 5;
                    break;
                case 'X':
                    current = 10;
                    break;
                case 'L':
                    current = 50;
                    break;
                case 'C':
                    current = 100;
                    break;
                case 'D':
                    current = 500;
                    break;
                case 'M':
                    current = 1000;
                    break;
            }
            if(previous < current){
                arabicSum += current - (previous * 2);
            } else {
                arabicSum += current;
            }
            previous = current;
        }
        return arabicSum;
    }

    public static void main(String[] args) {
        RomanToInteger obj = new RomanToInteger();
        System.out.println(obj.romanToInt("IV"));
    }
}
