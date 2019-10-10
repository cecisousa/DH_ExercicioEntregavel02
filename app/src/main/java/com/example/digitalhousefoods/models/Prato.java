package com.example.digitalhousefoods.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Prato implements Parcelable {

    private int imagem;
    private String nomePrato;
    private String descricaoPrato;

    public Prato () {

    }

    public Prato(int imagem, String nomePrato, String descricaoPrato) {
        this.imagem = imagem;
        this.nomePrato = nomePrato;
        this.descricaoPrato = descricaoPrato;
    }

    protected Prato(Parcel in) {
        imagem = in.readInt();
        nomePrato = in.readString();
        descricaoPrato = in.readString();
    }

    public static final Creator<Prato> CREATOR = new Creator<Prato>() {
        @Override
        public Prato createFromParcel(Parcel in) {
            return new Prato(in);
        }

        @Override
        public Prato[] newArray(int size) {
            return new Prato[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imagem);
        dest.writeString(nomePrato);
        dest.writeString(descricaoPrato);
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String getNomePrato() {
        return nomePrato;
    }

    public void setNomePrato(String nomePrato) {
        this.nomePrato = nomePrato;
    }

    public String getDescricaoPrato() {
        return descricaoPrato;
    }

    public void setDescricaoPrato(String descricaoPrato) {
        this.descricaoPrato = descricaoPrato;
    }
}
