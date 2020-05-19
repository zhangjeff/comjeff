package thread.concurrent2020.animal;

public class Rabbit extends Animal{

    @Override
    public void running() {
        int dis = 5;
        length -= dis;
        System.out.println("兔子跑了" + dis + "米，距离终点还有"+ length + "米");
        if(length <= 0) {
            length = 0;
            System.out.println("兔子获得胜利！");
            if (calltoback != null){
                calltoback.win();
            }
        }
        try {
            if ((200 - length) % 20 == 0) {
                Thread.sleep(1000);
            } else {
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
