package br.com.local.navdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ToolbarWidgetWrapper;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    MaterialToolbar toolbar;
    DrawerLayout drawerLayout;

    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.idToolBar);
        drawerLayout = findViewById(R.id.idDrawerLayout);
        navigationView = findViewById(R.id.idNavigationView);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout,
                toolbar,
                R.string.opennav,
                R.string.closenav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.mImport:
                Toast.makeText(getApplicationContext(), "Cliquei no import",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.mGallery:
                Toast.makeText(getApplicationContext(), "Cliquei no gallery",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.mSlideShow:
                Toast.makeText(getApplicationContext(), "Cliquei no slideshow",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.mSend:
                Toast.makeText(getApplicationContext(), "Cliquei no send",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.mShare:
                Toast.makeText(getApplicationContext(), "Cliquei no share",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.mSettings:
                Toast.makeText(getApplicationContext(), "Cliquei no settings",
                        Toast.LENGTH_SHORT).show();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);


        return true;
    }
}