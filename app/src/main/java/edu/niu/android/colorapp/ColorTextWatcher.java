/************************************************************************
 *   CSCI 322/522                Assignment 3                Fall 2023   *
 *                                                                       *
 *   App Name: ColorApp                                                  *
 *                                                                       *
 *   Class Name: ColorTextWatcher                                        *
 *                                                                       *
 *   Developer(s): Alexander Bertolasi, Dominic Brooks                   *
 *                                                                       *
 *   Due Date: 10/06/2023                                                *
 *                                                                       *
 *   Purpose: The ColorTextWatcher class is responsible for monitoring   *
 *            changes in the text input of three EditText fields         *
 *            (red, green, and blue color components) in the Android app.*
 ************************************************************************/
package edu.niu.android.colorapp;

import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.view.View;

/*****************************************************************************************
 *                                                                                       *
 * TextWatcher class to monitor changes in the red, green, and blue EditText fields.     *
 * It clamps the input values to a valid color range (0-255) and updates the color label.*
 *                                                                                       *
 ****************************************************************************************/
public class ColorTextWatcher implements TextWatcher {
    // Reference to the color label View
    private View colorLabel;

    // References to EditText fields for red, green, and blue values
    private EditText redField, greenField, blueField;

    /*****************************************************************************************
     * ColorTextWatcher constructor that sets up a ColorTextWatcher instance                 *
     * for monitoring and handling color-related input fields.                               *
     * It takes references to the colorLabel, redField, greenField, and blueField,           *
     * which are used for color representation and input.                                    *
     *                                                                                       *
     * @param colorLabel The View element used to display the resulting color.               *
     * @param redField   The EditText field for entering the red component of the color.     *
     * @param greenField The EditText field for entering the green component of the color.   *
     * @param blueField  The EditText field for entering the blue component of the color.    *
     * @return A ColorTextWatcher instance for color input handling.                         *
     *****************************************************************************************/
    public ColorTextWatcher(View colorLabel, EditText redField, EditText greenField, EditText blueField) {
        this.colorLabel = colorLabel;
        this.redField = redField;
        this.greenField = greenField;
        this.blueField = blueField;
    }
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        // Not used in this context
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        // Not used in this context
    }

    @Override
    public void afterTextChanged(Editable editable) {
        // Parse and clamp the red, green, and blue values
        int red = parseAndClamp(redField);
        int green = parseAndClamp(greenField);
        int blue = parseAndClamp(blueField);

        // Set the background color of the colorLabel View
        colorLabel.setBackgroundColor(Color.rgb(red, green, blue));
    }

    /******************************************************************************
     * Helper method to parse and clamp an EditText input to a valid color value. *
     *                                                                            *
     * @param editText The EditText containing the color value.                   *
     * @return The clamped color value between 0 and 255.                         *
     *****************************************************************************/
    private int parseAndClamp(EditText editText) {
        try {
            // Parse the text in the EditText as an integer
            int value = Integer.parseInt(editText.getText().toString());

            // Clamp the value to the range [0, 255]
            return Math.min(255, Math.max(0, value));
        } catch (NumberFormatException e) {
            // Handle invalid input by returning 0 (black)
            return 0;
        }
    }
}