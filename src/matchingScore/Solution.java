package matchingScore;

class Solution {
    static int[] bScore;
    static int[] link;

    public static void main(String[] args){
        String word = "Hi";
        String[] pages = {"Hi, <body>Hi,Hi,Hi</body>"};
        solution(word, pages);
        System.out.println(bScore[0]);
    }

    public static int solution(String word, String[] pages) {
        int answer = 0;
        bScore = new int[pages.length];

        for (int i=0; i<pages.length; i++){
            bScore[i] = baseScore(word, pages[i]);
        }

        return answer;
    }

    private static void searchLink(String pages){
    }

    private static int baseScore(String word, String pages) {
        String[] tem_st = pages.split("body");
        int score = 0;
        for (int i=0; i<tem_st.length; i++){
            if (tem_st[1].contains(word)){
                score++;
            }
        }
        return score;
    }

}
