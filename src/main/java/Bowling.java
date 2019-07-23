public class Bowling {

    public static final int FRAMES_NUMBER = 10;
    private final Frame[] frames;

    public Bowling(){
        this.frames = new Frame[FRAMES_NUMBER];
        for (int i = 0; i < FRAMES_NUMBER; i++) frames[i] = new Frame();
    }

    public Frame[] getFrames() {
        return frames;
    }
}