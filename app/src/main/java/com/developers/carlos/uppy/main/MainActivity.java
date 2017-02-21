package com.developers.carlos.uppy.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.developers.carlos.uppy.AcercaDeActivity;
import com.developers.carlos.uppy.ContactoActivity;
import com.developers.carlos.uppy.mascota_favoritos.FavoritosActivity;
import com.developers.carlos.uppy.R;
import com.developers.carlos.uppy.mascotas.MascotaFragment;
import com.developers.carlos.uppy.mascota_perfil.MascotaPerfilFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IMainView, View.OnClickListener{

    private TabLayout tabLayout;
    private ViewPager mViewPager;
    private FloatingActionButton fab;
    private IMainPresenter mainPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        fab  = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);

        mainPresenter = new MainPresenterImp(this);

        setupViewPager();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_favorito:  launchActivity(new Intent(this,FavoritosActivity.class));
                                        break;

            case R.id.action_contacto:  launchActivity(new Intent(this,ContactoActivity.class));
                                        break;

            case R.id.action_acercaDe:  launchActivity(new Intent(this,AcercaDeActivity.class));
                                        break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setupViewPager() {
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new MascotaFragment());
        adapter.addFragment(new MascotaPerfilFragment());
        mViewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(mViewPager);

        setIconoTabLayout(0, R.drawable.home_48);
        setIconoTabLayout(1, R.drawable.mascota_48);
    }

    @Override
    public void setIconoTabLayout(int tab, int icon) {
        tabLayout.getTabAt(tab).setIcon(icon);
    }

    @Override
    public void mostrarToast(String msj) {
        Toast.makeText(this,msj,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void mostrarSnack(String msj,View v) {
        Snackbar.make(v, msj, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    @Override
    public void launchActivity(Intent intent) {
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        if(R.id.fab == v.getId()){
            mainPresenter.onClickSubirFoto(v);
        }
    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        public void addFragment(Fragment fragment) {
            mFragments.add(fragment);
        }

    }

}
