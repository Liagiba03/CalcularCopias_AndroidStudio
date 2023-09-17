package com.edu.papeleria.model;

public class TotalPago {
    private int copias;
    public String cliente;
    private String tipoPago;

    public void setCopias(int copias) {
        this.copias = copias;
    }
    public void setTipoPago(String tipoPago){
        this.tipoPago = tipoPago;
    }

    public int getCopias() {
        return copias;
    }

    public String calcularTotal() {
        double total=0;
        double recargo=0;
        if(copias<=50) {
            total = copias * 0.50;
        }else if(copias<=100) {
            total = (50*0.50) + ((copias - 50) * 0.40);
        }else{
            total = (50*0.50) + (50*0.40) + ((copias - 100) * 0.30);
        }
        if(tipoPago.equals("Tarjeta")){
            recargo = total*0.3;
            total +=recargo;
            return "Cliente: " + cliente +
                    "\nNo. Copias: " + copias +
                    "\nTotal a pagar: $" + total+
                    "\nPagado con: "+tipoPago+
                    "\nRecargo: "+recargo;
        }else{
            return "Cliente: " + cliente +
            "\nNo. Copias: " + copias +
                    "\nTotal a pagar: $" + total+
                    "\nPagado con: "+tipoPago;
        }

    }
}
