package br.ufop.components;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.util.Calendar;

import br.ufop.Exceptions.PassedDateException;
import br.ufop.Exceptions.ValueOutOfBoundsException;
import br.ufop.modules.InitialScreen;

public class SchoolActivity implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator<SchoolActivity>(){

        @Override
        public SchoolActivity createFromParcel(Parcel p_Parcel) {
            try {
                return new SchoolActivity(p_Parcel);
            } catch (ValueOutOfBoundsException e) {
                Log.d("Exception","Invalid value for Activity");
            } catch (PassedDateException e) {
                Log.d("Exception","Invalid Date for Activity");
            }
            return null;
        }

        @Override
        public SchoolActivity[] newArray(int p_Size) {
            return new SchoolActivity[p_Size];
        }
    };


    private SchoolClass m_Class;
    private double m_Value;
    private Calendar m_Deadline;

    public SchoolActivity (SchoolClass p_Class, double p_Value, Calendar p_Deadline) throws ValueOutOfBoundsException,PassedDateException{
        if (p_Value > 100.00 && p_Value < 0.00) throw new ValueOutOfBoundsException();
        if (p_Deadline.after(InitialScreen.g_CurrentDate)) throw new PassedDateException();
        m_Class = p_Class;
        m_Value = p_Value;
        m_Deadline = p_Deadline;
    }

    private SchoolActivity(Parcel p_Parcel) throws ValueOutOfBoundsException, PassedDateException {
        this((SchoolClass)p_Parcel.readParcelable(SchoolClass.class.getClassLoader()),p_Parcel.readDouble(),(Calendar)p_Parcel.readSerializable());
    }

    public SchoolClass getSchoolClass() {
        return m_Class;
    }

    public void setClass(SchoolClass p_Class) {
        m_Class = p_Class;
    }

    public double getValue() {
        return m_Value;
    }

    public void setValue(double p_Value) {
        m_Value = p_Value;
    }

    public Calendar getDeadLine() {
        return m_Deadline;
    }

    public void setDeadLine(Calendar p_DeadLine) {
        m_Deadline = p_DeadLine;
    }

    public double finishActivity (Calendar p_Date, Double p_Value){
        if (p_Date.before(m_Deadline)){
            return p_Value;
        }
        else{
            return 0.00;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(getSchoolClass(),flags);
        dest.writeDouble(getValue());
        dest.writeSerializable(getDeadLine());
    }
}
