package src.Entity;

import java.time.LocalDateTime;

public class Games {
    private String gameId;
    private String whitePlayerId;
    private String blackPlayerId;
    private String winnerId;      
    private String tournamentId;  
    private String moves;        
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String victoryType;  

    public Games(String gameId, String whitePlayerId, String blackPlayerId, 
                      String winnerId, String tournamentId, String moves, 
                      LocalDateTime startTime, LocalDateTime endTime, String victoryType) {
        this.gameId = gameId;
        this.whitePlayerId = whitePlayerId;
        this.blackPlayerId = blackPlayerId;
        this.winnerId = winnerId;
        this.tournamentId = tournamentId;
        this.moves = moves;
        this.startTime = startTime;
        this.endTime = endTime;
        this.victoryType = victoryType;
    }

    
    public void setGameId(String gameId) { this.gameId = gameId; }
    public void setWhitePlayerId(String whitePlayerId) { this.whitePlayerId = whitePlayerId; }
	public void setBlackPlayerId(String blackPlayerId) {this.blackPlayerId = blackPlayerId;}
	public void setWinnerId(String winnerId) {	this.winnerId = winnerId;}
    public void setTournamentId(String tournamentId) {	this.tournamentId = tournamentId;	}
    public void setMoves(String moves) {this.moves = moves; }
    public void setStartTime(LocalDateTime startTime) {	this.startTime = startTime;}
    public void setEndTime(LocalDateTime endTime) {	this.endTime = endTime;}
    public void setVictoryType(String victoryType) { this.victoryType = victoryType;}


	public String getGameId() { return gameId; }
    public String getWhitePlayerId() { return whitePlayerId; }
    public String getBlackPlayerId() { return blackPlayerId; }
    public String getWinnerId() { return winnerId; }
    public String getTournamentId() { return tournamentId; }
    public String getMoves() { return moves; }
    public LocalDateTime getStartTime() { return startTime; }
    public LocalDateTime getEndTime() { return endTime; }
    public String getVictoryType() { return victoryType; }
}