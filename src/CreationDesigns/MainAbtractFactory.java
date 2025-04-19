package CreationDesigns;

interface Button {
    void toggle();
}

interface CheckBox {
    void render();
}

class LightButton implements Button {
    @Override
    public void toggle() {
        System.out.println("Light button");
    }
}

class DarkButton implements Button {
    @Override
    public void toggle() {
        System.out.println("Dark button");
    }
}

class LightCheckBox implements CheckBox {
    @Override
    public void render() {
        System.out.println("Light checkbox");
    }
}


class DarkCheckBox implements CheckBox {
    @Override
    public void render() {
        System.out.println("Dark checkbox");
    }
}

interface GUIFactory {
    Button createButton();
    CheckBox createCheckBox();
}


class LightThemeFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new LightButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new LightCheckBox();
    }
}


class DarkThemeFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new DarkButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new DarkCheckBox();
    }
}

//client code
class Application {
    private Button button;
    private CheckBox checkBox;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkBox = factory.createCheckBox();
    }

    public void renderUI() {
        button.toggle();
        checkBox.render();
    }
}

//Main class
public class MainAbtractFactory {
    public static void main(String[] arg) {
        GUIFactory lightFactory = new LightThemeFactory();
        Application app1 = new Application(lightFactory);
        app1.renderUI();

        GUIFactory darkFactory = new DarkThemeFactory();
        Application app2 = new Application(darkFactory);
        app2.renderUI();
    }
}
