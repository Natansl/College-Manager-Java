package br.ufop.modules;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
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
        setContentView(R.layout.inicial_Screen);
        addButtonListeners();
    }

    public void addButtonListeners(){
        Button v_Button = findViewById(R.id.btRegisterClass);
        v_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent v_Transition = new Intent(InitialScreen.this,RegisterScreen.class);
                //v_Transition.putParcelableArrayListExtra("Classes",(ArrayList<SchoolClass>)m_Classes.values());
                v_Transition.putExtra("Classes",m_Classes);
                startActivity(v_Transition);
            }
        });

        v_Button = findViewById(R.id.btSeeClasses);
        v_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent v_Transition = new Intent (InitialScreen.this, AccessScreen.class);
                startActivity(v_Transition);
            }
        });
    }
}
