package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf_client = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		System.out.println("Entre com os dados do cliente: ");
		System.out.print("Nome: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Data de nascimento: ");
		
		Date birthDate = sdf_client.parse(sc.next());
		
		Client client = new Client(name,email,birthDate);
		
		
		//List<OrderItem> items = new ArrayList<>();
		Order pedido = new Order(new Date(),OrderStatus.PENDING_PAYMENT,client);
		System.out.print("Quantos itens para este pedido?\n");
		int n = sc.nextInt();
		sc.nextLine();
		for(int i = 0; i < n ; i++) {
			
			System.out.println("Entre com os dados do item #"+(int)(i+1));
			System.out.print("Nome do produto: ");
			String productName = sc.nextLine();
			System.out.print("Preco do produto: ");
			double productPrice = sc.nextDouble();
			System.out.print("Quantidade do produto: ");
			int productQuantity = sc.nextInt();
			OrderItem item = new OrderItem(productQuantity,
							productPrice,
							new Product(productName,productPrice));
			pedido.addItem(item);
			sc.nextLine();
		}
		
		System.out.println(pedido);
		
		sc.close();
	}

}
