package interactionsatisfaction.communiface;

public class Lessons {

    private String lessonName;

    public Lessons(String name) {
        lessonName = name;
    }

    public void nextButton() {
        Questioning question = new Questioning(this.lessonName);
        question.oddOneOut();
    }

    public String trainingPic() {
        Questioning question = new Questioning(this.lessonName);
        String imgPath = question.randImg(this.lessonName);
        return imgPath;
    }
}
