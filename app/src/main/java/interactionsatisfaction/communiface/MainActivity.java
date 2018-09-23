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

import interactionsatisfaction.communiface.R;

import interactionsatisfaction.communiface.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private String emotions = "";
    private int slideimage = 0;

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
        } else if (id == R.id.nav_happy) {
            Lessons lesson = new Lessons("Happy");
            ContentClose();
            ContentSlideOpen();
            emotions = "Happy";
            slideimage = 0;
            ((ImageView) findViewById(R.id.slide_image)).setImageResource(SlideImages("N"));
        } else if (id == R.id.nav_sad) {
            Lessons lesson = new Lessons("Sad");
            ContentClose();
            ContentSlideOpen();
            emotions = "Sad";
            slideimage = 0;
            ((ImageView) findViewById(R.id.slide_image)).setImageResource(SlideImages("N"));
        } else if (id == R.id.nav_angry) {
            Lessons lesson = new Lessons("Angry");
            ContentClose();
            ContentSlideOpen();
            emotions = "Angry";
            slideimage = 0;
            ((ImageView) findViewById(R.id.slide_image)).setImageResource(SlideImages("N"));
        } else if (id == R.id.nav_surprise) {
            Lessons lesson = new Lessons("Surprise");
            ContentClose();
            ContentSlideOpen();
            emotions = "Surprise";
            slideimage = 0;
            ((ImageView) findViewById(R.id.slide_image)).setImageResource(SlideImages("N"));
        } else if (id == R.id.nav_fear) {
            Lessons lesson = new Lessons("Fear");
            ContentClose();
            ContentSlideOpen();
            emotions = "Fear";
            slideimage = 0;
            ((ImageView) findViewById(R.id.slide_image)).setImageResource(SlideImages("N"));
        } else if (id == R.id.nav_disgust) {
            Lessons lesson = new Lessons("Disgust");
            ContentClose();
            ContentSlideOpen();
            emotions = "Disgust";
            slideimage = 0;
            ((ImageView) findViewById(R.id.slide_image)).setImageResource(SlideImages("N"));
        } else if (id == R.id.nav_neutral) {
            Lessons lesson = new Lessons("Neutral");
            ContentClose();
            ContentSlideOpen();
            emotions = "Neutral";
            slideimage = 0;
        } else if (id == R.id.nav_all) {
            //Lessons lesson = new Lessons("All");
            ContentClose();
            emotions = "All";
            //*************Skip Slide Stuff*************************
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void OnClickSlide(View view){
        int id = view.getId();
        if (id == R.id.slide_btnl) {
            if(SlideImages("L") != -1) {
            ((ImageView) findViewById(R.id.slide_image)).setImageResource(SlideImages("L"));
            }
        } else if (id == R.id.slide_btnr) {
            if(SlideImages("R") != -1) {
                ((ImageView) findViewById(R.id.slide_image)).setImageResource(SlideImages("R"));
            }
        } else if (id == R.id.slide_continue) {
            ContentClose();
            //get question type
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
        System.out.println("ShitFuck" + getApplicationContext().getResources().getIdentifier(mDrawableName.toLowerCase() , "drawable", getApplicationContext().getPackageName()) + " " + mDrawableName);
        return (getResources().getIdentifier(mDrawableName.toLowerCase() , "drawable", getPackageName()));
    }

    private void ContentClose(){
        ContentMainClose();
        ContentSlideClose();
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
    }

    private void ContentSlideOpen(){
        findViewById(R.id.slide_btnl).setVisibility(View.VISIBLE);
        findViewById(R.id.slide_btnr).setVisibility(View.VISIBLE);
        findViewById(R.id.slide_image).setVisibility(View.VISIBLE);
        findViewById(R.id.slide_continue).setVisibility(View.VISIBLE);
    }
}
