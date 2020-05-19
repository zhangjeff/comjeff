package thread.concurrent2020.animal;

public class Tortoise extends Animal {
    @Override
    public void running() {
        int dis = 2;
        length -= dis;
        System.out.println("乌龟跑了" + dis + "米，距离终点还有"+ length + "米");
        if(length <= 0) {
            length = 0;
            System.out.println("乌龟获得胜利！");
            if (calltoback != null){
                calltoback.win();
            }
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
