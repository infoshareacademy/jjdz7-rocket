package teamrocket.servlets.upd;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Properties;
import javax.enterprise.context.RequestScoped;
import javax.servlet.http.Part;

@RequestScoped
public class FileUploadProcessor {

  private static final String SETTINGS_FILE = "settings.properties";

  public String getUploadImageFilesPath() throws IOException {
    Properties settings = new Properties();
    settings.load( Objects.requireNonNull ( Thread.currentThread ()
            .getContextClassLoader ().getResource ( SETTINGS_FILE ) )
        .openStream());
    return settings.getProperty("Upload.Path.Images");
  }
}
