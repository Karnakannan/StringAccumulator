import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StringCalculator {
    public static int add(String s) {
        int inpNum = 0, tempNum;
        List<String> negativeDigits = new ArrayList<String>();
        if (s.equalsIgnoreCase("") || s.equalsIgnoreCase(null)) {
            return 0;
        } else if (s.contains(",") || s.contains(";") || s.contains("*") || s.contains("%") || s.contains("|") || s.contains("\n")) {
            if (s.startsWith("//"))
                s = s.replace("//", "");

            StringTokenizer strToken = new StringTokenizer(s, ",\n;*%|");
            while (strToken.hasMoreTokens()) {
                tempNum = Integer.parseInt(strToken.nextToken());
                if (tempNum < 0)
                    negativeDigits.add(Integer.toString(tempNum));
                else {
                    if (tempNum > 1000)
                        inpNum += 0;
                    else
                        inpNum += tempNum;
                }
            }
            if (!(negativeDigits.isEmpty())) {
                throw new RuntimeException("negatives not allowed - " + negativeDigits);
            }
        } else {
            inpNum = Integer.parseInt(s);
        }
        return inpNum;
    }
}
