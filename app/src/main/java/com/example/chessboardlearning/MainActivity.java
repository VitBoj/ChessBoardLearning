package com.example.chessboardlearning;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


import com.example.chessboardlearning.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.buttonBlack.setOnClickListener(this);
        binding.buttonWhite.setOnClickListener(this);
        binding.refresh.setOnClickListener(this);
        FillMap();
        ShowAsk(FillMap());
    }

    public Map FillMap() {
        Map<String, String> hashMap = new HashMap<>();
        char[] firstLettersSet = {'A', 'C', 'E', 'G'};
        char[] secondLettersSet = {'B', 'D', 'F', 'H'};
        for (char letter : firstLettersSet) {
            fillFirstSet(hashMap, letter);
        }
        for (char letter : secondLettersSet) {
            fillSecondSet(hashMap, letter);
        }
        return hashMap;
    }

    public void fillFirstSet(Map<String, String> map, char setLetter) {
        for (int i = 1; i < 9; i++) {
            if (isEven(i) == true) {
                map.put(setLetter + String.valueOf(i), "Black");
            } else map.put(setLetter + String.valueOf(i), "White");
        }
    }

    public void fillSecondSet(Map<String, String> map, char setLetter) {
        for (int i = 1; i < 9; i++) {
            if (isEven(i) == true) {
                map.put(setLetter + String.valueOf(i), "White");
            } else map.put(setLetter + String.valueOf(i), "Black");
        }
    }

    public boolean isEven(int n) {
        if (n % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void ShowAsk(Map hashMap) {
        List<String> valuesList = new ArrayList<>(hashMap.keySet());
        int randomIndex = new Random().nextInt(valuesList.size());
        String randomValue = valuesList.get(randomIndex);
        binding.askAndResultView.setText(randomValue);
        binding.answer.setText(" ");
    }

    public void CheckIfCorrect(String color) {
        String key = binding.askAndResultView.getText().toString();
        String value = FillMap().get(key).toString();
        if (value.equals(color)) {
            binding.answer.setTextColor(getResources().getColor(R.color.green));
            binding.answer.setText("Верно");
        } else {
            binding.answer.setTextColor(getResources().getColor(R.color.red));
            binding.answer.setText("Не верно");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.buttonBlack):
                String color = "Black";
                CheckIfCorrect(color);
                break;
            case (R.id.buttonWhite):
                String color2 = "White";
                CheckIfCorrect(color2);
                break;
            case (R.id.refresh):
                ShowAsk(FillMap());
            default:
                break;
        }
    }
}
