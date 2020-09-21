public class Player {
    int balance;
    int lost_balance = 0;

    public Player(int balance){
        this.balance = balance;
    }

    public int placeBet(){
        int bet;
        if (balance<1) {
            return 0;
        }
        if (lost_balance != 0 && balance >= lost_balance*2){
            bet = lost_balance * 2;
        } else {
            bet = 1;
        }
        balance = balance - bet;
        return bet;
    }

    public void pickUpMoney(int won_balance){
        balance = balance + won_balance;
    }

    public int predict() {
        return (int) (Math.random() * 15);
    }
}
