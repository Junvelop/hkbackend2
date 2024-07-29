package hk.edu20240716.day13;

import java.util.List;

public class CardMain {

    public static void main(String[] args) {
        CardCase cardCase = new CardCase();
        List<Card> cards = cardCase.getCards(); // 52장의 카드 가져옴

        String[][] cardsArray = new String[6][10]; // 이차원 배열 선언 (6행 10열)

        int index = 0;
        int row = 0;
        int col = 0;

        for (Card card : cards) {
            cardsArray[row][col] = card.toString(); // 카드를 문자열로 변환하여 이차원 배열에 저장
            col++;

            // 10장씩 출력하고 다음 행으로 넘어가기
            if (col == 10) {
                row++;
                col = 0;
            }

            index++;

            // 모든 카드를 출력한 경우 종료
            if (index >= cards.size()) {
                break;
            }
        }
        
        String target = "♥";
        int[] columnCounts = new int[10]; // 각 열별로 특정 문자의 개수를 저장할 배열

        for (int i = 0; i < cardsArray.length; i++) {
            for (int j = 0; j < cardsArray[i].length; j++) {
                if (cardsArray[i][j] != null && cardsArray[i][j].contains(target)) {
                    columnCounts[i]++;
                }
            }
        }

        
        

        // 이차원 배열 출력
        for (int i = 0; i < cardsArray.length; i++) {
            for (int j = 0; j < cardsArray[i].length; j++) {
                System.out.print(cardsArray[i][j] + "\t");
            }
            System.out.println();
        }
        
        for (int j = 0; j < columnCounts.length; j++) {
            System.out.println("Column " + (j + 1) + " has " + columnCounts[j] + " cards with " + target);
        }
    }

}
