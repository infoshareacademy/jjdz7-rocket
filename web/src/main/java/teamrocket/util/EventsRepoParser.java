package teamrocket.util;

import teamrocket.dao.EventsDaoBean;
import teamrocket.domain.Event;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class EventsRepoParser {

    private List<Event> eventsEntityList = new ArrayList<>();

    private EventsDaoHelper eventsDaoHelper;

    EventsRepoParser(EntityManager em){
        this.eventsDaoHelper = new EventsDaoHelper();
        eventsDaoHelper.setEntityManager(em);
    }

    public void parseFileRepoFromAppModuleToDb(){
        List<teamrocket.model.Event> eventList = getEventsListFromFileInAppModule();
        convertEventListToEventsEntityDto(eventList,eventsEntityList);
        for (Event event:eventsEntityList){
            eventsDaoHelper.add(event);
        }
    }

    public Event convertDtoToEntity(teamrocket.model.Event event){
        Event eventEntity = new Event();
        eventEntity.setEventName(event.getEventName());
        eventEntity.setEventType(event.getEventType());
        eventEntity.setEventDescription( event.getEventDescription());
        eventEntity.setGameName(event.getGameName());
        eventEntity.setPlayersNumber(event.getPlayersNumber());
        eventEntity.setEventDate(event.getEventDate());
        eventEntity.setEventStartTime(event.getEventStartTime());
        eventEntity.setEventEndTime(event.getEventEndTime());
        eventEntity.setEventPlaceName(event.getEventPlaceName());
        eventEntity.setEventAddress(event.getEventAddress());
        eventEntity.setEventCity(event.getEventCity());
        return eventEntity;
    }

    private List<teamrocket.model.Event> getEventsListFromFileInAppModule(){
        return teamrocket.model.Event.createArrayFromRepo();
    }

    private void convertEventListToEventsEntityDto(List<teamrocket.model.Event> eventList, List<Event> eventsEntityList){
        for (teamrocket.model.Event event : eventList){
            eventsEntityList.add(convertDtoToEntity(event));
        }
    }

    private class EventsDaoHelper extends EventsDaoBean {
        public void setEntityManager(EntityManager em){
            entityManager  = em;
        }
    }
}
