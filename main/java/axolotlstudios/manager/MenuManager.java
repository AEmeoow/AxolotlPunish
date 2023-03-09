package axolotlstudios.manager;

import lombok.Getter;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class MenuManager {

    @Getter private final Map<Player, OfflinePlayer> targetPlayer = new HashMap<>();

}
