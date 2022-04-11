import java.time.Duration;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RegularPhone extends Phone{

    private final Money amount;
    private final Duration seconds;

    @Override
    protected Money calculateCallFee(Call call) {
        return amount.times(call.getDuration().getSeconds() / seconds.getSeconds());
    }
}
