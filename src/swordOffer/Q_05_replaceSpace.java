package swordOffer;

public class Q_05_replaceSpace {
    public static String replaceSpace(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i ++){
            stringBuilder.append(s.charAt(i) == ' '? "%20":s.charAt(i));
        }
        return stringBuilder.toString();
    }
}
