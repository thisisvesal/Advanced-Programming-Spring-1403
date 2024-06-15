public class Main {
    public static void main(String[] args) {
        Child c = new Child(400, 1200); // money=400, cost=1200

        new Thread() {
            @Override
            public void run() {
                c.buy();
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                c.addMoney(500);
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                c.addMoney(500);
            }
        }.start();



        try {
            System.out.println("Sleep: 50 ms");
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        c.newWish(2000);
        new Thread() {
            @Override
            public void run() {
                c.buy();
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                c.addMoney(200);
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                c.addMoney(5000);
            }
        }.start();


        System.out.println("Final money: " + c.getMoney());
    }
}
