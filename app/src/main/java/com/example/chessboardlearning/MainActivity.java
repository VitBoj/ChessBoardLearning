package com.example.chessboardlearning;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
////////////////////////////////////////////////////////////////////////////////////////////////////
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView viewAsk,answer;
    Button buttonWhite,buttonBlack,refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewAsk=findViewById(R.id.askAndResultView);
        answer=findViewById(R.id.answer);
        buttonBlack=findViewById(R.id.buttonBlack);
        buttonWhite=findViewById(R.id.buttonWhite);
        refresh=findViewById(R.id.refresh);
        buttonBlack.setOnClickListener(this);
        buttonWhite.setOnClickListener(this);
        refresh.setOnClickListener(this);

        FillMap();
        ShowAsk(FillMap());
    }
////////////////////////////////////////////////////////
    public Map FillMap(){
        Map<String, String> hashMap = new HashMap<String, String>();
        for(int i=1;i<9;i++){
            if(isEven(i)==true){
                hashMap.put("A"+convToStr(i),"White");}
            else hashMap.put("A"+convToStr(i),"Black");
        }
        for(int i=1;i<9;i++){
            if(isEven(i)==true){
                hashMap.put("B"+convToStr(i),"Black");}
            else hashMap.put("B"+convToStr(i),"White");
        }for(int i=1;i<9;i++){
            if(isEven(i)==true){
                hashMap.put("C"+convToStr(i),"White");}
            else hashMap.put("C"+convToStr(i),"Black");
        }for(int i=1;i<9;i++){
            if(isEven(i)==true){
                hashMap.put("D"+convToStr(i),"Black");}
            else hashMap.put("D"+convToStr(i),"White");
        }for(int i=1;i<9;i++){
            if(isEven(i)==true){
                hashMap.put("E"+convToStr(i),"White");}
            else hashMap.put("E"+convToStr(i),"Black");
        }for(int i=1;i<9;i++){
            if(isEven(i)==true){
                hashMap.put("F"+convToStr(i),"Black");}
            else hashMap.put("F"+convToStr(i),"White");
        }for(int i=1;i<9;i++){
            if(isEven(i)==true){
                hashMap.put("G"+convToStr(i),"White");}
            else hashMap.put("G"+convToStr(i),"Black");
        }
        for(int i=1;i<9;i++){
            if(isEven(i)==true){
                hashMap.put("H"+convToStr(i),"Black");}
            else hashMap.put("H"+convToStr(i),"White");
        }
        return hashMap;
    }
/////////////////////////////////////////////////////////
    public boolean isEven(int n){
        if(n % 2 == 0) {
            //Четное
            return  true;
        } else {
            return false;
        }
    }
/////////////////////////////////////
    public  String convToStr(int i){
        String s=String.valueOf(i);
        return s;
    }
/////////////////////////////////////////////////////////////////////
    public void ShowAsk(Map hashMap){
        List<String> valuesList = new ArrayList<String>(hashMap.keySet());
        int randomIndex = new Random().nextInt(valuesList.size());
        String randomValue = valuesList.get(randomIndex);
        viewAsk.setText(randomValue);
        answer.setText(" ");



    }
///////////////////////////////////////////////////////////////////////
    public void CheckIfCorrect(String color) {
        String key=viewAsk.getText().toString();
        String value = FillMap().get(key).toString();
        if(value.equals(color)){
            answer.setTextColor(getResources().getColor(R.color.green));
            answer.setText("Верно");
        }
        else {
            answer.setTextColor(getResources().getColor(R.color.red));
            answer.setText("Не верно");
        }
////////////////////////////////////////
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case (R.id.buttonBlack):
                String color="Black";
                CheckIfCorrect(color);
                break;
            case (R.id.buttonWhite):
                String color2="White";
                CheckIfCorrect(color2);
                break;
            case(R.id.refresh):
                ShowAsk(FillMap());
           default:
               break;
        }
    }
////////////////////////////////////////////////////////////////////////////////////////////////////
}
