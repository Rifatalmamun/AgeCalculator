package com.example.rifat.agecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // declaration all the variable

    private TextView yearResult,monthResult,dayResult,nextMonthResult,nextDayResult,extraYearResult,extraMonthResult,extraWeakResult,extraDayResult,extraHourResult,extraMinuteResult,extraSecondResult;
    private EditText currentDateDay,currentDateMonth,currentDateYear,birthDateDay,birthDateMonth,birthDateYear;
    private Button calculateAgeButton,clearButton,currentDateCalenderPickerButton,birthDateCalenderPickerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // find all the variable

        currentDateDay=(EditText) findViewById(R.id.CurrentDateDay_id);
        currentDateMonth=(EditText)findViewById(R.id.CurrentDateMonth_id);
        currentDateYear=(EditText)findViewById(R.id.CurrentDateYear_id);

        birthDateDay=(EditText)findViewById(R.id.BirthDateDay_id);
        birthDateMonth=(EditText)findViewById(R.id.BirthDateMonth_id);
        birthDateYear=(EditText)findViewById(R.id.BirthDateYear_id);

        yearResult=(TextView)findViewById(R.id.YearResultTextView_id);
        monthResult=(TextView)findViewById(R.id.MonthResultTextView_id);
        dayResult=(TextView)findViewById(R.id.DayResultTextView_id);

        nextMonthResult=(TextView)findViewById(R.id.NextBirthDayMonthResult_id);
        nextDayResult=(TextView)findViewById(R.id.NextBirthdayDayResult_id);

        extraYearResult=(TextView)findViewById(R.id.EI_yearTextView_id);
        extraMonthResult=(TextView)findViewById(R.id.EI_monthTextView_id);
        extraWeakResult=(TextView)findViewById(R.id.EI_weakTextView_id);
        extraDayResult=(TextView)findViewById(R.id.EI_dayTextView_id);
        extraHourResult=(TextView)findViewById(R.id.EI_hourTextView_id);
        extraMinuteResult=(TextView)findViewById(R.id.EI_minuteTextView_id);
        extraSecondResult=(TextView)findViewById(R.id.EI_secondTextView_id);

        calculateAgeButton=(Button)findViewById(R.id.CalculateAgeButton_id);
        clearButton=(Button)findViewById(R.id.ClearButton_id);
        currentDateCalenderPickerButton=(Button)findViewById(R.id.CurrentDataCalender_id);
        birthDateCalenderPickerButton=(Button)findViewById(R.id.BirthDateCalender_id);

        // now set OnClicklistener............................................................
        currentDateCalenderPickerButton.setOnClickListener(this);
        birthDateCalenderPickerButton.setOnClickListener(this);
        calculateAgeButton.setOnClickListener(this);
        clearButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.CurrentDataCalender_id){
            openCurrentDatePicker();
        }
        if(v.getId()==R.id.BirthDateCalender_id){
            openBirthDatePicker();
        }
        if(v.getId()==R.id.CalculateAgeButton_id){

        }
        if(v.getId()==R.id.ClearButton_id){

        }
    }
    // this is openCurrentDatePicker method.................
    private void openCurrentDatePicker() {

    }
    // this is openBirthDatePicker method...................
    private void openBirthDatePicker() {

    }
}
