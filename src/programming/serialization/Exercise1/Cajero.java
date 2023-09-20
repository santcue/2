package programming.serialization.Exercise1;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class Cajero {

    private Map<String, Cuenta> cuentas;
    private int intentosFallidos;

    public Cajero() {
        cuentas = new HashMap<>();
        cuentas.put("123456789", new Cuenta("123456789", "1234", 1000));
    }

    public void iniciarSesion() {
        JOptionPane.showMessageDialog(null, "Bienvenido al cajero");

        while(true) {
            String documento = JOptionPane.showInputDialog("Ingrese su documento");
            String pin = JOptionPane.showInputDialog("Ingrese su PIN");

            if (validarPIN(documento, pin)) {
                mostrarMenu(documento);
                break;
            } else {
                intentosFallidos++;
                JOptionPane.showMessageDialog(null, "Documento o PIN incorrecto. Intentos Fallidos:" + intentosFallidos);
                if (intentosFallidos >= 3) {
                    JOptionPane.showMessageDialog(null, "Ha alcanzado el limite de intentos fallidos");
                    break;
                }
            }
        }
    }

    private boolean validarPIN(String documento, String pin) {
        Cuenta cuenta = cuentas.get(documento);
        return cuenta != null && cuenta.validarPin(pin);
    }

    private void mostrarMenu(String documento) {
        while (true) {
            String[] opciones = { "Retiro de dinero", "Deposito de dinero", "Transferencia de dinero", "Consultar saldo", "Salir" };
            int seleccion = JOptionPane.showOptionDialog(null, "Seleccione una opcion", "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);

            switch (seleccion) {
                case 0:
                    retirar(documento);
                    break;
                case 1:
                    depositar(documento);
                    break;
                case 2:
                    transferir(documento);
                    break;
                case 3:
                    consultarSaldo(documento);
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Gracias por usar el cajero");
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion invalida");
            }
        }
    }

    private void retirar(String documento) {
        Cuenta cuenta = cuentas.get(documento);
        if (cuenta != null) {
            double saldoActual = cuenta.getSaldo();
            String montoStr = JOptionPane.showInputDialog("Ingrese el monto a retirar (en multiplos de $50.000)");
            try {
                double monto = Double.parseDouble(montoStr);
                if (monto % 50000 == 0 && monto <= saldoActual) {
                    cuenta.retirar(monto);
                    JOptionPane.showMessageDialog(null, "Retiro exitoso su saldo actual es " + cuenta.getSaldo());
                } else {
                    JOptionPane.showMessageDialog(null, "Monto invalido o saldo insuficiente");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Monto invalido");
            }
        }
    }

    private void depositar(String documento) {
        Cuenta cuenta = cuentas.get(documento);
        if (cuenta != null) {
            String montoStr = JOptionPane.showInputDialog("Ingrese el monto a depositar");
            try {
                double monto = Double.parseDouble(montoStr);
                if (monto > 0) {
                    String[] opciones = { "Efectivo", "Cheque" };
                    int seleccion = JOptionPane.showOptionDialog(null, "Seleccione una opcion", "Tipo de deposito", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
                    if (seleccion == 0) {
                        cuenta.depositar(monto);
                        JOptionPane.showMessageDialog(null, "Deposito exitoso su saldo actual es " + cuenta.getSaldo());
                    } else if (seleccion == 1) {
                        String numeroCheque = JOptionPane.showInputDialog("Ingrese el numero de cheque");
                        if (numeroCheque != null && !numeroCheque.isEmpty()) {
                            cuenta.registrarDepositoConCheque(numeroCheque, monto);
                            JOptionPane.showMessageDialog(null, "Deposito exitoso su saldo actual es " + cuenta.getSaldo());
                        } else {
                            JOptionPane.showMessageDialog(null, "Numero de cheque invalido");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Opcion invalida");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Monto invalido");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Monto invalido");
            }
        }
    }

    private void transferir(String documento) {
        Cuenta cuentaOrigen = cuentas.get(documento);
        if (cuentaOrigen != null) {
            String montoStr = JOptionPane.showInputDialog("Ingrese el monto a transferir:");
            try {
                double monto = Double.parseDouble(montoStr);
                if (monto > 0) {
                    String numeroCuentaDestino = JOptionPane.showInputDialog("Ingrese el número de cuenta de destino:");
                    Cuenta cuentaDestino = cuentas.get(numeroCuentaDestino);

                    if (cuentaDestino != null) {
                        if (cuentaOrigen.getSaldo() >= monto) {
                            cuentaOrigen.retirar(monto);
                            cuentaDestino.depositar(monto);
                            JOptionPane.showMessageDialog(null, "Transferencia exitosa. Nuevo saldo: $" + cuentaOrigen.getSaldo());
                        } else {
                            JOptionPane.showMessageDialog(null, "Saldo insuficiente para la transferencia.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "La cuenta de destino no existe.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese un monto válido.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un monto válido.");
            }
        }
    }

    private void consultarSaldo(String documento) {
        Cuenta cuenta = cuentas.get(documento);
        if (cuenta != null) {
            double saldoActual = cuenta.getSaldo();
            JOptionPane.showMessageDialog(null, "Saldo actual: $" + saldoActual);
        }
    }
}
