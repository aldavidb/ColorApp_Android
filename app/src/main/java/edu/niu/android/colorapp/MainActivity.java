/************************************************************************
 *   CSCI 322/522                Assignment 3                Fall 2023   *
 *                                                                       *
 *   App Name: ColorApp                                                  *
 *                                                                       *
 *   Class Name: MainActivity                                            *
 *                                                                       *
 *   Developer(s): Alexander Bertolasi, Dominic Brooks                   *
 *                                                                       *
 *   Due Date: 10/06/2023                                                *
 *                                                                       *
 *   Purpose: This MainActivity class serves as the entry point          *
 *            of the Android app. It initializes the layout              *
 *            and displays the dynamic view with 3 text fields           *
 *            on a landscape screen.                                     *
 ************************************************************************/
package edu.niu.android.colorapp;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Reference to the color label View
    private View colorLabel;

    // References to EditText fields for red, green, and blue values
    private EditText redField, greenField, blueField;

    /************************************************************************
     *                                                                      *
     * onCreate Initializes the activity's user interface and layout.       *
     *                                                                      *
     ************************************************************************/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize references to UI elements
        colorLabel = findViewById(R.id.color_label);
        redField = findViewById(R.id.red_field);
        greenField = findViewById(R.id.green_field);
        blueField = findViewById(R.id.blue_field);

        // Create a ColorTextWatcher instance and attach it to the EditText fields
        ColorTextWatcher textWatcher = new ColorTextWatcher(colorLabel, redField, greenField, blueField);

        // Add TextWatcher to each EditText to monitor text changes
        redField.addTextChangedListener(textWatcher);
        greenField.addTextChangedListener(textWatcher);
        blueField.addTextChangedListener(textWatcher);
    }
}