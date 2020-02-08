package teamrocket.dao;

import teamrocket.domain.Game;

import javax.ejb.Local;

@Local
public interface GamesDaoInterface {

    public void add(Game o);
}
