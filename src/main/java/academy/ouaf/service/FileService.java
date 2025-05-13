package academy.ouaf.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileService {

    @Value("${public.upload.folder}")
    private String publicUploadFolder;

    @Value("${private.upload.folder}")
    private String privateUploadFolder;

    public void uploadToLocalFileSystem(MultipartFile file, String fileName, boolean publicFile) throws IOException {
        uploadToLocalFileSystem(file.getInputStream(), fileName, publicFile);
    }

    public void uploadToLocalFileSystem(InputStream inputStream, String fileName, boolean publicFile) throws IOException {

        Path storageDirectory = Paths.get(publicFile? publicUploadFolder : privateUploadFolder); // folder of uploaded images

        if (!Files.exists(storageDirectory)) {
            try {
                Files.createDirectories(storageDirectory);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Path destination = Paths.get(storageDirectory.toString() + "/" + fileName);

        Files.copy(inputStream, destination, StandardCopyOption.REPLACE_EXISTING);

    }
}