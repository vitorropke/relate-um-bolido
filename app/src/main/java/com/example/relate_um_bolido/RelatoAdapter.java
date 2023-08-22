package com.example.relate_um_bolido;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class RelatoAdapter extends RecyclerView.Adapter<RelatoAdapter.MyViewHolder> {

    Activity activity;
    private final Context context;
    private final ArrayList<Relato> relatos;

    public RelatoAdapter(Activity activity, Context context, ArrayList<Relato> relatos) {
        this.activity = activity;
        this.context = context;
        this.relatos = relatos;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView campoId;
        TextView campoLatitude;
        TextView campoLongitude;
        TextView campoAzimuteInicial;
        TextView campoElevacaoInicial;
        TextView campoAzimuteFinal;
        TextView campoElevacaoFinal;
        TextView campoDuracao;
        TextView campoMagnitude;
        TextView campoData;
        TextView campoHora;
        LinearLayout linearLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            campoId = itemView.findViewById(R.id.campo_id);
            campoLatitude = itemView.findViewById(R.id.campo_latitude);
            campoLongitude = itemView.findViewById(R.id.campo_longitude);
            campoAzimuteInicial = itemView.findViewById(R.id.campo_azimute_inicial);
            campoElevacaoInicial = itemView.findViewById(R.id.campo_elevacao_inicial);
            campoAzimuteFinal = itemView.findViewById(R.id.campo_azimute_final);
            campoElevacaoFinal = itemView.findViewById(R.id.campo_elevacao_final);
            campoDuracao = itemView.findViewById(R.id.campo_duracao);
            campoMagnitude = itemView.findViewById(R.id.campo_magnitude);
            campoData = itemView.findViewById(R.id.campo_data);
            campoHora = itemView.findViewById(R.id.campo_hora);

            linearLayout = itemView.findViewById(R.id.linha_tabela_relatos);
        }

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.linha_da_lista_de_relatos, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RelatoAdapter.MyViewHolder holder, int position) {
        Calendar calendar = relatos.get(position).getDataHora();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault());
        String data = simpleDateFormat.format(calendar.getTime());
        simpleDateFormat.applyPattern("HH:mm");
        String hora = simpleDateFormat.format(calendar.getTime());

        holder.campoId.setText(String.valueOf(relatos.get(position).getId()));
        holder.campoLatitude.setText(String.valueOf(relatos.get(position).getLatitude()));
        holder.campoLongitude.setText(String.valueOf(relatos.get(position).getLongitude()));
        holder.campoAzimuteInicial.setText(String.valueOf(relatos.get(position).getAzimuteInicial()));
        holder.campoElevacaoInicial.setText(String.valueOf(relatos.get(position).getElevacaoInicial()));
        holder.campoAzimuteFinal.setText(String.valueOf(relatos.get(position).getAzimuteFinal()));
        holder.campoElevacaoFinal.setText(String.valueOf(relatos.get(position).getElevacaoFinal()));
        holder.campoDuracao.setText(String.valueOf(relatos.get(position).getDuracao()));
        holder.campoMagnitude.setText(String.valueOf(relatos.get(position).getMagnitude()));
        holder.campoData.setText(data);
        holder.campoHora.setText(hora);

        holder.linearLayout.setOnClickListener(view -> {
            Intent intent = new Intent(context, EdicaoActivity.class);
            intent.putExtra("id", relatos.get(position).getId());
            intent.putExtra("latitude", relatos.get(position).getLatitude());
            intent.putExtra("longitude", relatos.get(position).getLongitude());
            intent.putExtra("data_hora", relatos.get(position).getDataHora().getTimeInMillis());
            intent.putExtra("azimute_inicial", relatos.get(position).getAzimuteInicial());
            intent.putExtra("elevacao_inicial", relatos.get(position).getElevacaoInicial());
            intent.putExtra("azimute_final", relatos.get(position).getAzimuteFinal());
            intent.putExtra("elevacao_final", relatos.get(position).getElevacaoFinal());
            intent.putExtra("duracao", relatos.get(position).getDuracao());
            intent.putExtra("magnitude", relatos.get(position).getMagnitude());
            intent.putExtra("cor", relatos.get(position).getCor());
            intent.putExtra("som", relatos.get(position).hasSom());
            intent.putExtra("rastro", relatos.get(position).hasRastro());
            intent.putExtra("explosao", relatos.get(position).hasExplosao());
            intent.putExtra("observacoes", relatos.get(position).getObservacoes());
            activity.startActivityForResult(intent, 1);
        });
    }

    @Override
    public int getItemCount() {
        return relatos.size();
    }

}
