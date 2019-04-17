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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.time.Year;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout tenyearLinearLayout,tenYearTextViewLinearLayout;
    // declaration all the variable

    private TextView yearResult,monthResult,dayResult,nextMonthResult,nextDayResult,extraYearResult,extraMonthResult,extraWeakResult,extraDayResult,extraHourResult,extraMinuteResult,extraSecondResult;
    private EditText currentDateDay,currentDateMonth,currentDateYear,birthDateDay,birthDateMonth,birthDateYear;
    private Button calculateAgeButton,clearButton,currentDateCalenderPickerButton,birthDateCalenderPickerButton;

    private DatePickerDialog current_Date_Picker;
    private DatePickerDialog birth_Date_Picker;
    int month[]={31,28,31,30,31,30,31,31,30,31,30,31};  // define a string for all month day count;

    // ten years er all variables

    private TextView firstDate,secondDate,thirdDate,fourDate,fiveDate,sixDate,sevenDate,eightDate,nineDate,tenDate;
    private TextView firstDay,secondDay,thirdDay,fourDay,fiveDay,sixDay,sevenDay,eightDay,nineDay,tenDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // find all the variable
        tenyearLinearLayout=(LinearLayout)findViewById(R.id.tenYearsBirthdayListLayout_id);
        tenYearTextViewLinearLayout=(LinearLayout)findViewById(R.id.tenYearsTextViewLayout_id) ;
        //..........................................................................................

        firstDate=(TextView)findViewById(R.id.firstBirthdayDate_id);
        secondDate=(TextView)findViewById(R.id.secondBirthdayDate_id);
        thirdDate=(TextView)findViewById(R.id.thirdBirthdayDate_id);
        fourDate=(TextView)findViewById(R.id.fourBirthdayDate_id);
        fiveDate=(TextView)findViewById(R.id.fiveBirthdayDate_id);
        sixDate=(TextView)findViewById(R.id.sixBirthdayDate_id);
        sevenDate=(TextView)findViewById(R.id.sevenBirthdayDate_id);
        eightDate=(TextView)findViewById(R.id.eightBirthdayDate_id);
        nineDate=(TextView)findViewById(R.id.nineBirthdayDate_id);
        tenDate=(TextView)findViewById(R.id.tenthBirthdayDate_id);

        //..........................................................................................
        //..........................................................................................

        firstDay=(TextView)findViewById(R.id.firstBirthdayDay_id);
        secondDay=(TextView)findViewById(R.id.secondBirthdayDay_id);
        thirdDay=(TextView)findViewById(R.id.thirdBirthdayDay_id);
        fourDay=(TextView)findViewById(R.id.fourBirthdayDay_id);
        fiveDay=(TextView)findViewById(R.id.fiveBirthdayDay_id);
        sixDay=(TextView)findViewById(R.id.sixBirthdayDay_id);
        sevenDay=(TextView)findViewById(R.id.sevenBirthdayDay_id);
        eightDay=(TextView)findViewById(R.id.eightBirthdayDay_id);
        nineDay=(TextView)findViewById(R.id.nineBirthdayDay_id);
        tenDay=(TextView)findViewById(R.id.tenthBirthdayDay_id);

        //..........................................................................................

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

                tenYearsFunction(bDay,bMonth,cYear);

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

                    nextBirthDay(monthDiff,dayDiff,cDay,cMonth,bDay,bMonth);
                }
            }

            tenyearLinearLayout.setVisibility(View.VISIBLE);
            tenYearTextViewLinearLayout.setVisibility(View.VISIBLE);
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


            tenyearLinearLayout.setVisibility(View.GONE);
            tenYearTextViewLinearLayout.setVisibility(View.GONE);
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

    private void nextBirthDay(int f_month, int f_day,int currentDay,int currentMonth,int birthdayDay,int birthdayMonth) {

        if(f_month==0 && f_day==0){
            nextDayResult.setText("0 Day");
            nextMonthResult.setText("0 Month");
        }

        else{
            int checkMonthDay=month[f_month];

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



    // ten year function here.................................................................

    private void tenYearsFunction(int bDay, int bMonth, int cYear) {

        int dayOne=bDay;
        int dayTwo=bDay;
        int dayThree=bDay;
        int dayFour=bDay;
        int dayFive=bDay;
        int daySix=bDay;
        int daySeven=bDay;
        int dayEight=bDay;
        int dayNine=bDay;
        int dayTen=bDay;


        int one,two,three,four,five,six,seven,eight,nine,ten;

        one=cYear+1;
        two=cYear+2;
        three=cYear+3;
        four=cYear+4;
        five=cYear+5;
        six=cYear+6;
        seven=cYear+7;
        eight=cYear+8;
        nine=cYear+9;
        ten=cYear+10;

        if(bMonth==2 && bDay==28){
            if(one%4==0){
                dayOne++;
            }
            if(two%4==0){
                dayTwo++;
            }
            if(three%4==0){
                dayThree++;
            }
            if(four%4==0){
                dayFour++;
            }
            if(five%4==0){
                dayFive++;
            }
            if(six%4==0){
                daySix++;
            }
            if(seven%4==0){
                daySeven++;
            }
            if(eight%4==0){
                dayEight++;
            }
            if(nine%4==0){
                dayNine++;
            }
            if(ten%4==0){
                dayTen++;
            }
        }

        if(bMonth==2 && bDay==29){
            if(one%4!=0){
                dayOne--;
            }
            if(two%4!=0){
                dayTwo--;
            }
            if(three%4!=0){
                dayThree--;
            }
            if(four%4!=0){
                dayFour--;
            }
            if(five%4!=0){
                dayFive--;
            }
            if(six%4!=0){
                daySix--;
            }
            if(seven%4!=0){
                daySeven--;
            }
            if(eight%4!=0){
                dayEight--;
            }
            if(nine%4!=0){
                dayNine--;
            }
            if(ten%4!=0){
                dayTen--;
            }
        }



        String dOne=Integer.toString(dayOne);
        String dTwo=Integer.toString(dayTwo);
        String dThree=Integer.toString(dayThree);
        String dFour=Integer.toString(dayFour);
        String dFive=Integer.toString(dayFive);
        String dSix=Integer.toString(daySix);
        String dSeven=Integer.toString(daySeven);
        String dEight=Integer.toString(dayEight);
        String dNine=Integer.toString(dayNine);
        String dTen=Integer.toString(dayTen);


        String month=Integer.toString(bMonth);

        if(month.equals("1")){
            month="January";
        }else if(month.equals("2")){
            month="February";
        }
        else if(month.equals("3")){
            month="March";
        }
        else if(month.equals("4")){
            month="April";
        }
        else if(month.equals("5")){
            month="May";
        }
        else if(month.equals("6")){
            month="June";
        }
        else if(month.equals("7")){
            month="July";
        }
        else if(month.equals("8")){
            month="August";
        }
        else if(month.equals("9")){
            month="September";
        }
        else if(month.equals("10")){
            month="October";
        }else if(month.equals("11")){
            month="November";
        }else if(month.equals("12")){
            month="December";
        }

        String yearOne=Integer.toString(one);
        String yearTwo=Integer.toString(two);
        String yearThree=Integer.toString(three);
        String yearFour=Integer.toString(four);
        String yearFive=Integer.toString(five);
        String yearSix=Integer.toString(six);
        String yearSeven=Integer.toString(seven);
        String yearEight=Integer.toString(eight);
        String yearNine=Integer.toString(nine);
        String yearTen=Integer.toString(ten);

        firstDate.setText(dOne+" "+month+" "+yearOne);
        secondDate.setText(dTwo+" "+month+" "+yearTwo);
        thirdDate.setText(dThree+" "+month+" "+yearThree);
        fourDate.setText(dFour+" "+month+" "+yearFour);
        fiveDate.setText(dFive+" "+month+" "+yearFive);
        sixDate.setText(dSix+" "+month+" "+yearSix);
        sevenDate.setText(dSeven+" "+month+" "+yearSeven);
        eightDate.setText(dEight+" "+month+" "+yearEight);
        nineDate.setText(dNine+" "+month+" "+yearNine);
        tenDate.setText(dTen+" "+month+" "+yearTen);


    }



}
