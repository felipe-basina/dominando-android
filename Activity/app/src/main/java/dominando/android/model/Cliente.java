package dominando.android.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Felipe on 10/07/2017.
 */

public class Cliente implements Parcelable {

    public int codigo;
    public String nome;

    public Cliente(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    private Cliente(Parcel from) {
        codigo = from.readInt();
        nome = from.readString();
    }

    public static final Parcelable.Creator<Cliente> CREATOR = new Parcelable.Creator<Cliente>() {

        @Override
        public Cliente createFromParcel(Parcel parcel) {
            return new Cliente(parcel);
        }

        @Override
        public Cliente[] newArray(int size) {
            return new Cliente[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(codigo);
        dest.writeString(nome);
    }
}
