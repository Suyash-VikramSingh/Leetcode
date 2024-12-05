class Solution {
    public boolean canChange(String start, String target) {
        int n = start.length();

        int i = 0, j = 0;

        while(i < n || j < n){
            while(i < n && start.charAt(i) == '_') i++;
            while(j < n && target.charAt(j) == '_') j++;

            if(i == n || j == n) break;

            char s = start.charAt(i);
            char t = target.charAt(j);

            if(s != t) return false;

            if(s == 'L' && i < j)
                return false;
            else if(s == 'R' && i > j)
                return false;

            i++;
            j++;
        }

        if(i == n && j == n) return true;

        return false;
    }
}