class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length; //rows
        int n = box[0].length; //cols
        int stops;

        for(int i = 0; i < m; i++){
            stops = n-1;
            for(int j = n-1; j >= 0; j--){
                if(box[i][j] == '*') stops = j-1;
                if(box[i][j] == '#'){
                    box[i][j] = '.';
                    box[i][stops] = '#';
                    stops--;
                }
            }
        }

        char[][] resBox = new char[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                resBox[i][j] = box[m-j-1][i];
            }
        }

        return resBox;
    }
}