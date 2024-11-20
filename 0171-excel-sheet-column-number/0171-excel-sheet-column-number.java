class Solution {
    public int titleToNumber(String columnTitle) {
        int n = columnTitle.length();
        int columnNum = 0, mul = 1;
        
        for(int i = n-1; i >= 0; i--){
            columnNum += mul * (columnTitle.charAt(i) - 'A' + 1);
            mul *= 26;
        }
        return columnNum;
    }
}