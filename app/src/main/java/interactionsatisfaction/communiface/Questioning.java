package interactionsatisfaction.communiface;
import java.util.*;


// methods: oddOneOut(), trueOrFalse(), multipleChoice(), imgMix()
public class Questioning {
    private String emoType;

    // Items for frontend
    private static int questionType = -1; // 0 = TF, 1 = Odd-one-out, 2 = ImgMix, 3 = MC
    private static String emoWord = "";
    private static String imgPath = "";
    private static String wrongPath1 = "";
    private static String wrongPath2 = "";
    private static String wrongPath3 = "";

    public static final int FOLDER_CAP = 10;

    static Random rnd = new Random();
    // Odd , T/F, MC, Img Mix

    public static int answer = -1;

    public Questioning(String type){
        this.emoType = type;
    }

    public static int getQuestionType(){
        return questionType;
    }
    public static String getEmoWord(){
        return emoWord;
    }
    public static String getImgPath(){
        return imgPath;
    }
    public static String getWrongPath1(){
        return wrongPath1;
    }
    public static String getWrongPath2(){
        return wrongPath2;
    }
    public static String getWrongPath3(){
        return wrongPath3;
    }

    public static String randEmo() {
        // Randomly choosing folder
        int folderNum = rnd.nextInt(7);
        String folderName = "";
        switch (folderNum) {
            case 0:
                folderName = "happy";
                break;
            case 1:
                folderName = "sad";
                break;
            case 2:
                folderName = "angry";
                break;
            case 3:
                folderName = "surprise";
                break;
            case 4:
                folderName = "fear";
                break;
            case 5:
                folderName = "disgust";
                break;
            case 6:
                folderName = "neutral";
                break;
        }
        return folderName;
    }

    // get random Img from folder
    public static String randImg(String folderName) {
        String path = folderName + "00" + Integer.toString(rnd.nextInt(FOLDER_CAP)) + ".jpg";
        return path;
    }


    //Response from front-end
    public static boolean response(int response) {
        questionType = -1;
        emoWord = "";
        imgPath = "";
        wrongPath1 = "";
        wrongPath2 = "";
        wrongPath3 = "";
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
        questionType = 1;
        imgPath = randImg(imgEmo);
        wrongPath1 = randImg(wrong);
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

        questionType = 0;
        emoWord = questionEmo;
        imgPath = randImg(imgEmo);
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

        questionType = 3;
        imgPath = randImg(imgEmo);
        wrongPath1 = wrong1;
        wrongPath2 = wrong2;
        wrongPath3 = wrong3;
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

        questionType = 2;
        emoWord = imgEmo;
        imgPath = randImg(imgEmo);
        wrongPath1 = randImg(wrong1);
        wrongPath2 = randImg(wrong2);
        wrongPath3 = randImg(wrong3);
    }

}
