package com.example.hector.dialogosandroid;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    int dia, mes, año, hora, minutos;

    private Button botonFecha;
    private Button botonHora;
    private Button botonColor;
    private TextView fechita;
    private TextView horita;
    private TextView colorito;

    DatePickerDialog dialogoFecha;
    TimePickerDialog dialogoHora;
    AlertDialog.Builder dialogoColores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonFecha = (Button) findViewById(R.id.btnCambiaFecha);
        botonHora = (Button) findViewById(R.id.btnCambiahora);
        botonColor = (Button) findViewById(R.id.btnCambiaColor);
        fechita = (TextView) findViewById(R.id.fecha);
        horita = (TextView) findViewById(R.id.Hora);
        colorito = (TextView) findViewById(R.id.color);

        dialogoFecha = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                fechita.setText("Fecha: " + dayOfMonth + "/" + (month +1)   + "/" + year);
            }
        },0,0,0);

        botonFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogoFecha.show();
            }
        });

        dialogoHora = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                String minutosPantalla = "";
                if (minute < 10){
                    minutosPantalla = "0" + minute;
                } else {
                    minutosPantalla = "" + minute;
                }

                horita.setText("Hora: " + hourOfDay + ":" + minutosPantalla);
            }
        }, 00,00,false);

        botonHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogoHora.show();
            }
        });

        final String[] colors_array = new String[3];
        colors_array[0] = "Azul";
        colors_array[1] = "Verde";
        colors_array[2] = "Rojo";

        dialogoColores = new AlertDialog.Builder(this);
        dialogoColores.setTitle("Selecciona un color")
                .setItems(colors_array, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        colorito.setText("Color: " + colors_array[which]);
                    }
                });
        dialogoColores.create();

        botonColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogoColores.show();
            }
        });

    }

}
