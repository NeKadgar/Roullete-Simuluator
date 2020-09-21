public class RoulleteGame {
    Player player1 = new Player(1000);

    private int spinRoullete() {
        return (int) (Math.random() * 15);
    }

    public void testRandom() {
        int i = 0;
        int counter2 = 0;
        int counter1 = 0;
        while (i<1000000000) {
            int x = (int) (Math.random() * 14) +1;
            if (x%2==0) counter2++;
            else counter1++;
            i++;
        }
        System.out.println("Четные: " + counter2);
        System.out.println("НЕЧетные: " + counter1);
    }

    public void startGame() {
        int iterations = 0;
        while (true) {
            int random_int = spinRoullete();
            int bet = player1.placeBet();
            int player_predict = player1.predict();
            if (bet == 0) {
                break;
            }
            if (random_int == 0) {
                if (player_predict == 0) player1.pickUpMoney(bet * 14);
            } else if (random_int % 2 == player_predict % 2) {
                player1.pickUpMoney(bet * 2);
            }
            iterations++;
            System.out.println(player1.balance);
            System.out.println("Иттерация №" + iterations);
        }
    }
}
