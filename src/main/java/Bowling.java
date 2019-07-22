public class Bowling {

    public static final int FRAMES_NUMBER = 10;
    private final Frame[] frames;

    public Bowling(){
        this.frames = new Frame[FRAMES_NUMBER];
        for (int i = 0; i < 10; i++) frames[i] = new Frame();
    }

    public Frame[] getFrames() {
        return frames;
    }
}
