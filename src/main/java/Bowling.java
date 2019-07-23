public class Bowling {

    public static final int FRAMES_NUMBER = 10;
    private final Frame[] frames;
    private Roll extraRoll;

    public Bowling(){
        this.frames = new Frame[FRAMES_NUMBER];
        for (int i = 0; i < FRAMES_NUMBER; i++) frames[i] = new Frame();
    }

    public Frame[] getFrames() {
        return this.frames;
    }

    /**
     * @return Total score
     * @throws Exception
     */
    public int score() throws Exception {
        int score = 0;
        for (int i = 0; i < FRAMES_NUMBER ; i++) score += this.frames[i].score();
        return score;
    }

    /**
     * @param frameIndex
     * @return The frame score
     * @throws Exception
     */
    public int score(int frameIndex) throws Exception {
        if (frameIndex == FRAMES_NUMBER - 1) return this.frames[frameIndex].score() + extraRoll.score();
        else return this.frames[frameIndex].score();
    }

    public Roll getExtraRoll() {
        if (this.extraRoll == null) this.extraRoll = new Roll();
        return this.extraRoll;
    }
}