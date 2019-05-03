package br.ufop.modules;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import br.ufop.components.SchoolActivity;
import br.ufop.components.SchoolClass;

public class RegisterScreen extends AppCompatActivity {
    SchoolActivity m_Activity = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_screen);
        addButtonListener();
    }

    private void addButtonListener(){
        Button v_Button = findViewById(R.id.ButtonSubmitNewClass);
        v_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    String v_Name = findViewById(R.id.TEName).toString();
                    Double v_ObjGrade = Double.valueOf(findViewById(R.id.TEObjectiveGrade).toString());
                    int v_MaxAbs = Integer.parseInt(findViewById(R.id.TEMaxAbsences).toString());

                    SchoolClass v_NewClass = new SchoolClass(v_Name,60.0,0.00,v_ObjGrade,0,v_MaxAbs);
                    //TODO add class in parent array;

                }catch (NumberFormatException e){
                    Toast.makeText(RegisterScreen.this,"Invalid number in objective grade or maximum absences",Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}
