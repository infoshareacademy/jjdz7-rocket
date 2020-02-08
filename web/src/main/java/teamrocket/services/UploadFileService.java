package teamrocket.services;

import teamrocket.dao.GamesDaoInterface;
import teamrocket.domain.Game;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@ApplicationScoped
public class UploadFileService {

    @EJB
    GamesDaoInterface dao;


    public void readFileInput(InputStream fileContent) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(fileContent));

        String s1 = br.readLine();
        Game game = new Game(s1);
        dao.add(game);

//        br
//                .lines()
//                .forEach(s -> dao.add(new Game(s)));

    }
}
