package br.ufop.components;

import android.os.Parcel;
import android.os.Parcelable;

public class SchoolClass implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator<SchoolClass>(){
        public SchoolClass createFromParcel(Parcel p_Parcel){
            return new SchoolClass(p_Parcel);
        }

        @Override
        public SchoolClass[] newArray(int size) {
            return new SchoolClass[0];
        }
    };
    private String m_Name;
    private double m_ClassGrade, m_ClassMinGrade, m_ClassObjGrade;
    private int m_ClassAbsences, m_ClassMaxAbsenses;

    public SchoolClass (String p_Name, double p_ClassMinGrade, double p_ClassGrade, double p_ClassObjGrade, int p_ClassAbsences, int p_ClassMaxAbsenses){
        m_Name = p_Name;
        m_ClassGrade = p_ClassGrade;
        m_ClassMinGrade = p_ClassMinGrade;
        m_ClassObjGrade = p_ClassObjGrade;
        m_ClassAbsences = p_ClassAbsences;
        m_ClassMaxAbsenses = p_ClassMaxAbsenses;
    }

    private SchoolClass(Parcel p_Parcel){
        this(p_Parcel.readString(),p_Parcel.readDouble(),p_Parcel.readDouble(),p_Parcel.readDouble(),p_Parcel.readInt(),p_Parcel.readInt());
    }

    public String getName() {
        return m_Name;
    }

    public double getClassGrade() {
        return m_ClassGrade;
    }

    public double getClassMinGrade() {
        return m_ClassMinGrade;
    }

    public double getClassObjGrade() {
        return m_ClassObjGrade;
    }

    public int getClassAbsences() {
        return m_ClassAbsences;
    }

    public int getClassMaxAbsences() {
        return m_ClassMaxAbsenses;
    }

    public void setName(String p_Name) {
        this.m_Name = p_Name;
    }

    public void setClassGrade(double p_ClassGrade) {
        this.m_ClassGrade = p_ClassGrade;
    }

    public void setClassMinGrade(double p_ClassMinGrade) {
        this.m_ClassMinGrade = p_ClassMinGrade;
    }

    public void setClassObjGrade(double p_ClassObjGrade) {
        this.m_ClassObjGrade = p_ClassObjGrade;
    }

    public void setClassAbsences(int p_ClassAbsenses) {
        this.m_ClassAbsences = p_ClassAbsenses;
    }

    public void setClassMaxAbsences(int p_ClassMaxAbsenses) {
        this.m_ClassMaxAbsenses = p_ClassMaxAbsenses;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getName());
        dest.writeDouble(getClassMinGrade());
        dest.writeDouble(getClassGrade());
        dest.writeDouble(getClassObjGrade());
        dest.writeInt(getClassAbsences());
        dest.writeInt(getClassMaxAbsences());
    }
}
