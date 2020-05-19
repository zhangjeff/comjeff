package thread.concurrent2020.bank;

/**
 * 两个人AB通过一个账户A在柜台取钱和B在ATM机取钱！
 * 钱的数量要设置成一个静态的变量，两个人要取的同一个对象值。
 */
public class MainClass {

    public static void main(String[] args) {
        Bank bank = new Bank();
        PersonA personA = new PersonA(bank, "counter");
        PersonB personB = new PersonB(bank, "ATM");
        PersonB personc = new PersonB(bank, "ATM");
        personA.start();
        personB.start();
        personc.start();
    }
}
