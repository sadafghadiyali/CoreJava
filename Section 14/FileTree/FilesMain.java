import javax.naming.directory.BasicAttributes;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class FilesMain {
    public static void main(String[] args) throws IOException {
        //Create File
        Path fileToCreate = FileSystems.getDefault().getPath("file1.txt");
        Files.createFile(fileToCreate);


        //Create Directory
        Path dirToCreate = FileSystems.getDefault().getPath("Dir1");
        Files.createDirectory(dirToCreate);

        //Create Directories
        dirToCreate=FileSystems.getDefault().getPath("Dir1/Dir2/Dir3/Dir4");
        Files.createDirectories(dirToCreate);

        //Copy File
        Path fileToCopy = FileSystems.getDefault().getPath("file1_copy.txt");
        Files.copy(fileToCreate,fileToCopy);

        //Move File
        Path CreatedToMove = FileSystems.getDefault().getPath("File_to_move.txt");
        Files.createFile(CreatedToMove);

        Path fileToMove = FileSystems.getDefault().getPath("File_to_move.txt");
        Path destnToMove = FileSystems.getDefault().getPath("Dir1/File_to_move.txt");
        Files.move(CreatedToMove,destnToMove);

        //Delete File
        Path fileToDelete = FileSystems.getDefault().getPath("File_to_delete.txt");
        Files.deleteIfExists(fileToDelete);

        //Basic File Attributes
        BasicFileAttributes attributes=Files.readAttributes(fileToCreate, BasicFileAttributes.class);
        System.out.println("File Size: "+attributes.size());
        System.out.println("Last Modified: "+attributes.lastModifiedTime());
        System.out.println("Created: "+attributes.creationTime());


        //=============DIRECTORY STREAM==================
        DirectoryStream.Filter<Path> filter=new DirectoryStream.Filter<Path>() {
            @Override
            public boolean accept(Path entry) throws IOException {
                return (Files.isRegularFile(entry));
            }
        };

        Path directory = FileSystems.getDefault().getPath("FileTree"+File.separator+"Dir2");
        try(DirectoryStream<Path> contents =Files.newDirectoryStream(directory,filter)){
            for(Path p : contents){
                System.out.println(p.getFileName());
            }
        }
        //Separators
        String separator = File.separator;
        System.out.println(separator);

        separator=FileSystems.getDefault().getSeparator();
        System.out.println(separator);

        //Creating Temp File
        Path tempFile = Files.createTempFile("tempo",".temp");
        System.out.println(tempFile.toAbsolutePath());

//================WALKING TREE========================
        System.out.println("***************Walking Tree for Dir2*************");
        Path path = FileSystems.getDefault().getPath("FileTree"+File.separator+"Dir2");
        try{
            Files.walkFileTree(path,new PrintNames());
        }catch (IOException io){
            io.getMessage();
        }

        System.out.println("********Copying dir2 to dir4/dir2copy");

        Path copyPath= FileSystems.getDefault().getPath("FileTree"+File.separator+"Dir4"+File.separator+"Dir2copy");
        try{
            Files.walkFileTree(path,new CopyFiles(path,copyPath));
        }catch (IOException io){
            io.getMessage();
        }
    }
}
