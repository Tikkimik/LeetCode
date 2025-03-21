package Problems.easy;

/**
 * 28. Find the Index of the First Occurrence in a String
 */
public class FindTheIndexOfTheFirstOccurrenceInAString {

    public static void main(String[] args) {
        FindTheIndexOfTheFirstOccurrenceInAString obj = new FindTheIndexOfTheFirstOccurrenceInAString();

        var haystack = "sadbutsad";
        var needle = "er";

        System.out.println(obj.strStr(haystack, needle));
    }

    public int strStr(String haystack, String needle) {

        return haystack.indexOf(needle);
    }
}
