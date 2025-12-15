package src.Entity;

import java.time.LocalDateTime;

public class Tournament {
    private String tournamentId;
    private String name;
    private String description;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String winnerId; 

    public Tournament(String tournamentId, String name, String description, 
                      LocalDateTime startTime, LocalDateTime endTime, String winnerId) {
        this.tournamentId = tournamentId;
        this.name = name;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.winnerId = winnerId;
    }

    
    public String getTournamentId() { return tournamentId; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public LocalDateTime getStartTime() { return startTime; }
    public LocalDateTime getEndTime() { return endTime; }
    public String getWinnerId() { return winnerId; }
    
   
    public void setWinnerId(String winnerId) { this.winnerId = winnerId; }
    public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }
}