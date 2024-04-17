package services;

import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    public double shippingService(double basic){
        if (basic < 100.0) {
            return 20.0;
        }
        else if (basic > 100.0 && basic < 200.0){
            return 12.0;
        }
        else
            return 0.0;

    }
}
