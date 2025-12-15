package src.Entity;

import java.time.LocalDateTime;

public class Puzzles {
    private String puzzleId;
    private String moves;      
    private String solutions ;
    private int rating;
    private String theme;
    private LocalDateTime createdAt;

    public Puzzles(String puzzleId, String moves, String solutions, int rating, String theme, LocalDateTime createdAt) {
        this.puzzleId = puzzleId;
        this.moves = moves;
        this.solutions = solutions;
        this.rating = rating;
        this.theme = theme;
        this.createdAt = createdAt;
    }

    public String getPuzzleId() { return puzzleId; }
    public String getMoves() { return moves; }
    public String getSolutions() { return solutions; }
    public int getRating() { return rating; }
    public String getTheme() { return theme; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setRating(int rating) { this.rating = rating; }
    public void setSolutions(String solutions) { this.solutions = solutions; }
}