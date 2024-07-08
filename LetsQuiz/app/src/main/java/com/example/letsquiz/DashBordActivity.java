package com.example.letsquiz;

import static com.example.letsquiz.MainActivity.listofQ;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.progressindicator.LinearProgressIndicator;

import java.util.Collections;
import java.util.List;

public class DashBordActivity extends AppCompatActivity {

    CountDownTimer count;
    int timevalue = 20;
    LinearProgressIndicator progreas;
    List<ModelC> allQ;
    ModelC modelC;
    int index = 0;
    TextView qui_text , o1_btn , o2_btn , o3_btn , o4_btn;
    LinearLayout next_btn;
    CardView o1_card , o2_card , o3_card , o4_card;
    int correctC = 0;
    int wrongC = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dash_bord);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        qui_text = findViewById(R.id.Qui_text);
        o1_btn = findViewById(R.id.o1_btn);
        o2_btn = findViewById(R.id.o2_btn);
        o3_btn = findViewById(R.id.o3_btn);
        o4_btn = findViewById(R.id.o4_btn);
        next_btn = findViewById(R.id.next_btn);

        o1_card = findViewById(R.id.o1_card);
        o2_card = findViewById(R.id.o2_card);
        o3_card = findViewById(R.id.o3_card);
        o4_card = findViewById(R.id.o4_card);
        progreas = findViewById(R.id.pp);

        // Initialize quiz data
        allQ = listofQ;
        Collections.shuffle(allQ);
        modelC = listofQ.get(index);

        // Start countdown timer
        startCountDownTimer();

        // Display initial question
        displayQuestion();

        // Set initial card click listeners
        setupCardClickListeners();
    }

    private void startCountDownTimer() {
        count = new CountDownTimer(20000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timevalue--;
                progreas.setProgress(timevalue);
            }

            @Override
            public void onFinish() {
                showTimeOutDialog();
            }
        }.start();
    }

    private void displayQuestion() {
        qui_text.setText(modelC.getQui());
        o1_btn.setText(modelC.getO1());
        o2_btn.setText(modelC.getO2());
        o3_btn.setText(modelC.getO3());
        o4_btn.setText(modelC.getO4());
        timevalue = 20;
        count.cancel();
        count.start();
    }

    private void setupCardClickListeners() {
        o1_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleAnswerSelection(o1_card, modelC.getO1());
            }
        });

        o2_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleAnswerSelection(o2_card, modelC.getO2());
            }
        });

        o3_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleAnswerSelection(o3_card, modelC.getO3());
            }
        });

        o4_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleAnswerSelection(o4_card, modelC.getO4());
            }
        });
    }

    private void handleAnswerSelection(CardView selectedCard, String selectedAnswer) {
        disableCardClicks();
        next_btn.setClickable(true);

        if (selectedAnswer.equals(modelC.getAns())) {
            selectedCard.setCardBackgroundColor(getResources().getColor(R.color.green));
            correctC++;
        } else {
            selectedCard.setCardBackgroundColor(getResources().getColor(R.color.Red));
            wrongC++;
        }

        // Prepare for next question or finish quiz
        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index < allQ.size() - 1) {
                    index++;
                    modelC = allQ.get(index);
                    resetCardColors();
                    displayQuestion();
                    enableCardClicks();
                    next_btn.setClickable(false);
                } else {
                    GameWon();
                }
            }
        });
    }
    private void GameWon() {
        Intent intent = new Intent(DashBordActivity.this, WonActivity.class);
        intent.putExtra("Right" , correctC);
        intent.putExtra("WroungA" , wrongC);
        startActivity(intent);
        finish();
    }

    private void showTimeOutDialog() {
        Dialog dialog = new Dialog(DashBordActivity.this);
        dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
        dialog.setContentView(R.layout.time_out_d);
        dialog.setCancelable(false);
        dialog.findViewById(R.id.try_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashBordActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        dialog.show();
    }

    private void enableCardClicks() {
        o1_card.setClickable(true);
        o2_card.setClickable(true);
        o3_card.setClickable(true);
        o4_card.setClickable(true);
    }

    private void disableCardClicks() {
        o1_card.setClickable(false);
        o2_card.setClickable(false);
        o3_card.setClickable(false);
        o4_card.setClickable(false);
    }

    private void resetCardColors() {
        o1_card.setCardBackgroundColor(getResources().getColor(R.color.white));
        o2_card.setCardBackgroundColor(getResources().getColor(R.color.white));
        o3_card.setCardBackgroundColor(getResources().getColor(R.color.white));
        o4_card.setCardBackgroundColor(getResources().getColor(R.color.white));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (count != null) {
            count.cancel();
        }
    }
}
