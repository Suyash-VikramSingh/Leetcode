class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder str = new StringBuilder("");
        while(columnNumber != 0){
            columnNumber--;
            str.insert(0, (char)((columnNumber % 26) + 'A'));
            columnNumber /= 26;
        }

        return str.toString();
    }
}