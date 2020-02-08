package teamrocket;

import teamrocket.domain.Game;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class Main {



    public static void main(String[] args) {


        String example = "174430;Gloomhaven;Isaac Childres;Cephalofair Games;Alexandr Elichev;2017;1;4;60;120;12;1;3.80;Adventure; Exploration; Fantasy; Fighting; Miniatures;Campaign  Battle Card Driven; Cooperative Play; Grid Movement; Hand Management; Modular Board; Role Playing; Simultaneous Action Selection; Storytelling; Variable Player Powers";
        Game game = new Game(example);

        Tak tak = new Tak();

        tak.add(game);

//
//        System.out.println(game.toString());


    }

    public static class Tak{
        @PersistenceContext(unitName = "grajdolex-hibernate")
        protected EntityManager entityManager;

        public void add(Game game){
            entityManager.persist(game);
        }
    }
}