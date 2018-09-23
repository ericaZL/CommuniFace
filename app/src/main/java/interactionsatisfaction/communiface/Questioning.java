package interactionsatisfaction.communiface;
import java.util.*;


// methods: oddOneOut(), trueOrFalse(), multipleChoice(), imgMix()
public class Questioning {
    private String emoType;
    public static final int FOLDER_CAP = 10;

    static Random rnd = new Random();
    // Odd , T/F, MC, Img Mix

    public static int answer = -1;

    public Questioning(String type){
        this.emoType = type;
    }

    public static String randEmo() {
        // Randomly choosing folder
        int folderNum = rnd.nextInt(7);
        String folderName = "";
        switch (folderNum) {
            case 0:
                folderName = "Happy";
                break;
            case 1:
                folderName = "Sad";
                break;
            case 2:
                folderName = "Angry";
                break;
            case 3:
                folderName = "Surprise";
                break;
            case 4:
                folderName = "Fear";
                break;
            case 5:
                folderName = "Disgust";
                break;
            case 6:
                folderName = "Neutral";
                break;
        }
        return folderName;
    }

    // get random Img from folder
    public String randImg(String folderName) {
        String path = folderName + "/" + folderName + "00" + Integer.toString(rnd.nextInt(FOLDER_CAP)) + ".jpg";
        return path;
    }


    //Response from front-end
    public static boolean response(int response) {
        if (response == answer) {
            answer = -1;
            return true;
        } else {
            answer = -1;
            return false;
        }
    }

    //Odd-one-out
    // Text prompt, 4 image buttons
    public void oddOneOut(){
        String imgEmo = randEmo();
        oddOneOut(imgEmo);
    }
    public static void oddOneOut(String imgEmo){
        String wrong = randEmo();

        answer = rnd.nextInt(4);

        ArrayList<String> outputs = new ArrayList<String>();
        outputs.add(outputs.size(), wrong);
        outputs.add(outputs.size(), wrong);
        outputs.add(outputs.size(), wrong);
        outputs.add(answer, imgEmo);

        // output text
        //question("Which of these faces is not like the others?");
        // images on buttons: in outputs
    }

    //T/F
    // Text prompt, one image, 2 standard buttons
    public void trueOrFalse(){
        String questionEmo = randEmo();
        trueOrFalse(questionEmo);
    }

    public static void trueOrFalse(String questionEmo){
        String imgEmo = randEmo();

        if(questionEmo.equals(imgEmo)){
            answer = 1;
        }else{
            answer = 0;
        }

        // output text
        //question("Is this person " + randEmo() + "?");
        //output image: imgEmo
    }

    //MC
    // Text prompt, one image, 4 buttons
    public void multipleChoice(){
        String imgEmo = randEmo();
        multipleChoice(imgEmo);
    }
    public static void multipleChoice(String imgEmo){
        String wrong1, wrong2, wrong3;

        do{
            wrong1 = randEmo();
        }while(wrong1.equals(imgEmo));
        do{
            wrong2 = randEmo();
        }while(wrong2.equals(imgEmo) && wrong2.equals(wrong1));
        do{
            wrong3 = randEmo();
        }while(wrong3.equals(imgEmo)  && wrong3.equals(wrong1)  && wrong2.equals(wrong3));

        answer = rnd.nextInt(4);

        ArrayList<String> outputs = new ArrayList<String>();
        outputs.add(outputs.size(), wrong1);
        outputs.add(outputs.size(), wrong2);
        outputs.add(outputs.size(), wrong3);
        outputs.add(answer, imgEmo);

        // output text
        //question("What is this person feeling?");
        // output outputs
        //output image: imgEmo
    }


    //Img Mix
    // Text prompt, 4 image buttons
    public void imgMix() {
        String imgEmo = randEmo();
        imgMix(imgEmo);
    }
    public static void imgMix(String imgEmo){
        String wrong1, wrong2, wrong3;

        do{
            wrong1 = randEmo();
        }while(wrong1.equals(imgEmo));
        do{
            wrong2 = randEmo();
        }while(wrong2.equals(imgEmo) && wrong2.equals(wrong1));
        do{
            wrong3 = randEmo();
        }while(wrong3.equals(imgEmo) && wrong3.equals(wrong1) && wrong2.equals(wrong3));

        answer = rnd.nextInt(4);

        ArrayList<String> outputs = new ArrayList<String>();
        outputs.add(outputs.size(), wrong1);
        outputs.add(outputs.size(), wrong2);
        outputs.add(outputs.size(), wrong3);
        outputs.add(answer, imgEmo);
        // output text
        //question("Which of these people are feeling " + answerEmo + "?");
        // images on buttons: in outputs
    }

}
