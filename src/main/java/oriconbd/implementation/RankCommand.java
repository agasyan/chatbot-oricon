package oriconbd.implementation;

import com.linecorp.bot.model.message.TextMessage;
import java.io.IOException;

public interface RankCommand {
    public TextMessage run(String date) throws IOException;
}
