package br.ufop.modules;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Calendar;
import java.util.HashMap;

import br.ufop.components.SchoolActivity;
import br.ufop.components.SchoolClass;

public class InitialScreen extends AppCompatActivity {
    private HashMap <String, SchoolClass> m_Classes = new HashMap<>();
    private HashMap <String, SchoolActivity> m_Activities = new HashMap<>();
    public static Calendar g_CurrentDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicial_screen);
    }

    public void seeClasses (View v){
        Intent v_Intent = new Intent(InitialScreen.this,AccessClassesScreen.class);
        Bundle v_Extras = new Bundle();
        v_Extras.putSerializable("ClassMap", m_Classes);
        v_Intent.putExtras(v_Extras);
        startActivity(v_Intent);
    }

    public void seeActivities (View v){
        Intent v_Intent = new Intent(InitialScreen.this,AccessActivitiesScreen.class);
        Bundle v_Extras = new Bundle();
        v_Extras.putSerializable("ActivitiesMap", m_Activities);
        v_Intent.putExtras(v_Extras);
        startActivity(v_Intent);
    }

}
