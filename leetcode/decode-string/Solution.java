/**
 * @author jashgopani
 */
class Solution {
    public String decodeString(String s) {
        char[] c = s.toCharArray();
        StringBuilder num = new StringBuilder();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length();) {
            if (c[i] == '[') {
                int bCloseIndex = getClosingBracketIndex(c, i + 1);
                int count = num.toString().trim().length() > 0 ? Integer.parseInt(num.toString()) : 1;
                repeat(decodeString(s.substring(i + 1, bCloseIndex)), count, res);
                num = new StringBuilder();
                i = bCloseIndex + 1;
            } else {
                if (Character.isDigit(c[i])) {
                    num.append(c[i]);
                } else {
                    res.append(c[i]);
                }
                i++;
            }
        }
        return res.toString();
    }

    public int getClosingBracketIndex(char[] arr, int startIndex) {
        int open = 0;
        for (int i = startIndex; i < arr.length; i++) {
            if (arr[i] == ']' && open == 0)
                return i;
            else if (arr[i] == ']' && open > 0)
                open--;
            else if (arr[i] == '[')
                open++;
        }
        return -1;
    }

    public void repeat(String s, int i, StringBuilder sb) {
        while (i > 0) {
            sb.append(s);
            i--;
        }
    }
}