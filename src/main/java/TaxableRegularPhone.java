import java.time.Duration;
import lombok.RequiredArgsConstructor;

public class TaxableRegularPhone extends RegularPhone {
    private final double taxRate;

    public TaxableRegularPhone(Money amount, Duration seconds, double taxRate) {
        super(amount, seconds);
        this.taxRate = taxRate;
    }

    @Override
    public Money calculateFee() {
        Money fee = super.calculateFee();
        return fee.plus(fee.times(taxRate));
    }

}
