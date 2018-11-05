public class Main{

    public static void main(String[] args){
        Controller controller = new Controller();

        String nameCar = controller.assignAnswerToCar();
        System.out.println("Name of car: " + nameCar);
    }
}