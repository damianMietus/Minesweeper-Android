package comdamianmietus.httpsgithub.minesweep;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.graphics.Color.CYAN;
import static android.graphics.Color.TRANSPARENT;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button[][] buttons = new Button[8][8];

    private int mineCount;
    private TextView textViewPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewPlayer = findViewById(R.id.text_view_p1);

        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                String buttonID  = "button_" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = findViewById(resID);
                buttons[i][j].setOnClickListener(this);
            }
        }

        Button buttonReset = findViewById(R.id.button_reset);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

            }
        });
    }

    @Override
    public void onClick(View v) {
        if (!((Button) v).getText().toString().equals("")){
            return;
        }

        ((Button) v).setText("x");
        ((Button) v).setBackgroundColor(TRANSPARENT);

        textViewPlayer.setText("Remaining Mines: 0");

    }
}
