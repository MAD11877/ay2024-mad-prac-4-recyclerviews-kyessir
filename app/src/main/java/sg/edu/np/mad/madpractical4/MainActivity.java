package sg.edu.np.mad.madpractical4;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Find the TextView by its ID
        TextView myTextView = findViewById(R.id.textView2);

        // Generate a random integer
        Random random = new Random();
        int min = 100000; // minimum value
        int max = 999999; // maximum value

        int randomNumber = random.nextInt((max - min) + 1) + min;

        // Set the text with a name and the random number
        String name = "MAD";
        myTextView.setText(name + " " + randomNumber);

        // Find the Button by its ID
        Button followButton = findViewById(R.id.button);

        // Set an OnClickListener to handle the toggle logic
        followButton.setOnClickListener(v -> {
            // Get the current text of the button
            String currentText = followButton.getText().toString();

            // Toggle the text between "FOLLOW" and "UNFOLLOW"
            if (currentText.equals("FOLLOW")) {
                followButton.setText("UNFOLLOW");
            } else {
                followButton.setText("FOLLOW");
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}