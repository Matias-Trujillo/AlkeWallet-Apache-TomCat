package AlkeWallet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class WalletController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Wallet wallet;

    public void init() throws ServletException {
        wallet = new Wallet();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        mostrarSaldo(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            if (action.equals("deposito")) {
                realizarDeposito(request, response);
            } else if (action.equals("retiro")) {
                realizarRetiro(request, response);
            }
        }
    }

    private void mostrarSaldo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("saldo", wallet.getSaldo());
        request.getRequestDispatcher("saldo.jsp").forward(request, response);
    }

    private void realizarDeposito(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int monto = Integer.parseInt(request.getParameter("monto"));
        wallet.depositar(monto);
        mostrarSaldo(request, response); // Después de depositar, mostrar el saldo actualizado
    }

    private void realizarRetiro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int monto = Integer.parseInt(request.getParameter("monto"));
        if (wallet.retirar(monto)) {
            mostrarSaldo(request, response);
        } else {
            request.setAttribute("mensaje", "Saldo insuficiente para realizar el retiro.");
            mostrarSaldo(request, response);
        }
    }
}


