package com.example.digitalhousefoods.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Restaurante implements Parcelable {

    private int imagem;
    private String nomeRestaurante;
    private String endereço;
    private String fechamento;

    public Restaurante () {

    }

    public Restaurante(int imagem, String nomeRestaurante, String endereço, String fechamento) {
        this.imagem = imagem;
        this.nomeRestaurante = nomeRestaurante;
        this.endereço = endereço;
        this.fechamento = fechamento;
    }

    protected Restaurante(Parcel in) {
        imagem = in.readInt();
        nomeRestaurante = in.readString();
        endereço = in.readString();
        fechamento = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imagem);
        dest.writeString(nomeRestaurante);
        dest.writeString(endereço);
        dest.writeString(fechamento);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Restaurante> CREATOR = new Creator<Restaurante>() {
        @Override
        public Restaurante createFromParcel(Parcel in) {
            return new Restaurante(in);
        }

        @Override
        public Restaurante[] newArray(int size) {
            return new Restaurante[size];
        }
    };

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String getNomeRestaurante() {
        return nomeRestaurante;
    }

    public void setNomeRestaurante(String nomeRestaurante) {
        this.nomeRestaurante = nomeRestaurante;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public String getFechamento() {
        return fechamento;
    }

    public void setFechamento(String fechamento) {
        this.fechamento = fechamento;
    }
}
