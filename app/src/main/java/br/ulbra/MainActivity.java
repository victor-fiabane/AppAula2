package br.ulbra;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText edtQuant, edtNum, edtEvent;
    TextView txResult;
    Button btnCalc;
    double vNum, calc;
    int vQuant;
    String evento;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtEvent = (EditText) findViewById(R.id.editEvent);
        edtQuant = (EditText) findViewById(R.id.editQuant);
        edtNum = (EditText) findViewById(R.id.editNum);
        txResult = (TextView) findViewById(R.id.txtResult);
    }
    public void calcular(View view){
        DecimalFormat f= new DecimalFormat("0.00");
        evento = edtEvent.getText().toString();
        vQuant = Integer.parseInt(edtQuant.getText().toString());
        vNum = Double.parseDouble(edtNum.getText().toString());
        calc = vNum / vQuant;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //define o titulo
        builder.setTitle("Titulo"); 
        //define a mensagem
        builder.setMessage("Valor por pessoa: R$"+f.format(calc));
        builder.setNeutralButton("OK",null);
        builder.show();
        txResult.setText("O evento "+evento+" terá como valor principal R$"+vNum+" rachado entre "+vQuant+"\n cada um paga R$ "+f.format(calc));

    }
}