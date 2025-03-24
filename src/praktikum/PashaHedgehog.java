package praktikum;

public class PashaHedgehog {

    public static void main(String[] args) {
        PashaHedgehog obj = new PashaHedgehog();

        long h = Long.MAX_VALUE;

        System.out.println(obj.howMuchDays(h));
    }

    public long howMuchDays(long h) {
        long day = 2;
        long night = -1;

        return h / (day + night) + night;
    }
}
