package interactionsatisfaction.communiface;

public class Lessons {
    /*public static final String HAPPY = "Happy";
    public static final String SAD = "Sad";
    public static final String ANGRY = "Angry";
    public static final String SURPRISE = "Surprise";
    public static final String FEAR = "Fear";
    public static final String DISGUST = "Disgust";
    public static final String NEUTRAL = "Neutral";*/

    private String lessonName;
    private int stage = 0;
    //private problems; ?

    public Lessons(String name) {
        lessonName = name;
    }

    public final void setLessonName(String name) {
        this.lessonName = name;
    }

    public final String getLessonName() {
        return lessonName;
    }

    public final void incStage(int stage) {
        if (this.stage == 2) this.stage += 1;
    }

    public final int getStage() {
        return stage;
    }

    public final void settingQuestions() {

    }
}
