package view;

import javax.swing.JOptionPane;

import controller.RedesController;

public class Main {

	public static void main(String[] args) {
		RedesController redesController = new RedesController();
		int opc = Integer.parseInt(JOptionPane
				.showInputDialog("Digite a Opcao que deseja:\n1 - Metodo Ip\n2 - Metodo Ping\n 9 - Finalizar"));
		switch (opc) {
		case 1:
			redesController.callIp();
			break;
		case 2:
			redesController.callPing();
			break;
		case 9:
			JOptionPane.showMessageDialog(null, "Programa Finalizado");
			break;
		default:
			System.out.println("Opcao Invalida");
		}
	}

}
