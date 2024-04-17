package services;

import entities.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final ShippingService shippingService;

    //CONSTRUTOR
    public OrderService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    //CALCULAR O VALOR FINAL A PARTIR QUE DEPENDE DO ShippingService
    public double calculoValorFinal(Order order){
        double valorSemDesconto = order.getBasic();
        double desconto = order.getDiscount();
        double valorComDesconto = valorSemDesconto - (valorSemDesconto * (desconto/100));

        double frete = shippingService.shippingService(valorSemDesconto);
        return valorComDesconto + frete;
    }


}
