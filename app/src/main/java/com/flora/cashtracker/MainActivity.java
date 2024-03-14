package com.flora.cashtracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class MainActivity extends AppCompatActivity {

    private MeowBottomNavigation bottomNavigation;

    private  final static int home=1;
    private  final static int search=2;
    private  final static int add=3;
    private  final static int analysis=4;
    private  final static int category=5;




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigation=findViewById(R.id.bottomNavigation);

        bottomNavigation.add(new MeowBottomNavigation.Model(home,R.drawable.home_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(search,R.drawable.search_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(add,R.drawable.add));
        bottomNavigation.add(new MeowBottomNavigation.Model(analysis,R.drawable.analytics_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(category,R.drawable.category_24));

        //get current selected Framgment////////////////////////////////////////////////////////////

        bottomNavigation.show(home,true);

        //add methods/////////////////////////////////////////////////////////////////////////////
        bottomNavigation.setOnShowListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                // Fragements here...
                Fragment fragment=null;
                if (model.getId()==1){
                    fragment=new home_frame();
                }
                else if (model.getId()==2){
                    fragment=new search_frame();
                }

                else if (model.getId()==3){
                    fragment=new add_frame();

                }   else if (model.getId()==4){
                    fragment=new anaylisis_frame();
                }
                else if (model.getId()==5){
                    fragment=new category_frame();
                }

                //create methods for load and replace data
                LoadAndReplaceFragment(fragment);

                return null;
            }
        });
        //add methods///////////////////////////////////////////////////////////////////////////////

    }
    //LoadAndReplaceFragment>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    private void LoadAndReplaceFragment(Fragment fragment) {

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragementcontainer,fragment,null)
                .commit();

    }
    //LoadAndReplaceFragment>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

}