package string;

public class string_520_detect_capital {
    public static boolean detectCapitalUse(String word) {
        int beforeUpper = 0;
        for (int i =0; i < word.length(); i ++){
            if (i == 0){
                if (isUpper(word.charAt(i))){
                    beforeUpper++;
                }
                continue;
            }
            if (beforeUpper== i){
                if (isUpper(word.charAt(i))){
                    beforeUpper++;
                }else{
                    if (beforeUpper == 1){
                        continue;
                    }
                    return false;
                }
            }else {
                if (isUpper(word.charAt(i))){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isUpper(char t){
        return t >= 'A' && t <= 'Z';
    }

    public static void main(String[] args) {
        System.out.println(detectCapitalUse("USA"));
        System.out.println(detectCapitalUse("Flag"));
        System.out.println(detectCapitalUse("FlaG"));
    }

    /**
     * 解题思路：无，
 soeasy    */
}
