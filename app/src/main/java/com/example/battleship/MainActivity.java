package com.example.battleship;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final int ROWS = 8;
    private static final int COLS = 8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TableLayout tableLayout = findViewById(R.id.tblLayout);

        for (int row = 0; row < ROWS; row++) {
            TableRow tableRow = new TableRow(this);

            for (int col = 0; col < COLS; col++) {
                Button btn = new Button(this);

                // Generar el nombre de las casillas
                String cellLabel = (char) ('A' + row) + String.valueOf(col + 1);
                btn.setText(cellLabel);

                // Definir layout params para ajustar el tamaño del botón
                TableRow.LayoutParams params = new TableRow.LayoutParams(
                        TableRow.LayoutParams.MATCH_PARENT, // Ancho del botón
                        TableRow.LayoutParams.WRAP_CONTENT, // Alto del botón
                        1f // Peso para que todos los botones sean iguales
                );
                params.setMargins(4, 4, 4, 4); // Añadir márgenes entre los botones
                btn.setLayoutParams(params);

                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Button clickedButton = (Button) v;
                        String cellText = clickedButton.getText().toString();
                        Toast.makeText(MainActivity.this, "Casilla pulsada: " + cellText, Toast.LENGTH_SHORT).show();
                    }
                });
                tableRow.addView(btn);
            }
            tableLayout.addView(tableRow);
        }

    }
}