package hello;



public class App {
    public static void main(String[] args) throws Exception
    {
        System.out.println("----------------app------------------");
        AvroService avroService= new AvroService();
        avroService.serializingDeserializingWithoutCodeGeneration();

        System.out.println("----------------app end------------------");
    }


}

