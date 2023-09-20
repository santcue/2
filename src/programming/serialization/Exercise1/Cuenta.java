package programming.serialization.Exercise1;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Cuenta implements Serializable {

    private String numeroCuenta;
    private String pin;
    private double saldo;
    private Map<String, Double> depositoConCheque;

    public Cuenta(String numeroCuenta, String pin, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.pin = pin;
        this.saldo = saldo;
        this.depositoConCheque = new HashMap<>();
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public boolean validarPin(String inputPIN) {
        return pin.equals(inputPIN);
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double monto) {
        saldo += monto;
    }

    public void retirar(double monto) {
        saldo -= monto;
    }

    public void registrarDepositoConCheque(String numeroCheque, double monto) {
        depositoConCheque.put(numeroCheque, monto);
    }

    public Map<String, Double> getDepositoConCheque() {
        return depositoConCheque;
    }

    public void trasnferir(Cuenta destino, double monto) {
        if (saldo >= monto) {
            saldo -= monto;
            destino.depositar(monto);
        }
    }



}
