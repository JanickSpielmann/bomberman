package application.client.control.server2client;

import application.client.model.Game;
import application.client.view.BombermanPanel;
import network.client.ServerProxy;
import protocol.server2client.BombExploded;

public class BombExplodedControl extends ServerToClientControl<BombExploded> {
    public BombExplodedControl(ServerProxy serverProxy, Game game, BombermanPanel view) {
        super(serverProxy, game, view);
    }

    @Override
    public void handleMessage(BombExploded message) {
        game.removeBomb(message.id());
        view.update();
    }
}
