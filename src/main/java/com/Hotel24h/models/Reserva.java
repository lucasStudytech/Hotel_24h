package com.Hotel24h.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reserva {

    private int id;
    private int idCliente;
    private int idQuarto;
    private Date dataCheckin;
    private Date dataCheckout;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdQuarto() {
        return idQuarto;
    }

    public void setIdQuarto(int idQuarto) {
        this.idQuarto = idQuarto;
    }

    public String getDataCheckin() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(dataCheckin);
    }

    public void setDataCheckin(String dataCheckin) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        this.dataCheckin = sdf.parse(dataCheckin);
    }

    public String getDataCheckout() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(dataCheckout);
    }

    public void setDataCheckout(String dataCheckout) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        this.dataCheckout = sdf.parse(dataCheckout);
    }

    @Override
    public String toString() {
        return "Reserva [id=" + id + ", idCliente=" + idCliente + ", idQuarto=" + idQuarto + ", dataCheckin="
                + dataCheckin + ", dataCheckout=" + dataCheckout + "]";
    }

}
