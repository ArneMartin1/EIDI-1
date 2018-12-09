public class StringUtil {

    public static void main(String[] args) {

        System.out.println("[TEST] toUpperCase");
        System.out.println(toUpperCase("abc--ED")); //erwartet: ABC--ED

        System.out.println("[TEST] toLowerCase");
        System.out.println(toLowerCase("abc--ed")); //erwartet: abc--ed

        System.out.println("[TEST] substring");
        System.out.println(substring("ABC", 1, 2)); //erwartet: "B"
        System.out.println(substring("ABC", 2, 1)); //erwartet: ""
        System.out.println(substring("ABC", -1, 42)); //erwartet: "ABC"
        System.out.println(substring("Klausur", 0, 10)); //erwartet: "Klausur"
        System.out.println(substring("Klausur", 2, 0)); //erwartet: ""
        System.out.println(substring("Klausur", -1, 5)); //erwartet: "Klaus"
        System.out.println(substring("Klausur", 0, 5)); //erwartet: "Klaús"

        System.out.println("[TEST] contains");
        System.out.println(contains("abc", "loremipsum")); //erwartet: -1
        System.out.println(contains("abc", "abcabc")); //erwartet: 0
        System.out.println(contains("abc", "cccabc")); //erwartet: 3
        System.out.println(contains("erben", "sterben")); //erwartet: 2
    }

    /**
     * Musterloesung zu Aufgabe 4.4
     *
     * @param in
     * @return in, all lower case letters are now upper case
     */
    public static String toUpperCase(String in){
        String out = "";

        for (int i = 0; i < in.length(); i++) {
            char c = in.charAt(i);

            if (c >= 'a' && c <= 'z') {
                c = (char) (c - 'a' + 'A');
            }

            out += c;
        }

        return out;
    }

    public static String toLowerCase(String in){
        
        //TODO: 3a)
         String out = "";

        for (int i = 0; i < in.length(); i++) {
            char c = in.charAt(i);

            if (c >= 'A' && c <= 'Z') {
                c = (char) (c - 'A' + 'a');
            }

            out += c;
        }

        return out;
    }

    public static String substring(String str, int start, int end) {
        
        //TODO: 3b)
        String out ="";
        if (start<0)
        {
            start=0;
            if(start<end)
            {
                for(int i= start; i<end && i<str.length(); i++)
                {
                char c = str.charAt(i);
                out += c;
                } 
                return out;
            }
            else
            {
                out="";
                return out;
            }
        }
        else if (start<end)
        {
            for (int i=start; i<end && i<str.length(); i++)
            {
            char c = str.charAt(i);
            out += c;
            }
            return out;
            }
        else 
        {
            out="";
            return out;
        }
    }

    public static int contains(String needle, String haystack) {

        //TODO 3c)
        int nadelLänge = needle.length();
        if (nadelLänge<=haystack.length())
        {
            for(int i=0; i<haystack.length();i++)
            {
                if((substring(haystack,i, (i+nadelLänge))).equals(needle))
                    {
                    return i;
                    }
            }
        }
        else
        {
            return -1;
        }
        return -1;
        
    }

}
