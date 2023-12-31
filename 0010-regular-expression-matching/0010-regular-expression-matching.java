import java.util.regex.*;
class Solution {
    public boolean isMatch(String s, String p) {
        return s.matches(p.replaceAll("\\Q***\\E","*\\\\**"));
    }
}