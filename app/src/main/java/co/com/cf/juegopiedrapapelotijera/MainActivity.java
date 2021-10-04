package co.com.cf.juegopiedrapapelotijera;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView imgAndroid;
    private TextView tvResultado;

    private Button btnJugar;
    private Spinner spElementos;
    private ImageView imgJugador;
    private TextView tvSelecionCel;

    int seleccionCelular,selecionJugador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgAndroid = (ImageView) findViewById(R.id.imgAndroid);
        tvResultado = (TextView) findViewById(R.id.tvResultado);
        tvResultado.setText("");

        btnJugar = (Button) findViewById(R.id.btnJugar);
        btnJugar.setOnClickListener(this);
        spElementos = (Spinner) findViewById(R.id.spElementos);
        imgJugador=(ImageView) findViewById(R.id.imgJugador);
        tvSelecionCel= (TextView) findViewById(R.id.tvSelecionCel);
        tvSelecionCel.setText("");

        spElementos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(adapterView.getContext(), (String) adapterView.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
                selecionJugador=position;
                switch (position){
                    case 1:
                        imgJugador.setImageResource(R.drawable.ic_piedra);
                        break;
                    case 2:
                        imgJugador.setImageResource(R.drawable.ic_tijera);
                        break;
                    case 3:
                        imgJugador.setImageResource(R.drawable.ic_papel);
                        break;
                    default:
                        imgJugador.setImageResource(0);
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // vacio

            }
        });


    }


    @Override
    public void onClick(View v) {    // Botón Jugar
        if (v.getId() == R.id.btnJugar) {//
            obtenerImagenAndroid();

            tvResultado.setText("");

            if(seleccionCelular==selecionJugador)
            {
                tvResultado.setText("EMPATE");
            }
            if(selecionJugador<seleccionCelular){
                if(selecionJugador==1 && seleccionCelular==3){
                    tvResultado.setText("Ganó la Maquina");
                }else{
                    tvResultado.setText("Tu Ganaste");
                }
            }
            if(seleccionCelular<selecionJugador){
                if(seleccionCelular==1 &&selecionJugador ==3){
                    tvResultado.setText("Tu Ganaste");
                }else{
                    tvResultado.setText("Gana la Máquina");
                }
            }
//           String men;
//            men=tvResultado.getText().toString();
//            tvResultado.setText(men + " Celular:"+seleccionCelular+" Humano: "+selecionJugador);
            //Toast.makeText(this, "Aleatorio: "+ seleccionCelular, Toast.LENGTH_SHORT).show();
        }
    }

    private void obtenerImagenAndroid() {
        Random r = new Random();
        int numAndroid = r.nextInt(3) + 1;
        seleccionCelular=numAndroid;
        switch (numAndroid) {
            case 1:
                imgAndroid.setImageResource(R.drawable.ic_piedra);
                tvSelecionCel.setText("Piedra");
                break;
            case 2:
                imgAndroid.setImageResource(R.drawable.ic_tijera);
                tvSelecionCel.setText("Tijera");
                break;
            case 3:
                imgAndroid.setImageResource(R.drawable.ic_papel);
                tvSelecionCel.setText("Papel");
                break;
        }



    }


}