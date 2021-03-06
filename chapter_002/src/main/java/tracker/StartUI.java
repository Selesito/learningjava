package tracker;


public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.allItem(input, tracker);
            } else if (select == 2) {
                StartUI.replaceItem(input, tracker);
            } else if (select == 3) {
                StartUI.deteleItem(input, tracker);
            } else if (select == 4) {
                StartUI.findIdItem(input, tracker);
            } else if (select == 5) {
                StartUI.findNameItem(input, tracker);
            } else if (select == 6) {
                System.out.println("=== Exit Program ====");
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");

    }

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void allItem(Input input, Tracker tracker) {
        System.out.println("=== Show all items ====");
        Item[] rsl = tracker.findAll();
        for (int i = 0; i < rsl.length; i++) {
            System.out.println(rsl[i]);
        }
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("=== Edit item ====");
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter name: ");
        if (tracker.replace(id, new Item(name))) {
            System.out.println("Удалось заменить объкт на новый " + name);
        } else {
            System.out.println("Не удалось заменить объкт на новый " + name);
        }
    }

    public static void deteleItem(Input input, Tracker tracker) {
        System.out.println("=== Delete item ====");
        int id = input.askInt("Enter id: ");
        if (tracker.delete(id)) {
            System.out.println("Удалили объект");
        } else {
            System.out.println("Не удалось удалить объект");
        }
    }

    public static void findIdItem(Input input, Tracker tracker) {
        System.out.println("=== Find item by Id ====");
        System.out.print("Enter id: ");
        int id = input.askInt("Enter id: ");
        Item rsl =  tracker.findById(id);
        if (rsl.equals(null)) {
            System.out.println("Заявка с таким id не найдена");
        } else {
            System.out.println(rsl);
        }
    }

    public static void findNameItem(Input input, Tracker tracker) {
        System.out.println("=== Find item by Name ====");
        String name = input.askStr("Enter name: ");
        Item[] rsl = tracker.findByName(name);
        if (rsl.length > 0) {
            for (int i = 0; i < rsl.length; i++) {
                System.out.println(rsl[i]);
            }
        } else {
            System.out.println("Заявки с таким именем не найдены");
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}