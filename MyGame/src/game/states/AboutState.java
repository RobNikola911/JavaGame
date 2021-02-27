package game.states;

import game.Handler;
import gfx.Assets;
import gfx.ClickListener;
import gfx.ui.AboutManager;
import gfx.ui.UIImageButton;
import gfx.ui.UIImageWallpaper;
import gfx.ui.UIManager;
import java.awt.Graphics;

public class AboutState extends State {

  private AboutManager aboutManager;
  private UIManager uiManager;

  public AboutState(Handler handler) {
    super(handler);
    this.aboutManager = new AboutManager(handler);
    this.uiManager = handler.getMouseManager().getUiManager();
    handler.getMouseManager().setAboutManager(aboutManager);

    this.aboutManager
        .addObject(new UIImageWallpaper(0, 0, 999, 556,
            Assets.getMenuElement("startScreen")));

    this.aboutManager
        .addObject(new UIImageWallpaper(0, 0, 999, 556,
            Assets.getMenuElement("infoTeam")));

    this.aboutManager.addObject(
        new UIImageButton(800, 470, 198, 91, Assets.getMenuElement("btn_back"),
            new ClickListener() {
              @Override
              public void onClick() {
                State.setState(handler.getGame().getMenuState());
                handler.getMouseManager().setUIManager(uiManager);
              }
            }));
  }

  @Override
  public void tick() {
//        this.aboutManager.tick();
  }

  @Override
  public void render(Graphics g) {
    this.aboutManager.render(g);
  }
}
