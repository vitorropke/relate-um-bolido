package com.example.relate_um_bolido;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class CadastroActivity extends AppCompatActivity {

    EditText entradaLatitude;
    EditText entradaLongitude;
    EditText entradaData;
    EditText entradaHora;
    EditText entradaAzimuteInicial;
    EditText entradaElevacaoInicial;
    EditText entradaAzimuteFinal;
    EditText entradaElevacaoFinal;
    EditText entradaDuracao;
    EditText entradaMagnitude;
    EditText entradaCor;
    CheckBox entradaSom;
    CheckBox entradaRastro;
    CheckBox entradaExplosao;
    EditText entradaObservacoes;
    Button botaoCadastrarRelato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        entradaLatitude = findViewById(R.id.latitude);
        entradaLongitude = findViewById(R.id.longitude);
        entradaData = findViewById(R.id.data);
        entradaHora = findViewById(R.id.hora);
        entradaAzimuteInicial = findViewById(R.id.azimute_inicial);
        entradaElevacaoInicial = findViewById(R.id.elevacao_inicial);
        entradaAzimuteFinal = findViewById(R.id.azimute_final);
        entradaElevacaoFinal = findViewById(R.id.elevacao_final);
        entradaDuracao = findViewById(R.id.duracao);
        entradaMagnitude = findViewById(R.id.magnitude);
        entradaCor = findViewById(R.id.cor);
        entradaSom = findViewById(R.id.som);
        entradaRastro = findViewById(R.id.rastro);
        entradaExplosao = findViewById(R.id.explosao);
        entradaObservacoes = findViewById(R.id.observacoes);

        botaoCadastrarRelato = findViewById(R.id.botao_cadastrar_relato);
        botaoCadastrarRelato.setOnClickListener(view -> {
            Calendar calendar = Calendar.getInstance();
            /*
            SimpleDateFormat formatoData = new SimpleDateFormat("yyy-MM-dd", Locale.getDefault());
            SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm", Locale.getDefault());

            try {
                calendar.setTime(Objects.requireNonNull(formatoData.parse(entradaData.getText().toString())));
                calendar.se
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
             */

            Relato relato = new Relato();
            relato.setLatitude(Double.parseDouble(entradaLatitude.getText().toString()));
            relato.setLongitude(Double.parseDouble(entradaLongitude.getText().toString()));
            relato.setDataHora(calendar);
            relato.setAzimuteInicial(Integer.parseInt(entradaAzimuteInicial.getText().toString()));
            relato.setElevacaoInicial(Integer.parseInt(entradaElevacaoInicial.getText().toString()));
            relato.setAzimuteFinal(Integer.parseInt(entradaAzimuteFinal.getText().toString()));
            relato.setElevacaoFinal(Integer.parseInt(entradaElevacaoFinal.getText().toString()));
            relato.setDuracao(Integer.parseInt(entradaDuracao.getText().toString()));
            relato.setMagnitude(Integer.parseInt(entradaMagnitude.getText().toString()));
            relato.setCor(entradaCor.getText().toString());
            relato.setSom(entradaSom.isChecked());
            relato.setRastro(entradaRastro.isChecked());
            relato.setExplosao(entradaExplosao.isChecked());
            relato.setObservacoes(entradaObservacoes.getText().toString());

            BancoDadosHelper bancoDadosHelper = new BancoDadosHelper(CadastroActivity.this);
            bancoDadosHelper.cadastrarRelato(relato);
        });
    }

}
