import java.time.Duration;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Call {
    private final LocalDateTime from;
    private final LocalDateTime to;

    public Duration getDuration() {
        return Duration.between(from, to);
    }
}
