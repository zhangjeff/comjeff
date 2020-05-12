package thread.concurrent2020;

public class Client {

    public static void main(String[] args) {
        TicketWindow ticketWindow1 = new TicketWindow("窗口一");
        ticketWindow1.start();

        TicketWindow ticketWindow2 = new TicketWindow("窗口二");
        ticketWindow2.start();

        TicketWindow ticketWindow3 = new TicketWindow("窗口三");
        ticketWindow3.start();
    }
}
