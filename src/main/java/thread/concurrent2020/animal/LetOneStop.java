package thread.concurrent2020.animal;

public class LetOneStop implements Calltoback {
    Animal an;

    public LetOneStop(Animal animal) {
        this.an = animal;
    }

    @Override
    public void win() {
        an.stop();
    }
}
