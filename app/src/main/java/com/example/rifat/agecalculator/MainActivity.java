package com.example.rifat.agecalculator;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.time.Year;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // declaration all the variable

    private TextView yearResult,monthResult,dayResult,nextMonthResult,nextDayResult,extraYearResult,extraMonthResult,extraWeakResult,extraDayResult,extraHourResult,extraMinuteResult,extraSecondResult;
    private EditText currentDateDay,currentDateMonth,currentDateYear,birthDateDay,birthDateMonth,birthDateYear;
    private Button calculateAgeButton,clearButton,currentDateCalenderPickerButton,birthDateCalenderPickerButton;

    private DatePickerDialog current_Date_Picker;
    private DatePickerDialog birth_Date_Picker;

    int month[]={31,28,31,30,31,30,31,31,30,31,30,31};  // define a string for all month day count;
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


        // apps ta on hole sob value first a empty dekhabe
        birthDateDay.setText("");
        birthDateMonth.setText("");
        birthDateYear.setText("");
        yearResult.setText("0 Year");
        monthResult.setText("0 Month");
        dayResult.setText("0 Day");
        nextMonthResult.setText("0 Month");
        nextDayResult.setText("0 Day");

        // now set OnClicklistener............................................................
        currentDateCalenderPickerButton.setOnClickListener(this);
        birthDateCalenderPickerButton.setOnClickListener(this);
        calculateAgeButton.setOnClickListener(this);
        clearButton.setOnClickListener(this);

        // First work is to set Current Date ........................
        Calendar c = Calendar.getInstance();
        int day = c.get(Calendar.DAY_OF_MONTH);
        int month = c.get(Calendar.MONTH)+1;
        int year = c.get(Calendar.YEAR);

        // Current Date er integer variable gulo k String a convert korlam..........
        String currentDay=Integer.toString(day);
        String currentMonth=Integer.toString(month);
        String currentYear=Integer.toString(year);
        // Current Date k set Korlam....................................................
        currentDateDay.setText(currentDay);
        currentDateMonth.setText(currentMonth);
        currentDateYear.setText(currentYear);
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
            // take all Current Date day,month,year...................................................
            String takeCurrentDay=currentDateDay.getText().toString();
            String takeCurrentMonth=currentDateMonth.getText().toString();
            String takeCurrentYear=currentDateYear.getText().toString();
            // take all Birth Date day,month,year.....................................................
            String takeBirthDay=birthDateDay.getText().toString();
            String takeBirthMonth=birthDateMonth.getText().toString();
            String takeBirthYear=birthDateYear.getText().toString();


            if(takeBirthDay.isEmpty() || takeBirthMonth.isEmpty() || takeBirthYear.isEmpty()) {

                Toast.makeText(getApplicationContext(), "Please Input DOB", Toast.LENGTH_SHORT).show();
            }
            else{

                int cDay=Integer.parseInt(takeCurrentDay);
                int cMonth=Integer.parseInt(takeCurrentMonth);
                int cYear=Integer.parseInt(takeCurrentYear);
                int bDay=Integer.parseInt(takeBirthDay);
                int bMonth=Integer.parseInt(takeBirthMonth);
                int bYear=Integer.parseInt(takeBirthYear);

                if((cYear<bYear) || ((cYear==bYear) && (cMonth<bMonth) || (bDay>31) || (cDay>31) || (bMonth>12) || (cMonth>12) || (cDay<1) || (cMonth<1) || (bDay<1) || (bMonth<1)  ) ){
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                    builder1.setMessage("Invalid Date!!! please check");
                    builder1.setCancelable(true);

                    builder1.setPositiveButton(
                            "ok",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });

                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                }else{
                    int yearDiff = cYear - bYear ;
                    int monthDiff = cMonth - bMonth ;

                    if(monthDiff < 0){

                        yearDiff = yearDiff - 1;

                        monthDiff = monthDiff + 12 ;
                    }
                    int dayDiff = cDay - bDay;
                    if(dayDiff<0){
                        if(monthDiff>0){
                            monthDiff=monthDiff-1;
                            dayDiff=dayDiff+MonthsToDays(cMonth-1,cYear);
                        }else{
                            yearDiff=yearDiff-1;
                            monthDiff=11;
                            dayDiff=dayDiff+MonthsToDays(cMonth-1,cYear);
                        }
                    }

                    extraInformationMethod(bDay,bMonth,bYear,cDay,cMonth,cYear);

                /*if(bDay>cDay){
                    cDay=cDay+month[bMonth-1];
                    cMonth=cMonth-1;
                }
                if(bMonth>cMonth){
                    cYear=cYear-1;
                    cMonth=cMonth+12;
                }

                int F_day=(cDay-bDay);
                int F_month=(cMonth-bMonth);
                int F_year=(cYear-bYear);*/

                    int E_Month = (yearDiff*12)+monthDiff ;  // extra month er hisab ta korlam

                    String finalDay=Integer.toString(dayDiff);
                    String finalMonth=Integer.toString(monthDiff);
                    String finalYear=Integer.toString(yearDiff);

                    yearResult.setText(finalYear+" Year");
                    monthResult.setText(finalMonth+" Month");
                    dayResult.setText(finalDay+" Day");

                    // extraINformationFunction(finalYear,finalMonth,finalDay);
                    String Extra_month = Integer.toString(E_Month);       // extra month er integer k string koralm

                    extraYearResult.setText(finalYear);
                    extraMonthResult.setText(Extra_month);

                    nextBirthDay(monthDiff,dayDiff,bMonth);
                }
            }
        }
        if(v.getId()==R.id.ClearButton_id){
            birthDateDay.setText("");
            birthDateMonth.setText("");
            birthDateYear.setText("");
            yearResult.setText("0 Year");
            monthResult.setText("0 Month");
            dayResult.setText("0 Day");
            nextMonthResult.setText("0 Month");
            nextDayResult.setText("0 Day");
            extraYearResult.setText("0");
            extraMonthResult.setText("0");
            extraWeakResult.setText("0");
            extraDayResult.setText("0");
            extraHourResult.setText("0");
            extraMinuteResult.setText("0");
            extraSecondResult.setText("0");
        }
    }

    // this is OpenCurrentDatePicker method....................................
    //.........................................................................
    private void openCurrentDatePicker() {

        DatePicker datePicker1=new DatePicker(this);
        int currentDay = datePicker1.getDayOfMonth();
        int currentMonth = (datePicker1.getMonth());
        int currentYear = datePicker1.getYear();

        current_Date_Picker=new DatePickerDialog(this,

                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        //textView.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                        String PCD=Integer.toString(dayOfMonth);
                        String PCM=Integer.toString(month+1);
                        String PCY=Integer.toString(year);

                        currentDateDay.setText(PCD);
                        currentDateMonth.setText(PCM);
                        currentDateYear.setText(PCY);
                    }
                },currentYear,currentMonth,currentDay);

        current_Date_Picker.show();
    }
    // this is openBirthDatePicker method......................................
    //.........................................................................
    private void openBirthDatePicker() {

        DatePicker datePicker2=new DatePicker(this);
        int birthDay=datePicker2.getDayOfMonth();
        int birthMonth=datePicker2.getMonth();
        int birthYear=datePicker2.getYear();

        birth_Date_Picker=new DatePickerDialog(this,

                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        String PBD=Integer.toString(dayOfMonth);
                        String PBM=Integer.toString(month+1);
                        String PBY=Integer.toString(year);

                        birthDateDay.setText(PBD);
                        birthDateMonth.setText(PBM);
                        birthDateYear.setText(PBY);
                    }
                },birthYear,birthMonth,birthDay);

        birth_Date_Picker.show();
    }
    // Extra Information method.....................................................................

    public void extraInformationMethod(int BirthDD,int BirthDM,int BirthDY,int CurrentDD,int CurrentDM,int CurrentDY)
    {

        //..................................First work for Birthday leapyear count

        int n1 = BirthDY*365 + BirthDD;  // birth date er year k din a convert kore day gulo jog korlam

        for(int i= 0;i<BirthDM-1;i++){
            n1+=month[i];                // total er sathe month er day gulo jog korlam
        }

        int BleapDay = leapyear(BirthDD,BirthDM,BirthDY);

        int totalBirthDay = n1 + BleapDay;

        //..................................Second work for Currenthday leapyear count

        int n2 = CurrentDY*365 + CurrentDD;
        for (int i=0;i<CurrentDM-1;i++){
            n2+=month[i];
        }

        int CleapDay = leapyear(CurrentDD,CurrentDM,CurrentDY);
        int totalCurrentDay = n2 + CleapDay;

        int extraDay = totalCurrentDay - totalBirthDay ;

        //Toast.makeText(getApplicationContext(),"Extra Day: "+extraDay,Toast.LENGTH_LONG).show();

        int extraWeek = extraDay / 7;
        int extraHour = extraDay * 24;
        int extraMinute = extraDay * 1440;
        int extraSecond = extraDay * 86400 ;


        String ExtraDay = Integer.toString(extraDay);
        String ExtraWeek = Integer.toString(extraWeek);
        String ExtraHour = Integer.toString(extraHour);
        String ExtraMinute = Integer.toString(extraMinute);
        String ExtraSecond = Integer.toString(extraSecond);

        extraDayResult.setText(ExtraDay);
        extraWeakResult.setText(ExtraWeek);
        extraHourResult.setText(ExtraHour);
        extraMinuteResult.setText(ExtraMinute);
        extraSecondResult.setText(ExtraSecond);
    }

    public int leapyear(int d,int m,int y){

        if(m<2){
            y--;
        }
        return y/4 - y/100 + y/400 ;
    }

    // next BirthDay Method...................................

    private void nextBirthDay(int f_month, int f_day,int b_month) {

        if(f_month==0 && f_day==0){
            nextDayResult.setText("0 Day");
            nextMonthResult.setText("0 Month");
        }

        else{
            int checkMonthDay=month[b_month];

            int month=12-f_month;
            int day=0;

            if(f_day>0){
                month--;
            }
            if(f_day==0){
                if(checkMonthDay==31){
                    f_day=31;
                }else{
                    f_day=30;
                }
            }
                day=checkMonthDay-f_day;


            String nextBirthDayInMonth = Integer.toString(month);
            String nextBirthDayInDay = Integer.toString(day);

            nextDayResult.setText(nextBirthDayInDay+" Day");
            nextMonthResult.setText(nextBirthDayInMonth+" Month");

        }
    }


    // take day of month from here................................

    public static int MonthsToDays(int tMonth, int tYear) {
        if (tMonth == 1 || tMonth == 3 || tMonth == 5 || tMonth == 7
                || tMonth == 8 || tMonth == 10 || tMonth == 12) {
            return 31;
        } else if (tMonth == 2) {
            if (tYear % 4 == 0) {
                return 29;
            } else {
                return 28;
            }
        } else {
            return 30;
        }
    }
}
