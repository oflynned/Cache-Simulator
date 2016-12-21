/**
 * Created by ed on 21/12/2016.
 */
class Tag {
    private int v;
    private long time;

    Tag() {
        this.v = -1;
        this.time = 0;
    }

    void setV(int v) {
        this.v = v;
    }

    void setTime(long time) {
        this.time = time;
    }

    int getV() {
        return v;
    }

    long getTime() {
        return time;
    }
}