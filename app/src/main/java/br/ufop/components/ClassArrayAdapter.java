package br.ufop.components;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import br.ufop.modules.R;

public class ClassArrayAdapter extends ArrayAdapter<SchoolClass> {
    private int m_Resource;

    public ClassArrayAdapter (Context p_Context, int p_TextViewResourceId, List<SchoolClass> p_Classes){
        super(p_Context, p_TextViewResourceId, p_Classes);
        m_Resource = p_TextViewResourceId;
    }

    @Override
    public View getView(int p_Position, View p_ConvertView, ViewGroup p_Parent){
        LinearLayout v_ClassView;
        SchoolClass v_Class = getItem(p_Position);
        if (p_ConvertView == null){
            v_ClassView = new LinearLayout(getContext());
            LayoutInflater v_Inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v_Inflater.inflate(m_Resource,v_ClassView,true);
        }else{
            v_ClassView = (LinearLayout) p_ConvertView;
        }
        TextView v_TVClassName = v_ClassView.findViewById(R.id.TVClassName);
        v_TVClassName.setText(v_Class.getName());
        return v_ClassView;
    }
}
