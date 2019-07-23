public class Bowling {

    public static final int FRAMES_NUMBER = 10;
    private final Frame[] frames;

    public Bowling(){
        this.frames = new Frame[FRAMES_NUMBER];
        for (int i = 0; i < FRAMES_NUMBER; i++) frames[i] = new Frame();
    }

    public Frame[] getFrames() {
        return this.frames;
    }

    public int score() throws Exception {
        int score = 0;
        for (Frame frame : this.frames) score += frame.score();
        return score;
    }
}