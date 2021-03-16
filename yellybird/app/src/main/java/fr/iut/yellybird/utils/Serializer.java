package fr.iut.yellybird.utils;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializer {
    /**
     * Serialization of an object
     * @param filename
     * @param object
     * @param context
     */
    public static void serialize(String filename, Object object, Context context)
    {
        try{
            FileOutputStream stream = context.openFileOutput(filename, Context.MODE_PRIVATE);
            ObjectOutputStream objectStream = new ObjectOutputStream(stream);
            objectStream.writeObject(object);
            objectStream.flush();
            objectStream.close();
        } catch (FileNotFoundException e) {
            //File not found
            e.printStackTrace();
        } catch (IOException e) {
            //Error serialisation
            e.printStackTrace();
        }
    }

    /**
     * Deserialization of an object
     * @param filename
     * @param context
     * @return
     */
    public static Object deserialize(String filename, Context context)
    {
            try {
                FileInputStream stream = context.openFileInput(filename);
                ObjectInputStream objectStream = new ObjectInputStream(stream);
                Object object = objectStream.readObject();
                objectStream.close();
                return object;
            } catch (FileNotFoundException e) {
                //File not found
                e.printStackTrace();
            } catch (IOException e) {
                //Error serialisation
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                //Error read object
                e.printStackTrace();
            }
            return null;
    }
}
