public class Main{

    public static void main(String[] args){
        ESProvider esProvider = new ESProvider();

        String nameCar = esProvider.assignAnswerToCar();
        System.out.println("Name of car: " + nameCar);
    }
}