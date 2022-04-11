import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.Test;

public class PhoneTest {

    private static Call FIXTURE_CALL = new Call(LocalDateTime.now().minusMinutes(1), LocalDateTime.now());

    @Test
    public void nightlyDiscountPhone_calculateFeeTest() {
        var phone = new NightlyDiscountPhone(Money.wons(1000), Money.wons(10), Duration.ofSeconds(10));
        var fee = phone.calculateCallFee(FIXTURE_CALL);
        System.out.println(fee.getAmount());
        assertEquals(BigDecimal.valueOf(60.0), fee.getAmount());
    }

    @Test
    public void regularPhone_calculateFeeTest() {
        var phone = new RegularPhone(Money.wons(1000), Duration.ofSeconds(10));
        var fee = phone.calculateCallFee(FIXTURE_CALL);

        System.out.println(fee.getAmount());
        assertEquals(BigDecimal.valueOf(6000.0), fee.getAmount());
    }

    @Test
    public void texableRegularPhone_calculateFeeTest() {
        var phone = new TaxableRegularPhone(Money.wons(1000), Duration.ofSeconds(10), 0.2);
        phone.setCalls(List.of(FIXTURE_CALL));
        var fee = phone.calculateFee();
        System.out.println(fee.getAmount());
        assertEquals(new BigDecimal("7200.00"), fee.getAmount());
    }
}
