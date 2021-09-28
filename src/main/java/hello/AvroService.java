package hello;

import org.apache.avro.Schema;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;

import java.io.File;
import java.io.IOException;

//import com.hello;

public class AvroService {
    public void serializingDeserializingWithoutCodeGeneration()  {
        //Creating users
        Schema schema= null;
        try {
            schema = new Schema.Parser().parse(new File("UserData.avsc"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("*********Schema.Parser().parse***********");
        }

        GenericRecord user1 = new GenericData.Record(schema);
        user1.put("id", "1");
        user1.put("name", "hunter");
        user1.put("email", "h@gmail.com");

//        GenericRecord user2 = new GenericData.Record(schema);
//        user2.put("id", "2");
//        user2.put("name", "flora");
//        user2.put("email", "flora@gmail.com");

        //Serializing
        File file = new File("UserData.avro");
        DatumWriter<GenericRecord> datumWriter = new GenericDatumWriter<GenericRecord>(schema);
        DataFileWriter<GenericRecord> dataFileWriter = new DataFileWriter<GenericRecord>(datumWriter);
        try {
            dataFileWriter.create(schema, file);
            dataFileWriter.append(user1);
//            dataFileWriter.append(user2);
            dataFileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("*********dataFileWriter***********");
        }

        //Deserializing
        DatumReader<GenericRecord> datumReader = new GenericDatumReader<GenericRecord>(schema);
        DataFileReader<GenericRecord> dataFileReader= null;
        try {
            dataFileReader = new DataFileReader<GenericRecord>(file, datumReader);
            GenericRecord user = null;
            System.out.println("---------------output---------------");
            while (dataFileReader.hasNext()) {
                user = dataFileReader.next(user);
                System.out.println(user);
            }
        } catch (IOException e) {
            System.out.println("*********DataFileReader***********");
            e.printStackTrace();
        }

    }

}
