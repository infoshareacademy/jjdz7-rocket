package teamrocket.servlets.upd;

import teamrocket.servlets.upd.UserImageNotFound;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Properties;
import javax.enterprise.context.RequestScoped;
import javax.servlet.http.Part;

@RequestScoped
public class FileUploadProcessor {

  private static final String SETTINGS_FILE = "settings.properties";

  public File uploadImageFile(Part filePart) throws IOException, UserImageNotFound {

    String fileName = Paths.get(filePart.getSubmittedFileName())
        .getFileName().toString();

    if (fileName == null || fileName.isEmpty()) {
      throw new UserImageNotFound("No user image has been uploaded");
    }

    File file = new File(getUploadImageFilesPath()
        + fileName);
    Files.deleteIfExists(file.toPath());

    InputStream fileContent = filePart.getInputStream();
    Files.copy(fileContent, file.toPath());

    fileContent.close();
    return file;
  }

  public String getUploadImageFilesPath() throws IOException {
    Properties settings = new Properties();
    settings.load( Objects.requireNonNull ( Thread.currentThread ()
            .getContextClassLoader ().getResource ( SETTINGS_FILE ) )
        .openStream());
    return settings.getProperty("Upload.Path.Images");
  }
}
