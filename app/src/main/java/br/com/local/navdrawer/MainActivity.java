package br.com.local.navdrawer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ToolbarWidgetWrapper;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    MaterialToolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.idToolBar);
        drawerLayout = findViewById(R.id.idDrawerLayout);
        navigationView = findViewById(R.id.idNavigationView);

        //Clique no menu para abrir e fechar o NavigationView
        toggle = new ActionBarDrawerToggle(
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

        Fragment fragment = null;
        Class fragmentClass;

        switch (item.getItemId()) {
            case R.id.mImport:
                fragmentClass = ImportFragment.class;
                break;
            case R.id.mGallery:
                fragmentClass = GalleryFragment.class;
                break;
            case R.id.mSlideShow:
                fragmentClass = SlideShowFragment.class;
                break;
            case R.id.mSend:
                fragmentClass = SendFragment.class;
                break;
            case R.id.mShare:
                fragmentClass = ShareFragment.class;
                break;
            case R.id.mSettings:
                fragmentClass = SettingsFragment.class;
                break;
            default:
                fragmentClass = ImportFragment.class;
        }
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.idContainerNav, fragment).commit();

        drawerLayout.closeDrawer(GravityCompat.START);


        return true;
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);

        toggle.syncState();

    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        toggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);

    }
}