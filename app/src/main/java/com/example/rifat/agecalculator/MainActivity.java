package com.example.rifat.agecalculator;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
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


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener {


    private LinearLayout tenyearLinearLayout;
    // declaration all the variable
    ActionBar actionBar;  // this for action bar


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
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



        // My Apps onCreate start Here..........................................................................................


        actionBar=getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0CAA95")));

        // find all the variable
        tenyearLinearLayout=(LinearLayout)findViewById(R.id.tenYearsBirthdayListLayout_id);

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

        birthDateDay.requestFocus();
        //................................................................ this is test case start line

        birthDateDay.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                String sday=birthDateDay.getText().toString().trim();

                if(sday.length()>1 || (sday.equals("4")) || (sday.equals("5")) || (sday.equals("6")) || (sday.equals("7")) || (sday.equals("8")) || (sday.equals("9"))   ){

                    birthDateMonth.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //.................................................................

        birthDateMonth.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                String smonth=birthDateMonth.getText().toString().trim();

                if(smonth.length()>1 || (smonth.equals("2")) || (smonth.equals("3"))  || (smonth.equals("4")) || (smonth.equals("5")) || (smonth.equals("6")) || (smonth.equals("7")) || (smonth.equals("8")) || (smonth.equals("9"))   ){

                    birthDateYear.requestFocus();
                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //.................................................................this is text case finish line
        //.................................................................

        birthDateYear.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(birthDateYear.getText().toString().trim().length()>3){

                    // This two line use for hiding soft keyboard after enter max length number in my edittex........

                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(birthDateYear.getWindowToken(), 0);

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        //.................................................................this is text case finish line

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
        yearResult.setText("00");
        monthResult.setText("00");
        dayResult.setText("00");
        nextMonthResult.setText("00");
        nextDayResult.setText("00");
        extraYearResult.setText("00");
        extraMonthResult.setText("00");
        extraWeakResult.setText("00");
        extraDayResult.setText("00");
        extraHourResult.setText("00");
        extraMinuteResult.setText("00");
        extraSecondResult.setText("00");


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

            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(birthDateYear.getWindowToken(), 0);

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

                tenYearsFunction(bDay,bMonth,bYear,cDay,cMonth,cYear);

                if((cYear<bYear) || ((cYear==bYear) && (cMonth<bMonth) || (bDay>31) || (cDay>31) || (bMonth>12) || (cMonth>12) || (cDay<1) || (cMonth<1) || (bDay<1) || (bMonth<1)  ) ){

                    invalidFunction("Invalid Date!!! please check");

                }else if( (cDay<bDay) && (cMonth<=bMonth) && (cYear<=bYear) ){

                    invalidFunction("Invalid Date!!! please check");

                }else if( (cDay==bDay) && (cMonth==bMonth) && (cYear==bYear) ){
                    invalidFunction("Current Date & Brith Date Same");
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

                    int E_Month = (yearDiff*12)+monthDiff ;  // extra month er hisab ta korlam

                    String finalDay=Integer.toString(dayDiff);
                    String finalMonth=Integer.toString(monthDiff);
                    String finalYear=Integer.toString(yearDiff);

                    yearResult.setText(finalYear);
                    monthResult.setText(finalMonth);
                    dayResult.setText(finalDay);

                    // extraINformationFunction(finalYear,finalMonth,finalDay);
                    String Extra_month = Integer.toString(E_Month);       // extra month er integer k string koralm

                    extraYearResult.setText(finalYear);
                    extraMonthResult.setText(Extra_month);

                    nextBirthDay(monthDiff,dayDiff,cDay,cMonth,bDay,bMonth);

                    tenyearLinearLayout.setVisibility(View.VISIBLE);
                }
            }


        }
        if(v.getId()==R.id.ClearButton_id){
            birthDateDay.setText("");
            birthDateMonth.setText("");
            birthDateYear.setText("");
            yearResult.setText("00");
            monthResult.setText("00");
            dayResult.setText("00");
            nextMonthResult.setText("00");
            nextDayResult.setText("00");
            extraYearResult.setText("00");
            extraMonthResult.setText("00");
            extraWeakResult.setText("00");
            extraDayResult.setText("00");
            extraHourResult.setText("00");
            extraMinuteResult.setText("00");
            extraSecondResult.setText("00");

            tenyearLinearLayout.setVisibility(View.GONE);

            birthDateDay.requestFocus();
        }



    }

// next BirthDay Method...................................

    private void nextBirthDay(int f_month, int f_day,int currentDay,int currentMonth,int birthdayDay,int birthdayMonth) {

        if(f_month==0 && f_day==0){
            nextDayResult.setText("00");
            nextMonthResult.setText("00");
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

            nextDayResult.setText(nextBirthDayInDay);
            nextMonthResult.setText(nextBirthDayInMonth);
        }
    }
    // ten year function here.................................................................

    private void tenYearsFunction(int bDay, int bMonth,int bYear,int cDay,int cMonth,int cYear) {

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

        if(cMonth<bMonth){
            one=cYear;
        }else if((cMonth==bMonth) && (cDay<bDay) ){
            one=cYear;
        }else{
            one=cYear+1;
        }
        two=one+1;
        three=two+1;
        four=three+1;
        five=four+1;
        six=five+1;
        seven=six+1;
        eight=seven+1;
        nine=eight+1;
        ten=nine+1;

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

        // new write code for tenYears birthday Day find.................

        //................for 1st.......................
        int y1=one;
        int step1=y1%10;
        y1=y1/10;
        int last1Digit=((y1%10)*10)+step1;

        int monthCode1=monthCodeFunction(bMonth);
        int yearCode1=yearCodeFunction(one);

        String s1_dayName=findDayNameFunction(dayOne,monthCode1,last1Digit,yearCode1);
        firstDay.setText(s1_dayName);

        //................for 2nd.......................
        int y2=two;
        int step2=y2%10;
        y2=y2/10;
        int last2Digit=((y2%10)*10)+step2;

        int monthCode2=monthCodeFunction(bMonth);
        int yearCode2=yearCodeFunction(two);

        String s2_dayName=findDayNameFunction(dayTwo,monthCode2,last2Digit,yearCode2);
        secondDay.setText(s2_dayName);

        //................for 3rd.......................
        int y3=three;
        int step3=y3%10;
        y3=y3/10;
        int last3Digit=((y3%10)*10)+step3;

        int monthCode3=monthCodeFunction(bMonth);
        int yearCode3=yearCodeFunction(three);

        String s3_dayName=findDayNameFunction(dayThree,monthCode3,last3Digit,yearCode3);
        thirdDay.setText(s3_dayName);

        //................for 4th.......................
        int y4=four;
        int step4=y4%10;
        y4=y4/10;
        int last4Digit=((y4%10)*10)+step4;

        int monthCode4=monthCodeFunction(bMonth);
        int yearCode4=yearCodeFunction(four);

        String s4_dayName=findDayNameFunction(dayFour,monthCode4,last4Digit,yearCode4);
        fourDay.setText(s4_dayName);

        //................for 5th.......................
        int y5=five;
        int step5=y5%10;
        y5=y5/10;
        int last5Digit=((y5%10)*10)+step5;

        int monthCode5=monthCodeFunction(bMonth);
        int yearCode5=yearCodeFunction(five);

        String s5_dayName=findDayNameFunction(dayFive,monthCode5,last5Digit,yearCode5);
        fiveDay.setText(s5_dayName);

        //................for 6th.......................
        int y6=six;
        int step6=y6%10;
        y6=y6/10;
        int last6Digit=((y6%10)*10)+step6;

        int monthCode6=monthCodeFunction(bMonth);
        int yearCode6=yearCodeFunction(six);

        String s6_dayName=findDayNameFunction(daySix,monthCode6,last6Digit,yearCode6);
        sixDay.setText(s6_dayName);

        //................for 7th.......................
        int y7=seven;
        int step7=y7%10;
        y7=y7/10;
        int last7Digit=((y7%10)*10)+step7;

        int monthCode7=monthCodeFunction(bMonth);
        int yearCode7=yearCodeFunction(seven);

        String s7_dayName=findDayNameFunction(daySeven,monthCode7,last7Digit,yearCode7);
        sevenDay.setText(s7_dayName);

        //................for 8th.......................
        int y8=eight;
        int step8=y8%10;
        y8=y8/10;
        int last8Digit=((y8%10)*10)+step8;

        int monthCode8=monthCodeFunction(bMonth);
        int yearCode8=yearCodeFunction(eight);

        String s8_dayName=findDayNameFunction(dayEight,monthCode8,last8Digit,yearCode8);
        eightDay.setText(s8_dayName);

        //................for 9th.......................
        int y9=nine;
        int step9=y9%10;
        y9=y9/10;
        int last9Digit=((y9%10)*10)+step9;

        int monthCode9=monthCodeFunction(bMonth);
        int yearCode9=yearCodeFunction(nine);

        String s9_dayName=findDayNameFunction(dayNine,monthCode9,last9Digit,yearCode9);
        nineDay.setText(s9_dayName);

        //................for 10th.......................
        int y10=ten;
        int step10=y10%10;
        y10=y10/10;
        int last10Digit=((y10%10)*10)+step10;

        int monthCode10=monthCodeFunction(bMonth);
        int yearCode10=yearCodeFunction(ten);

        String s10_dayName=findDayNameFunction(dayTen,monthCode10,last10Digit,yearCode10);
        tenDay.setText(s10_dayName);

    }


    // monthCodeFunction Method..........................................................
    private int monthCodeFunction(int month)
    {
        int c =0;

        if(month==1){
            c=0;
        }
        else if(month==2){
            c=3;
        }
        else if(month==3){
            c=3;
        }
        else if(month==4){
            c=6;
        }
        else if(month==5){
            c=1;
        }
        else if(month==6){
            c=4;
        }
        else if(month==7){
            c=6;
        }
        else if(month==8){
            c=1;
        }
        else if(month==9){
            c=5;
        }
        else if(month==10){
            c=0;
        }
        else if(month==11){
            c=3;
        }
        else if(month==12){
            c=5;
        }
        return c;
    }
    // yearCodeFunction Method..........................................................
    private int yearCodeFunction(int year){

        int c=0;

        if(year>=1600 && year<=1699){
            c=6;
        }
        else if(year>=1700 && year<=1799){
            c=4;
        }
        else if(year>=1800 && year<=1899){
            c=2;
        }
        else if(year>=1900 && year<=1999){
            c=0;
        }
        else if(year>=2000 && year<=2099){
            c=6;
        }
        return c;
    }


    // Day name method write here...............................

    private String findDayNameFunction(int day, int monthCode, int last2Digit, int yearCode) {

        int result;

        result=day+monthCode+last2Digit+(last2Digit/4)+yearCode;
        result=result%7;

        String dayName="";

        if(result==0){
            dayName="Sunday";
        }
        else if(result==1){
            dayName="Monday";
        }
        else if(result==2){
            dayName="Tuesday";
        }
        else if(result==3){
            dayName="Wednesday";
        }
        else if(result==4){
            dayName="Thursday";
        }
        else if(result==5){
            dayName="Friday";
        }
        else if(result==6){
            dayName="Saturday";
        }

        return dayName;
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

        if(extraSecond<0){
            extraSecondResult.setText("N/A");
        }
        else{
            String ExtraSecond = Integer.toString(extraSecond);
            extraSecondResult.setText(ExtraSecond);
        }

        if(extraMinute<0){
            extraMinuteResult.setText("N/A");
        }
        else{
            String ExtraMinute = Integer.toString(extraMinute);
            extraMinuteResult.setText(ExtraMinute);
        }

        String ExtraDay = Integer.toString(extraDay);
        String ExtraWeek = Integer.toString(extraWeek);
        String ExtraHour = Integer.toString(extraHour);

        extraDayResult.setText(ExtraDay);
        extraWeakResult.setText(ExtraWeek);
        extraHourResult.setText(ExtraHour);

    }

    public int leapyear(int d,int m,int y){

        if(m<2){
            y--;
        }
        return y/4 - y/100 + y/400 ;
    }

    private void invalidFunction(String message)
    {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
        builder1.setMessage(message);
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

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}

