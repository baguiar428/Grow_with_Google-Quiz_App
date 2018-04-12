package com.example.android.quizapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0;
    private EditText nameField;
    private RadioGroup ldlRadioGroup;
    private RadioGroup hdlRadioGroup;
    private CheckBox fadDietsCheckBox;
    private CheckBox calorieDeficitCheckBox;
    private CheckBox bodyWrapsCheckBox;
    private CheckBox exerciseCheckBox;
    private CheckBox restCheckBox;
    private CheckBox gatoradeCheckBox;
    private CheckBox sugarCheckBox;
    private CheckBox proteinCheckBox;
    private EditText answerField5;
    private EditText answerField6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameField = findViewById(R.id.name_field);
        ldlRadioGroup = findViewById(R.id.ldl_radiogroup);
        hdlRadioGroup = findViewById(R.id.hdl_radiogroup);
        fadDietsCheckBox = findViewById(R.id.fad_diets_checkbox);
        calorieDeficitCheckBox = findViewById(R.id.calorie_deficit_checkbox);
        bodyWrapsCheckBox = findViewById(R.id.body_wraps_checkbox);
        exerciseCheckBox = findViewById(R.id.exercise_checkbox);
        restCheckBox = findViewById(R.id.rest_checkbox);
        gatoradeCheckBox = findViewById(R.id.gatorade_checkbox);
        sugarCheckBox = findViewById(R.id.sugar_checkbox);
        proteinCheckBox = findViewById(R.id.protein_checkbox);
        answerField5 = findViewById(R.id.ques_5_answer);
        answerField6 = findViewById(R.id.ques_6_answer);
    }


    /**
     * This method is called when the SUBMIT button is clicked.
     * This is where all the classes are called to check/evaluate/calculate the quiz questions.
     */
    public void submitQuiz(View view) {

        String nameText = nameField.getText().toString();

        int question1Score = checkQuestion1();

        int question2Score = checkQuestion2();

        boolean hasFadDiets = fadDietsCheckBox.isChecked();

        boolean hasCalorieDeficit = calorieDeficitCheckBox.isChecked();

        boolean hasBodyWraps = bodyWrapsCheckBox.isChecked();

        boolean hasExcercise = exerciseCheckBox.isChecked();

        boolean hasRest = restCheckBox.isChecked();

        boolean hasGatorade = gatoradeCheckBox.isChecked();

        boolean hasSugar = sugarCheckBox.isChecked();

        boolean hasProtein = proteinCheckBox.isChecked();

        int checkBoxScore = calculateCheckBoxPoints(hasFadDiets, hasCalorieDeficit, hasBodyWraps, hasExcercise, hasRest, hasGatorade, hasSugar, hasProtein);

        String answer5Text = answerField5.getText().toString();
        int question5Score = checkQuestion5(answer5Text);

        String answer6Text = answerField6.getText().toString();
        int question6Score = checkQuestion6(answer6Text);

        score = question1Score + question2Score + checkBoxScore + question5Score + question6Score;


        Toast.makeText(this, "Hello, " + nameText + "\nYou scored " + score + " out of 8 points!", Toast.LENGTH_LONG).show();
    }

    /**
     * This method checks and scores Question #1
     * The correct answer is stored in "answer".The radiogroup is called and checks if what is
     * selected matches the same identifier as answer.
     *
     * @return is 1 or 0 points depending on if question was answered correctly or not.
     */

    private int checkQuestion1() {
        int question1Point = 0;
        int answer = R.id.ldl_false;

        int selected = ldlRadioGroup.getCheckedRadioButtonId();
        if (selected == answer) {
            question1Point += 1;
        }

        return question1Point;
    }

    /**
     * This method checks and scores Question #2
     * The correct answer is stored in "answer".The radiogroup is called and checks if what is
     * selected matches the same identifier as answer.
     *
     * @return is 1 or 0 points depending on if question was answered correctly or not.
     */

    private int checkQuestion2() {
        int question2Point = 0;
        int answer = R.id.hdl_true;

        int selected = hdlRadioGroup.getCheckedRadioButtonId();
        if (selected == answer) {
            question2Point += 1;
        }

        return question2Point;
    }

    /**
     * This method checks and scores the checkboxes that make up questions #3 - 4.
     * When a checkbox is checked the right answers get a point and wrong answers get nothing.
     *
     * @param addFadDiets       is if the "Fad Diets" box is checked or not.
     * @param addCalorieDeficit is if the "Calorie deficit" box is checked or not.
     * @param addBodyWraps      is if the "Body wraps" box is checked or not.
     * @param addExercise       is if the "Exercise" box is checked or not.
     * @param addRest           is if the "Rest" box is checked or not.
     * @param addGatorade       is if the "Gatorade" box is checked or not.
     * @param addSugar          is if the "Sugar" box is checked or not.
     * @param addProtein        is if the "Protein" box is checked or not.
     * @return the points scored by selecting the correct checkboxes.
     */

    private int calculateCheckBoxPoints(boolean addFadDiets, boolean addCalorieDeficit,
                                        boolean addBodyWraps, boolean addExercise,
                                        boolean addRest, boolean addGatorade,
                                        boolean addSugar, boolean addProtein) {
        int checkBoxPoints = 0;

        if (addFadDiets) {
//            Incorrect answer - Don't count
        }

        if (addCalorieDeficit) {
            checkBoxPoints += 1;
        }

        if (addBodyWraps) {
//            Incorrect answer - Don't count
        }

        if (addExercise) {
            checkBoxPoints += 1;
        }
        if (addRest) {
            checkBoxPoints += 1;
        }

        if (addGatorade) {
//            Incorrect answer - Don't count
        }

        if (addSugar) {
//            Incorrect answer - Don't count
        }

        if (addProtein) {
            checkBoxPoints += 1;
        } else {
//            Incorrect answer - Don't count
        }

        return checkBoxPoints;
    }

    /**
     * This method checks and scores Question #5
     *
     * @param question5Answer is the input answer of either A or B.
     * @return a point if the answer matches A. case is ignored.
     */

    private int checkQuestion5(String question5Answer) {
        int question5Point = 0;

        if ("a".equalsIgnoreCase(question5Answer)) {
            question5Point = 1;
        }
        return question5Point;
    }

    /**
     * This method checks and scores Question #6
     *
     * @param question6Answer is the input answer of either A or B.
     * @return a point if the answer matches B. case is ignored.
     */

    private int checkQuestion6(String question6Answer) {
        int question6Point = 0;

        if ("b".equalsIgnoreCase(question6Answer)) {
            question6Point = 1;
        }
        return question6Point;
    }
}
