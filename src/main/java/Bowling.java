public class Bowling {

    public static final int FRAMES_NUMBER = 10;
    private final Frame[] frames;
    private Roll extraRoll;

    public Bowling() {
        this.frames = new Frame[FRAMES_NUMBER];
        for (int i = 0; i < FRAMES_NUMBER; i++) frames[i] = new Frame();
    }

    public Frame[] getFrames() {
        return this.frames;
    }

    public int score() throws Exception {
        int score = 0;
        for (int i = 0; i < FRAMES_NUMBER; i++) score += getFrameScore(i);
        return score;
    }

    public int getFrameScore(int frameIndex) throws Exception {
        if (frameIndex == FRAMES_NUMBER - 1) {
            return this.frames[frameIndex].score() + getExtraRoll().score();
        } else {
            return this.frames[frameIndex].score();
        }
    }

    public Roll getExtraRoll() {
        if (this.extraRoll == null) this.extraRoll = new Roll();
        return this.extraRoll;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n       -------- BOWLING --------     ").append("\n");
        for (int i = 0; i < FRAMES_NUMBER; i++) {
            try {
                Roll[] rolls = getFrames()[i].getRolls();
                sb.append("Frame: ").append(i).append(" Score: ").append(getFrameScore(i))
                        .append("   roll_0: ").append(rolls[0].getPinsDropped()).append("   roll_1: ").append(rolls[1].getPinsDropped());
                if (i == FRAMES_NUMBER - 1 && getExtraRoll() != null) sb.append("   roll_extra: ").append(getExtraRoll().getPinsDropped());
                sb.append("\n");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            sb.append("          Your score: ").append(score()).append("!!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}