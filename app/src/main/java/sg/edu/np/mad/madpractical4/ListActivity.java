package sg.edu.np.mad.madpractical4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        List<User> userList = generateRandomUsers(20);


    }

    private List<User> generateRandomUsers(int numberOfUsers) {
        List<User> userList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < numberOfUsers; i++) {
            String name = "User" + (i + 1);
            String description = "Description " + (i + 1);
            int id = i + 1;
            boolean followed = random.nextBoolean();

            User user = new User(name, description, id, followed);
            userList.add(user);
        }

        return userList;
    }

    private void showAlertDialog() {
        // Create an AlertDialog.Builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // Set the dialog title and message
        builder.setTitle("Profile");
        builder.setMessage("MADness");

        // Set the positive button and its click listener
        builder.setPositiveButton("View", (dialog, which) -> {
            // Create an Intent to start the MainActivity
            Intent intent = new Intent(this, MainActivity.class);
            // Start the MainActivity
            this.startActivity(intent);
            // Do something when the positive button is clicked
            dialog.dismiss();
        });

        // Set the negative button and its click listener
        builder.setNegativeButton("Close", (dialog, which) -> {
            // Do something when the negative button is clicked
            dialog.dismiss();
        });

        // Create and show the AlertDialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}