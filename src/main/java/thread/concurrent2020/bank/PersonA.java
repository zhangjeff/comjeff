package thread.concurrent2020.bank;

public class PersonA extends Thread {
    Bank bank;

    String mode;

    public PersonA(Bank bank,String mode){
        this.bank = bank;
        this.mode = mode;
    }

    @Override
    public void run() {
        while (Bank.money >= 100) {
            try {
                bank.outMoney(100, mode);
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            try {
                sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
