package com.example.lab2;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText inputEditText;
    private Spinner countTypeSpinner;
    private Button countButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.inputEditText = findViewById(R.id.inputEditText);
        this.countTypeSpinner = findViewById(R.id.countTypeSpinner);
        this.countButton = findViewById(R.id.countButton);
        this.resultTextView = findViewById(R.id.resultTextView);

        setupSpinner();

        countButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countWordsOrChars();
            }
        });
    }

    private void setupSpinner() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.selection_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.countTypeSpinner.setAdapter(adapter);
    }

    private void countWordsOrChars() {
        String userText = this.inputEditText.getText().toString().trim();

        if (userText.isEmpty()) {
            showToast(getString(R.string.empty_text_warning));
            this.resultTextView.setText("");
            return;
        }

        String selectedCountType = this.countTypeSpinner.getSelectedItem().toString();
        WordCounter wordCounter = new WordCounter();

        int count;
        if (selectedCountType.equals("Words")) {
            count = wordCounter.countWords(userText);
        } else {
            count = wordCounter.countCharacters(userText);
        }

        String resultText = count + " " + selectedCountType;
        this.resultTextView.setText(resultText);
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
