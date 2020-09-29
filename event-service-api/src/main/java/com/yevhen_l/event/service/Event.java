package com.yevhen_l.event.service;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String place;
    private String speaker;
    private String eventType;
    private LocalDateTime dateTime;

    @JsonCreator
    public Event() {
    }

    @JsonCreator
    public Event(@JsonProperty("title") String title,
                 @JsonProperty("place") String place,
                 @JsonProperty("speaker") String speaker,
                 @JsonProperty("eventType") String eventType,
                 @JsonProperty("dateTime") LocalDateTime dateTime
    ) {
        this.title = title;
        this.place = place;
        this.speaker = speaker;
        this.eventType = eventType;
        this.dateTime = dateTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, place, speaker, eventType, dateTime);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(title, event.title) &&
                Objects.equals(place, event.place) &&
                Objects.equals(speaker, event.speaker) &&
                Objects.equals(eventType, event.eventType) &&
                Objects.equals(dateTime, event.dateTime);
    }
}
