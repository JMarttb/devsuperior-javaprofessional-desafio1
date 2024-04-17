package com.devsuperior.desafioum;

import entities.Order;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import services.OrderService;
import services.ShippingService;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class DesafioumApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioumApplication.class, args);

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("ENTRADA (dados do pedido: código, valor básico e porcentagem de desconto)" );

		//SOLICITAR ENTRADAS COMO EXEMPLDO DO PDF
		int code = sc.nextInt();
		double basic = sc.nextDouble();
		double discount = sc.nextDouble();

		//CRIAR UM PEDIDO COM OS DADOS DO USUÁRIO
		Order order = new Order(code, basic,discount);

		//INSTANCIAR OrderService***
		OrderService orderService = new OrderService(new ShippingService());

		//CALCULAR O VALOR FINAL SOB O NOME valorTotal.
		//essa linha de código está chamando o método calculoValorTotal do orderService e armazenando o valor retornado desse método na variável valorTotal.
		double valorTotal = orderService.calculoValorFinal(order);

		//IMPRESSÃO
		System.out.println("Pedido código " + order.getCode());
		System.out.printf("Valor total: R$ %.2f\n", valorTotal);

		sc.close();


	}




}
