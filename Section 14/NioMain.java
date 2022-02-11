import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            Path filePath = FileSystems.getDefault().getPath("data.txt");
            Files.write(filePath, "\nLine 5".getBytes("UTF-8"), StandardOpenOption.APPEND);
            List<String> list = Files.readAllLines(filePath);

            for (String l : list) {
                System.out.println(l);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
//================WRITING BINARY FILE THROUGH CHANNELS====================
        try (FileOutputStream fos = new FileOutputStream("data.dat")) {
            //Creating channel
            FileChannel channel = fos.getChannel();
            byte[] outputBytes = "Hello World!".getBytes("UTF-8");

            //Wrapping outputBytes to ByteBuffer to write the buffer to the channel
            ByteBuffer buffer = ByteBuffer.wrap(outputBytes);
            int numBytes = channel.write(buffer);
            System.out.println("Bytes written: " + numBytes);

            //Adding integer to the buffer
            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
            intBuffer.putInt(123);
            //when we put 123 to intBuffer, the buffer capacity got full, hence flip is used to point the buffer to again 0.
            // Flip is basically used to switch from read to write or write read.
            intBuffer.flip();
            numBytes = channel.write(intBuffer);
            System.out.println("Bytes written: " + numBytes);

            intBuffer.flip();
            intBuffer.putInt(-244);
            intBuffer.flip();
            numBytes = channel.write(intBuffer);
            System.out.println("Bytes written: " + numBytes);



//======================READING FROM DATA.DAT USING NIO===================
            RandomAccessFile rao = new RandomAccessFile("data.dat", "rwd");
            FileChannel readChannel = rao.getChannel();

            //Reading String
            buffer.flip();
            int inputByte = readChannel.read(buffer);
            System.out.println(new String(buffer.array()));

            //Reading integers
            intBuffer.flip();
            inputByte = readChannel.read(intBuffer);
            intBuffer.flip();
            System.out.println(intBuffer.getInt());
            intBuffer.flip();
            inputByte = readChannel.read(intBuffer);
            intBuffer.flip();
            System.out.println(intBuffer.getInt());
            channel.close();
            readChannel.close();
            rao.close();

        } catch (IOException io) {
            io.printStackTrace();
        }
//================WRITING USING CHAINED PUT=============================
        try {
            RandomAccessFile fos = new RandomAccessFile("data2.dat","rwd");
            FileChannel channel = fos.getChannel();

            ByteBuffer buffer = ByteBuffer.allocate(100);
            byte[] outputByte1 = "Hello World!".getBytes(StandardCharsets.UTF_8);
            byte[] outputByte2 = "Bye Bye!".getBytes(StandardCharsets.UTF_8);

            buffer.put(outputByte1);
            buffer.putInt(456);
            buffer.putInt(-1000);
            buffer.put(outputByte2);
            buffer.putInt(000);

            buffer.flip();
            int bytesWritten = channel.write(buffer);

            RandomAccessFile rao = new RandomAccessFile("data2.dat", "rwd");
            FileChannel readChannel = rao.getChannel();
            ByteBuffer readBuffer = ByteBuffer.allocate(100);
            readChannel.read(readBuffer);

            byte[] inputByte = new byte[outputByte1.length];

            readBuffer.flip();
            readBuffer.get(inputByte);
            System.out.println("inputByte = " + new String(inputByte));

            System.out.println(readBuffer.getInt());
            System.out.println(readBuffer.getInt());


            byte[] inputByte2 = new byte[outputByte2.length];
            readBuffer.get(inputByte2);
            System.out.println("inputByte = " + new String(inputByte2));


            System.out.println(readBuffer.getInt());

            //======================copying file==========================
            channel.position(0);
            RandomAccessFile copyFile=new RandomAccessFile("dataCopy.dat","rw");
            FileChannel copyChannel = copyFile.getChannel();
            long bytesTransferred = copyChannel.transferFrom(channel,0,channel.size());
            System.out.println("Channels Transferred = "+bytesTransferred);


        } catch (IOException io) {
            io.printStackTrace();
        }

    }
}
