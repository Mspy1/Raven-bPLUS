package keystrokesmod.client.clickgui.raven.components;

import keystrokesmod.client.clickgui.raven.Component;
import keystrokesmod.client.main.Raven;
import keystrokesmod.client.module.setting.impl.ComboSetting;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

import java.awt.*;

public class ModeComponent implements Component {
    private final int c = (new Color(30, 144, 255)).getRGB();
    private final ComboSetting mode;
    private final ModuleComponent module;
    private int x;
    private int y;
    private int o;
    private final boolean registeredClick = false;
    private final boolean md = false;

    public ModeComponent(ComboSetting desc, ModuleComponent b, int o) {
        this.mode = desc;
        this.module = b;
        this.x = b.category.getX() + b.category.getWidth();
        this.y = b.category.getY() + b.o;
        this.o = o;
    }

    public void draw() {
        GL11.glPushMatrix();
        GL11.glScaled(0.5D, 0.5D, 0.5D);
        int bruhWidth = (int) (Minecraft.getMinecraft().fontRendererObj.getStringWidth(this.mode.getName() + ": ")
                * 0.5);
        Minecraft.getMinecraft().fontRendererObj.drawString(this.mode.getName() + ": ",
                (float) ((this.module.category.getX() + 4) * 2),
                (float) ((this.module.category.getY() + this.o + 4) * 2), 0xffffffff, true);
        Minecraft.getMinecraft().fontRendererObj.drawString(String.valueOf(this.mode.getMode()),
                (float) ((this.module.category.getX() + 4 + bruhWidth) * 2),
                (float) ((this.module.category.getY() + this.o + 4) * 2), this.c, true);
        GL11.glPopMatrix();
    }

    public void update(int mousePosX, int mousePosY) {
        this.y = this.module.category.getY() + this.o;
        this.x = this.module.category.getX();
    }

    public void setComponentStartAt(int n) {
        this.o = n;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    public void mouseDown(int x, int y, int b) {
        if (i(x, y)) {
            this.mode.nextMode();
            module.mod.guiButtonToggled(mode);
            Raven.mc.thePlayer.playSound("gui.button.press", 1, 1);
        }
    }

    @Override
    public void mouseReleased(int x, int y, int m) {

    }

    @Override
    public void keyTyped(char t, int k) {

    }
    
    @Override
    public int getY() {
        return y;
    }

    private boolean i(int x, int y) {
        return x > this.x && x < this.x + this.module.category.getWidth() && y > this.y && y < this.y + 11;
    }
}