package ch.hslu.SW11;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileHandler {
  String filename = "out_sw11.txt";


  public void Write() {
    var num = 354456567;

    try {
      var writer = new DataOutputStream(new FileOutputStream(this.filename));

      // writer.writeBytes(String.valueOf(num));
      writer.writeUTF(String.valueOf(num));

      writer.close();
    } catch (IOException e) {
      System.err.println("Errour");
    }

  }

  public void Read() {
    try {
      var reader = new DataInputStream(new FileInputStream(this.filename));
      
      var out = reader.readUTF();

      System.out.println(out);

      reader.close();
    } catch (Exception e) {
      System.err.println("Euou");
    }
  }
}
