package br.ufop.modules;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

import br.ufop.components.ClassArrayAdapter;
import br.ufop.components.SchoolClass;

public class AccessClassesScreen extends ListActivity {
    HashMap<String,SchoolClass> m_ClassMap = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent v_intent = getIntent();
        m_ClassMap = (HashMap<String,SchoolClass>)v_intent.getSerializableExtra("ClassMap");
        ArrayList<SchoolClass> v_ArrayClasses = new ArrayList<>(m_ClassMap.values());
        ClassArrayAdapter v_Adapter = new ClassArrayAdapter(this,R.layout.class_list_item,v_ArrayClasses);
        setListAdapter(v_Adapter);

        setContentView(R.layout.classes_screen);
    }

    @Override
    public void onListItemClick(ListView p_ListView, View p_View, int p_Position, long p_Id){
        super.onListItemClick(p_ListView, p_View, p_Position, p_Id);

    }

    public void createClass(View v){
        Intent v_Intent = new Intent(AccessClassesScreen.this,AddClassScreen.class);
        Bundle v_Bundle = new Bundle();
        v_Bundle.putSerializable("ClassesMap", m_ClassMap);
        v_Intent.putExtras(v_Bundle);
        startActivity(v_Intent);
    }

}
