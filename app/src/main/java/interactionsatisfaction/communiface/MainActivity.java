package interactionsatisfaction.communiface;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.provider.MediaStore;
import android.view.View;
import java.io.*;

import interactionsatisfaction.communiface.R;

import interactionsatisfaction.communiface.R;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private String emotions = "";
    private int slideimage = 0;
    private Questioning q = new Questioning();
    private String emotionquestion;
    private Random rnd = new Random();
    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ContentClose();
        ContentMainOpen();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_menu) {
            ContentClose();
            ContentMainOpen();
        } else if (id == R.id.nav_pic) {
            ContentClose();
            ContentPicOpen();
        } else if (id == R.id.nav_happy) {
            Lessons lesson = new Lessons("Happy");
            ContentClose();
            ContentSlideOpen();
            emotions = "Happy";
            slideimage = 0;
            ((TextView)findViewById(R.id.slide_emotion)).setText("These people are Happy");
            ((ImageView) findViewById(R.id.slide_image)).setImageResource(SlideImages("N"));
        } else if (id == R.id.nav_sad) {
            Lessons lesson = new Lessons("Sad");
            ContentClose();
            ContentSlideOpen();
            emotions = "Sad";
            slideimage = 0;
            ((TextView)findViewById(R.id.slide_emotion)).setText("These people are Sad");
            ((ImageView) findViewById(R.id.slide_image)).setImageResource(SlideImages("N"));
        } else if (id == R.id.nav_angry) {
            Lessons lesson = new Lessons("Angry");
            ContentClose();
            ContentSlideOpen();
            emotions = "Angry";
            slideimage = 0;
            ((TextView)findViewById(R.id.slide_emotion)).setText("These people are Angry");
            ((ImageView) findViewById(R.id.slide_image)).setImageResource(SlideImages("N"));
        } else if (id == R.id.nav_surprise) {
            Lessons lesson = new Lessons("Surprise");
            ContentClose();
            ContentSlideOpen();
            emotions = "Surprise";
            slideimage = 0;
            ((TextView)findViewById(R.id.slide_emotion)).setText("These people are Surprised");
            ((ImageView) findViewById(R.id.slide_image)).setImageResource(SlideImages("N"));
        } else if (id == R.id.nav_fear) {
            Lessons lesson = new Lessons("Fear");
            ContentClose();
            ContentSlideOpen();
            emotions = "Fear";
            slideimage = 0;
            ((TextView)findViewById(R.id.slide_emotion)).setText("These people are Afraid");
            ((ImageView) findViewById(R.id.slide_image)).setImageResource(SlideImages("N"));
        } else if (id == R.id.nav_disgust) {
            Lessons lesson = new Lessons("Disgust");
            ContentClose();
            ContentSlideOpen();
            emotions = "Disgust";
            slideimage = 0;
            ((TextView)findViewById(R.id.slide_emotion)).setText("These people are Disgusted");
            ((ImageView) findViewById(R.id.slide_image)).setImageResource(SlideImages("N"));
        } else if (id == R.id.nav_neutral) {
            Lessons lesson = new Lessons("Neutral");
            ContentClose();
            ContentSlideOpen();
            emotions = "Neutral";
            slideimage = 0;
            ((TextView)findViewById(R.id.slide_emotion)).setText("These people are Neutral");
            ((ImageView) findViewById(R.id.slide_image)).setImageResource(SlideImages("N"));
        } else if (id == R.id.nav_all) {
            ContentClose();
            emotions = "All";
            GetQuestions();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void OnClickSlide(View view){
        int id = view.getId();
        if (id == R.id.slide_btnl) {
            if(slideimage != 0) {
                ((ImageView) findViewById(R.id.slide_image)).setImageResource(SlideImages("L"));
            }
        } else if (id == R.id.slide_btnr) {
            if(slideimage != 9) {
                ((ImageView) findViewById(R.id.slide_image)).setImageResource(SlideImages("R"));
            }
        } else if (id == R.id.slide_continue) {
            ContentClose();
            GetQuestions();
        }
    }

    public void OnClickTF(View view){
        int id = view.getId();
        boolean response = false;

        if (id == R.id.tf_true) {
            ContentClose();
            ContentTFOpen2();
            response = q.response(1);
        }else if (id == R.id.tf_false) {
            ContentClose();
            ContentTFOpen2();
            response = q.response(0);
        }else if (id == R.id.tf_continue) {
            ContentClose();
            GetQuestions();
            return;
        }
        if(response == true){
            ((TextView)findViewById(R.id.tf_title)).setText("Correct");
            ((TextView)findViewById(R.id.tf_emotion)).setText("This person was " + emotionquestion);
        }
        else {
            ((TextView)findViewById(R.id.tf_title)).setText("Good Try!");
            ((TextView)findViewById(R.id.tf_emotion)).setText("This person was " + emotionquestion);
        }
    }

    public void OnClickOdd(View view){
        int id = view.getId();
        boolean response = false;

        if (id == R.id.odd_image1) {
            ContentClose();
            ContentOddOpen2();
            response = q.response(0);
        } else if (id == R.id.odd_image2) {
            ContentClose();
            ContentOddOpen2();
            response = q.response(1);
        } else if (id == R.id.odd_image3) {
            ContentClose();
            ContentOddOpen2();
            response = q.response(2);
        } else if (id == R.id.odd_image4) {
            ContentClose();
            ContentOddOpen2();
            response = q.response(3);
        } else if (id == R.id.odd_continue) {
            ContentClose();
            GetQuestions();
            return;
        }
        if(response == true){
            ((TextView)findViewById(R.id.odd_title)).setText("Correct");
            ((TextView)findViewById(R.id.odd_emotion)).setText("The odd expression was " + emotionquestion);
        }
        else {
            ((TextView)findViewById(R.id.odd_title)).setText("Good Try!");
            ((TextView)findViewById(R.id.odd_emotion)).setText("The odd expression was " + emotionquestion);
        }
    }

    public void OnClickPic(View view) {
        int id = view.getId();

        if (id == R.id.pic_continue) {
            int REQUEST_PERMISSION= 100;
            int cameraPermission = this.checkSelfPermission(android.Manifest.permission.CAMERA);
            if (android.os.Build.VERSION.SDK_INT >= 23) {
                if (cameraPermission != android.content.pm.PackageManager.PERMISSION_GRANTED  ) {

                    this.requestPermissions(
                            new String[]{android.Manifest.permission.CAMERA },
                            REQUEST_PERMISSION
                    );
                }
            }
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }
            //startActivity(takePictureIntent);
        }
    }

    public void ReturnPic (boolean correct){
        if(correct == true){
            ((TextView)findViewById(R.id.pic_emotion)).setText("Correct");
        }
        else{
            ((TextView)findViewById(R.id.pic_emotion)).setText("Good Try!");
        }
    }

    private int SlideImages(String direction){
        if(direction == "L") {
            if(slideimage != 0) {
                slideimage--;
            } else{
                return -1;
            }
        }
        else if(direction == "R"){
            if(slideimage != 9) {
                slideimage++;
            } else{
                return -1;
            }
        }
        String mDrawableName = emotions + "00" + slideimage;
        return (getResources().getIdentifier(mDrawableName.toLowerCase() , "drawable", getPackageName()));
    }

    private void GetQuestions(){
        int answer = rnd.nextInt(2);
        if(answer == 1 && emotions == "All"){
            ContentOddOpen1();
            if(emotions != "All") {
                q.oddOneOut(emotions.toLowerCase());
            }
            else{
                q.oddOneOut();
            }
            ((TextView)findViewById(R.id.odd_title)).setText("Which is not like the others?");
            ((TextView)findViewById(R.id.odd_emotion)).setText("");
            emotionquestion = q.getEmoWord().substring(0, q.getEmoWord().length() - 3);
            ArrayList<String> al = new ArrayList<String>(Questioning.getArray());
            ((ImageView)findViewById(R.id.odd_image1)).setImageResource(getResources().getIdentifier(al.get(0).toLowerCase() , "drawable", getPackageName()));
            ((ImageView)findViewById(R.id.odd_image2)).setImageResource(getResources().getIdentifier(al.get(1).toLowerCase() , "drawable", getPackageName()));
            ((ImageView)findViewById(R.id.odd_image3)).setImageResource(getResources().getIdentifier(al.get(2).toLowerCase() , "drawable", getPackageName()));
            ((ImageView)findViewById(R.id.odd_image4)).setImageResource(getResources().getIdentifier(al.get(3).toLowerCase() , "drawable", getPackageName()));
        }
        else {
            ContentTFOpen1();
            if(emotions != "All") {
                q.trueOrFalse(emotions.toLowerCase());
            }
            else{
                q.trueOrFalse();
            }
            ((TextView)findViewById(R.id.tf_title)).setText("Is this person...");
            ((TextView)findViewById(R.id.tf_emotion)).setText(q.getEmoWord() + "?");
            emotionquestion = q.getImgPath().substring(0, q.getImgPath().length() - 3);
            ((ImageView)findViewById(R.id.tf_image)).setImageResource(getResources().getIdentifier(q.getImgPath().toLowerCase() , "drawable", getPackageName()));
        }
    }

    private void ContentClose(){
        ContentMainClose();
        ContentSlideClose();
        ContentTFClose();
        ContentOddClose();
        ContentPicClose();
    }

    private void ContentMainClose(){
        findViewById(R.id.main_title).setVisibility(View.GONE);
        findViewById(R.id.main_options).setVisibility(View.GONE);
        findViewById(R.id.main_divider1).setVisibility(View.GONE);
        findViewById(R.id.main_divider2).setVisibility(View.GONE);
    }

    private void ContentMainOpen(){
        findViewById(R.id.main_title).setVisibility(View.VISIBLE);
        findViewById(R.id.main_options).setVisibility(View.VISIBLE);
        findViewById(R.id.main_divider1).setVisibility(View.VISIBLE);
        findViewById(R.id.main_divider2).setVisibility(View.VISIBLE);
    }

    private void ContentSlideClose(){
        findViewById(R.id.slide_btnl).setVisibility(View.GONE);
        findViewById(R.id.slide_btnr).setVisibility(View.GONE);
        findViewById(R.id.slide_image).setVisibility(View.GONE);
        findViewById(R.id.slide_continue).setVisibility(View.GONE);
        findViewById(R.id.slide_emotion).setVisibility(View.GONE);
    }

    private void ContentSlideOpen(){
        findViewById(R.id.slide_btnl).setVisibility(View.VISIBLE);
        findViewById(R.id.slide_btnr).setVisibility(View.VISIBLE);
        findViewById(R.id.slide_image).setVisibility(View.VISIBLE);
        findViewById(R.id.slide_continue).setVisibility(View.VISIBLE);
        findViewById(R.id.slide_emotion).setVisibility(View.VISIBLE);
    }

    private void ContentTFClose(){
        findViewById(R.id.tf_continue).setVisibility(View.GONE);
        findViewById(R.id.tf_emotion).setVisibility(View.GONE);
        findViewById(R.id.tf_false).setVisibility(View.GONE);
        findViewById(R.id.tf_true).setVisibility(View.GONE);
        findViewById(R.id.tf_image).setVisibility(View.GONE);
        findViewById(R.id.tf_title).setVisibility(View.GONE);
    }

    private void ContentTFOpen1(){
        findViewById(R.id.tf_emotion).setVisibility(View.VISIBLE);
        findViewById(R.id.tf_false).setVisibility(View.VISIBLE);
        findViewById(R.id.tf_true).setVisibility(View.VISIBLE);
        findViewById(R.id.tf_image).setVisibility(View.VISIBLE);
        findViewById(R.id.tf_title).setVisibility(View.VISIBLE);
    }

    private void ContentTFOpen2(){
        findViewById(R.id.tf_continue).setVisibility(View.VISIBLE);
        findViewById(R.id.tf_emotion).setVisibility(View.VISIBLE);
        findViewById(R.id.tf_image).setVisibility(View.VISIBLE);
        findViewById(R.id.tf_title).setVisibility(View.VISIBLE);
    }

    private void ContentOddClose(){
        findViewById(R.id.odd_continue).setVisibility(View.GONE);
        findViewById(R.id.odd_emotion).setVisibility(View.GONE);
        findViewById(R.id.odd_image1).setVisibility(View.GONE);
        findViewById(R.id.odd_image2).setVisibility(View.GONE);
        findViewById(R.id.odd_image3).setVisibility(View.GONE);
        findViewById(R.id.odd_image4).setVisibility(View.GONE);
        findViewById(R.id.odd_title).setVisibility(View.GONE);
    }

    private void ContentOddOpen1(){
        findViewById(R.id.odd_emotion).setVisibility(View.VISIBLE);
        findViewById(R.id.odd_image1).setVisibility(View.VISIBLE);
        findViewById(R.id.odd_image2).setVisibility(View.VISIBLE);
        findViewById(R.id.odd_image3).setVisibility(View.VISIBLE);
        findViewById(R.id.odd_image4).setVisibility(View.VISIBLE);
        findViewById(R.id.odd_title).setVisibility(View.VISIBLE);
    }

    private void ContentOddOpen2(){
        findViewById(R.id.odd_continue).setVisibility(View.VISIBLE);
        findViewById(R.id.odd_emotion).setVisibility(View.VISIBLE);
        findViewById(R.id.odd_image1).setVisibility(View.VISIBLE);
        findViewById(R.id.odd_image2).setVisibility(View.VISIBLE);
        findViewById(R.id.odd_image3).setVisibility(View.VISIBLE);
        findViewById(R.id.odd_image4).setVisibility(View.VISIBLE);
        findViewById(R.id.odd_title).setVisibility(View.VISIBLE);
    }

    private void ContentPicClose(){
        findViewById(R.id.pic_continue).setVisibility(View.GONE);
        findViewById(R.id.pic_emotion).setVisibility(View.GONE);
        findViewById(R.id.pic_title).setVisibility(View.GONE);
    }

    private void ContentPicOpen(){
        findViewById(R.id.pic_continue).setVisibility(View.VISIBLE);
        findViewById(R.id.pic_emotion).setVisibility(View.VISIBLE);
        findViewById(R.id.pic_title).setVisibility(View.VISIBLE);
    }
}
